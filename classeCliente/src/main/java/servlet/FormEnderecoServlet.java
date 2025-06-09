//package servlet;
//
//import dao.EnderecoDAO;
//import dao.PessoaDAO;
//import model.Endereco;
//import model.Pessoa;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet("/endereco-form")
//public class FormEnderecoServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            PessoaDAO pessoaDAO = new PessoaDAO();
//            List<Pessoa> pessoas = pessoaDAO.listar();
//            req.setAttribute("pessoas", pessoas);
//
//            
//            String id = req.getParameter("id");
//            if (id != null && !id.isEmpty()) {
//                EnderecoDAO enderecoDAO = new EnderecoDAO();
//                Endereco endereco = enderecoDAO.buscarPorId(Integer.parseInt(id));
//                req.setAttribute("endereco", endereco);
//            }
//
//            req.getRequestDispatcher("form-endereco.jsp").forward(req, resp);
//
//        } catch (SQLException e) {
//            throw new ServletException("Erro ao carregar formulário de endereço", e);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            Endereco endereco = new Endereco();
//            endereco.setPessoaId(Integer.parseInt(req.getParameter("pessoaId")));
//            endereco.setRua(req.getParameter("rua"));
//            endereco.setNumero(req.getParameter("numero"));
//            endereco.setComplemento(req.getParameter("complemento"));
//            endereco.setCidade(req.getParameter("cidade"));
//            endereco.setBairro(req.getParameter("bairro"));
//            endereco.setEstado(req.getParameter("estado"));
//            endereco.setCep(req.getParameter("cep"));
//
//            EnderecoDAO dao = new EnderecoDAO();
//            dao.inserir(endereco);
//            resp.sendRedirect("enderecos");
//
//            
//        
//        	} catch (SQLException e) {
//    		
//            
//    		if (e.getMessage().contains("pessoa_id_key")) {
//    			req.setAttribute("erroMensagem", "Endereço já cadastrado no sistema.");
//    			req.getRequestDispatcher("erro.jsp").forward(req, resp);
//            } 
//    		
//    		else {
//    
//    			throw new ServletException(e);
//    		}
//        	}
//    }
//}
//
//        
//        
//    
//
