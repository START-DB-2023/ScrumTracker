import styled from "styled-components"

export type ButtonVariants = "primary" | "secondary" | "danger" | "noDecoration"

interface IButtonProps {
  variant: ButtonVariants
  $freesize: boolean
  $shadow: boolean
}

export const ButtonContainer = styled.div<IButtonProps>`
  width: ${(props) => (props.$freesize ? "100%" : "fit-content")};

  .button {
    background-color: ${({ theme, variant }) =>
    variant === "primary"
      ? theme.COLORS["green-200"]
      : variant === "danger"
        ? theme.COLORS["red-600"]
        : variant === "noDecoration"
          ? theme.COLORS.Transparent
          : theme.COLORS.white};
    border: ${({ theme, variant }) =>
    variant === "secondary"
      ? `2px solid ${theme.COLORS["green-200"]}`
      : "none"};
    color: ${({ theme, variant }) =>
    variant === "primary"
      ? theme.COLORS.white
      : variant === "danger"
        ? theme.COLORS.white
        : theme.COLORS["green-200"]};
    cursor: pointer;

    :hover {
      background-color: ${({ theme, variant }) =>
    variant === "primary"
      ? theme.COLORS["green-300"]
      : variant === "danger"
        ? theme.COLORS["red-400"]
        : theme.COLORS["lightgreen-100"]};

      border: ${({ theme, variant }) =>
    variant === "secondary"
      ? `2px solid ${theme.$COLORS["green-300"]}`
      : "none"};
    }

    :active {
      background-color: ${({ theme, variant }) =>
    variant === "primary"
      ? theme.COLORS["green-300"]
      : theme.COLORS["lightgreen-200"]};
      border: ${({ theme, variant }) =>
    variant === "secondary"
      ? `2px solid ${theme.COLORS["green-300"]}`
      : "none"};
    }
  }

  .disabled {
    background-color: ${({ theme, variant }) =>
    variant === "primary" ? theme.COLORS["gray-300"] : theme.COLORS.white};
    border: ${({ theme, variant }) =>
    variant === "secondary"
      ? `2px solid ${theme.COLORS["gray-500"]}`
      : "none"};
    color: ${({ theme }) => theme.COLORS["gray-500"]};
    cursor: not-allowed;
  }
`
export const ButtonContent = styled.button<IButtonProps>`
  align-items: center;
  border-radius: ${props => props.theme.BORDERRADIUS.md};
  display: flex;
  font-size: ${props => props.theme.FONTSIZE.base};
  font-weight: ${props => props.theme.FONTWEIGHT.bold};
  gap: 1rem;
  justify-content: center;
  line-height: 1.75rem;
  filter: ${(props) =>
    props.$shadow ? "drop-shadow(0px 5px 10px rgba(0, 0, 0, 0.3))" : "none"};
  transition: 0.2s;
`
