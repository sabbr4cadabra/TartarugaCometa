<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Pessoa, model.Endereco" %>

<html>
<head><title>Pessoas</title></head>
<body>
    <h1>Lista de Clientes</h1>
    <a href="pessoa-form">Nova Pessoa</a>
    <a href="menu.jsp">Home</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Nome</th>
            <th>CPF/CNPJ</th>
            <th>Rua</th>
            <th>Número</th>
            <th>Complemento</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>CEP</th>
            
            
            <th>Ações</th>
        </tr>
        <c:forEach var="p" items="${pessoas}">
            <tr>
                <td>${p.id}</td>
                <td>${p.tipoPessoa}</td>
                <td>${p.nomeRazaoSocial}</td>
                <td>${p.cpfCnpj}</td>
                
                
            	<td>${p.Rua}</td>
           	 	<td>${p.Numero}</td>
	            <td>${p.Complemento}</td>
	            <td>${p.Bairro}</td>
            	<td>${p.Cidade}</td>
            	<td>${p.Estado}</td>
            	<td>${p.Cep}</td>
                <td>
                    <a href="pessoa-form?id=${p.id}">Editar</a>
                    <a href="pessoas?acao=excluir&id=${p.id}" onclick="return confirm('Confirma exclusão?')">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
