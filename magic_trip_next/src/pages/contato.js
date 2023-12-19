import PageHead from "@/components/head/Head";

function Contato() {
	return (
		<>
			<PageHead titulo="Contato - Agência de Viagens Mágicas"></PageHead>
			<main className="container mt-5 ">
				<h2 className="text-center"> Contato - Agência de Viagens Mágicas</h2>
				<div className="row mt-2 g-5 ">
					<div className="col-xl-4 col-lg-5 col-sm-12 ">
						<figure className="ratio ratio-1x1">
							<img
								src="/imgs/email.jpg"
								alt="imagem de uma cartinha mágica"
								className="object-fit-cover rounded-4"
							/>
						</figure>
					</div>
					<div className="col h-100">
						<form
							id="myForm"
							// a ser implementado
						>
							<div className="mb-3">
								<label
									htmlFor="nome"
									className="form-label"
								>
									Nome:
								</label>
								<input
									type="text"
									className="form-control"
									id="nome"
									name="nome"
									required=""
								/>
							</div>
							<div className="mb-3">
								<label
									htmlFor="email"
									className="form-label"
								>
									E-mail:
								</label>
								<input
									type="email"
									className="form-control"
									id="email"
									name="email"
									required=""
								/>
							</div>
							<div className="mb-3">
								<label
									htmlFor="mensagem"
									className="form-label"
								>
									Mensagem:
								</label>
								<textarea
									className="form-control"
									id="mensagem"
									name="mensagem"
									rows={4}
									required=""
									defaultValue={""}
								/>
							</div>
							<button
								type="submit"
								className="btn btn-success"
							>
								Enviar Mensagem
							</button>
						</form>
					</div>
				</div>
			</main>
		</>
	);
}

export default Contato;
