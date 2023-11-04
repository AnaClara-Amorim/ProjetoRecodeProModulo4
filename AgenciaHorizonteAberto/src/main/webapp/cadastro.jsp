<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<style>
    body{
        background-color: rgb(112, 90, 112);
        font-family: Verdana, Geneva, Tahoma, sans-serif;
    }
</style>
</head>
<body>
<div class="container mt-5">
  <h2 class="text-center">Formulário de Registro</h2>
  <form action="cadastro" method="POST">
    <div class="mb-3">
      <label for="nome" class="form-label">Nome:</label>
      <input type="text" class="form-control" id="nome" placeholder="Digite seu nome" required name = "nome">
    </div>
    <div class="mb-3">
      <label for="endereco" class="form-label">Endereço:</label>
      <input type="text" class="form-control" id="endereco" placeholder="Digite seu endereço" required name = "endereco">
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Digite seu email" required name = "email">
    </div>
    <div class="mb-3">
      <label for="senha" class="form-label">Senha:</label>
      <input type="password" class="form-control" id="senha" placeholder="Digite sua senha" required name = "senha">
    </div>
    <button type="submit" class="btn btn-dark">Registrar</button>
  </form>
</div>
</body>
</html>