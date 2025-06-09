<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Entrega" %>
<%@ page import="model.Produto" %>

<%
    List<Entrega> entregas = (List<Entrega>) request.getAttribute("entregas");
    List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
%>

<html>
<head>
    <title>Associação de Produtos à Entrega</title>
</head>
<body>
    <h2>Associação de Produtos à Entrega</h2>

    <form method="post" action="entrega-produto">
        <label>Entrega:</label>
        <select name="entregaId" required>
            <option value="">Selecione</option>
            <% for (Entrega e : entregas) { %>
                <option value="<%= e.getId() %>">
                    Pedido <%= e.getId() %> - Data: <%= e.getDataEntrega() %>
                </option>
            <% } %>
        </select><br><br>

        <label>Produto:</label>
        <select name="produtoId" required>
            <option value="">Selecione</option>
            <% for (Produto p : produtos) { %>
                <option value="<%= p.getId() %>"><%= p.getNome() %></option>
            <% } %>
        </select><br><br>

        <label>Quantidade:</label>
        <input type="number" name="quantidade" step="1" min="1" required><br><br>

        <label>Valor Unitário:</label>
        <input type="number" name="valorUnitario" step="0.01" min="0" required><br><br>

        <input type="submit" value="Salvar Produto na Entrega">
    </form>

    <br><a href="entrega">Voltar para entregas</a>
</body>
</html>
