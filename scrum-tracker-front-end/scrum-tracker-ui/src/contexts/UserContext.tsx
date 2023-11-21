import { useState, createContext, useContext, SetStateAction } from "react";

interface GlobalContextProviderProps {
  children: React.ReactNode;
}

type Status = "A Fazer" | "Em desenvolvimento" | "Bloqueado" | "Encaminhado para testes" | "Concluído"
type Priority = "ALTA" | "MÉDIA" | "BAIXA";

interface ContextProps {
  modalOpenSignOut: boolean;
  setModalOpenSignOut: React.Dispatch<SetStateAction<boolean>>;
  openModal: boolean;
  setOpenModal: React.Dispatch<SetStateAction<boolean>>;
  openModalItem: boolean;
  setOpenModalItem: React.Dispatch<SetStateAction<boolean>>;
  openModalEdit: boolean;
  setOpenModalEdit: React.Dispatch<SetStateAction<boolean>>;
  openComponentProject: boolean;
  setOpenComponentProject: React.Dispatch<SetStateAction<boolean>>;
  openComponentProduct: boolean;
  setOpenComponentProduct: React.Dispatch<SetStateAction<boolean>>;
  status: Status[];
  setStatus: React.Dispatch<SetStateAction<Status[]>>;
  priority: Priority[];
  setPriority: React.Dispatch<SetStateAction<Priority[]>>;
}

// Criando o contexto com os valores padrão
/* const GlobalContext = createContext<ContextProps | undefined>(undefined); */

const GlobalContext = createContext<ContextProps>({
  modalOpenSignOut: false,
  setModalOpenSignOut: (): boolean => false,
  openModal: false,
  setOpenModal: (): boolean => false,
  openModalItem: false,
  setOpenModalItem: (): boolean => false,
  openModalEdit: false,
  setOpenModalEdit: (): boolean => false,
  openComponentProject: true,
  setOpenComponentProject: (): boolean => true,
  openComponentProduct: false,
  setOpenComponentProduct: (): boolean => false,
  status: [],
  setStatus: (): void => { },
  priority: [],
  setPriority: (): void => { },
});

export const GlobalContextProvider = ({ children }: GlobalContextProviderProps) => {
  const [modalOpenSignOut, setModalOpenSignOut] = useState(false);
  const [openModal, setOpenModal] = useState(false);
  const [openModalItem, setOpenModalItem] = useState(false);
  const [openModalEdit, setOpenModalEdit] = useState(false);
  const [openComponentProject, setOpenComponentProject] = useState(true);
  const [openComponentProduct, setOpenComponentProduct] = useState(false);
  const [status, setStatus] = useState<Status[]>([
    "A Fazer",
    "Em desenvolvimento",
    "Bloqueado",
    "Encaminhado para testes",
    "Concluído"
  ])
  const [priority, setPriority] = useState<Priority[]>([
    "ALTA",
    "MÉDIA",
    "BAIXA"
  ])

  const props = {
    modalOpenSignOut,
    setModalOpenSignOut,
    openModal,
    setOpenModal,
    openComponentProject,
    setOpenComponentProject,
    openComponentProduct,
    setOpenComponentProduct,
    openModalEdit,
    setOpenModalEdit,
    status,
    setStatus,
    priority,
    setPriority,
    openModalItem,
    setOpenModalItem
  };

  return (
    <GlobalContext.Provider value={props}>{children}</GlobalContext.Provider>
  );
};

export const useGlobalContext = () => useContext(GlobalContext);
