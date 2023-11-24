import Button from '../Button';
import { ModalContainer } from "./styles";
import closed from '../../assets/close.svg';
import { useDataProductContext } from '../../contexts/ProductContext';
import { useRef } from 'react';
import api from '../../connections/api';
import { tokenService } from '../../utils/TokenService';
import { useListContext } from '../../contexts/UserContextList';

export default function ModalRegisterSprint() {
  const { setOpenModalRegisterSprint, dataProduct } = useDataProductContext()
  const { setListSprints } = useListContext()

  const formRegisterSprint = useRef<HTMLFormElement>(null);
  const Goals = useRef<HTMLTextAreaElement>(null)

  async function registerSprint(event: React.FormEvent<HTMLFormElement>): Promise<void> {
    event?.preventDefault()

    try {
      const response = await api.post("sprint/", {
        sprintGoals: Goals.current?.value,
        itensBacklog: [],
        tasksSprints: [],
        product: dataProduct
      }, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      });

      console.log(response.data);

      setListSprints(response.data);
      setOpenModalRegisterSprint(false)
      searchSprint()
    } catch (error) {
      console.log(error)
    }
  }

  async function searchSprint() {
    try {
      const response = await api.get(`/sprint/product/${dataProduct.id}`, {
        headers: {
          Authorization: `Bearer ${tokenService.get("token")}`
        }
      })
      setListSprints(response.data)
    } catch (error) {
      console.log(Response.error);
    }
  }

  return (
    <ModalContainer id="modal">
      <div id='background-Modal'>
        <div className='containerSprint'>
          <h2> Registro de Sprint</h2>
          <img src={closed} alt="Fechar" onClick={() => setOpenModalRegisterSprint(false)} />
        </div>
        <form ref={formRegisterSprint} method='post' onSubmit={registerSprint}>
          <div>
            <label htmlFor="sprintGoals">Objetivo da Sprint*:</label>
            <textarea id="sprintGoals" ref={Goals}></textarea>
          </div>
          <Button title='Registrar' variant="primary" freesize type='submit' />
        </form>
      </div>
    </ModalContainer>
  );

}