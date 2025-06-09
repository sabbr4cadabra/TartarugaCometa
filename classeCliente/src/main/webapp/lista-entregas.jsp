<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Entrega" %>

<%
    List<Entrega> entregas = (List<Entrega>) request.getAttribute("entregas");
%>

<html>
<head>
    <title>Lista de Entregas</title>
</head>
<body>
    <h2>Entregas Cadastradas</h2>
    <a href="entrega?acao=form">Nova Entrega</a>
    <a href="menu.jsp">Home</a><br><br>


    <table border="1">
        <tr>
            <th>ID</th>
            <th>Pessoa ID</th>
            <th>Data Entrega</th>
            <th>Ações</th>
        </tr>
        <%
            if (entregas != null && !entregas.isEmpty()) {
                for (Entrega e : entregas) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getPessoaID() %></td>
            <td><%= e.getDataEntrega() %></td>
            <td>
                <a href="EntregaProdutoServlet?entregaId=<%= e.getId() %>">Ver Produtos</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="4">Nenhuma entrega cadastrada.</td></tr>
        <%
            }
        %>
    </table>
</body>
</html>
