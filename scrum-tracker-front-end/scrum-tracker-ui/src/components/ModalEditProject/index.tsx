import { FormEvent, useState } from "react";
import editImage from '../../assets/Edit.svg';
import closed from '../../assets/close.svg';
import api from '../../connections/api';
import { useDataProductContext } from "../../contexts/ProductContext";
import { tokenService } from "../../utils/TokenService";
import Button from "../Button";
import { ButtonWrapper, FormContainer, ModalContainer } from "./styles";

function ModalEditProject() {
  const { dataProduct, setOpenModalEditProduct, setDataProduct } = useDataProductContext();

  const [dadoForm, setDadoForm] = useState({
    "name": dataProduct.name,
    "client": dataProduct.client,
    "objectives": dataProduct.objectives,
    "vision": dataProduct.vision,
    "definitionOfReady": dataProduct.definitionOfDone,
    "definitionOfDone": dataProduct.definitionOfReady
  })

  function handleChangeProject(event: React.ChangeEvent<HTMLInputElement>) {
    return setDadoForm({ ...dadoForm, [event.target.name]: event.target.value })
  }

  function handleChangeProjectArea(event: React.ChangeEvent<HTMLTextAreaElement>) {
    return setDadoForm({ ...dadoForm, [event.target.name]: event.target.value })
  }

  async function submitFormEditProduct(event: FormEvent<HTMLFormElement>) {
    event.preventDefault()

    try {
      const response = await api.put(`product/${dataProduct.id}`, {
        ...dadoForm
      }, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      });
      setDataProduct(response.data);
      setOpenModalEditProduct(false)
    } catch (error) {
      console.log(error);
    }
  }


  return (
    <ModalContainer id="modal">
      <div className="background-Modal">
        <div>
          <div className="containerTitleEditProject">
            <img src={editImage} alt="Editar Projeto" />
            <h2> Editar Produto</h2>
          </div>
          <img src={closed} alt="Fechar" onClick={() => setOpenModalEditProduct(false)} />
        </div>
        <FormContainer onSubmit={(event: React.FormEvent<HTMLFormElement>) => submitFormEditProduct(event)} >
          <div >
            <label htmlFor="name">Nome:*</label>
            <input id="name" name="name" type="text" maxLength={255} value={dadoForm.name} onChange={(event: React.ChangeEvent<HTMLInputElement>) => handleChangeProject(event)} />
          </div>
          <div >
            <label htmlFor="client">Client:*</label>
            <input id="client" name="client" type="text" maxLength={255} value={dadoForm.client} onChange={(event: React.ChangeEvent<HTMLInputElement>) => handleChangeProject(event)} />
          </div>
          <div>
            <label htmlFor="objectives">Objetivos:</label>
            <textarea id="objectives" name="objectives" value={dadoForm.objectives} onChange={(event: React.ChangeEvent<HTMLTextAreaElement>) => handleChangeProjectArea(event)}></textarea>
          </div>
          <div>
            <label htmlFor="vision">Visão do Produto:</label>
            <textarea id="vision" name="vision" value={dadoForm.vision} onChange={(event: React.ChangeEvent<HTMLTextAreaElement>) => handleChangeProjectArea(event)}></textarea>
          </div>
          <div>
            <label htmlFor="definitionOfReady">Definição de Preparado:</label>
            <textarea id="definitionOfReady" name="definitionOfReady" value={dadoForm.definitionOfReady} onChange={(event: React.ChangeEvent<HTMLTextAreaElement>) => handleChangeProjectArea(event)}></textarea>
          </div>
          <div>
            <label htmlFor="definitionOfDone">Definição de Pronto:</label>
            <textarea id="definitionOfDone" name="definitionOfDone" value={dadoForm.definitionOfDone} onChange={(event: React.ChangeEvent<HTMLTextAreaElement>) => handleChangeProjectArea(event)}></textarea>
          </div>
          <ButtonWrapper>
            <Button title="Atualizar" variant="primary" freesize={true} type="submit" />

          </ButtonWrapper>
        </FormContainer>
      </div>
    </ModalContainer>
  );
}

export default ModalEditProject;
