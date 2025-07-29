import './TabelaProdutos.css';
import React, { useState } from 'react';
import {
    Table,
    TableHeader,
    TableColumn,
    TableBody,
    TableRow,
    TableCell,
    Chip,
    Tooltip,
    Spinner,
    Button,
    Input
} from "@heroui/react";
import dayjs from 'dayjs';

export const DeleteIcon = (props) => {
    return (
        <svg
            aria-hidden="true"
            fill="none"
            focusable="false"
            height="1em"
            role="presentation"
            viewBox="0 0 20 20"
            width="1em"
            {...props}
        >
            <path
                d="M17.5 4.98332C14.725 4.70832 11.9333 4.56665 9.15 4.56665C7.5 4.56665 5.85 4.64998 4.2 4.81665L2.5 4.98332"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1.5}
            />
            <path
                d="M7.08331 4.14169L7.26665 3.05002C7.39998 2.25835 7.49998 1.66669 8.90831 1.66669H11.0916C12.5 1.66669 12.6083 2.29169 12.7333 3.05835L12.9166 4.14169"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1.5}
            />
            <path
                d="M15.7084 7.61664L15.1667 16.0083C15.075 17.3166 15 18.3333 12.675 18.3333H7.32502C5.00002 18.3333 4.92502 17.3166 4.83335 16.0083L4.29169 7.61664"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1.5}
            />
            <path
                d="M8.60834 13.75H11.3833"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1.5}
            />
            <path
                d="M7.91669 10.4167H12.0834"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1.5}
            />
        </svg>
    );
};

export const EditIcon = (props) => {
    return (
        <svg
            aria-hidden="true"
            fill="none"
            focusable="false"
            height="1em"
            role="presentation"
            viewBox="0 0 20 20"
            width="1em"
            {...props}
        >
            <path
                d="M11.05 3.00002L4.20835 10.2417C3.95002 10.5167 3.70002 11.0584 3.65002 11.4334L3.34169 14.1334C3.23335 15.1084 3.93335 15.775 4.90002 15.6084L7.58335 15.15C7.95835 15.0834 8.48335 14.8084 8.74168 14.525L15.5834 7.28335C16.7667 6.03335 17.3 4.60835 15.4583 2.86668C13.625 1.14168 12.2334 1.75002 11.05 3.00002Z"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeMiterlimit={10}
                strokeWidth={1.5}
            />
            <path
                d="M9.90833 4.20831C10.2667 6.50831 12.1333 8.26665 14.45 8.49998"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeMiterlimit={10}
                strokeWidth={1.5}
            />
            <path
                d="M2.5 18.3333H17.5"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeMiterlimit={10}
                strokeWidth={1.5}
            />
        </svg>
    );
};

export const columns = [
    { name: "Código", uid: "codigo" },
    { name: "Nome do produto", uid: "nomeProduto" },
    { name: "Qtd em estoque", uid: "quantidade" },
    { name: "Validade", uid: "validade" },
    { name: "Observações", uid: "observacoes" },
    { name: "Última modificação", uid: "ultimaModificacao" },
    { name: "Opções", uid: "opcoes" }
];

export const SearchIcon = (props) => {
    return (
        <svg
            aria-hidden="true"
            fill="none"
            focusable="false"
            height="1em"
            role="presentation"
            viewBox="0 0 24 24"
            width="1em"
            {...props}
        >
            <path
                d="M11.5 21C16.7467 21 21 16.7467 21 11.5C21 6.25329 16.7467 2 11.5 2C6.25329 2 2 6.25329 2 11.5C2 16.7467 6.25329 21 11.5 21Z"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
            />
            <path
                d="M22 22L20 20"
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
            />
        </svg>
    );
};

