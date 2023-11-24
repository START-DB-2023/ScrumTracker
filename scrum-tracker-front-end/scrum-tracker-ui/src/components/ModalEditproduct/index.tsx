import { ModalContainer, ButtonWrapper, FormContainer } from "./styles";
import { FormEvent, useEffect, useState } from "react";
import closed from '../../assets/close.svg'
import { useGlobalContext } from "../../contexts/UserContext";
import Button from "../Button";
import { useListContext } from "../../contexts/UserContextList";
/* import ProductBackLog from "../../pages/Home/components/ProductBackLog"; */
import { tokenService } from "../../utils/TokenService";
import api from '../../connections/api'
import { IItemBacklog, ISprints } from "../../@types/types";
import { useDataProductContext } from "../../contexts/ProductContext";


interface ModalEditProductProps {
  itemProductBacklog: IItemBacklog
}

const ModalEditProduct: React.FC<ModalEditProductProps> = ({ itemProductBacklog }) => {
  const { listSprints, list, setList, setListSprints } = useListContext()
  const { setOpenModalEdit, status, priority } = useGlobalContext();
  const { productBacklog, dataProduct } = useDataProductContext();
  const [sprintData, setSprintData] = useState<ISprints | null>(null)
  /*   const { dataProduct, setDataProduct } = useDataProductContext(); */
  const [dadoForm, setDadoForm] = useState({
    id: itemProductBacklog.id,
    name: itemProductBacklog.name,
    userHistory: itemProductBacklog.userHistory,
    status: itemProductBacklog.status,
    priority: itemProductBacklog.priority,
    effortEstimation: itemProductBacklog.effortEstimation,
    sprints: itemProductBacklog.sprintViews
  })



  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    return setDadoForm({ ...dadoForm, [event.target.name]: event.target.value })
  }

  function handleChangeTextArea(event: React.ChangeEvent<HTMLTextAreaElement>) {
    return setDadoForm({ ...dadoForm, [event.target.name]: event.target.value })
  }

  function handleChangeSelect(event: React.ChangeEvent<HTMLSelectElement>) {
    return setDadoForm({ ...dadoForm, [event.target.name]: event.target.value })
  }


  async function submitFormEditProduct(event: FormEvent<HTMLFormElement>) {
    event.preventDefault()

    //console.log(listSprints);

    //console.log(dadoForm.sprints);

    //let sprint = {}


    if (listSprints.length !== 0) {
      try {
        const response = await api.get(`/sprint/${dadoForm.sprints}`, {
          headers: {
            Authorization: `Bearer ${tokenService.get("token")}`
          }
        })

        setSprintData(response.data)
        //sprint = response.data
        await putSprintEdit(response.data)

        //console.log(response.data.sprintGoals);


      } catch (error) {
        console.log(error);
      }
    } else {
      putEditProduct()
    }

  }

  async function putSprintEdit(event) {
    try {
      await api.put(`/sprint/${dadoForm.sprints}`, {
        sprintGoals: event.sprintGoals,
        itensBacklog: [{
          ...dadoForm,
          sprints: [],
          criteriaAcceptance: "",
          productBacklog: productBacklog
        }],
        product: dataProduct, 
        tasksSprints: []
      }, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      })

      //console.log(response.data);
      

      await putEditProduct(event)

    } catch (error) {
      console.log(Response.error);
    }
  }

  async function putEditProduct(event) {
    try {
      await api.put(`/item-backlog/${dadoForm.id}`, {
        ...dadoForm,
        sprints: [{
          id: event.id,
          sprintGoals: event.sprintGoals,
          tasksSprints: [],
          itensBacklog: [],
          product: event.productView

        }],
        criteriaAcceptance: "",
        productBacklog: productBacklog
      }, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      })

      const newList = list.map((item) =>
        item.id === dadoForm.id ? { ...item, ...dadoForm } : item)
      setList(newList)

      setOpenModalEdit(false)

    } catch (error) {
      console.log(error);
    }
  }

  

  useEffect(() => {
    //searchSprint()
    /* console.log(dadoForm);
    console.log(dadoForm.sprints[0].id); */
  }, [])


  return (
    <ModalContainer id="modal">
      <div className="background-Modal">
        <div>
          <h2> Editar Produto</h2>
          <img src={closed} alt="Fechar" onClick={() => setOpenModalEdit(false)} />
        </div>
        <FormContainer onSubmit={(event: React.FormEvent<HTMLFormElement>) => submitFormEditProduct(event)} >
          <div >
            <label htmlFor="name">Nome:*</label>
            <input id="name" name="name" type="text" maxLength={255} value={dadoForm.name} onChange={(event: React.ChangeEvent<HTMLInputElement>) => handleChange(event)} />
          </div>
          <div>
            <label htmlFor="userHistory">História do Usuário:*</label>
            <textarea id="userHistory" name="userHistory" value={dadoForm.userHistory} onChange={(event: React.ChangeEvent<HTMLTextAreaElement>) => handleChangeTextArea(event)}></textarea>
          </div>
          <div>
            <label htmlFor="status">Status:</label>
            <select name="status" defaultValue={dadoForm.status} onChange={(event: React.ChangeEvent<HTMLSelectElement>) => handleChangeSelect(event)}>
              {status.map((event) => {
                return (
                  <option key={event} value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div >
            <label htmlFor="priory">Prioridade</label>
            <select name="priority" defaultValue={dadoForm.priority} onChange={(event: React.ChangeEvent<HTMLSelectElement>) => handleChangeSelect(event)}>
              {priority.map((event) => {
                return (
                  <option value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div>
            <label htmlFor="effortEstimation" >Estimativa de Esforço</label>
            <input id="effortEstimation" name="effortEstimation" value={dadoForm.effortEstimation} onChange={(event: React.ChangeEvent<HTMLInputElement>) => handleChange(event)}></input>
          </div>
          <div>
            <label htmlFor="sprints">Sprints:</label>
            <select name="sprints" /* defaultValue={dadoForm.sprints[0].id || ''} */ onChange={(event: React.ChangeEvent<HTMLSelectElement>) => handleChangeSelect(event)}>
              <option value=""> ... </option>
              {listSprints.map((event, index) => {
                return (
                  <option key={event.id} value={event.id}>
                    {index +1}
                  </option>
                )
              })}
            </select>
          </div>

          <ButtonWrapper>
            <Button title="Cancelar" variant="danger" freesize={true} type="button" onClick={() => setOpenModalEdit(false)} />
            <Button title="Atualizar" variant="primary" freesize={true} type="submit" />
          </ButtonWrapper>
        </FormContainer>
      </div>
    </ModalContainer>
  );
}


export default ModalEditProduct;


