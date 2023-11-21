/* import { ContainerProduct, Status } from './styles';
import { teste } from './list'

export default function ProductBackLog() {
    return (
        <ContainerProduct>
            <table>
                <thead>
                    <tr>
                        <th><h1>Nome</h1></th>
                        <th><h1>História de Usuário</h1></th>
                        <th><h1>Status</h1></th>
                        <th><h1>Prioridade</h1></th>
                        <th><h1>Estimativa de Esforço</h1></th>
                    </tr>
                </thead>
                <tbody>
                    {teste.map((product) => {
                        return (
                            <tr key={product.id}>
                                <td><h1>{product.name}</h1></td>
                                <td><h1 className='history'>{product.history}</h1></td>
                                <td><h1>{product.status}</h1></td>
                                <td><Status $statusColor={product.priority}><h1>{product.priority}</h1></Status></td>
                                <td><h1>{product.estimate}</h1></td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </ ContainerProduct>
    )
} */