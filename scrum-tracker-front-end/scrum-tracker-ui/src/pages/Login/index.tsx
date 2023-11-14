import {Container, FormContainer} from "./styles";
import Logo from '../../assets/Logo.svg';
import IconEmail from '../../assets/email.svg';
import IconSenha from '../../assets/senha.svg';
import {useState} from "react";
import api from "../../connections/api";

export default function Login(){
    const [email, setEmail] = useState<string>("")
    const [password, setPassword] = useState<string>("");

    async function handleSubmit(e: React.FormEvent<HTMLFormElement>){
        e.preventDefault()
        
        try {
            const response = await api.get("/hello/authenticated",{
            headers : {
                authorization: `Basic ${btoa(email+":"+password)}`
            }}); 

            console.log(response);
            
    } catch(error){
        return console.log(error);
        
    }
}

    return (
        <>
        <Container>

            <div className="image-box">
                <img src={Logo} alt="Imagem da logomarca do Scrum Tracker"  />
            </div>
           
            <FormContainer>
                <form onSubmit={handleSubmit}>
                    <div>
                        <label htmlFor="">E-mail:</label>
                        <input value={email} onChange={(e:React.ChangeEvent<HTMLInputElement>)=>{setEmail(e.target.value)}} type="email" placeholder="Digite seu e-mail"/>
                        <img src={IconEmail} alt="Ícone de e-mail"/>
                    </div>
                    <div>
                        <label htmlFor="">Senha:</label>
                        <input value={password} type="password" onChange={(e:React.ChangeEvent<HTMLInputElement>)=>{setPassword(e.target.value)}} placeholder="Digite sua senha"/>
                        <img src={IconSenha} alt="Ícone de senha" />
                    </div>
                    <button type="submit">Entrar</button>
                </form>
            </FormContainer>
        </Container>
        </>
    )
}