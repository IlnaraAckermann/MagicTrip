<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="jstl" uri="jakarta.tags.core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>Editar Cliente</title>
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
					<li class="nav-item active"><a class="nav-link"
						href="./ListarUsuarios">Usuario</a></li>
					<li class="nav-item"><a class="nav-link"
						href="./ListarDestinos">Destinos</a></li>
					<li class="nav-item"><a class="nav-link" href="./Vendedores	">Vendedores</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>



	<main class="container">

		<h1>Editar de Cliente</h1>
		<form action="./editarUsuario" method="post">
		<input type="hidden" name="id" value="${user.id_usuario}">
			<div class="form-floating mb-3">
				<input type="text" id="nome" name="nome" class="form-control" value="${user.nome}"
					required> <label for="nome">Nome:</label>
			</div>
			<div class="form-floating mb-3">
				<input type="date" name="dataNascimento" id="dataNascimento"
					class="form-control" value="${user.dataNascimento}" required> <label for="dataNascimento">Data
					de Nascimento:</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" id="cpf" name="cpf" class="form-control" value="${user.cpf}" required>
				<label for="cpf">CPF:</label>
			</div>
			<div class="form-floating mb-3">
				<input type="email" name="email" id="email" class="form-control" value="${user.email}"
					required> <label for="email">E-mail:</label>
			</div>
			<div class="form-floating mb-3">
				<input type="text" id="senha" name="senha" class="form-control"
					value="${user.senha}" required> <label for="senha">Senha:</label>
			</div>
			<div class="row g-3 ">
				<div class="col-md-7">
					<div class="form-floating ">
						<input type="text" id="logradouro" name="logradouro"
							class="form-control" value="${user.logradouro}" required> <label for="logradouro">Logradouro:</label>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-floating">
						<input type="number" id="numero" name="numero"
							class="form-control" value="${user.numero}" required> <label for="numero">Número:</label>
					</div>
				</div>
				<div class="col-md-3 mb-3">
					<div class="form-floating">
						<input type="text" id="complemento" name="complemento"
							class="form-control" value="${user.complemento}"> <label for="complemento">Complemento:</label>
					</div>
				</div>
			</div>
			<div class="row g-3 mb-3">
				<div class="col-md-6">
					<div class="form-floating">
						<input type="text" id="bairro" name="bairro" class="form-control" value="${user.bairro}"	required> <label for="bairro">Bairro:</label>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-floating">
						<input type="text" id="cidade" name="cidade" class="form-control" value="${user.cidade}"
							required> <label for="cidade">Cidade:</label>
					</div>
				</div>
			</div>
			<div class="row g-3 mb-3">
				<div class="col-md-6">
					<div class="form-floating mb-3">
						<input type="text" id="cep" name="cep" class="form-control" value="${user.cep}"
							required> <label for="cep">CEP:</label>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-floating  mb-3">
						<select class="form-select" id="estado" name="estado">
							<option value="${user.estado}" selected>${user.estado}</option>
							<option value="AC">Acre</option>
							<option value="AL">Alagoas</option>
							<option value="AP">Amapá</option>
							<option value="AM">Amazonas</option>
							<option value="BA">Bahia</option>
							<option value="CE">Ceará</option>
							<option value="DF">Distrito Federal</option>
							<option value="ES">Espírito Santo</option>
							<option value="GO">Goiás</option>
							<option value="MA">Maranhão</option>
							<option value="MT">Mato Grosso</option>
							<option value="MS">Mato Grosso do Sul</option>
							<option value="MG">Minas Gerais</option>
							<option value="PA">Pará</option>
							<option value="PB">Paraíba</option>
							<option value="PR">Paraná</option>
							<option value="PE">Pernambuco</option>
							<option value="PI">Piauí</option>
							<option value="RJ">Rio de Janeiro</option>
							<option value="RN">Rio Grande do Norte</option>
							<option value="RS">Rio Grande do Sul</option>
							<option value="RO">Rondônia</option>
							<option value="RR">Roraima</option>
							<option value="SC">Santa Catarina</option>
							<option value="SP">São Paulo</option>
							<option value="SE">Sergipe</option>
							<option value="TO">Tocantins</option>
							<option value="Não residente no Brasil">*Não residente
								no Brasil*</option>
						</select> <label for="estado" class="form-label">Estado</label>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Editar</button>
			<a href="./home" class="btn btn-secondary">Cancelar</a>
			
		</form>
	</main>
<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/js/bootstrap.bundle.min.js"></script>

</body>
</html>