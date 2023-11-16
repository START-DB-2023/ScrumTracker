import { ContainerProduct } from './styles';
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
                                <td><h1>{product.nome}</h1></td>
                                <td><h1 className='history'>{product.history}</h1></td>
                                <td><h1>{product.status}</h1></td>
                                <td><h1>{product.prioridade}</h1></td>
                                <td><h1>{product.estimativa}</h1></td>
                            </tr>
                        )
                    })}
                </tbody>
            </table>
        </ ContainerProduct>
    )
}