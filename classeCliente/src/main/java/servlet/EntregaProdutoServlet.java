package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import dao.EntregaDAO;
import dao.EntregaProdutoDAO;
import dao.ProdutoDAO;
import model.Entrega;
import model.EntregaProduto;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/entrega-produto")
public class EntregaProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntregaProdutoDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new EntregaProdutoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            EntregaDAO entregaDAO = new EntregaDAO();
            ProdutoDAO produtoDAO = new ProdutoDAO();

            List<Entrega> entregas = entregaDAO.listar();
            List<Produto> produtos = produtoDAO.listar();

            req.setAttribute("entregas", entregas);
            req.setAttribute("produtos", produtos);

            req.getRequestDispatcher("form-entrega-produto.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar dados para o formulário", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int entregaId = Integer.parseInt(req.getParameter("entregaId"));
            int produtoId = Integer.parseInt(req.getParameter("produtoId"));
            int quantidade = Integer.parseInt(req.getParameter("quantidade"));
            BigDecimal valorUnitario = new BigDecimal(req.getParameter("valorUnitario"));

            EntregaProduto ep = new EntregaProduto();
            ep.setEntregaId(entregaId);
            ep.setProdutoId(produtoId);
            ep.setQuantidade(quantidade);
            ep.setValorUnitario(valorUnitario);

            dao.inserir(ep);

            resp.sendRedirect("entrega"); 
        } catch (Exception e) {
            throw new ServletException("Erro ao salvar produto da entrega", e);
        }
    }
}

