import { ThemeProvider } from "styled-components";
import { defaultTheme } from "./styles/themes/default";
import { GlobalStyles } from "./styles/global";
import {GlobalContextProvider} from './contexts/UserContext'
import Router from "./routes/Router";

function App() {

  return (
   
    <ThemeProvider theme={defaultTheme}>
      <GlobalStyles/>
      <GlobalContextProvider >
      <Router/>
      </GlobalContextProvider>
    </ThemeProvider>

  )
}

export default App
