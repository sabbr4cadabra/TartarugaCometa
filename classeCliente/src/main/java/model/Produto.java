package model;

import java.math.BigDecimal;

public class Produto {

	    private int id;
	    private String nome;
	    private BigDecimal valor;
	    private BigDecimal peso;
	    private BigDecimal volume;


	 
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }


	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; }

	    public BigDecimal getPeso() { return peso; }
	    public void setPeso(BigDecimal peso) { this.peso = peso; }

	    public BigDecimal getVolume() { return volume; }
	    public void setVolume(BigDecimal volume) { this.volume = volume; }

	    public BigDecimal getValor() { return valor; }
	    public void setValor(BigDecimal valor) { this.valor = valor; }

	}
