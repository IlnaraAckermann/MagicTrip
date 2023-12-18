import React from 'react'
import Head from "next/head";

function PageHead({titulo}) {
	return (
		<Head>
			<title>{titulo}</title>
		</Head>
	);
}

export default PageHead;
