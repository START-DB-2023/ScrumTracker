import { ThemeProvider } from "styled-components";
import { defaultTheme } from "./styles/themes/default";
import { GlobalStyles } from "./styles/global";
import { GlobalContextProvider } from './contexts/UserContext'
import Router from "./routes/Router";
import { ListContextProvider } from "./contexts/UserContextList";
import { DataProductContextProvider } from "./contexts/ProductContext";

function App() {

  return (

    <ThemeProvider theme={defaultTheme}>
      <GlobalStyles />
      <GlobalContextProvider >
        <ListContextProvider>
          <DataProductContextProvider>
            <Router />
          </DataProductContextProvider>
        </ListContextProvider>
      </GlobalContextProvider>
    </ThemeProvider>

  )
}

export default App
