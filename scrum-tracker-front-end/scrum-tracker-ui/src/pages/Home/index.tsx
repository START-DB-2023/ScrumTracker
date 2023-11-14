import Add from '../../assets/add.svg'
import { useEffect } from 'react';
import { useGlobalContext } from '../../contexts/UserContext';
import { HomeContainer, NavBar, HomeContent } from './styles';
import ModalRegisterProduct from '../../components/ModalRegisterProduct';


export default function Home(){

    const {openModal, setOpenModal} = useGlobalContext();

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
                    <li>Home</li>
                    <li>Product Backlog</li>
                    <li>Sprints</li>
                </ul>
                
            </NavBar>
            <button onClick={() => setOpenModal(true)}>
                <img src={Add} alt="Adicionar"/>
            </button>
            
            <div>
                <HomeContent>
                    <h1>Meus projetos</h1>
                </HomeContent>
            </div>
        </HomeContainer>
        {openModal && <ModalRegisterProduct/> }
        </>
    )
}




