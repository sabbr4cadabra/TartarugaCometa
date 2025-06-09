<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Endereco" %>

<%
    List<Endereco> enderecos = (List<Endereco>) request.getAttribute("enderecos");
%>

<html>
<head>
    <title>Lista de Endereços</title>
</head>
<body>
    <h2>Endereços Cadastrados</h2>
    <a href="endereco-form">Novo Endereço</a><br><br>
    <a href="menu.jsp">Home</a><br><br>

 
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Pessoa ID</th>
            <th>Rua</th>
            <th>Número</th>
            <th>Complemento</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>CEP</th>
        </tr>
        <%
        if (enderecos != null && !enderecos.isEmpty()) {
                for (Endereco e : enderecos) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getPessoaId() %></td>
            <td><%= e.getRua() %></td>
            <td><%= e.getNumero() %></td>
            <td><%= e.getComplemento() %></td>
            <td><%= e.getBairro() %></td>
            <td><%= e.getCidade() %></td>
            <td><%= e.getEstado() %></td>
            <td><%= e.getCep() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="9">Nenhum endereço cadastrado.</td></tr>
        <%
            }
        %>
    </table>
</body>
</html>

