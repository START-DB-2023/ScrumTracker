import Logo from "../../assets/Logo.svg"
import User from "../../assets/User.svg"
import ModalSignOut from "../ModalSignOut"
import { useEffect } from "react"
import { useGlobalContext } from "../../contexts/UserContext"
import { HeaderContainer, HeaderContent, LoginContent } from "./styles"


const Header = () => {
  const {modalOpenSignOut, setModalOpenSignOut} = useGlobalContext();

    useEffect(() => {
      const handleClickOutside = (event: MouseEvent) => {
        const modalElement = document.getElementById("modalSignOut");
  
        if (modalOpenSignOut && modalElement && !modalElement.contains(event.target as Node)) {
          setModalOpenSignOut(false);
        }
      };
  
      document.addEventListener("mousedown", handleClickOutside);
  
      return () => {
        document.removeEventListener("mousedown", handleClickOutside);
      };
    }, [modalOpenSignOut, setModalOpenSignOut]);


  return (
    <HeaderContainer>
      <HeaderContent>
        <img src={Logo} alt="Logomarca do Scrum Tracker"/>
        
        <LoginContent>
          <div>
            <img src={User} alt="Ícone do Usuário" onClick={() => setModalOpenSignOut(true)}/>
            {modalOpenSignOut && <ModalSignOut />}
          </div>
          <span>
            {localStorage.getItem("name")} <br /> {localStorage.getItem("lastName")}
          </span>
        </LoginContent>
      </HeaderContent>
    </HeaderContainer>
  )
}

export default Header
