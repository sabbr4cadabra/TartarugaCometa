package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Entrega {

	private int id;
    private int pessoaID;
    private Date dataEntrega;


    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public int getPessoaID() {return pessoaID;}
    public void setPessoaID(int pessoaID) {this.pessoaID = pessoaID;}

    public Date getDataEntrega() {return dataEntrega;}	
    public void setDataEntrega(Date dataEntrega) {this.dataEntrega = dataEntrega;}
    
    }