import { ProjectsMain } from './styles';
import { useDataProductContext } from "../../../../contexts/ProductContext"
import ModalEditProject from '../../../../components/ModalEditProject';


export default function Projects() {
  const { dataProduct, openModalEditProduct, setOpenModalEditProduct } = useDataProductContext();

  return (
    <>
      <ProjectsMain>
        <h1>Meus projetos</h1>
        <section>
          {dataProduct &&
            <div onClick={() => setOpenModalEditProduct(true)}>
              <h3>{dataProduct.name}</h3>
            </div>
          }

        </section>
      </ProjectsMain>
      {openModalEditProduct && <ModalEditProject />}
    </>
  )
}