const TabelaProdutos = ({ produtos, aoExcluirProduto, aoAtualizarProduto, abrirModalFormulario }) => {

    const [isLoading, setIsLoading] = React.useState(false);
    const [sortDescriptor, setSortDescriptor] = React.useState({
        column: "validade",
        direction: "ascending",
    });

    const [showDeleteConfirm, setShowDeleteConfirm] = useState(false);
    const [productToDelete, setProductToDelete] = useState(null);

    const [filterValue, setFilterValue] = React.useState("");
    const hasSearchFilter = Boolean(filterValue);
    const [statusFilter, setStatusFilter] = React.useState("all");


    const handleDeleteClick = (product) => {
        setProductToDelete(product);
        setShowDeleteConfirm(true);
    };

    const confirmDelete = () => {
        if (productToDelete) {
            aoExcluirProduto(productToDelete);
        }
        setShowDeleteConfirm(false);
        setProductToDelete(null);
    };

    const cancelDelete = () => {
        setShowDeleteConfirm(false);
        setProductToDelete(null);
    };

    const produtosOrdenados = React.useMemo(() => {
        return [...produtos].sort((a, b) => {
            let first = a[sortDescriptor.column];
            let second = b[sortDescriptor.column];


            if (sortDescriptor.column === "validade" || sortDescriptor.column === "ultimaModificacao") {
                first = dayjs(first).valueOf();
                second = dayjs(second).valueOf();
            }
            let cmp = (parseInt(first) || first) < (parseInt(second) || second) ? -1 : 1;
            if (sortDescriptor.direction === "descending") {
                cmp *= -1;
            }
            return cmp;
        });
    }, [produtos, sortDescriptor]);

    const renderCell = React.useCallback((produto, columnKey) => {
        const cellValue = produto[columnKey];

        switch (columnKey) {
            case "nomeProduto":
                return (
                    <div className="flex flex-col">
                        <p className="text-bold text-sm capitalize">{cellValue}</p>
                    </div>
                );
            case "ultimaModificacao":
                return (
                    <p>{dayjs(cellValue).format('DD/MM/YYYY')}</p>

                )
            case "validade":

                const hoje = dayjs().startOf('day');
                const validade = dayjs(cellValue).startOf('day');
                const estaVencido = validade.isBefore(hoje, 'day');

                let chipColor = '';
                if (estaVencido) {
                    chipColor = 'danger';
                } else if (produto.isAVencer) {
                    chipColor = 'warning';
                }

                return (
                    <Chip color={chipColor} variant="flat">
                        {validade.format('DD/MM/YYYY')}
                    </Chip>
                );
            case "opcoes":
                return (
                    <div className="relative flex items-center gap-2" >
                        <Tooltip content="Editar produto">
                            <span className="text-lg text-default-400 cursor-pointer active:opacity-50"
                                aria-label="Editar produto">
                                <EditIcon onClick={() => abrirModalFormulario({
                                    label: "Editar produto",
                                    acao: (produto) => aoAtualizarProduto(produto),
                                    produto: produto,
                                    modo: "edicao",
                                })} />
                            </span>
                        </Tooltip>
                        <Tooltip color="danger" content="Excluir produto"
                            aria-label="Excluir produto">
                            <span className="text-lg text-danger cursor-pointer active:opacity-50">
                                <DeleteIcon
                                    onClick={() => handleDeleteClick(produto)}
                                />
                            </span>
                        </Tooltip>
                    </div>
                );
            default:
                return cellValue;
        }
    }, [abrirModalFormulario, aoAtualizarProduto, handleDeleteClick]);


    const onClear = React.useCallback(() => {
        setFilterValue("");
    }, []);

    const onSearchChange = React.useCallback((value) => {
        console.log("Search value changed:", value);
        if (value) {
            setFilterValue(value);
        } else {
            setFilterValue("");
        }
    }, []);

    const filteredItems = React.useMemo(() => {
        let filteredProdutos = [...produtosOrdenados];

        if (hasSearchFilter) {
            filteredProdutos = filteredProdutos.filter((produto) =>
                produto.nomeProduto.toLowerCase().includes(filterValue.toLowerCase()),
            );
        }

        return filteredProdutos;
    }, [produtosOrdenados, filterValue]);

    const topContent = React.useMemo(() => {
        return (
            <div className="flex flex-col gap-4">
                <div className="flex justify-between gap-3 items-end">
                    <Input
                        isClearable
                        className="w-full sm:max-w-[30%]"
                        placeholder="Busque um produto"
                        startContent={<SearchIcon />}
                        value={filterValue}
                        onClear={() => onClear()}
                        onValueChange={onSearchChange}
                    />
                </div>
            </div>
        );
    }, [
        filterValue,
        onSearchChange,
        hasSearchFilter,
    ]);

    return (
        <>
            <Table className='tabela-produtos'
                sortDescriptor={sortDescriptor}
                onSortChange={setSortDescriptor}
                topContent={topContent}
                topContentPlacement="outside"
            >
                <TableHeader columns={columns}>
                    {(column) => (
                        <TableColumn key={column.uid} align={column.uid === "opcoes" ? "center" : "start"}
                            allowsSorting={["validade", "nomeProduto"].includes(column.uid)}>
                            {column.name}
                        </TableColumn>
                    )}
                </TableHeader>
                <TableBody
                    items={filteredItems}
                    isLoading={isLoading}
                    emptyContent={"Nenhum produto encontrado."}
                    loadingContent={<Spinner label="Loading..." />}>
                    {(item) => (
                        <TableRow key={item.id}>
                            {(columnKey) => <TableCell>{renderCell(item, columnKey)}</TableCell>}
                        </TableRow>
                    )}
                </TableBody>
            </Table>

            {showDeleteConfirm && productToDelete && (
                <div className="fixed inset-0 bg-gray-600 bg-opacity-50 overflow-y-auto h-full w-full flex items-center justify-center z-50">
                    <div className="p-8 border w-96 shadow-lg rounded-md bg-white">
                        <h3 className="text-lg font-bold mb-4">Confirmar Exclusão</h3>
                        <p className="mb-6">Deseja realmente excluir o produto "{productToDelete.nomeProduto}"?</p>
                        <div className="flex justify-end gap-4">
                            <Button onPress={cancelDelete} className="bg-gray-300 text-gray-800 px-4 py-2 rounded-md hover:bg-gray-400">Cancelar</Button>
                            <Button onPress={confirmDelete} className="bg-red-500 text-white px-4 py-2 rounded-md hover:bg-red-600">Excluir</Button>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
}
export default TabelaProdutos;