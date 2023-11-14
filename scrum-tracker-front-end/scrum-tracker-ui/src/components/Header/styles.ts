import styled from "styled-components"

export const HeaderContainer = styled.header`
  background-color: ${(props) => props.theme.COLORS.black};
  height: 14vh;
`
export const HeaderContent = styled.div`
  width: 100%;
  height: 100%;
  max-width: 150rem;
  margin: 0 auto;
  padding: 0 1.5rem;

  display: flex;
  justify-content: space-between;
  align-items: center;

  > img {
    width: 25rem;
    object-fit: contain;
  }

  @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
    > img {
      width: 18rem;
      object-fit: contain;
    }
  }
`
export const LoginContent = styled.div`
  display: flex;
  align-items: center;
  gap: 2.4rem;

  img {
    object-fit: cover;
    cursor: pointer;

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
      width: 4.0rem;
    }
  }

  div{
    position: relative;
  }

  span {
    color: ${(props) => props.theme.COLORS.white};
    ${(props) => props.theme.TEXT.lgLite}
    line-height:2.5rem;

    @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
      font-size: ${(props) => props.theme.FONTSIZE.base};
    }
  }

  @media (${(props) => props.theme.BREAKPOINTS.tablet}) {
    gap: 1.5rem;
  }

  
`
