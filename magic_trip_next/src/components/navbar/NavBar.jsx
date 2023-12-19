import React, { useState, useEffect } from "react";
import Link from "next/link";
/**
 * @author Ilnara Ackermann
 * @date 29/10/23
 * @description Função responsável pela animação do icone hamburger, ela modifica o css ativando assim a animação.
 */

function NavBar() {
	useEffect(()=> {
		const toggleMenu = document.getElementById("toggleMenu");
		const navIco = document.querySelector("#nav-icon1");

		const handleClick = () => {
			const ariaExpanded = toggleMenu.getAttribute("aria-expanded");
	  
			if (ariaExpanded === "true") {
			  navIco.classList.add("open");
			} else {
			  navIco.classList.remove("open");
			}
		  };
		  toggleMenu.addEventListener("click", handleClick);
		  return () => {
			toggleMenu.removeEventListener("click", handleClick);
		  };
		}, []);
	

	return (
		<>
		<header>
			<div id="nav-top">
				<nav className="navbar navbar-expand-lg shadow position-absolute container-fluid z-3">
					<div className="container-fluid ">
						<Link className="navbar-brand" href="/">
							MagicTrip
						</Link>
						
						<div className="btn-group mx-2 ms-auto" role="group" aria-label="Basic radio toggle button group" id="btnTema">
							<input type="radio" className="btn-check" name="btnradio" id="btnClaro" autoComplete="off" />
							<label className="btn btn-outline-secondary" htmlFor="btnClaro" >
								Claro
							</label>
							<input type="radio" className="btn-check" name="btnradio" id="btnEscuro" autoComplete="off" />
							<label className="btn btn-outline-secondary" htmlFor="btnEscuro" >
								Escuro
							</label>
						</div>


						<button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" id="toggleMenu" >
							<div id="nav-icon1">
								<span></span>
								<span></span>
								<span></span>
							</div>
						</button>

						<div className="collapse navbar-collapse" id="navbarSupportedContent" >
							<ul className="navbar-nav me-auto mb-2 mb-lg-0">
								<li className="nav-item">
									<Link className="nav-link" href="/" >
										Home
									</Link>
								</li>
								<li className="nav-item">
									<Link className="nav-link" href="/destinos" >
										Destinos
									</Link>
								</li>
								<li className="nav-item">
									<Link className="nav-link" href="/promocao" >
										Promoções
									</Link>
								</li>
								<li className="nav-item">
									<Link className="nav-link" href="/contato" >
										Contato
									</Link>
								</li>
								<li className="nav-item">
									<Link className="nav-link" href="/listar_usuarios" >
										Listar Usuarios
									</Link>
								</li>
								<li className="nav-item">
									<Link className="nav-link" href="/cadastrar_usuarios" >
										Cadastrar Usuarios
									</Link>
								</li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</header>
		</>
	);
}

export default NavBar;
