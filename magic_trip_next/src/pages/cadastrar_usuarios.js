import React, { useEffect } from "react";
import PageHead from "@/components/head/Head";
import useUsuarios from "../hooks/useUsuarios";

const CadastrarUsuarios = () => {
	const { criar, formValues, listar, handleInputChange, handleSubmit } =
		useUsuarios();

	return (
		<>
			<PageHead titulo="Usuários Mágicos!" />
			<div className="container">
				<h1>Cadastre-se!</h1>
				<section className="my-5 ">
					<form onSubmit={handleSubmit}>
						<div className="mb-3">
							<label for="nome" className="form-label" >
								Nome
							</label>
							<input type="text" className="form-control" id="nome" required value={formValues.nome} onChange={handleInputChange}/>
						</div>
						<div className="mb-3">
							<label for="cpf" className="form-label" >
								CPF
							</label>
							<input type="text" className="form-control" id="cpf" required minlength="11" maxlength="11" value={formValues.cpf} onChange={handleInputChange}/>
						</div>
						<div className="mb-3">
							<label for="endereco" className="form-label" >
								Endereço
							</label>
							<input type="text" className="form-control" id="endereco" required value={formValues.endereco} onChange={handleInputChange} />
						</div>
						<div className="mb-3">
							<label for="cidade"
								className="form-label"
							>
								Cidade
							</label>
							<input
								type="text"
								className="form-control"
								id="cidade"
								required value={formValues.cidade} onChange={handleInputChange}
							/>
						</div>
						<div className="mb-3">
							<label
								for="estado"
								className="form-label" 
							>
								Estado
							</label>
							<input
								type="text"
								className="form-control"
								id="estado"
								required
								minlength="2"
								maxlength="2"
                value={formValues.estado} onChange={handleInputChange}
							/>
						</div>
						<div className="mb-3">
							<label
								for="email"
								className="form-label"
							>
								Email
							</label>
							<input
								type="email"
								className="form-control"
								id="email"
								required
                value={formValues.email} onChange={handleInputChange}
							/>
						</div>
						<div className="mb-3">
							<label
								for="senha"
								className="form-label"
							>
								Senha
							</label>
							<input
								type="password"
								className="form-control"
								id="senha"
								required
                value={formValues.senha} onChange={handleInputChange}
							/>
						</div>
						<button
							type="submit"
							className="btn btn-primary"
						>
							Enviar
						</button>
					</form>
				</section>
			</div>
		</>
	);
};

export default CadastrarUsuarios;
