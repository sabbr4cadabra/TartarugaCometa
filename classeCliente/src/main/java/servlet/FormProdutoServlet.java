package servlet;

import dao.ProdutoDAO;
import dao.PessoaDAO;
import dao.EnderecoDAO;
import model.Produto;
import model.Endereco;
import model.Pessoa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/produto-form")
public class FormProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PessoaDAO pessoaDAO = new PessoaDAO();
            List<Pessoa> pessoas = pessoaDAO.listar();
            req.setAttribute("pessoas", pessoas);

            
            String id = req.getParameter("id");
            if (id != null && !id.isEmpty()) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto = produtoDAO.buscarPorId(Integer.parseInt(id));
                req.setAttribute("produto", produto);
            }

            req.getRequestDispatcher("form-produto.jsp").forward(req, resp);

        } catch (SQLException e) {
            throw new ServletException("Erro ao carregar formulário de endereço", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Produto produto = new Produto();
            produto.setNome(req.getParameter("nome"));
            produto.setPeso(new BigDecimal(req.getParameter("peso")));
            produto.setVolume(new BigDecimal(req.getParameter("volume")));
            produto.setValor(new BigDecimal(req.getParameter("valor")));





            ProdutoDAO dao = new ProdutoDAO();
            dao.inserir(produto);
            resp.sendRedirect("produtos");

            
        
        	} catch (SQLException e) {
    		
            
    		if (e.getMessage().contains("produto_id_key")) {
    			req.setAttribute("erroMensagem", "Produto já cadastrado no sistema.");
    			req.getRequestDispatcher("erro.jsp").forward(req, resp);
            } 
    		
    		else {
    
    			throw new ServletException(e);
    		}
        	}
    }
}

        
        
    


