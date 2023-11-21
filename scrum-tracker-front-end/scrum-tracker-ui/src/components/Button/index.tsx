import { ButtonContainer, ButtonContent, ButtonVariants } from "./styles"

interface ButtonProps {
  disabled?: boolean
  icon?: React.ReactNode
  onClick?: React.MouseEventHandler
  title?: string
  type?: "button" | "submit"
  variant?: ButtonVariants
  freesize?: boolean
  shadow?: boolean
}

export default function Button({
  disabled = false,
  icon,
  onClick,
  title = "",
  type = "button",
  variant = "primary",
  freesize = false,
  shadow = false,
}: ButtonProps) {
  return (
    <ButtonContainer variant={variant} $freesize={freesize} $shadow={shadow}>
      <ButtonContent
        $freesize={freesize}
        $shadow={shadow}
        variant={variant}
        className={disabled ? "disabled" : "button"}
        disabled={disabled}
        onClick={onClick}
        type={type}
      >
        <>
          {icon} {title}
        </>
      </ButtonContent>
    </ButtonContainer>
  )
}
