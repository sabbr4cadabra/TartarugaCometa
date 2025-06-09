package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import dao.EntregaDAO;
import dao.PessoaDAO;
import dao.ProdutoDAO;
import model.Entrega;
import model.Pessoa;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/entrega")
public class EntregaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EntregaDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new EntregaDAO(); 
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String acao = req.getParameter("acao");

            EntregaDAO entregaDAO = new EntregaDAO();

            if ("excluir".equals(acao)) {
                int id = Integer.parseInt(req.getParameter("id"));
                entregaDAO.excluir(id);
                resp.sendRedirect("entrega");
                return;
            }

            
            if ("form".equals(acao)) {
                PessoaDAO pessoaDAO = new PessoaDAO();
                List<Pessoa> pessoas = pessoaDAO.listar();
                req.setAttribute("pessoas", pessoas);
                req.getRequestDispatcher("form-entrega.jsp").forward(req, resp);
                return;
            }

            
            List<Entrega> lista = entregaDAO.listar();
            req.setAttribute("entregas", lista);
            req.getRequestDispatcher("lista-entregas.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int pessoaId = Integer.parseInt(req.getParameter("pessoaId"));
            String dataStr = req.getParameter("dataEntrega");

  
            java.sql.Date dataEntrega = java.sql.Date.valueOf(dataStr);

            Entrega entrega = new Entrega();
            entrega.setPessoaID(pessoaId);
            entrega.setDataEntrega(dataEntrega);

            dao.inserir(entrega);
            resp.sendRedirect("entrega");
        } catch (Exception e) {
            throw new ServletException("Erro ao salvar entrega", e);
        }
    }
}
