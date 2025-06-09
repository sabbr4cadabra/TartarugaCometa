package servlet;

import dao.EnderecoDAO;
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

@WebServlet("/pessoa-form")
public class FormPessoaServlet extends HttpServlet {
    private PessoaDAO dao = new PessoaDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idStr = req.getParameter("id");
            if (idStr != null) {
                Pessoa p = dao.buscarPorId(Integer.parseInt(idStr));
                req.setAttribute("pessoa", p);
            }
            req.getRequestDispatcher("formPessoa.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pessoa p = new Pessoa();
        
        p.setTipoPessoa(req.getParameter("tipoPessoa"));
        p.setNomeRazaoSocial(req.getParameter("nomeRazaoSocial"));
        p.setCpfCnpj(req.getParameter("cpfCnpj"));
 

        try {
        	PessoaDAO pessoaDAO = new PessoaDAO();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            
            String idStr = req.getParameter("id");
            if (idStr == null || idStr.isEmpty()) {
            	int pessoaIdGerado = pessoaDAO.inserirRetornandoId(p); 

                Endereco endereco = new Endereco();
                endereco.setPessoaId(pessoaIdGerado);
                endereco.setRua(req.getParameter("rua"));
                endereco.setNumero(req.getParameter("numero"));
                endereco.setComplemento(req.getParameter("complemento"));
                endereco.setBairro(req.getParameter("bairro"));
                endereco.setCidade(req.getParameter("cidade"));
                endereco.setEstado(req.getParameter("estado"));
                endereco.setCep(req.getParameter("cep"));

                enderecoDAO.inserir(endereco);
            
                if (dao.cpfCnpjExiste(p.getCpfCnpj())) {
                    req.setAttribute("erro", "CPF/CNPJ já cadastrado!");
                    req.getRequestDispatcher("pessoas").forward(req, resp);
                    return;
                }

            	
                dao.inserir(p);
            } else {
                p.setId(Integer.parseInt(idStr));
                dao.atualizar(p);
            }
            resp.sendRedirect("pessoas");
        	} 
        
        	catch (SQLException e) {
        		
      
        		if (e.getMessage().contains("pessoa_cpf_cnpj_key")) {
        			req.setAttribute("erroMensagem", "CPF/CNPJ já cadastrado no sistema.");
        			req.getRequestDispatcher("erro.jsp").forward(req, resp);
                } 
        		
        		else {
        
        			throw new ServletException(e);
        		}
        		
            
            
            
        }
    }
}
