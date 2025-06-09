<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Pessoa, model.Endereco" %>

<html>
<head><title>Cadastro de Pessoa</title></head>
<body>
    <h1>${pessoa != null ? "Editar" : "Nova"} Pessoa</h1>

    <form method="post" action="pessoas">
        <c:if test="${pessoa != null}">
            <input type="hidden" name="id" value="${pessoa.id}" />
        </c:if>
        <label>Tipo:</label>
        <select name="tipoPessoa">
            <option value="FISICA" ${pessoa.tipoPessoa == 'FISICA' ? 'selected' : ''}>Física</option>
            <option value="JURIDICA" ${pessoa.tipoPessoa == 'JURIDICA' ? 'selected' : ''}>Jurídica</option>
        </select><br/>

        <label>Nome/Razão Social:</label>
        <input type="text" name="nomeRazaoSocial" value="${pessoa.nomeRazaoSocial}"/><br/>

        <label>CPF/CNPJ:</label>
        <input type="text" name="cpfCnpj" value="${pessoa.cpfCnpj}"/><br/>

        <label>Rua:</label>
        <input type="text" name="rua" value="${p.Rua}"/><br>
        
        <label>Número:</label>
        <input type="text" name="numero" value="${p.Numero}"><br>
        
        <label>Complemento:</label>
        <input type="text" name="complemento" value="${p.Complemento}"><br>
        
        <label>Bairro:</label>
        <input type="text" name="bairro" value="${p.Bairro}"><br>
        
        <label>Cidade:</label>
        <input type="text" name="cidade" value="${p.Cidade}"><br>
        
        <label>Estado:</label>
        <input type="text" name="estado" value="${p.Estado}"><br>
        
        <label>CEP:</label>
        <input type="text" name="cep" value="${p.Cep}"><br><br>
    

        <input type="submit" value="Salvar"/>
    </form>
    <a href="menu.jsp">Voltar</a>
</body>
</html>
