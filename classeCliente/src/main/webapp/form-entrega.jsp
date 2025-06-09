<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Pessoa" %>

<%
    List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("pessoas");
%>

<html>
<head>
    <title>Nova Entrega</title>
</head>
<body>
    <h2>Nova Entrega</h2>
    <form method="post" action="entrega?acao=form">
        <label>Pessoa:</label>
        <select name="pessoaId" required>
            <option value="">Selecione</option>
            <% for (Pessoa p : pessoas) { %>
                <option value="<%= p.getId() %>"><%= p.getNomeRazaoSocial() %></option>
            <% } %>
        </select><br><br>

        <label>Data da Entrega:</label>
        <input type="date" name="dataEntrega" required><br><br>

        <input type="submit" value="Salvar">
    </form>

    <br><a href="entrega">Voltar para Lista</a>
    <a href="menu.jsp">Home</a><br><br>
</body>
</html>

