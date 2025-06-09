package model;

import java.math.BigDecimal;

public class EntregaProduto {
    private int entregaId;
    private int produtoId;
    private int quantidade;
    private BigDecimal valorUnitario;

    public EntregaProduto() {}

    public EntregaProduto(int entregaId, int produtoId, int quantidade) {
        this.entregaId = entregaId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getEntregaId() {return entregaId;}
    public void setEntregaId(int entregaId) {this.entregaId = entregaId;}

    public int getProdutoId() {return produtoId;}
    public void setProdutoId(int produtoId) {this.produtoId = produtoId;}

    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
    
    public BigDecimal getValorUnitario() {return valorUnitario;}
    public void setValorUnitario(BigDecimal valorUnitario) {this.valorUnitario = valorUnitario;}
}
