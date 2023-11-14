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

		<h2>Lista de Destinos</h2>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nome</th>
					<th scope="col">Descrição</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${listaDestinos}" var="destino">
					<tr>
						<td>${destino.id_destino}</td>
						<td>${destino.nome}</td>
						<td>${destino.descricao}</td>
						<td><a href="./EditarDestino?id=${destino.id_destino}"
							class="btn btn-success"> <i class="fa-solid fa-pen-to-square"></i>
						</a> <a href="./ExcluirDestino?id=${destino.id_destino}"
							onclick="return confirm('Deseja Excluir?')"
							class="btn btn-danger"> <i class="fa-solid fa-trash"></i>
						</a></td>

					</tr>

				</jstl:forEach>

			</tbody>
		</table>
	</main>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>