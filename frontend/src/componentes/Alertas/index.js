import './Alertas.css'
import { Alert} from "@heroui/react";
const Alertas = ({ isVisible, titulo, color, produtos, onClose  }) => {

    return (
        <div className="flex flex-col gap-4">
            {isVisible ? (
                <Alert
                    color={color}
                    title={titulo}
                    description={
                        <ul>
                            {produtos.map((p) => (
                                <li key={p.id}>
                                    {p.nomeProduto} — Vence em {new Date(p.validade).toLocaleDateString()}
                                </li>
                            ))}
                        </ul>
                    }
                    isVisible={isVisible}
                    variant="faded"
                    onClose={onClose}
                />

            ): null
        }
        </div>
    );
}

export default Alertas;