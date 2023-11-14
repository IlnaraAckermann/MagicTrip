<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="jstl" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>CRUD JSP</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light p-3">
			<a class="navbar-brand" href="#">CRUD JSP</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item "><a class="nav-link"
						href="./ListarUsuarios">Usuario</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="./ListarDestinos">Destinos</a></li>
					<li class="nav-item"><a class="nav-link" href="./Vendedores	">Vendedores</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

		<main class="container-fluid">
			<h2>Cadastro de Destino</h2>

			<form action="./EditarDestino" method="post">			
		<input type="hidden" name="id" value="${destino.id_destino}">
				<div class="mb-3">
					<label for="nome" class="form-label">Nome do Destino:</label> <input
						type="text" class="form-control" id="nome" name="nome" value="${destino.nome}" required>
				</div>
				<div class="mb-3">
					<label for="descricao" class="form-label">Descrição do
						Destino:</label>
					<textarea class="form-control" id="descricao" name="descricao" 
						rows="3" required>${destino.descricao}</textarea>
				</div>
				<button type="submit" class="btn btn-primary">Salvar</button>
			</form>

			<a href="./ListarDestinos" class="btn btn-secondary mt-3">Voltar
				para Lista de Destinos</a>
		</main>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>