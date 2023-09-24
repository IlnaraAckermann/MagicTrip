CREATE TABLE User 
( 
 user_id INT PRIMARY KEY AUTO_INCREMENT,  
 user_CPF VARCHAR(n),  
 logradouro VARCHAR(n),  
 numero INT,  
 complemento VARCHAR(n),  
 cep VARCHAR(n),  
 bairro VARCHAR(n),  
 cidade VARCHAR(n),  
 estado VARCHAR(n),  
 frist_name VARCHAR(n),  
 middle_name VARCHAR(n),  
 last_name VARCHAR(n),  
); 

CREATE TABLE telefone 
( 
 telefone_area VARCHAR(n),  
 telefone_numero VARCHAR(n),  
 idUser INT,  
); 

CREATE TABLE destinos 
( 
 dest_id INT PRIMARY KEY AUTO_INCREMENT,  
 dest_name VARCHAR(n),  
 dest_descricao VARCHAR(n),  
); 

CREATE TABLE vendedor 
( 
 ID_vendedor INT PRIMARY KEY AUTO_INCREMENT,  
 idUser INT,  
); 

CREATE TABLE ava_vend 
( 
 Comentario VARCHAR(n),  
 Nota INT,  
 idvendedor INT,  
); 

CREATE TABLE ava_dest 
( 
 nota INT,  
 comentario VARCHAR(n),  
 iddestinos INT,  
); 

CREATE TABLE compra 
( 
 valor FLOAT,  
 qnt_pessoas INT,  
 tipo_pacote VARCHAR(n),  
 comissao FLOAT,  
 data_fim DATE,  
 data_inicio DATE,  
 dest_id INT PRIMARY KEY,  
 ID_vendedor INT PRIMARY KEY,  
 user_id INT PRIMARY KEY,  
); 

ALTER TABLE telefone ADD FOREIGN KEY(idUser) REFERENCES User (idUser)
ALTER TABLE vendedor ADD FOREIGN KEY(idUser) REFERENCES User (idUser)
ALTER TABLE ava_vend ADD FOREIGN KEY(idvendedor) REFERENCES vendedor (idvendedor)
ALTER TABLE ava_dest ADD FOREIGN KEY(iddestinos) REFERENCES destinos (iddestinos)
ALTER TABLE compra ADD FOREIGN KEY(dest_id) REFERENCES destinos (dest_id)
ALTER TABLE compra ADD FOREIGN KEY(ID_vendedor) REFERENCES vendedor (ID_vendedor)
ALTER TABLE compra ADD FOREIGN KEY(user_id) REFERENCES User (user_id)
