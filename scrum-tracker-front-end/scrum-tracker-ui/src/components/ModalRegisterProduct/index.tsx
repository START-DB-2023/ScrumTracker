import { ModalContainer } from "./styles";
import TextAreaModal from '../TextAreaModal/index'

export default function ModalRegisterProduct() {
  return (
    <ModalContainer id="modal">
      <h2> Registro de Produto</h2>
      <form>
        <div >
          <label htmlFor="name">Nome:*</label>
          <input id="name" name="name" type="text" maxLength={255}  />
        </div>
        <div>
          <label htmlFor="client">Cliente:*</label>
          <input id="client" name="client" type="text" />
        </div>
        <div>
          <label htmlFor="goals">Objetivos:</label>
          <TextAreaModal id="goals" />
        </div>
        <div >
          <label htmlFor="productView">Visão do produto</label>
          <TextAreaModal id="productView" />
        </div>
        <div>
          <label htmlFor="DOR" >Definição de Preparado</label>
          <TextAreaModal id="DOR"/>
        </div>
        <div>
          <label htmlFor="DOD">Definição de Pronto</label>
          <TextAreaModal id="DOD"/>
        </div>
        <button>Pronto </button>
      </form>

      {/* <img src={SignOut} alt="sair" /> */}
    </ModalContainer>
  );
}
