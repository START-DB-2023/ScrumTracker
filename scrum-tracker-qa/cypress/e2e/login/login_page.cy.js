//1. acessar pagina
describe('realizar login Scrum Tracker', () => {
    
    beforeEach(()=> {
        cy.visit(Cypress.env("url") + '/Login')
    })

    it('Should have form elements', () => {
        cy.get('input[type="password"]').should('be.visible');
        cy.get('input[type="text"]').should('be.visible');
        cy.get('button[type="submit"]').should('be.visible');
    })
    it('Should click the button and redict to "/"', () => {
        cy.visit(Cypress.env("url") +'/Login')
        cy.get('input[type="text"]').type(Cypress.env("USER"))
        cy.get('input[type="password"]').type(Cypress.env("USER_PASSWORD"))
        cy.get('button[type="submit"]').click();
        cy.wait(500)
        // url deve ser igual a url + /
        cy.url().should('eq', Cypress.env("url") + '/');
        
    })
    it('when the password is incorrect, toastfy should appear and remain on the login page', () => {
        cy.visit(Cypress.env("url") +'/Login')
        cy.get('input[type="text"]').type(Cypress.env("USER"))
        cy.get('input[type="password"]').type("senhaerrada")
        cy.get('button[type="submit"]').click();
    
        cy.get('.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error.Toastify__toast--close-on-click').should('be.visible');
        // url deve ser igual a url + /
        cy.url().should('eq', Cypress.env("url") + '/Login');
        
    })

    it('when the email and password is incorrect, toastfy should appear and remain on the login page', () => {
        cy.visit(Cypress.env("url") +'/Login')
        cy.get('input[type="text"]').type("fhsdj")
        cy.get('input[type="password"]').type("gfdg")
        cy.get('button[type="submit"]').click();
    
        cy.get('.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error.Toastify__toast--close-on-click').should('be.visible');
        // url deve ser igual a url + /
        cy.url().should('eq', Cypress.env("url") + '/Login');
        
    })

    it('when the email is invalid, toastfy should appear and remain on the login page', () => {
        cy.visit(Cypress.env("url") +'/Login')
        cy.get('input[type="text"]').type(".email@.com")
        cy.get('input[type="password"]').type("gfdg")
        cy.get('button[type="submit"]').click();
    
        cy.get('.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error.Toastify__toast--close-on-click').should('be.visible');
        // url deve ser igual a url + /
        cy.url().should('eq', Cypress.env("url") + '/Login');
        
    })

    it('when the unauthenticated user tries to access a private route it must redirect to "/login"', () => {
        
        cy.visit(Cypress.env("url") +'/')
        cy.url().should('eq', Cypress.env("url") + '/login');
        
        
    })

})

