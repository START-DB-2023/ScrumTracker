import { Navigate } from 'react-router-dom'
import { tokenService } from "../utils/TokenService";


interface PrivateRouteProps {
    children: React.ReactNode;
}

export default function PrivateRoute({ children }: PrivateRouteProps) {
    const token = tokenService.get("token")

    return token ? children : <Navigate to='/login' />
}