import styled from "styled-components"

export const ModalContainer = styled.div`

display: flex;
  align-items: center;
  justify-content: center;

  position: fixed;
  top: 14vh;
  left: 0;
  width: 100%;
  height:100%;
  overflow-y: scroll;
  max-height: -webkit-fill-available;
  padding: 12rem 0 2rem 0;

  z-index: 3;


    background-color: rgba(145, 154, 150, 0.30);
    backdrop-filter: blur(2px);

    #background-Modal {
      background-color: ${props => props.theme.COLORS.white};
    color:${props => props.theme.COLORS.black};
    border: 2px solid ${props => props.theme.COLORS["gray-300"]};
    width : 50rem;
    padding:3rem 4rem;
    border-radius:3rem;
    gap: 2rem;
    }

    &::-webkit-scrollbar{
        width: 0.5rem;
        height: 0.5rem;
    }

    &::-webkit-scrollbar-thumb{
        background: ${props => props.theme.COLORS["gray-200"]};
        border-radius: 1rem;
    }

    &::-webkit-scrollbar-thumb:hover {
    background: ${props => props.theme.COLORS["green-200"]};
}

.containerSprint{
    display: flex;
    justify-content: space-between;
    align-items: center;

    margin-bottom: 2rem;
}

    h2{
        font-size: 2.5rem;
        
    }

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
     
        padding:2rem 3rem;
    }

    @media (max-width:430px) {
        
        padding:1rem 3rem;
       
    }

    form{

       div{
        display:flex;
        flex-direction:column;

        margin-bottom:1.5rem;
       }

       label{
        margin-bottom: .58em;
        font-weight:${props => props.theme.FONTWEIGHT.bold};
       }

       input{
        height: 3.6rem;
        border: 1.5px solid ${props => props.theme.COLORS["gray-200"]};
        border-radius:8px;
        }
        textarea{
            height: 9.6rem;
            border: 1.5px solid ${props => props.theme.COLORS["gray-200"]};
            border-radius:8px;
            resize:none;

        }
        button{
            margin-top: 2rem;
            height:3rem;
        }


    }






`

