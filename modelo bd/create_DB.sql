CREATE TABLE usuario ( 
 id_usuario INT PRIMARY KEY AUTO_INCREMENT,  
 cpf VARCHAR(11) NOT NULL UNIQUE,  
 logradouro VARCHAR(255),  
 numero INT,  
 complemento VARCHAR(255),  
 cep VARCHAR(9),  
 bairro VARCHAR(255),  
 cidade VARCHAR(255),  
 estado VARCHAR(2),  
 nome_primeiro VARCHAR(255),  
 nome_meio VARCHAR(255),  
 name_ultimo VARCHAR(255)  
); 

CREATE TABLE telefone 
( 
 telefone_area VARCHAR(2),  
 telefone_numero VARCHAR(11),  
 id_usuario INT  
); 

CREATE TABLE destinos 
(  
 id_destino INT PRIMARY KEY AUTO_INCREMENT,  
 nome VARCHAR(255) NOT NULL UNIQUE,  
 descricao VARCHAR(255)
); 

CREATE TABLE vendedor 
( 
 id_vendedor INT PRIMARY KEY AUTO_INCREMENT,  
 id_usuario INT
); 

CREATE TABLE avaliacao_vendedor 
( 
 Comentario VARCHAR(255),  
 Nota INT,  
 id_vendedor INT  
); 

CREATE TABLE avaliacao_destino 
( 
 nota INT,  
 comentario VARCHAR(255),  
 id_destino INT  
); 

CREATE TABLE compra 
( 
 valor DECIMAL(10,2),  
 qnt_pessoas INT,  
 tipo_pacote VARCHAR(255),  
 comissao DECIMAL(10,2),  
 data_fim DATE,  
 data_inicio DATE,  
 id_destino INT PRIMARY KEY,  
 id_vendedor INT PRIMARY KEY,  
 id_usuario INT PRIMARY KEY 
); 

ALTER TABLE telefone ADD FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
ALTER TABLE vendedor ADD FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
ALTER TABLE avaliacao_vendedor ADD FOREIGN KEY(id_vendedor) REFERENCES vendedor (id_vendedor)
ALTER TABLE avaliacao_destino ADD FOREIGN KEY(id_destino) REFERENCES destinos (id_destino)
ALTER TABLE compra ADD FOREIGN KEY(id_destino) REFERENCES destinos (id_destino)
ALTER TABLE compra ADD FOREIGN KEY(id_vendedor) REFERENCES vendedor (id_vendedor)
ALTER TABLE compra ADD FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
