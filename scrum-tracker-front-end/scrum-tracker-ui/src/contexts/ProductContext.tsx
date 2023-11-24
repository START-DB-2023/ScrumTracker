import { useState, createContext, useContext, SetStateAction } from "react";
import { IProduct } from "../@types/types";
/* import api from '../connections/api' */

interface DataProductContextProviderProps {
  children: React.ReactNode;
}


interface ContextProps {
  dataProduct: IProduct[];
  setDataProduct: React.Dispatch<SetStateAction<IProduct[]>>;
  openModalEditProduct: boolean;
  setOpenModalEditProduct: React.Dispatch<SetStateAction<boolean>>;
  productBacklog: IProduct[];
  setProductBacklog: React.Dispatch<SetStateAction<IProduct[]>>;
  openModalRegisterSprint: boolean;
  setOpenModalRegisterSprint: React.Dispatch<SetStateAction<boolean>>;
}

const DataProductContext = createContext<ContextProps>({
  dataProduct: [],
  setDataProduct: (): void => { },
  openModalEditProduct: false,
  setOpenModalEditProduct: (): boolean => false,
  productBacklog: [],
  setProductBacklog: (): void => { },
  openModalRegisterSprint: false,
  setOpenModalRegisterSprint: (): boolean => false,
});

export const DataProductContextProvider = ({ children }: DataProductContextProviderProps) => {
  const [dataProduct, setDataProduct] = useState<IProduct>()
  const [openModalEditProduct, setOpenModalEditProduct] = useState(false)
  const [productBacklog, setProductBacklog] = useState<IProduct[]>([])
  const [openModalRegisterSprint, setOpenModalRegisterSprint] = useState(false)

  /* async function searchProjects(): Promise<void> {

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
  }, []) */

  const props = {
    dataProduct,
    setDataProduct,
    /* searchProjects, */
    openModalEditProduct,
    setOpenModalEditProduct,
    productBacklog,
    setProductBacklog,
    openModalRegisterSprint,
    setOpenModalRegisterSprint
  };

  return (
    <DataProductContext.Provider value={props}>{children}</DataProductContext.Provider>
  );
};

export const useDataProductContext = () => useContext(DataProductContext);
