<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
  <title>Login</title>
   <script>
        // Verifica se o atributo 'loginFailed' está presente e exibe um alerta
        <% if (request.getAttribute("loginFailed") != null && (boolean) request.getAttribute("loginFailed")) { %>
            alert("Credenciais inválidas. Tente novamente.");
        <% } %>
        
        //verifica se o cadastroRealizado e exibe um alerta.
             <% if (request.getAttribute("cadastroRealizado") != null && (boolean) request.getAttribute("cadastroRealizado")) { %>
            alert("Cadastro realizado com sucesso!");
        <% } %>
    </script>
</head>
<body class="d-flex align-items-center justify-content-center" style="height: 100vh;">

<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card">
        <div class="card-header">
          Login
        </div>
        <div class="card-body">
          <form action="./Autenticador" method="post" >
            <div class="form-group">
              <label for="username">Email:</label>
              <input type="text" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
              <label for="password">Senha:</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Entrar</button>
          </form>
          <br>
          <p>Não tem uma conta? <a href="cadastarusuario.jsp">Cadastre-se aqui</a></p>
        </div>
      </div>
    </div>
  </div>
</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
