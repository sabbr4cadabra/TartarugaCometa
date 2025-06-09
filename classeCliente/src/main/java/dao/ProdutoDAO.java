package dao;

import model.Endereco;
import model.Produto;
import model.Pessoa;
import util.ConexaoDB;
import java.sql.*;
import java.util.*;

public class ProdutoDAO {

    public void inserir(Produto p) throws SQLException {
        String sql = "INSERT INTO produto(nome, peso, volume, valor) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDB.getConnection(); 
        		PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
            
            stmt.setString(1, p.getNome());
            stmt.setBigDecimal(2, p.getPeso());
            stmt.setBigDecimal(3, p.getVolume());
            stmt.setBigDecimal(4, p.getValor());
            stmt.executeUpdate();
        }
        
        }
    

    public List<Produto> listar() throws SQLException {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        
        try (Connection conn = ConexaoDB.getConnection();
        		Statement stmt = conn.createStatement();
        		ResultSet rs = stmt.executeQuery(sql)) {
        	
            	while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPeso(rs.getBigDecimal("peso"));
                p.setVolume(rs.getBigDecimal("volume"));
                p.setValor(rs.getBigDecimal("valor"));
                lista.add(p);
            }
        }
        return lista;
    }

    public void atualizar(Produto p) throws SQLException {
        String sql = "UPDATE produto SET nome=?, peso=?, volume=?, valor=? WHERE id=?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setBigDecimal(2, p.getPeso());
            ps.setBigDecimal(3, p.getVolume());
            ps.setBigDecimal(4, p.getValor());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                ps.setBigDecimal(2, p.getPeso());
                ps.setBigDecimal(3, p.getVolume());
                ps.setBigDecimal(4, p.getValor());
                return p;
            }
        }
        return null;
    }
}

