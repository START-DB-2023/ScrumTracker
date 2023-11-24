import Logo from "../../assets/Logo.svg"
import User from "../../assets/User.svg"
import ModalSignOut from "../ModalSignOut"
import { useGlobalContext } from "../../contexts/UserContext"
import { HeaderContainer, HeaderContent, LoginContent } from "./styles"


const Header = () => {
  const { modalOpenSignOut, setModalOpenSignOut } = useGlobalContext();
  return (
    <HeaderContainer>
      <HeaderContent>
        <img src={Logo} alt="Logomarca do Scrum Tracker" />
        <LoginContent>
          <div>
            <img src={User} alt="Ícone do Usuário" onClick={() => setModalOpenSignOut(!modalOpenSignOut)} />
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
