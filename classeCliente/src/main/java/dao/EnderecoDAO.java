package dao;

import model.Endereco;
import util.ConexaoDB;
import java.sql.*;
import java.util.*;

public class EnderecoDAO {

    public void inserir(Endereco e) throws SQLException {
        String sql = "INSERT INTO endereco(pessoa_id, rua, numero, complemento, cidade, bairro, estado, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDB.getConnection(); 
        		PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            stmt.setInt(1, e.getPessoaId());
            stmt.setString(2, e.getRua());
            stmt.setString(3, e.getNumero());
            stmt.setString(4, e.getComplemento());
            stmt.setString(5, e.getCidade());
            stmt.setString(6, e.getBairro());
            stmt.setString(7, e.getEstado());
            stmt.setString(8, e.getCep());
            stmt.executeUpdate();
        }
        
        }
    

    public List<Endereco> listar() throws SQLException {
        List<Endereco> lista = new ArrayList<>();
        String sql = "SELECT * FROM endereco";
        
        try (Connection conn = ConexaoDB.getConnection();
        		Statement stmt = conn.createStatement();
        		ResultSet rs = stmt.executeQuery(sql)) {
        	
            	while (rs.next()) {
                Endereco e = new Endereco();
                e.setId(rs.getInt("id"));
                e.setPessoaId(rs.getInt("pessoa_id"));
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setCidade(rs.getString("cidade"));
                e.setBairro(rs.getString("bairro"));
                e.setEstado(rs.getString("estado"));
                e.setCep(rs.getString("cep"));
                lista.add(e);
            }
        }
        return lista;
    }

    public void atualizar(Endereco e) throws SQLException {
        String sql = "UPDATE endereco SET pessoa_id=?, rua=?, numero=?, complemento=?, cidade=?, bairro=?, estado=?, cep=? WHERE id=?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, e.getPessoaId());
            ps.setString(2, e.getRua());
            ps.setString(3, e.getNumero());
            ps.setString(4, e.getComplemento());
            ps.setString(5, e.getCidade());
            ps.setString(6, e.getBairro());
            ps.setString(7, e.getEstado());
            ps.setString(8, e.getCep());
            ps.setInt(9, e.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM endereco WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Endereco buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM endereco WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Endereco e = new Endereco();
                e.setId(rs.getInt("id"));
                e.setPessoaId(rs.getInt("pessoa_id"));
                e.setRua(rs.getString("rua"));
                e.setNumero(rs.getString("numero"));
                e.setComplemento(rs.getString("complemento"));
                e.setCidade(rs.getString("cidade"));
                e.setBairro(rs.getString("bairro"));
                e.setEstado(rs.getString("estado"));
                e.setCep(rs.getString("cep"));
                return e;
            }
        }
        return null;
    }
}

