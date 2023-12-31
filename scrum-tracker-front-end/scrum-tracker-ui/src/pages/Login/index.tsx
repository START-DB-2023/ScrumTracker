import { Container, FormContainer } from "./styles";
import Logo from '../../assets/Logo.svg';
import IconEmail from '../../assets/email.svg';
import IconSenha from '../../assets/senha.svg';
import { useState } from "react";
import api from "../../connections/api";
import { toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { validateEmail } from "../../utils/Validation";
import { useNavigate } from "react-router-dom";
import { tokenService } from "../../utils/TokenService";
import Spinner from "../../components/Spinner";
import { AxiosError } from 'axios';
import { useDataProductContext } from "../../contexts/ProductContext";
/* import {useDataProductContext} from '../../contexts/ProductContext' */


export default function Login() {
  const [email, setEmail] = useState<string>("")
  const [password, setPassword] = useState<string>("");
  const [loading, setLoading] = useState<boolean>(false);

  const { setDataProduct } = useDataProductContext();

  /* const {searchProjects} = useDataProductContext(); */

  const navigate = useNavigate();

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault()

    //Valida o Campo Email
    const validationEmail = validateEmail(email)
    if (!validationEmail.isValid) {
      return (
        toast.error(validationEmail.message, {
        }))
    }

    if (!password) {
      return (
        toast.error("Campo Senha é obrigatório")
      )
    }

    try {
      setLoading(true);
      const response = await api.post("/login", {
        email: email,
        password: password
      });

      const token = response.data.token;

      //salvando no localStorage
      tokenService.save("token", token)
      tokenService.save("name", response.data.name)
      tokenService.save("lastName", response.data.lastName)
      tokenService.save("role", response.data.role)

      if (tokenService.get("token")) {
        setLoading(false);
        searchProjects()
        toast.success("Login efetuado com sucesso", {});
        navigate("/");
      }

    } catch (error) {
      if (error instanceof AxiosError && error.response?.data.exceptionMessage === "Bad credentials.") {
        return (
          setLoading(false),
          toast.error("Email ou senha inválido", {
          })
        )
      }
    }
  }

  async function searchProjects(): Promise<void> {

    try {
      const response = await api.get("/product/", {
      });
      setDataProduct(response.data)
      //console.log(response.data.id);

    } catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      <Container>

        <div className="image-box">
          <img src={Logo} alt="Imagem da logomarca do Scrum Tracker" />
        </div>

        <FormContainer>
          <form onSubmit={handleSubmit}>
            <div>
              <label htmlFor="">E-mail:</label>
              <input value={email} onChange={(e: React.ChangeEvent<HTMLInputElement>) => { setEmail(e.target.value) }} type="text" placeholder="Digite seu e-mail" />
              <img src={IconEmail} alt="Ícone de e-mail" />
            </div>
            <div>
              <label htmlFor="">Senha:</label>
              <input value={password} type="password" onChange={(e: React.ChangeEvent<HTMLInputElement>) => { setPassword(e.target.value) }} placeholder="Digite sua senha" />
              <img src={IconSenha} alt="Ícone de senha" />
            </div>
            {loading ? <Spinner /> : <button type="submit">Entrar</button>}

          </form>
        </FormContainer>
      </Container>
    </>
  )
}
