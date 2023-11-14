import {fireEvent, render, screen} from '@testing-library/react'
import '@testing-library/jest-dom'
import Header from '.';
import { ThemeProvider } from 'styled-components';
import { defaultTheme } from '../../styles/themes/default';
import { GlobalContextProvider } from '../../contexts/UserContext';

describe ('should render home', () => {

    beforeAll(() => {
        render(
            <GlobalContextProvider>
                <ThemeProvider theme={defaultTheme}>
                    <Header/>
                </ThemeProvider>
            </GlobalContextProvider>
        );
    });

    test('should render logo', () => {
        expect(screen.getByAltText("Logomarca do Scrum Tracker")).toBeInTheDocument();
    });

    test('should render user icon', () => {
        expect(screen.getByAltText("Ícone do Usuário")).toBeInTheDocument();
    });

    test('should render user name', () => {
        expect(screen.getByText("Fulano \n Souza"))
    });
    
});