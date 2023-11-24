import { useState, createContext, useContext, SetStateAction } from "react";
import { IItemBacklog, ISprints } from "../@types/types";

interface ListContextProviderProps {
  children: React.ReactNode;
}

interface ContextProps {
  list: IItemBacklog[];
  setList: React.Dispatch<SetStateAction<IItemBacklog[]>>;
  listSprints: ISprints[]
  setListSprints: React.Dispatch<SetStateAction<ISprints[]>>
}

const ListContext = createContext<ContextProps>({
  list: [],
  setList: (): void => { },
  listSprints: [],
  setListSprints: (): void => { },
});

export const ListContextProvider = ({ children }: ListContextProviderProps) => {
  const [list, setList] = useState<IItemBacklog[]>([
  ])
  const [listSprints, setListSprints] = useState<ISprints[]>([])

  const props = {
    list,
    setList,
    listSprints,
    setListSprints
  };

  return (
    <ListContext.Provider value={props}>{children}</ListContext.Provider>
  );
};

export const useListContext = () => useContext(ListContext);
