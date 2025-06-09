package servlet;

import dao.PessoaDAO;
import model.Pessoa;
import model.Endereco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/pessoas")
public class PessoaServlet extends HttpServlet {
    private PessoaDAO dao = new PessoaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String acao = req.getParameter("acao");
            if ("excluir".equals(acao)) {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.excluir(id);
                resp.sendRedirect("pessoas");
                return;
            }

            List<Pessoa> lista = dao.listar();
            req.setAttribute("pessoas", lista);
            req.getRequestDispatcher("pessoas.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tipoPessoa = req.getParameter("tipo_pessoa");
        String nomeRazaoSocial = req.getParameter("nome_razao_social");
        String cpfCnpj = req.getParameter("cpf_cnpj");

        Pessoa p = new Pessoa();
        p.setTipoPessoa(tipoPessoa);
        p.setNomeRazaoSocial(nomeRazaoSocial);
        p.setCpfCnpj(cpfCnpj);

        try {
            dao.inserir(p);
            resp.sendRedirect("pessoas");
        } catch (SQLException e) {
            throw new ServletException("Erro ao inserir pessoa", e);
        }
    }

    
    
    
    
    
    
    
    
}
