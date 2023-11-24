import { useEffect } from 'react';
import { useGlobalContext } from '../../contexts/UserContext';
import { HomeContainer, NavBar, HomeContent } from './styles';
import ModalRegisterProduct from '../../components/ModalRegisterProduct';
import Projects from './components/Projects';
import ProductBackLog from './components/ProductBackLog';
import Button from '../../components/Button';
import { Plus } from "phosphor-react"
import ModalRegisterItemProduct from '../../components/ModalRegisterItemProduct';
import { useDataProductContext } from '../../contexts/ProductContext';
import ModalRegisterSprint from '../../components/ModalRegisterSprint';


export default function Home() {

  const { openModal, openComponentProject,
    openComponentProduct, openModalItem, handleComponent, openModalComponent } = useGlobalContext();
  const { setOpenModalRegisterSprint, openModalRegisterSprint } = useDataProductContext()

  return (
    <>
      <HomeContainer >
        <NavBar>
          <ul>
            <li onClick={() => handleComponent({ event })}>Home</li>
            <li onClick={() => handleComponent({ event })}>Product Backlog</li>
            <li onClick={() => setOpenModalRegisterSprint(true)} >Sprints</li>
          </ul>
          <Button variant='primary' shadow={true} freesize={false} icon={<Plus />} onClick={openModalComponent} />
        </NavBar>

        <div className='containerMain'>
          <HomeContent>
            {openComponentProject && <Projects />}
            {openComponentProduct && <ProductBackLog />}
          </HomeContent>
        </div>
      </HomeContainer>
      {openModal && <ModalRegisterProduct />}
      {openModalItem && <ModalRegisterItemProduct />}
      {openModalRegisterSprint && <ModalRegisterSprint />}
    </>
  )
}




