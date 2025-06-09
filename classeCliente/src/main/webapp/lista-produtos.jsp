<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Produto" %>

<%
    List<Produto> produtos = (List<Produto>) request.getAttribute("produto");
%>

<html>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
    <h2>Produtos Cadastrados</h2>
    <a href="produto-form">Novo produto</a><br><br>
    <a href="menu.jsp">Home</a><br><br>

 
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Peso</th>
            <th>Volume</th>
            <th>Valor</th>
        </tr>
        <%
        if (produtos != null && !produtos.isEmpty()) {
                for (Produto p : produtos) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNome() %></td>
            <td><%= p.getPeso() %></td>
            <td><%= p.getVolume() %></td>
            <td><%= p.getValor() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="9">Nenhum produto cadastrado.</td></tr>
        <%
            }
        %>
    </table>
</body>
</html>

