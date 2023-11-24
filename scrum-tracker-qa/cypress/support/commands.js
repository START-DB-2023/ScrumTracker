import '@testing-library/cypress/add-commands'

Cypress.Commands.add("LoginScrumTracker", () => {
    cy.visit(Cypress.env("url") +'/login')
    cy.get('input[type="text"]').type(Cypress.env("USER"))
    cy.get('input[type="password"]').type(Cypress.env("USER_PASSWORD"))
    cy.contains('Entrar').click();
    cy.wait(500);
})


// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })