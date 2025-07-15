import { Alert, Modal,
    ModalContent,
    ModalBody, } from '@heroui/react';
import './ModalAlerta.css';
import Formulario from '../Formulario';

const ModalAlerta = (onClose, placement, isOpen, dadosFormulario) => {
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
    );
};

export default ModalAlerta;