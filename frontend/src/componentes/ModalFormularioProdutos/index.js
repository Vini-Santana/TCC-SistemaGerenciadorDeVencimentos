
import {
    Modal,
    ModalContent,
    ModalBody,
} from "@heroui/react";
import Formulario from "../Formulario"
import './ModalFormularioProdutos.css';

const ModalFormularioProdutos = ({ dadosFormulario, onClose, placement, isOpen, }) => {

    return (

        <div className="modal">
            <Modal isOpen={isOpen} placement={placement} onClose={onClose} size="3xl">
                <ModalContent>
                    <ModalBody>
                        <Formulario
                            dadosFormulario={dadosFormulario}
                            onClose={onClose}
                        />
                    </ModalBody>
                </ModalContent>
            </Modal>
        </div>
    )
}

export default ModalFormularioProdutos;