import { useRef } from 'react';
import closed from '../../assets/close.svg';
import api from '../../connections/api';
import { useDataProductContext } from "../../contexts/ProductContext";
import { useGlobalContext } from '../../contexts/UserContext';
import { tokenService } from '../../utils/TokenService';
import Button from '../Button';
import TextAreaModal from '../TextAreaModal/index';
import { ModalContainer } from "./styles";


export default function ModalRegisterProduct() {
  const { setOpenModal } = useGlobalContext();

  const { setDataProduct } = useDataProductContext();

  const formRegisterRef = useRef<HTMLFormElement>(null);

  async function registerProduct(event: React.FormEvent<HTMLFormElement>): Promise<void> {
    event?.preventDefault()

    if (formRegisterRef.current) {
      const formDataRegister = new FormData(formRegisterRef.current);
      const formRegisterJson = Object.fromEntries(formDataRegister.entries());

      try {
        const response = await api.post("product/", {
          ...formRegisterJson
        }, {
          headers: {
            Authorization: `Bearer ${tokenService.get("token")}`
          }
        });
        setDataProduct(response.data);
        setOpenModal(false)

        console.log(response);



        await api.post("product-backlog/", {
          itensBacklog: [],
          product: response.data
        }, {
          headers: {
            Authorization: `Bearer ${tokenService.get("token")}`
          }
        });


        //  setDataProduct([
        //   ...dataProduct,
        //   response.data
        // ]) 

      } catch (error) {
        console.log(error);
      }
    }
  }

  return (
    <ModalContainer id="modal">
      <div id='background-Modal'>
        <div className='containerModalHeader'>
          <h2> Registro de Produto</h2>
          <img src={closed} alt="Fechar" onClick={() => setOpenModal(false)} />
        </div>
        <form ref={formRegisterRef} method='post' onSubmit={registerProduct}>
          <div >
            <label htmlFor="name">Nome:*</label>
            <input id="name" name="name" type="text" maxLength={255} />
          </div>
          <div>
            <label htmlFor="client">Cliente:*</label>
            <input id="client" name="client" type="text" />
          </div>
          <div>
            <label htmlFor="objectives">Objetivos:</label>
            <textarea id="objectives" name='objectives'></textarea>
          </div>
          <div >
            <label htmlFor="vision">Visão do produto</label>
            <textarea id="vision" name='vision'></textarea>
          </div>
          <div>
            <label htmlFor="definitionOfReady" >Definição de Preparado</label>
            <textarea id="definitionOfReady" name='definitionOfReady'></textarea>
          </div>
          <div>
            <label htmlFor="definitionOfDone">Definição de Pronto</label>
            <textarea id="definitionOfDone" name='definitionOfDone'></textarea>
          </div>
          <Button title='Registrar' variant="primary" freesize type='submit' />
        </form>
      </div>
    </ModalContainer>
  );
}
