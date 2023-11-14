import styled from "styled-components"

export const HomeContainer = styled.div`
position: relative;
height: 86vh;
width: 100vw;
justify-content: end;
align-items: end;



button{
    display:flex;
    align-items: center;
    justify-content: center;
    
    height: 7rem;
    width: 7rem;
    background-color: ${props => props.theme.COLORS["green-300"]};
    
    border-radius: 100px;
    border: none;
    
    position: absolute;
    top: 1.5rem;
    right:1.5rem;
    
    transition: 0.2s;
    filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
    cursor: pointer;
    

    &:hover{
        background-color: ${props => props.theme.COLORS["green-200"]};  
    }


    img{
        height: 3rem;
        width: 3rem;
    }

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
        height: 5rem;
        width: 5rem;
    }
   
}


div{
    width: 100%;
    height: calc(100% - 50px);
    background-color: ${props => props.theme.COLORS["gray-400"]};
    border-top-right-radius: 25%;
    padding: 2rem;

    h1{
        ${props => props.theme.HEADLINE.xl}
        color:${props => props.theme.COLORS.black};
        text-transform: uppercase;

    }

    @media (max-width:400px) {
        border-top-right-radius: 35%;
    }
}
`

export const NavBar = styled.nav`

    display: flex;
    text-transform: uppercase;
    height: 5rem; 
    padding:0 1.5rem;
    max-width:150rem;
    margin: 0 auto;

    ul{
        display: flex;
        gap: 2rem;
        align-self: center;
    }


li{
    list-style: none;
    color: ${props => props.theme.COLORS["green-100"]};
    ${props => props.theme.TEXT.lgLite}
    transition:0.2s;
    cursor:pointer;

    &:hover{
        color: ${props => props.theme.COLORS["green-200"]};  
    }

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
        font-size: ${(props) => props.theme.FONTSIZE.sm};
    }
    @media (${(props) => props.theme.BREAKPOINTS.phone}) {
        font-size: ${(props) => props.theme.FONTSIZE.xs};
    }
}
`
export const HomeContent = styled.section`
    max-width: 150rem;
`