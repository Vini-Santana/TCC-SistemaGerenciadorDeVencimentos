package br.com.projetoTCC.domain.entities.BaseDeDadosProduto;

public class BaseDeDadosProduto {

    private String nomeProduto;
    private String codigo;

    public BaseDeDadosProduto(String nomeProduto, String codigo) {
        this.nomeProduto = nomeProduto;
        this.codigo = codigo;
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
