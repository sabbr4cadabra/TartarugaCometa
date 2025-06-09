package servlet;

import dao.EnderecoDAO;
import model.Endereco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/enderecos")
public class EnderecoListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("chegou no /enderecos");
    	
        try {
            EnderecoDAO dao = new EnderecoDAO();
            List<Endereco> enderecos = dao.listar();
            req.setAttribute("enderecos", enderecos);

            req.getRequestDispatcher("lista-enderecos.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException("Erro ao listar endereços", e);
        }
    }
}

