import './CampoListProdutos.css';
import Select from 'react-select';

const CampoListProdutos = ({itens =[], valor, aoAlterado, label, obrigatorio }) => {
    const opcoes = itens.map(item => ({
        label: item.nomeProduto,
        value: item.nomeProduto,
        codigo: item.codigo
    }));

    return (

        <div className="lista-de-produtos">
            <label>{label}</label>
            <Select
                options={opcoes}
                required={obrigatorio}
                onChange={(opcao) => {
                    aoAlterado(opcao || null) // Passa o objeto inteiro, não só o nome
                }}
                value={opcoes.find(op => op.value === valor)}
                isClearable
                isSearchable
                styles={{
                    control: (base) => ({
                        ...base,
                        borderRadius: '8px',
                        padding: '2px',
                        borderColor: '#4b1e0e',
                    }),
                    menu: (base) => ({
                        ...base,
                        backgroundColor: '#f5f5f5',
                        zIndex: 9999
                    }),
                }}
            />
        </div>



    )
}

export default CampoListProdutos;