describe('Navigate', () => {
    
    beforeEach(()=> {
        cy.LoginScrumTracker(Cypress.env("USER"), Cypress.env("PASSWORD"))
        cy.visit(Cypress.env("url") + "/")
        cy.wait(2000);
    })

    it('', () => {
        
        
        cy.get('ul > :nth-child(2)').should('contain', 'Product Backlog')
        cy.get('ul > :nth-child(2)').click()
        cy.get('table').should('be.visible')

        cy.get('ul > :nth-child(1)').should('contain', 'Home');
        cy.get('ul > :nth-child(1)').click()
        cy.get('h1').should('contain', 'Meus projetos')
        
        cy.get('ul > :nth-child(3)').should('contain', 'Sprints')
        cy.get('ul > :nth-child(3)').click()
        cy.wait(1000)
        cy.get('#background-Modal').should('be.visible');

    })


})