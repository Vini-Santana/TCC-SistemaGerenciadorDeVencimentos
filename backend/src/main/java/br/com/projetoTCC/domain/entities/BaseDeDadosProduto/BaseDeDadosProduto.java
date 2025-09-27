package br.com.projetoTCC.domain.entities.BaseDeDadosProduto;

public class BaseDeDadosProduto {

    private Long id;
    private String nomeProduto;
    private String codigo;
    private String codigoBarras;

    public BaseDeDadosProduto(Long id, String nomeProduto, String codigo, String codigoBarras) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.codigo = codigo;
        this.codigoBarras = codigoBarras;
    }

    public BaseDeDadosProduto(String nomeProduto, String codigo, String codigoBarras) {
        this.nomeProduto = nomeProduto;
        this.codigo = codigo;
        this.codigoBarras = codigoBarras;
    }

    public Long getId() {
        return id;
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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

}
