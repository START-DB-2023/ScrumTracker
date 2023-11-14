import SignOut from '../../assets/SignOut.svg'
import {ModalContainer} from "./styles"

export default function ModalSignOut(){

    return(
        <ModalContainer id='modalSignOut'>
            <img src={SignOut} alt="sair" />
        </ModalContainer>
    )
}