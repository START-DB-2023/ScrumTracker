import deleteIcon from "../../../../assets/Delete.svg";
import editIcon from '../../../../assets/Edit.svg';
import ModalEditProduct from "../../../../components/ModalEditproduct";
import { useGlobalContext } from "../../../../contexts/UserContext";
import { useEffect, useState } from "react";
import { ContainerProduct, Status } from './styles';
import { useListContext } from "../../../../contexts/UserContextList";
import { useDataProductContext } from "../../../../contexts/ProductContext";
import api from '../../../../connections/api'
import { tokenService } from "../../../../utils/TokenService";
/* import ModalRegisterSprint from "../../../../components/ModalRegisterSprint"; */
import { IItemBacklog } from "../../../../@types/types";
import { NavLink } from "react-router-dom";
import { toast } from "react-toastify";

export default function ProductBackLog() {

  const { openModalEdit, setOpenModalEdit } = useGlobalContext();
  const { list, setList, setListSprints } = useListContext();
  const [itemProductBacklog, setItemProductBacklog] = useState({})
  const { dataProduct, setDataProduct } = useDataProductContext()
  const { setProductBacklog } = useDataProductContext()

  async function searchProjects(): Promise<void> {

    try {
      const response = await api.get("/product/")
      setDataProduct(response.data)
      await searchProductBacklog()

    } catch (error) {
      console.log(error);
    }
  }

  async function searchProductBacklog(): Promise<void> {
    try {
      const response = await api.get(`/product-backlog/product/${dataProduct.id}`, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      });
      setProductBacklog(response.data)
      setList(response.data.itensBacklog)
      await searchSprint()

    } catch (error) {
      console.log(error);
    }
  }

  /* async function searchItemBacklog(): Promise<void> {

    try {
      const response = await api.get(`/item-backlog/product-backlog/${productBacklog.id}`, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      });
      setList(response.data)
      console.log(response.data);
      searchSprint()

    } catch (error) {
      console.log(error);

    }
  } */

  async function searchSprint(): Promise<void> {
    try {
      const response = await api.get(`/sprint/product/${dataProduct.id}`, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      });
      setListSprints(response.data)

    } catch (error) {
      console.log(error);

      //toast.error(error)

    }
  }

  function EditProduct(event: IItemBacklog) {
    setOpenModalEdit(true)
    setItemProductBacklog(event)
  }

  async function DeleteProduct(id: number): Promise<void> {
    try {
      await api.delete(`/item-backlog/${id}`, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      });

      const newList = list.filter((item) => item.id !== id);
      setList(newList);
    } catch (error) {
      console.log(error);
    }
  }


  useEffect(() => {
    searchProjects()
  }, [])


console.log('list -> ' , list)
  return (
    <ContainerProduct>
      <table>
        <thead>
          <tr>
            <th>Nome</th>
            <th>História de Usuário</th>
            <th>Status</th>
            <th>Prioridade</th>
            <th>Estimativa de Esforço</th>
            <th >Sprint</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {list.map((product) => {
            return (
              <tr key={product.id}>
                <td>{product.name}</td>
                <td className='history'>{product.userHistory}</td>
                <td>{product.status}</td>
                <td><Status $statusColor={product.priority}>{product.priority}</Status></td>
                <td>{product.effortEstimation}</td>
                {/* <NavLink to={`/sprint/${product.sprintViews[0]?.id}`}><td>Sprint {product.sprintViews[0]? product.sprintViews[0].id :""}</td></NavLink> */}
                <NavLink to={product.sprintViews && product.sprintViews.length > 0 ? `/sprint/${product.sprintViews[0].id}` : '#'}>
                <td> {product.sprintViews && product.sprintViews.length > 0
                  ? `Sprint ${product.sprintViews.map((sprint, index) => index + 1).join(', ')}`
                  : ' '}
                </td>
                </NavLink>
                <td>
                  <div className="options">
                    <img src={editIcon} alt="Editar Dados da Tabela" onClick={() => EditProduct(product)} />
                    <img src={deleteIcon} alt="Excluir Dado da Tabela" onClick={() => DeleteProduct(product.id)} />
                  </div>
                </td>
              </tr>
            )
          })}
        </tbody >
      </table >
      {openModalEdit && <ModalEditProduct
        itemProductBacklog={itemProductBacklog}
      />
      }
    </ ContainerProduct >
  )
}



// `