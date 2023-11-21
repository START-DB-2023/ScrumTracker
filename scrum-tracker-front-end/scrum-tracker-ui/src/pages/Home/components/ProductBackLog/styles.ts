import styled from "styled-components"

export const ContainerProduct = styled.section`

width: 88%;
background-color: ${props => props.theme.COLORS.white};
border-radius: 3rem;
overflow-y: auto;
max-height: 45rem;


&::-webkit-scrollbar{
        width: 0.5rem;
        height: 0.5rem;
    }

    &::-webkit-scrollbar-track-piece{
        margin: 4.5rem;
    }

    &::-webkit-scrollbar-thumb{
        background: ${props => props.theme.COLORS["green-100"]};
        border-radius: 1rem;
    }

    &::-webkit-scrollbar-thumb:hover {
    background: ${props => props.theme.COLORS.black};
}


table{
  
    width: 100%;
    border-collapse: collapse;


    th{
    color: ${props => props.theme.COLORS.black};
    ${(props) => props.theme.TEXT.lgLite}
    line-height:2.5rem;
    letter-spacing: 0.008rem;
    }



    .options {
        display: flex;
        gap: 25px;
    }



    th, td {
      padding: 0.8rem;
      font-size: 1.4rem;
    }

    td{
        color: ${props => props.theme.COLORS.black};
    ${(props) => props.theme.TEXT.lgLite}
    line-height:2.5rem;
    letter-spacing: 0.008rem;
    text-align: center;
      max-width: 15rem;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
      font-size: 1.4rem;
    }

    }

    thead{
        position: sticky;
        top: 0;
        background-color: ${props => props.theme.COLORS["gray-100"]};
    }

    tbody{
        tr{
          
            &:hover{
                background-color: ${props => props.theme.COLORS["gray-200"]};
                cursor: pointer;
            }
        }
    }

    td{
      
        border-top: 0.3rem solid ${props => props.theme.COLORS["gray-100"]};
    }

    /* td h1{
    text-align: center;
      max-width: 15rem;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    } */






.history{
        max-width: 50rem;
        text-align: center;
      max-width: 15rem;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
}

`

const STATUS_COLOR = {
  MÉDIA: "yellow-100",
  BAIXA: "green-300",
  ALTA: "red-500",
} as const;

interface StatusProps {
  $statusColor: keyof typeof STATUS_COLOR;
}

export const Status = styled.span<StatusProps>`
  display: flex;
  align-items: center;
  justify-content:center;

  text-transform: uppercase;

  border-radius:${props => props.theme.BORDERRADIUS.lg};
  background-color: ${(props) =>
    props.theme.COLORS[STATUS_COLOR[props.$statusColor]]};
`;

