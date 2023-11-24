import { useRef } from 'react';
import closed from '../../assets/close.svg';
import { useGlobalContext } from "../../contexts/UserContext";
import { useListContext } from '../../contexts/UserContextList';
import Button from "../Button";
import { ButtonWrapper, FormContainer, ModalContainer } from "./styles";
import { tokenService } from '../../utils/TokenService';
import api from '../../connections/api'
import { useDataProductContext } from '../../contexts/ProductContext';
import { IItemBacklog } from '../../@types/types';

export default function ModalRegisterItemProduct() {
  const { status, priority, setOpenModalItem } = useGlobalContext();
  const { list, setList } = useListContext();
  const { dataProduct } = useDataProductContext()

  const formRef = useRef<HTMLFormElement>(null);


  async function submitForm(event: React.FormEvent<HTMLFormElement>) {
    event?.preventDefault()

    if (formRef.current) {
      const formData = new FormData(formRef.current);
      const formJson = Object.fromEntries(formData.entries());

      try {
        await api.post("/item-backlog/", {
          ...formJson,
          status: formJson.status === "A Fazer" ? "A_FAZER" : formJson.status === "Em desenvolvimento" ? "EM_DESENVOLVIMENTO" : formJson.status === "Concluído" ? "CONCLUIDO" : formJson.status,
          priority: formJson.priority === "ALTA" ? "ALTA" : formJson.priority === "MÉDIA" ? "MEDIA" : formJson.priority === "BAIXA" ? "BAIXA" : formJson.priority,
          productBacklog: dataProduct,
          criteriaAcceptance: "versionamento",
          sprints: []
        }, {
          headers: {
            Authorization: `Bearer ${tokenService.get("token")}`
          }
        });

        //adicionar no array criado list no context
        const newItem = { ...formJson, id: list.length }
        const newList: IItemBacklog[] = [...list, newItem]
        setOpenModalItem(false)
        return setList(newList)

      } catch (error) {
        console.log(error);
      }


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
            <label htmlFor="userHistory">História do Usuário:*</label>
            <textarea id="userHistory" name="userHistory"></textarea>
          </div>
          <div>
            <label htmlFor="status">Status:</label>
            <select name="status">
              {status.map((event) => {
                return (
                  <option key={event} value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div >
            <label htmlFor="priority">Prioridade</label>
            <select name="priority"  >
              {priority.map((event) => {
                return (
                  <option key={event} value={event}>{event}</option>
                )
              })}
            </select>
          </div>
          <div>
            <label htmlFor="effortEstimation" >Estimativa de Esforço</label>
            <input id="estimate" name="effortEstimation" ></input>
          </div>
          {/* <div>
            <label htmlFor="sprints" >Sprint</label>
            <input id="sprints" name="sprints" disabled></input>
          </div> */}
          <ButtonWrapper>
            <Button title="Cancelar" variant="danger" freesize={true} type="button" onClick={() => setOpenModalItem(false)} />
            <Button title="Registrar" variant="primary" freesize={true} type="submit" />
          </ButtonWrapper>
        </FormContainer>
      </div>
    </ModalContainer>
  );
}

