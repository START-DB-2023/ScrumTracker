import SignOut from '../../assets/SignOut.svg'
import { useGlobalContext } from '../../contexts/UserContext';
import { tokenService } from '../../utils/TokenService';
import { ModalContainer } from "./styles"
import { useNavigate } from 'react-router-dom'

export default function ModalSignOut() {
    const { setModalOpenSignOut } = useGlobalContext();
    const navigate = useNavigate();

    function handleLogout() {
        setModalOpenSignOut(false)
        tokenService.clear()
        navigate('/login')
    }

    return (
        <ModalContainer id='modalSignOut' onClick={handleLogout}>
            <img src={SignOut} alt="sair" />
        </ModalContainer>
    )
}

