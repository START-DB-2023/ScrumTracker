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


    h1{
    color: ${props => props.theme.COLORS.black};
    ${(props) => props.theme.TEXT.lgLite}
    line-height:2.5rem;
    letter-spacing: 0.008rem;
    }

    

    th, td {
      padding: 0.8rem;
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

    td h1{
    text-align: center;
      max-width: 15rem;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis;
    }

    }


.history{
        max-width: 50rem;
}

`

const STATUS_COLOR = {
  medium: "yellow-200",
  low: "green-300",
  high: "red-500",
} as const;

interface StatusProps {
  $statusColor: keyof typeof STATUS_COLOR;
}

export const Status = styled.span<StatusProps>`
  display: flex;
  align-items: center;
  justify-content:center;

  border-radius:${props => props.theme.BORDERRADIUS.lg};
  background-color: ${(props) =>
      props.theme.COLORS[STATUS_COLOR[props.$statusColor]]};
`;