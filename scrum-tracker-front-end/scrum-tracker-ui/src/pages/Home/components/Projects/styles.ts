import styled from "styled-components"

export const ProjectsMain = styled.section`

display:flex;
flex-direction:column;
gap:2rem;

h1{
    ${props => props.theme.HEADLINE.xl}
    color:${props => props.theme.COLORS.black};
    text-transform: uppercase;

}
section{

    div{
        width: 15rem;
        height: 15rem;
        background-color:${props => props.theme.COLORS.white};
        display:flex;
        justify-content:center;
        align-items:center;
        text-align:center;
        border-radius: ${props => props.theme.BORDERRADIUS.md};
        padding:1rem;
        cursor:pointer;
        box-shadow: 1px 1px 1px 1px ${props => props.theme.COLORS["gray-200"]};

        &:hover{
            opacity:0.8;
        }



    }
    h3{
        color: ${props => props.theme.COLORS.black};
    }
}

`


