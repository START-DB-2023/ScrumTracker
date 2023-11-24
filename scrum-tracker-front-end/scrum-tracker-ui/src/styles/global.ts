import { createGlobalStyle } from "styled-components";

export const GlobalStyles = createGlobalStyle`

* {
    margin:0;
    padding:0;
    box-sizing:border-box;
}

:focus {
    outline: none;
}

html {
    font-size: 62.5%;
}

body {
    -webkit-font-smoothing: antialiased;
    font-family: 'Poppins', sans-serif;
    color: ${props => props.theme.COLORS.Transparent};
    overflow:hidden; 
}

a{
    text-decoration: none;
}

`