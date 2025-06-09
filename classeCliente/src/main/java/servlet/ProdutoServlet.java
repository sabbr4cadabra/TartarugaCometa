package servlet;

import dao.ProdutoDAO;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("chegou no /produtos");
    	
        try {
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.listar();
            req.setAttribute("produto", produtos);

            req.getRequestDispatcher("lista-produtos.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException("Erro ao listar produtos", e);
        }
    }
}


