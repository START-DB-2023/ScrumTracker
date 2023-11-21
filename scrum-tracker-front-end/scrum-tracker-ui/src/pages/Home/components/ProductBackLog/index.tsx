import deleteIcon from "../../../../assets/Delete.svg";
import editIcon from '../../../../assets/Edit.svg';
import ModalEditProduct from "../../../../components/ModalEditproduct";
import { useGlobalContext } from "../../../../contexts/UserContext";
import { useState } from "react";
// import Button from "../../../../components/Button";
/* import { teste } from './list'; */
import { ContainerProduct, Status } from './styles';
import { useListContext } from "../../../../contexts/UserContextList";



export default function ProductBackLog() {

  const { openModalEdit, setOpenModalEdit } = useGlobalContext();
  const { list, setList } = useListContext();
  const [testeai, setTesteai] = useState(0)

  function TestandoValor(id: number): void {
    setOpenModalEdit(true)
    setTesteai(id)
  }


  function DeleteProduct(id: number): void {
    const newTest = [...list].filter((listItem) => listItem.id !== id);
    setList(newTest)
  }

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
            <th></th>
          </tr>
        </thead>
        <tbody>
          {list.map((product) => {
            return (
              <tr key={product.id}>
                <td>{product.name}</td>
                <td className='history'>{product.history}</td>
                <td>{product.status}</td>
                <td><Status $statusColor={product.priority}>{product.priority}</Status></td>
                <td>{product.estimate}</td>
                <td>
                  <div className="options">
                    <img src={editIcon} alt="Editar Dados da Tabela" onClick={() => TestandoValor(product.id)} />
                    <img src={deleteIcon} alt="Excluir Dado da Tabela" onClick={() => DeleteProduct(product.id)} />
                  </div>
                </td>
              </tr>
            )
          })}
        </tbody>
      </table>
      {openModalEdit && <ModalEditProduct
        idAbrir={testeai}
      />}
    </ ContainerProduct>
  )
}
