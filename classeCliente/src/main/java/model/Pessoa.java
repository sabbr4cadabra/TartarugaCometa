package model;

public class Pessoa {
    private int id;
    private String tipoPessoa;
    private String nomeRazaoSocial;
    private String cpfCnpj;
    private Endereco endereco;
   
    
    
    		

    		// id
    		public int getId() { return id; }
    		public void setId(int id) { this.id = id; }

    		// tipo pessoa
    		public String getTipoPessoa() { return tipoPessoa; }
    		public void setTipoPessoa(String tipoPessoa) { this.tipoPessoa = tipoPessoa; }

    		// razao social
    		public String getNomeRazaoSocial() { return nomeRazaoSocial; }
    		public void setNomeRazaoSocial(String nomeRazaoSocial) { this.nomeRazaoSocial = nomeRazaoSocial; }

    		// cpf/cnpj
    		public String getCpfCnpj() { return cpfCnpj; }
    		public void setCpfCnpj(String cpfCnpj) { this.cpfCnpj = cpfCnpj; }
    		
    		public Endereco getEndereco() {return endereco;}
    		public void setEndereco(Endereco endereco) {this.endereco = endereco;}


}
