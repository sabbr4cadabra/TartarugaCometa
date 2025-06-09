<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Pessoa" %>

<%
    List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
%>

<html>
<head>
    <title>Cadastro de Produtos</title>
</head>
<body>
    <h2>Cadastro de Produtos</h2>

    <form method="post" action="produto-form">
        <label>Pessoa:</label>
        <select name="pessoaId">
            <% for (Pessoa p : pessoas) { %>
                <option value="<%= p.getId() %>"><%= p.getNomeRazaoSocial() %></option>
            <% } %>
        </select><br><br>

        <label>Nome:</label><input type="text" name="nome"><br>
        <label>Peso:</label><input type="int" name="peso"><br>
        <label>Volume:</label><input type="int" name="volume"><br>
        <label>Valor:</label><input type="int" name="valor"><br>
        

        <input type="submit" value="Salvar">
        <a href="menu.jsp">Voltar</a><br><br>
    </form>
</body>
</html>
