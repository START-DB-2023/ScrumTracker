import { useState, createContext, useContext, SetStateAction } from "react";

interface ListContextProviderProps {
  children: React.ReactNode;
}

type Listagem = {
  id: number,
  name: string,
  history: string,
  status: "A fazer" | "Em desenvolvimento" | "Concluído" | "Encaminhado para testes" | "Bloqueado",
  priority: "ALTA" | "MÉDIA" | "BAIXA",
  estimate: string,
  sprint: number
}

interface ContextProps {
  list: Listagem[];
  setList: React.Dispatch<SetStateAction<Listagem[]>>;
}

const ListContext = createContext<ContextProps>({
  list: [],
  setList: (): void => { },
});

export const ListContextProvider = ({ children }: ListContextProviderProps) => {
  const [list, setList] = useState<Listagem[]>([
    {
      id: 0,
      name: "Chaiene",
      history: "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quam obcaecati aperiam molestiae enim, beatae quas accusantium sed ad possimus magni autem ullam culpa non fugiat facere doloremque! Enim itaque non eaque, ea asperiores magni dolor dolores odio vitae at alias, exercitationem vel totam dolorum id atque tenetur. Id, dicta deserunt.",
      status: "Em desenvolvimento",
      priority: "ALTA",
      estimate: "3 dias",
      sprint: 2
    },
    {
      id: 1,
      name: "Caique",
      history: "La La Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quam obcaecati aperiam molestiae enim, beatae quas accusantium sed ad possimus magni autem ullam culpa non fugiat facere doloremque! Enim itaque non eaque, ea asperiores magni dolor dolores odio vitae at alias, exercitationem vel totam dolorum id atque tenetur. Id, dicta deserunt.",
      status: "Concluído",
      priority: "MÉDIA",
      estimate: "5 dias",
      sprint: 1
    }
  ])

  const props = {
    list,
    setList
  };

  return (
    <ListContext.Provider value={props}>{children}</ListContext.Provider>
  );
};

export const useListContext = () => useContext(ListContext);
