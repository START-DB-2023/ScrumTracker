//1. acessar pagina
describe('Add and edit product', () => {
    
    beforeEach(()=> {
        cy.LoginScrumTracker(Cypress.env("USER"), Cypress.env("PASSWORD"))
        cy.visit(Cypress.env("url") + "/")
        cy.wait(2000);
    })

    it('Should open modal when the button was clicked and show the product', () => {
        const nomeDoproduto = 'Texto de teste';
        
        cy.get('button').click()
        cy.wait(1000)
        cy.get('#modal').should('be.visible');
        cy.get('input[name="name"]').type("nomeDoproduto")
        cy.get('input[name="client"]').type("Cliente teste")
        cy.get('button[type="submit"]').click();
        cy.wait(1000)

        cy.get('#div-project').should('be.visible');
        cy.get('[data-cy="product-name"]').contains( "nomeDoproduto");

    })

    it('when name and client is balnk should show a error message', () => {
        
        cy.get('button').click()
        cy.wait(1000)
        cy.get('#modal').should('be.visible');
        cy.get('button[type="submit"]').click();
        cy.wait(1000)

        cy.get('.Toastify__toast.Toastify__toast-theme--light.Toastify__toast--error.Toastify__toast--close-on-click').should('be.visible');


    })

    it('when edited product shold change the name inside the div ', () => {
        
        cy.get('button').click()
        cy.wait(1000)
        cy.get('#modal').should('be.visible');
        cy.get('input[name="name"]').type("nomeDoproduto")
        cy.get('input[name="client"]').type("Cliente teste")
        cy.get('button[type="submit"]').click();
        cy.wait(1000)

        cy.get('#div-project').click()
        cy.wait(1000)
        cy.get('#modal').should('be.visible');
        cy.get('input[name="name"]').clear();
        cy.get('input[name="name"]').type("Projeto Errata")
        cy.get('button[type="submit"]').click();
        cy.wait(1000)

        cy.get('[data-cy="product-name"]').contains("Projeto Errata");


    })
    
    // it('Should click the button and redict to "/"', () => {
    //     cy.visit(Cypress.env("url") +'/Login')
    //     cy.get('input[type="text"]').type(Cypress.env("USER"))
    //     cy.get('input[type="password"]').type(Cypress.env("USER_PASSWORD"))
    //     cy.get('button[type="submit"]').click();
    //     cy.wait(500)
    //     // url deve ser igual a url + /
    //     cy.url().should('eq', Cypress.env("url") + '/');
        
    // })

})