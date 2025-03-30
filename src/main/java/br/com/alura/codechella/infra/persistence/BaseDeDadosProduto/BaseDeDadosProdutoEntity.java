package br.com.alura.codechella.infra.persistence.BaseDeDadosProduto;

import jakarta.persistence.*;

@Entity
@Table(name = "BaseDeDadosProduto")
public class BaseDeDadosProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private String codigo;

    public BaseDeDadosProdutoEntity() {}

    public BaseDeDadosProdutoEntity(String nomeProduto, String codigo) {
        this.nomeProduto = nomeProduto;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
