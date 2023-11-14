import styled from "styled-components"

export const ModalContainer = styled.div`
display:flex;
align-items: center;
justify-content: center;

width: 100%;
height: 100%;

background-color: ${props => props.theme.COLORS["gray-400"]};
border:1px solid ${props => props.theme.COLORS.white};
position: absolute !important;
left: 2rem;

z-index:1;
`