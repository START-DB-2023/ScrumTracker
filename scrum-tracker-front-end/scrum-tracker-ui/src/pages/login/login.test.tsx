import {fireEvent, render, screen} from '@testing-library/react'
import '@testing-library/jest-dom'
import Login from '.'
import { ThemeProvider } from 'styled-components';
import { defaultTheme } from '../../styles/themes/default';


describe ('should render login', () => {

    beforeAll(() => {
        render(
            <ThemeProvider theme={defaultTheme}>
                <Login />
            </ThemeProvider>
        );
    });
    
    test('should render logo', () => {
        expect(screen.getByAltText('Imagem da logomarca do Scrum Tracker')).toBeInTheDocument();
    });
    
    test('should render email label', () => {
        expect(screen.getByText("E-mail:")).toBeInTheDocument();
    });

    test('should render email input', () => {
        expect(screen.getByPlaceholderText("Digite seu e-mail")).toBeInTheDocument();
    });

    test('should render email icon', () => {
        expect(screen.getByAltText('Ícone de e-mail')).toBeInTheDocument();
    });

    test('should render password label', () => {
        expect(screen.getByText("Senha:")).toBeInTheDocument();
    });

    test('should render password input', () => {
        expect(screen.getByPlaceholderText("Digite sua senha")).toBeInTheDocument();
    });

    test('should render password icon', () => {
        expect(screen.getByAltText('Ícone de senha')).toBeInTheDocument();
    });

    test('should render sign in button', () => {
        expect(screen.getByText("Entrar")).toBeInTheDocument();
    });

})

describe ('should react to events', () => {

    beforeAll(() => {
        render(
            <ThemeProvider theme={defaultTheme}>
                <Login />
            </ThemeProvider>
        );
    });

    test('button should change style when hovered', () => {
        const button = screen.getByText("Entrar");
        fireEvent.mouseOver(button);
        expect(button).toHaveStyle(`background: ${(props: { theme: { COLORS: { white: string; }; }; }) => props.theme.COLORS.white}`)
    })
})

// ${({ theme }) => theme.BREAKPOINTS.md}