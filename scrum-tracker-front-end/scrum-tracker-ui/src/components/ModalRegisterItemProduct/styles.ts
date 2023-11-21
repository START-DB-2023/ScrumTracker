import styled from "styled-components"


export const ModalContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;

  position: fixed;
  top: 14vh;
  left: 0;
  width: 100%;
  overflow-y: scroll;
  max-height: -webkit-fill-available;
  padding: 3rem 0 2rem 0;
  /* height: calc(100% - 14vh); */

  background-color: rgba(145, 154, 150, 0.30);
  backdrop-filter: blur(2px);

  z-index: 3;

  &::-webkit-scrollbar{
        width: 1rem;
        height: 1rem;
    }


    &::-webkit-scrollbar-thumb{
        background: ${props => props.theme.COLORS["green-200"]};
        border-radius: 1rem;
    }

    &::-webkit-scrollbar-thumb:hover {
    background: ${props => props.theme.COLORS["gray-200"]};
}

  .background-Modal {
    background-color: ${props => props.theme.COLORS.white};
    color:${props => props.theme.COLORS.black};
    border: 2px solid ${props => props.theme.COLORS["gray-300"]};
    width : 50rem;
    padding:3rem 4rem;
    border-radius:3rem;

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
    > div {
      display: flex;
      justify-content: space-between;

      padding-bottom: 2rem;
      img{
        cursor: pointer;
      }

      h2{
        font-size: 2.5rem;
      }
    }
    }

`
export const FormContainer = styled.form`

    div{
        display:flex;
        flex-direction:column;
        margin-bottom:1.5rem;
      }
       label{
        margin-bottom: .58em;
        font-weight:${props => props.theme.FONTWEIGHT.bold};
       }
       input, select{
        height: 3.6rem;
        border: 1.5px solid ${props => props.theme.COLORS["gray-200"]};
        border-radius:8px;
        padding-left: 1rem;
        }
        textarea{
            min-height: 5.6rem;
            border: 1.5px solid ${props => props.theme.COLORS["gray-200"]};
            border-radius:8px;
            resize:none;
            padding: .5rem 0 0 1rem;
        }
`

export const ButtonWrapper = styled.section`
display: flex;
gap: 3rem;

margin-top: 5rem;

button{
height: 3rem;
}
`
