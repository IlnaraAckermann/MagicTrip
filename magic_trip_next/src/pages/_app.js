import Footer from "@/components/footer/footer";
import NavBar from "@/components/navbar/NavBar";
import "@/styles/globals.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { useEffect } from "react";

export default function App({ Component, pageProps }) {
	useEffect(() => {
		require("bootstrap/dist/js/bootstrap.bundle.min.js");
	}, []);

	return (
		<>
			<NavBar />
			<Component {...pageProps} />
     <Footer/>
     </>
	);
}
