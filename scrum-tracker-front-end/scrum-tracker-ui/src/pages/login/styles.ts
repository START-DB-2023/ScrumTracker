import styled from "styled-components";

export const Container = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;

  @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
    flex-direction: column;
    justify-content: start;
  }

  .image-box {
    background-color: ${(props) => props.theme.COLORS.black};
    width: 50vw;
    height: 100vh;
    display: flex;
    align-itens: center;
    justify-content: center;

    img {
      width: 60%;
    }

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
      width: 100vw;
      height: 30vh;
    }
  }
`;

export const FormContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 50vw;

  form{
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  button {
    cursor: pointer;
    width: 15vw;
    height: 6rem;
    border-radius: ${(props) => props.theme.BORDERRADIUS.md};
    border: none;
    background: ${(props) => props.theme.COLORS["green-300"]};
    color: ${(props) => props.theme.COLORS.white};
    filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
    transition: 0.2s;

    &:hover {
      background: ${(props) => props.theme.COLORS.white};
      color: ${(props) => props.theme.COLORS["green-300"]};
      border: 1px solid ${(props) => props.theme.COLORS["green-300"]};
    }
  }

  div {
    width: 35vw;
    position: relative;

    label {
      color: ${(props) => props.theme.COLORS["gray-600"]};
      ${(props) => props.theme.TEXT.lg};
    }

    input {
      border-radius: ${(props) => props.theme.BORDERRADIUS.sm};
      background-color: ${(props) => props.theme.COLORS["gray-100"]};
      width: 100%;
      height: 5rem;
      margin-bottom: 3rem;
      padding-left: 2rem;
      border: none;

      &::placeholder {
      }
      &:hover {
      }

      &:focus {
        border: 1px solid ${(props) => props.theme.COLORS["green-300"]};
      }

      &:focus + img {
        display: none;
      }
    }

    img {
      position: absolute;
      width: auto;
      height: 5rem;
      right: 0.01rem;
    }

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
      width: 100%;
      
    }
  }
  @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
    width: 100vw;
    height: 70vh;
  }
`;
