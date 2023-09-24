
## Modelo de dados conceitual

O modelo de dados conceitual para uma aplicação de viagens é composto pelas seguintes entidades:

* Usuário
* Telefone
* Vendedor
* Destino
* Avaliação de vendedor
* Avaliação de destino
* Compra

As relações entre essas entidades são as seguintes:

* Um usuário pode ter um ou mais telefones.
* Um usuário pode ser um vendedor.
* Uma compra é feita por um usuário, em um destino e realizada por um vendedor.
* Um destino pode ter uma ou mais avaliações.
* Uma avaliação de vendedor ou destino é feita por um usuário.

## Modelo de dados lógico

O modelo de dados lógico para uma aplicação de viagens é composto pelas seguintes tabelas:

* **User:** Armazena informações sobre os usuários da aplicação.
* **telefone:** Armazena informações sobre os telefones dos usuários.
* **destinos:** Armazena informações sobre os destinos de viagem.
* **vendedor:** Armazena informações sobre os vendedores da aplicação.
* **ava_vend:** Armazena informações sobre as avaliações dos vendedores.
* **ava_dest:** Armazena informações sobre as avaliações dos destinos.
* **compra:** Armazena informações sobre as compras feitas pelos usuários.

As relações entre essas tabelas são as seguintes:

* A tabela `User` tem uma relação de um para muitos com a tabela `telefone`.
* A tabela `User` tem uma relação de um para um com a tabela `vendedor`.
* A tabela `destinos` tem uma relação de muitos para muitos com a tabela `ava_dest`.
* A tabela `vendedor` tem uma relação de muitos para muitos com a tabela `ava_vend`.
* A tabela `compra` tem uma relação de um para muitos com as tabelas `destinos`, `vendedor` e `User`.

## Script SQL

O seguinte script SQL cria as tabelas e as relações entre elas:

```sql
CREATE TABLE User ( 
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

CREATE TABLE telefone ( 
 telefone_area VARCHAR(n),  
 telefone_numero VARCHAR(n),  
 idUser INT,  
); 

CREATE TABLE destinos ( 
 dest_id INT PRIMARY KEY AUTO_INCREMENT,  
 dest_name VARCHAR(n),  
 dest_descricao VARCHAR(n),  
); 

CREATE TABLE vendedor ( 
 ID_vendedor INT PRIMARY KEY AUTO_INCREMENT,  
 idUser INT,  
); 

CREATE TABLE ava_vend ( 
 Comentario VARCHAR(n),  
 Nota INT,  
 idvendedor INT,  
); 

CREATE TABLE ava_dest ( 
 nota INT,  
 comentario VARCHAR(n),  
 iddestinos INT,  
); 

CREATE TABLE compra ( 
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
```

## Implementação inicial

A implementação inicial do banco de dados será simplificada. Não será necessário implementar todas as entidades fracas no início. O modelo poderá ser refinado mais para frente do projeto.