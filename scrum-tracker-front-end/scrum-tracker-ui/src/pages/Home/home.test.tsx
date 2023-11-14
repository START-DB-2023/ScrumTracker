import {fireEvent, render, screen} from '@testing-library/react'
import '@testing-library/jest-dom'
import Home from '.';
import { ThemeProvider } from 'styled-components';
import { defaultTheme } from '../../styles/themes/default';
import { GlobalContextProvider } from '../../contexts/UserContext';

describe ('should render home', () => {

    beforeAll(() => {
        render(
            <GlobalContextProvider>
                <ThemeProvider theme={defaultTheme}>
                    <Home/>
                </ThemeProvider>
            </GlobalContextProvider>
        );
    });


});
