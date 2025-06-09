package dao;

import model.Entrega;
import util.ConexaoDB;
import java.sql.*;
import java.util.*;

public class EntregaDAO {

    public void inserir(Entrega e) throws SQLException {
        String sql = "INSERT INTO entrega(pessoa_id, data_entrega) VALUES (?, ?)";
        
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, e.getPessoaID());
            stmt.setDate(2, new java.sql.Date(e.getDataEntrega().getTime())); 
            stmt.executeUpdate();
        }
    }

    public List<Entrega> listar() throws SQLException {
        List<Entrega> lista = new ArrayList<>();
        String sql = "SELECT * FROM entrega";
        
        try (Connection conn = ConexaoDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
        	
            while (rs.next()) {
                Entrega e = new Entrega();
                e.setId(rs.getInt("id"));
                e.setPessoaID(rs.getInt("pessoa_id"));
                e.setDataEntrega(rs.getDate("data_entrega")); 
                lista.add(e);
            }
        }
        return lista;
    }

    public void atualizar(Entrega e) throws SQLException {
        String sql = "UPDATE entrega SET data_entrega=? WHERE id=?";
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(e.getDataEntrega().getTime()));
            ps.setInt(2, e.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM entrega WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Entrega buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM entrega WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Entrega e = new Entrega();
                e.setId(rs.getInt("id"));
                e.setPessoaID(rs.getInt("pessoa_id"));
                e.setDataEntrega(rs.getDate("data_entrega"));
                return e;
            }
        }
        return null;
    }
}
