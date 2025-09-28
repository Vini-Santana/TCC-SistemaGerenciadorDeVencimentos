
import {
    Modal,
    ModalContent,
    ModalBody,
} from "@heroui/react";
import Formulario from "../Formulario"
import './ModalFormularioProdutos.css';

const ModalFormularioProdutos = ({ dadosFormulario, onClose, placement, isOpen, aoAtualizarProduto}) => {

    return (

        <div className="modal">
            <Modal isOpen={isOpen} placement={placement} onClose={onClose} size="3xl" hideCloseButton={true}>
                <ModalContent>
                    <ModalBody className="p-0">
                        <Formulario
                            dadosFormulario={dadosFormulario}
                            onClose={onClose}
                            aoAtualizarProduto={aoAtualizarProduto}
                        />
                    </ModalBody>
                </ModalContent>
            </Modal>
        </div>
    )
}

export default ModalFormularioProdutos;