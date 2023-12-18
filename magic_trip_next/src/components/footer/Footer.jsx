import React from 'react'

function Footer() {
    return ( 
        <footer className="py-4">
    <div className="container text-center">
      <small>
        Site desenvolvido por @IlnaraAckermann
        <br />

        <a href="https://github.com/IlnaraAckermann" target="_blank"  className="mx-2" title="GitHub">        
          <i className="fab fa-github mx-2">GitHub</i>        
        </a>

        <a href="https://www.linkedin.com/in/ilnaraackermann" target="_blank" className=" mx-2" title="LinkedIn">
          <i className="fab fa-linkedin mx-2">LinkedIn</i>      
        </a>
      </small>
    </div>
  </footer>
     );
}

export default Footer;