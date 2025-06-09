<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Pessoa" %>

<%
    List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
%>

<html>
<head>
    <title>Cadastro de Endereço</title>
</head>
<body>
    <h2>Cadastro de Endereço</h2>

    <form method="post" action="endereco-form">
        <label>Pessoa:</label>
        <select name="pessoaId">
            <% for (Pessoa p : pessoas) { %>
                <option value="<%= p.getId() %>"><%= p.getNomeRazaoSocial() %></option>
            <% } %>
        </select><br><br>

        <label>Rua:</label><input type="text" name="rua"><br>
        <label>Número:</label><input type="text" name="numero"><br>
        <label>Complemento:</label><input type="text" name="complemento"><br>
        <label>Bairro:</label><input type="text" name="bairro"><br>
        <label>Cidade:</label><input type="text" name="cidade"><br>
        <label>Estado:</label><input type="text" name="estado"><br>
        <label>CEP:</label><input type="text" name="cep"><br><br>

        <input type="submit" value="Salvar">
        <a href="menu.jsp">Home</a>
    </form>
</body>
</html>
