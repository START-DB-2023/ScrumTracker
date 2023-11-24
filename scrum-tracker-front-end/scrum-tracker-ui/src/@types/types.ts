export enum IStatus {
    A_FAZER = "A_FAZER",
    EM_DESENVOLVIMENTO = "EM_DESENVOLVIMENTO",
    CONCLUIDO = "CONCLUIDO"
}

export enum Priority {
    ALTA = "ALTA",
    MEDIA = "MEDIA",
    BAIXA = "BAIXA"
}

export interface IItemBacklog {
    id: number
    sprintViews: string[]
    status: Status
    priority: Priority
    name: string
    criteriaAcceptance: string
    effortEstimation: string
    sprints: string[]
    userHistory: string
}

export interface IProductBacklog {
    itemsBacklog: IItemBacklog
    product: IProduct
}

export type IProduct = {
    id: number
    name: string
    client: string
    objectives: string
    vision: string
    definitionOfReady: string
    definitionOfDone: string
    productBacklog: IProductBacklog
}

export interface ISprints {
    id: number
    itemBacklogViews: IItemBacklog[]
    sprintGoals: string
    taskSprint: string[]
}