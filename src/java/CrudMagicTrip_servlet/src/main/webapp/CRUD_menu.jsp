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
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="./home">Usuario</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="./Destino">Destinos</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="./Vendedores	">Vendedores</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	
	<main class="container-fluid">

		<h2>Lista de Usuários</h2>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Nome</th>
					<th scope="col">Email</th>
					<th scope="col" class=" d-none d-sm-table-cell">Senha</th>
					<th scope="col" class=" d-none d-md-table-cell">CPF</th>
					<th scope="col" class="d-none d-md-table-cell">Data de
						Nascimento</th>
					<th scope="col" class="d-none d-lg-table-cell">Endereço</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${listaUsuarios}" var="user">
					<tr>
						<td>${user.id_usuario}</td>
						<td>${user.nome}</td>
						<td>${user.email}</td>
						<td class=" d-none d-sm-table-cell">${user.senha}</td>
						<td class=" d-none d-md-table-cell">${user.cpf}</td>
						<td class=" d-none d-md-table-cell">${user.dataNascimento}</td>
						<td class="d-none d-lg-table-cell ">${user.logradouro},nº
							${user.numero} ${user.complemento},<br /> ${user.bairro},
							${user.cidade} - ${user.estado}, CEP ${user.cep}
						</td>
						<td><a href="./editarUsuario?id=${user.id_usuario}"
							class="btn btn-success"> <i class="fa-solid fa-pen-to-square"></i>
						</a> <a href="./excluirUsuario?id=${user.id_usuario}"
							onclick="return confirm('Deseja Excluir?')"
							class="btn btn-danger"> <i class="fa-solid fa-trash"></i>
						</a></td>

					</tr>

				</jstl:forEach>

			</tbody>
		</table>
	</main>
</body>
</html>