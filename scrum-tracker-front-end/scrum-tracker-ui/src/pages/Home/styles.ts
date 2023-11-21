import styled from "styled-components"

export const HomeContainer = styled.div`
position: relative;
height: 86vh;
width: 100vw;
justify-content: end;
align-items: end;

.containerMain{
    width: 100%;
    height: calc(100% - 50px);
    background-color: ${props => props.theme.COLORS["gray-400"]};
    border-top-right-radius: 25%;
    padding: 2rem;

    /* h1{
        ${props => props.theme.HEADLINE.xl}
        color:${props => props.theme.COLORS.black};


    } */

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

    button{
    position: absolute;
    right: 3rem;
    top: 2rem;
    height: 6rem;
    width: 6rem;
    border-radius: 100px !important;
}

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
