import { SprintContainer, Status, SprintGoals } from "./styles"
import api from '../../connections/api/index'
import { tokenService } from "../../utils/TokenService";
import { NavBar } from "../Home/styles";
import { useEffect, useState } from "react";
import { Priority, IStatus } from "../../@types/types";
import { useNavigate, useParams } from "react-router-dom";
import Button from "../../components/Button";
import { useGlobalContext } from "../../contexts/UserContext";

interface IListSprint {
    id: number
    name: string
    userHistory: string
    priority: Priority
    status: IStatus
    effortEstimation: string
}

export default function Sprints() {
    const [listSprintId, setListSprintId] = useState<IListSprint[]>([])
    const [goalsSprint, setGoalsSprint] = useState("")
    const { id } = useParams()
    const { handleComponent } = useGlobalContext()
    const navigate = useNavigate();

    async function searchSprintId(): Promise<void> {
        try {
            const response = await api.get(`/sprint/${id}`, {
                headers: {
                    Authorization: `Bearer ${tokenService.get("token")}`
                }
            });
            setGoalsSprint(response.data.sprintGoals)
            setListSprintId(response.data.itemBacklogViews)
        } catch (error) {
            console.log(error);
        }
    }

    function routePage(event) {
        navigate("/")
        handleComponent(event)
    }

    useEffect(() => {
        searchSprintId()
    }, [])


    return (
        <SprintContainer>
            <NavBar>
                <ul>
                    <li onClick={() => routePage({ event })}>Home</li>
                    <li onClick={() => routePage({ event })}>Product Backlog</li>
                </ul>
            </NavBar>
            {/* <SprintGoals>dwadwada</SprintGoals> */}
            <main>
                <section>
                    <h3>Objetivo da Sprint</h3>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. I</p>


                </section>
                <table>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>História de Usuário</th>
                            <th>Status</th>
                            <th>Prioridade</th>
                            <th>Estimativa de Esforço</th>
                            <th>Tasks</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {listSprintId.map((product) => {
                            return (
                                <tr key={product.id}>
                                    <td>{product.name}</td>
                                    <td className='history'>{product.userHistory}</td>
                                    <td>{product.status}</td>
                                    <td><Status $statusColor={product.priority}>{product.priority}</Status></td>
                                    <td>{product.effortEstimation}</td>
                                    <td className="button"><Button title="Adicionar task" type="button" variant="primary" freesize={true} /></td>
                                    {/* <td><button>tasks</button></td> */}
                                </tr>
                            )
                        })}
                    </tbody>
                </table>
            </main>
        </SprintContainer>
    )
}