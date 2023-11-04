<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de usu�rios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-4">
    <h1>Lista de Usu�rios</h1>
    <a href="cadastro.jsp" class="btn btn-dark">Criar Usu�rio</a>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Endere�o</th>
                <th>Email</th>
                <th>A��es</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td>${usuario.idUsuario}</td>
                    <td>${usuario.nome}</td> 
                    <td>${usuario.endereco}</td>
                    <td>${usuario.email}</td>
                    <td>
                        <a href="atualizar?id=${usuario.idUsuario}" class="btn btn-dark">Atualizar cadastro</a>
                        <a href="deletar?id=${usuario.idUsuario}" class="btn btn-primary">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>