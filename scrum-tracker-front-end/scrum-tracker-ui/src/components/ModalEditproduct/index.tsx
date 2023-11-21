import { ModalContainer, ButtonWrapper, FormContainer } from "./styles";
import { FormEvent, useState } from "react";
/* import { teste } from '../../pages/Home/components/ProductBackLog/list' */
import closed from '../../assets/close.svg'
import { useGlobalContext } from "../../contexts/UserContext";
import Button from "../Button";
import { useListContext } from "../../contexts/UserContextList";

interface ModalEditProductProps {
  idAbrir: number;
}

const ModalEditProduct: React.FC<ModalEditProductProps> = ({ idAbrir }) => {
  const { setOpenModalEdit, status, priority } = useGlobalContext();
  const { list, setList } = useListContext();

  const [dadoForm, setDadoForm] = useState({
    "name": list[idAbrir].name,
    "history": list[idAbrir].history,
    "status": list[idAbrir].status,
    "priority": list[idAbrir].priority,
    "estimate": list[idAbrir].estimate
  })

  function handleChange(event: React.ChangeEvent<HTMLInputElement>) {
    return setDadoForm({ ...dadoForm, [event.target.name]: event.target.value })
  }

  function submitFormEditProduct(event: FormEvent<HTMLFormElement>) {
    event.preventDefault()

    const newList = [...list];
    newList[idAbrir] = {
      ...newList[idAbrir],
      name: dadoForm.name,
      history: dadoForm.history,
      status: dadoForm.status,
      priority: dadoForm.priority,
      estimate: dadoForm.estimate
    }

    setList(newList)
    setOpenModalEdit(false)
  }


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
            <input id="name" name="name" type="text" maxLength={255} value={dadoForm.name} onChange={(event) => handleChange(event)} />
          </div>
          <div>
            <label htmlFor="history">História do Usuário:*</label>
            <textarea id="history" name="history" value={dadoForm.history} onChange={(event) => handleChange(event)}></textarea>
          </div>
          <div>
            <label htmlFor="status">Status:</label>
            <select name="status" defaultValue={dadoForm.status} onChangeCapture={(event) => handleChange(event)}>
              {status.map((event) => {
                return (
                  <option value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div >
            <label htmlFor="priory">Prioridade</label>
            <select name="priority" defaultValue={dadoForm.priority} onChangeCapture={(event) => handleChange(event)}>
              {priority.map((event) => {
                return (
                  <option value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div>
            <label htmlFor="EdE" >Estimativa de Esforço</label>
            <input id="estimate" name="estimate" value={dadoForm.estimate} onChange={(event) => handleChange(event)}></input>
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
