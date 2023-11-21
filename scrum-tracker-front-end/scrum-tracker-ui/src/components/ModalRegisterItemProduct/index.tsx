import { useRef } from 'react';
import closed from '../../assets/close.svg';
import { useGlobalContext } from "../../contexts/UserContext";
import { useListContext } from '../../contexts/UserContextList';
import Button from "../Button";
import { ButtonWrapper, FormContainer, ModalContainer } from "./styles";
import { tokenService } from '../../utils/TokenService';
import api from '../../connections/api'

export default function ModalRegisterItemProduct() {
  const { status, priority, setOpenModalItem } = useGlobalContext();
  const { list, setList } = useListContext();


  const formRef = useRef<HTMLFormElement>(null);

  interface Listagem {
    id: number;
    name: string;
    history: string;
    status: "A fazer" | "Em desenvolvimento" | "Concluído" | "Encaminhado para testes" | "Bloqueado";
    priority: "ALTA" | "MÉDIA" | "BAIXA";
    estimate: string,
    sprint: number
  }

  async function submitForm(event: React.ChangeEvent<HTMLInputElement>) {
    event?.preventDefault()

    if (formRef.current) {
      const formData = new FormData(formRef.current);
      const formJson = Object.fromEntries(formData.entries());

      try {
        const response = await api.post("item-backlog", {
          ...formJson
        }, {
          headers: {
            Authorization: `Bearer ${tokenService.get("token")}`
          }
        });
        console.log(response);

      } catch (error) {
        console.log(error);
      }

      const newItem = { ...formJson, id: list.length }
      const newList: Listagem[] = [...list, newItem]
      return setList(newList)
    }

  }


  return (
    <ModalContainer id="modal">
      <div className="background-Modal">
        <div>
          <h2> Registro novo Item ao Produto</h2>
          <img src={closed} alt="Fechar" onClick={() => setOpenModalItem(false)} />
        </div>
        <FormContainer ref={formRef} method='post' onSubmit={submitForm} >
          <div >
            <label htmlFor="name">Nome:*</label>
            <input id="name" name="name" type="text" maxLength={255} />
          </div>
          <div>
            <label htmlFor="criteriaAcceptance">História do Usuário:*</label>
            <textarea id="history" name="criteriaAcceptance"></textarea>
          </div>
          <div>
            <label htmlFor="status">Status:</label>
            <select name="status" >
              {status.map((event) => {
                return (
                  <option value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div >
            <label htmlFor="priority">Prioridade</label>
            <select name="priority" >
              {priority.map((event) => {
                return (
                  <option value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div>
            <label htmlFor="effortEstimation" >Estimativa de Esforço</label>
            <input id="estimate" name="effortEstimation" ></input>
          </div>
          <ButtonWrapper>
            <Button title="Cancelar" variant="danger" freesize={true} type="button" onClick={() => setOpenModalItem(false)} />
            <Button title="Registrar" variant="primary" freesize={true} type="submit" />
          </ButtonWrapper>
        </FormContainer>
      </div>
    </ModalContainer>
  );
}

