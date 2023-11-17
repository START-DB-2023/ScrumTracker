import Add from '../../assets/add.svg'
import { useEffect } from 'react';
import { useGlobalContext } from '../../contexts/UserContext';
import { HomeContainer, NavBar, HomeContent } from './styles';
import ModalRegisterProduct from '../../components/ModalRegisterProduct';
import Projects from '../../components/Projects';
import ProductBackLog from '../../components/ProductBackLog';


export default function Home(){

    const { openModal, setOpenModal, openComponentProject, setOpenComponentProject, openComponentProduct, setOpenComponentProduct } = useGlobalContext();

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


    useEffect(() => {
        const handleClickOutside = (event: MouseEvent) => {
          const modalElement = document.getElementById("modal");
    
          if (openModal && modalElement && !modalElement.contains(event.target as Node)) {
            setOpenModal(false);
          }
        };
    
        document.addEventListener("mousedown", handleClickOutside);
    
        return () => {
          document.removeEventListener("mousedown", handleClickOutside);
        };
      }, [openModal, setOpenModal]);

    return(
        <>
        <HomeContainer >
            <NavBar>
                <ul>
                <li onClick={() => handleComponent({ event })}>Home</li>
                        <li onClick={() => handleComponent({ event })}>Product Backlog</li>
                    <li>Sprints</li>
                </ul>
                
            </NavBar>
            <button onClick={() => setOpenModal(true)}>
                <img src={Add} alt="Adicionar"/>
            </button>
            
            <div>
                <HomeContent>
                {openComponentProject && <Projects />}
                        {openComponentProduct && <ProductBackLog />}
                </HomeContent>
            </div>
        </HomeContainer>
        {openModal && <ModalRegisterProduct/> }
        </>
    )
}




