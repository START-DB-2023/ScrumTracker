import styled from "styled-components"

export const ModalContainer = styled.div`

    background-color: ${props => props.theme.COLORS.white};
    color:${props => props.theme.COLORS.black};
    border: 2px solid ${props=>props.theme.COLORS["gray-300"]};
    width : 60rem; 
    position: absolute; 
    top: 15vh;
    right: calc(50% - 30rem);
    display:flex; 
    justify-content:center;
    flex-direction:column;
    align-itens:center;
    padding:3rem 4rem;
    border-radius:3rem;
    gap: 2rem;
    height: 63rem;
    overflow-y: scroll;
    

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
        width: 40rem;
        right: calc(50% - 20rem);
        padding:2rem 3rem;
    }

    @media (max-width:430px) {
        width: 30rem;
        right: calc(50% - 15rem);
        padding:1rem 3rem;
        top: 20vh;
    }

    form{
        
       div{


        display:flex;
        flex-direction:column; 

        margin-bottom:1.5rem;
       }

       label{
        margin-bottom: .58em;
        font-weight:${props=>props.theme.FONTWEIGHT.bold};
       }

       input{
        height: 3.6rem;
        border: 1.5px solid ${props=>props.theme.COLORS["gray-200"]};
        border-radius:8px;
        }
        textarea{
            min-height: 5.6rem;
            border: 1.5px solid ${props=>props.theme.COLORS["gray-200"]};
            border-radius:8px;
            resize:none;
            
        }

    }
    
   
    
    


`