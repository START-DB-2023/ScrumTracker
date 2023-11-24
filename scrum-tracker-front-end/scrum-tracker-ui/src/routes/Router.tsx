import { BrowserRouter, Route, Routes } from "react-router-dom"
import Home from "../pages/Home"
import Login from "../pages/Login"
import PrivateRoute from "./privateRoute"
import { DefaultLayout } from "../layouts/DefaultLayout"
import Sprints from "../pages/Sprints"


export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/" element={<DefaultLayout />}>
          <Route path="/" element={
            <PrivateRoute>
              <Home />
            </PrivateRoute>
          } />
          <Route path="/sprint/:id" element={
            <PrivateRoute>
              <Sprints />
            </PrivateRoute>
          } />

        </Route>

      </Routes>
    </BrowserRouter>
  )
}
