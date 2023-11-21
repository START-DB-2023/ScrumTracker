import { useState, createContext, useContext, SetStateAction, useEffect } from "react";
import api from '../connections/api'

interface DataProductContextProviderProps {
  children: React.ReactNode;
}

type Listagem = {
  id: number
  name: string
  client: string
  objectives: string
  vision: string
  ready: string
  state: string
  productBacklog: string
}

interface ContextProps {
  dataProduct: Listagem[];
  setDataProduct: React.Dispatch<SetStateAction<Listagem[]>>;
  openModalEditProduct: boolean;
  setOpenModalEditProduct: React.Dispatch<SetStateAction<boolean>>;
}

const DataProductContext = createContext<ContextProps>({
  dataProduct: [],
  setDataProduct: (): void => { },
  openModalEditProduct: false,
  setOpenModalEditProduct: (): boolean => false,
});

export const DataProductContextProvider = ({ children }: DataProductContextProviderProps) => {
  const [dataProduct, setDataProduct] = useState<Listagem[]>([])
  const [openModalEditProduct, setOpenModalEditProduct] = useState(false)

  async function searchProjects(): Promise<void> {

    try {
      const response = await api.get("/product/", {
      });
      setDataProduct(response.data)
      console.log(response.data);
      
    } catch (error) {
      console.log(error);

    }
  }

  useEffect(() => {
    searchProjects()
  }, [])

  const props = {
    dataProduct,
    setDataProduct,
    searchProjects,
    openModalEditProduct,
    setOpenModalEditProduct
  };

  return (
    <DataProductContext.Provider value={props}>{children}</DataProductContext.Provider>
  );
};

export const useDataProductContext = () => useContext(DataProductContext);
