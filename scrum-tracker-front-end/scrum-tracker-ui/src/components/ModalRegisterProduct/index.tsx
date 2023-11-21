import { useRef } from 'react';
import TextAreaModal from '../TextAreaModal/index';
import { ModalContainer } from "./styles";
import api from '../../connections/api';
import { tokenService } from '../../utils/TokenService';
import { useDataProductContext } from "../../contexts/ProductContext"
import Button from '../Button';
import { useGlobalContext } from '../../contexts/UserContext'

interface IregisterProduct {
  name: string,
  client: string,
  objectives: string,
  vision: string,
  state: string,
  ready: string

}

export default function ModalRegisterProduct() {
  const { setOpenModal } = useGlobalContext();

  const { setDataProduct, dataProduct } = useDataProductContext();

  const formRegisterRef = useRef<HTMLFormElement>(null);

  async function registerProduct(event: React.ChangeEvent<HTMLInputElement>): Promise<void> {
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

        try {
          const response = await api.post("product-backlog/", {
            itensBacklog: null,
            product: {...dataProduct}
          }, {
            headers: {
              Authorization: `Bearer ${tokenService.get("token")}`
            }
          });

          console.log(response);


          setDataProduct([
            ...dataProduct,
            response.data
          ])
        } catch (error) {
          console.log(error);
        }
      } catch (error) {
        console.log(error);
      }
    }
  }

  return (
    <ModalContainer id="modal">
      <div id='background-Modal'>
        <h2> Registro de Produto</h2>
        <form ref={formRegisterRef} method='post' onSubmit={registerProduct}>
          <div >
            <label htmlFor="name">Nome:*</label>
            <input id="name" name="name" type="text" maxLength={255} />
          </div>
          <div>
            <label htmlFor="ready">Cliente:*</label>
            <input id="client" name="client" type="text" />
          </div>
          <div>
            <label htmlFor="objectives">Objetivos:</label>
            <TextAreaModal id="objectives" />
          </div>
          <div >
            <label htmlFor="vision">Visão do produto</label>
            <TextAreaModal id="vision" />
          </div>
          <div>
            <label htmlFor="state" >Definição de Preparado</label>
            <TextAreaModal id="state" />
          </div>
          <div>
            <label htmlFor="ready">Definição de Pronto</label>
            <TextAreaModal id="ready" />
          </div>
          <Button title='Registrar' variant="primary" freesize type='submit' />
        </form>

        {/* <img src={SignOut} alt="sair" /> */}
      </div>
    </ModalContainer>
  );
}
