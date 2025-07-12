// import { Modal, ModalContent, ModalBody } from "@heroui/react"
import {
    Modal,
    ModalContent,
    ModalHeader,
    ModalBody,
    ModalFooter,
    Button,
    useDisclosure,
} from "@heroui/react";
import Formulario from "../Formulario"
import './ModalFormularioProdutos.css';
import { div } from "framer-motion/client";


const ModalFormularioProdutos = ({ listaDeProdutos, aoProdutoCadastrado, onClose, placement, isOpen }) => {

    return (

        <div className="modal">
            <Modal isOpen={isOpen} placement={placement}>
                <ModalContent>
                    <ModalBody>
                        <Formulario
                            listaDeProdutos={listaDeProdutos}
                            aoProdutoCadastrado={aoProdutoCadastrado}
                            onClose={onClose}
                        />
                    </ModalBody>
                </ModalContent>
            </Modal>
        </div>
    )
}

export default ModalFormularioProdutos;