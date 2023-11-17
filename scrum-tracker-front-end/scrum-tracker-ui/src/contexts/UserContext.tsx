import { useState, createContext, useContext, SetStateAction} from "react";

interface GlobalContextProviderProps {
  children: React.ReactNode;
}
  
interface ContextProps {
    modalOpenSignOut: boolean;
    setModalOpenSignOut: React.Dispatch<SetStateAction<boolean>>;
    openModal:boolean; 
    setOpenModal: React.Dispatch<SetStateAction<boolean>>;
    openComponentProject: boolean;
  setOpenComponentProject: React.Dispatch<SetStateAction<boolean>>;
  openComponentProduct: boolean;
  setOpenComponentProduct: React.Dispatch<SetStateAction<boolean>>;
}

const GlobalContext = createContext<ContextProps>({
  modalOpenSignOut: false,
  setModalOpenSignOut: (): boolean => false,
  openModal: false,
  setOpenModal: (): boolean => false,
  openComponentProject: true,
  setOpenComponentProject: (): boolean => true,
  openComponentProduct: false,
  setOpenComponentProduct: (): boolean => false,
});

export const GlobalContextProvider = ({ children }: GlobalContextProviderProps) => {
  const [modalOpenSignOut, setModalOpenSignOut] = useState(false);
  const [openModal, setOpenModal] = useState(false);
  const [openComponentProject, setOpenComponentProject] = useState(true);
  const [openComponentProduct, setOpenComponentProduct] = useState(false);

  const props = {
    modalOpenSignOut,
    setModalOpenSignOut,
    openModal,
    setOpenModal,
    openComponentProject,
    setOpenComponentProject,
    openComponentProduct,
    setOpenComponentProduct
  };

  return (
    <GlobalContext.Provider value={props}>{children}</GlobalContext.Provider>
  );
};

export const useGlobalContext = () => useContext(GlobalContext);
