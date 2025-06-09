package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.EntregaProduto;
import model.Produto;
import util.ConexaoDB;

public class EntregaProdutoDAO {

    public void inserir(EntregaProduto ep) throws SQLException {
        String sql = "INSERT INTO entrega_produto (entrega_id, produto_id, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ep.getEntregaId());
            stmt.setInt(2, ep.getProdutoId());
            stmt.setInt(3, ep.getQuantidade());
            stmt.setBigDecimal(4, ep.getValorUnitario());

            stmt.executeUpdate();
        }
    }

    public List<Produto> listarProdutosPorEntrega(int entregaId) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.* FROM produto p " +
                     "JOIN entrega_produto ep ON p.id = ep.produto_id " +
                     "WHERE ep.entrega_id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, entregaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getBigDecimal("valor"));
                produtos.add(p);
            }
        }

        return produtos;
    }

    public void excluirProdutoDaEntrega(int entregaId, int produtoId) throws SQLException {
        String sql = "DELETE FROM entrega_produto WHERE entrega_id = ? AND produto_id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, entregaId);
            stmt.setInt(2, produtoId);

            stmt.executeUpdate();
        }
    }
}

