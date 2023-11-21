import Add from '../../assets/add.svg'
import { useEffect } from 'react';
import { useGlobalContext } from '../../contexts/UserContext';
import { HomeContainer, NavBar, HomeContent } from './styles';
import ModalRegisterProduct from '../../components/ModalRegisterProduct';
import Projects from './components/Projects';
import ProductBackLog from './components/ProductBackLog';
import Button from '../../components/Button';
import { Plus } from "phosphor-react"
import ModalRegisterItemProduct from '../../components/ModalRegisterItemProduct';


export default function Home() {

  const { openModal, setOpenModal, openComponentProject, setOpenComponentProject,
    openComponentProduct, setOpenComponentProduct, setOpenModalItem,
    openModalItem } = useGlobalContext();

  function handleComponent(event: { event?: Event | undefined }) {

    const saida = (event.event?.target as HTMLElement).textContent;
    if (saida === "Home") {
      setOpenComponentProject(true);
      setOpenComponentProduct(false)
    } else if (saida === "Product Backlog") {
      setOpenComponentProject(false);
      setOpenComponentProduct(true)
    }

  }

  function openModalComponent() {
    if (openComponentProject) {
      setOpenModal(true)
    } else if (openComponentProduct) {
      setOpenModalItem(true)
    }
  }


  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      const modalElementBackground = document.getElementById("modal");
      const modalElement = document.getElementById("background-Modal");

      if (openModal && modalElement && modalElementBackground && !modalElement.contains(event.target as Node)) {
        setOpenModal(false);
      }
    };

    document.addEventListener("mousedown", handleClickOutside);

    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, [openModal, setOpenModal]);

  return (
    <>
      <HomeContainer >
        <NavBar>
          <ul>
            <li onClick={() => handleComponent({ event })}>Home</li>
            <li onClick={() => handleComponent({ event })}>Product Backlog</li>
            <li>Sprints</li>
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
    </>
  )
}




