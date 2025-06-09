package dao;

import model.Endereco;
import model.Pessoa;
import util.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    public void inserir(Pessoa p) throws SQLException {
        String sql = "INSERT INTO pessoa(tipo_pessoa, nome_razao_social, cpf_cnpj) VALUES (?, ?, ?)";

        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getTipoPessoa());
            ps.setString(2, p.getNomeRazaoSocial());
            ps.setString(3, p.getCpfCnpj());
            ps.executeUpdate();
        }
        catch(SQLException e) {
        	System.out.println(e);
        	
        	throw e;
        }
    }
    
    public int inserirRetornandoId(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoa (tipo_pessoa, nome_razao_social, cpf_cnpj) VALUES (?, ?, ?) RETURNING id";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getTipoPessoa());
            stmt.setString(2, pessoa.getNomeRazaoSocial());
            stmt.setString(3, pessoa.getCpfCnpj());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                throw new SQLException("Falha ao obter o ID da pessoa.");
            }
        }
    }

    

    public List<Pessoa> listar() throws SQLException {
        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT id AS pessoa_id, tipo_pessoa, nome_razao_social, cpf_cnpj, " +
                "id AS endereco_id, e.rua, e.numero, e.complemento, e.bairro, e.cidade, e.estado, e.cep " +
                "FROM pessoa p " +
                "LEFT JOIN endereco e ON e.pessoa_id = p.id";

        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setTipoPessoa(rs.getString("tipo_pessoa"));
                p.setNomeRazaoSocial(rs.getString("nome_razao_social"));
                p.setCpfCnpj(rs.getString("cpf_cnpj"));
                
                int enderecoId = rs.getInt("endereco_id");
                if (enderecoId > 0) {
                    Endereco e = new Endereco();
                    e.setId(enderecoId);
                    e.setRua(rs.getString("rua"));
                    e.setNumero(rs.getString("numero"));
                    e.setComplemento(rs.getString("complemento"));
                    e.setBairro(rs.getString("bairro"));
                    e.setCidade(rs.getString("cidade"));
                    e.setEstado(rs.getString("estado"));
                    e.setCep(rs.getString("cep"));

                    p.setEndereco(e);
                
                }
                lista.add(p);
                
                
               
            }
        }

        return lista;
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Pessoa buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setTipoPessoa(rs.getString("tipo_pessoa"));
                p.setNomeRazaoSocial(rs.getString("nome_razao_social"));
                p.setCpfCnpj(rs.getString("cpf_cnpj"));
                return p;
            }
        }
        return null;
    }

    public void atualizar(Pessoa p) throws SQLException {
        String sql = "UPDATE pessoa SET tipo_pessoa=?, nome_razao_social=?, cpf_cnpj=? WHERE id=?";
        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getTipoPessoa());
            ps.setString(2, p.getNomeRazaoSocial());
            ps.setString(3, p.getCpfCnpj());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        }
    }


public boolean cpfCnpjExiste(String cpfCnpj) throws SQLException {
    String sql = "SELECT 1 FROM pessoa WHERE cpf_cnpj = ?";
    try (Connection con = ConexaoDB.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, cpfCnpj);
        ResultSet rs = ps.executeQuery();
        return rs.next(); 
    }
}
}

