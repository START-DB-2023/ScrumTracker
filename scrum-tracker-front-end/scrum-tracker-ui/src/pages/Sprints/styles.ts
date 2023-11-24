import styled from "styled-components"

export const SprintContainer = styled.section`


background-color: ${props => props.theme.COLORS.white};
//border-radius: 3rem;
overflow-y: auto;


height: 86vh;
width: 100vw;
justify-content: end;
align-items: end;



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

main{
    width: 100%;
    height: calc(100% - 50px);
    background-color: ${props => props.theme.COLORS["gray-400"]};
    //border-top-right-radius: 25%;
    padding: 2rem;

    /* h1{
        ${props => props.theme.HEADLINE.xl}
        color:${props => props.theme.COLORS.black};


    } */

    @media (max-width:400px) {
        border-top-right-radius: 33%;
    }

    section{
        color:black;
        width: 90%;
        margin-bottom: 2rem;;
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

    td{
        .button{
            border-top: 0.3rem solid ${props => props.theme.COLORS["gray-100"]};
            display: flex;
            justify-content: center;
            align-items: center;
            &:hover{
                opacity: .5;
            }
        }
        
        button{
            width: 100%;
            height:3.5rem;
        }
    }

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
    MEDIA: "yellow-100",
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

export const SprintGoals = styled.p`
color: ${props => props.theme.COLORS.black};
`