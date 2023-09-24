
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
 name_ultimo VARCHAR(255),  
); 

CREATE TABLE telefone 
( 
 telefone_area VARCHAR(2),  
 telefone_numero VARCHAR(11),  
 id_usuario INT,  
); 

CREATE TABLE destinos 
(  
 id_destino INT PRIMARY KEY AUTO_INCREMENT,  
 nome VARCHAR(255) NOT NULL UNIQUE,  
 descricao VARCHAR(255),
); 

CREATE TABLE vendedor 
( 
 id_vendedor INT PRIMARY KEY AUTO_INCREMENT,  
 id_usuario INT,  
); 

CREATE TABLE avaliacao_vendedor 
( 
 Comentario VARCHAR(n),  
 Nota INT,  
 id_vendedor INT,  
); 

CREATE TABLE avaliacao_destino 
( 
 nota INT,  
 comentario VARCHAR(n),  
 id_destino INT,  
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
 id_usuario INT PRIMARY KEY,  
); 

ALTER TABLE telefone ADD FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
ALTER TABLE vendedor ADD FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)
ALTER TABLE avaliacao_vendedor ADD FOREIGN KEY(id_vendedor) REFERENCES vendedor (id_vendedor)
ALTER TABLE avaliacao_destino ADD FOREIGN KEY(id_destino) REFERENCES destinos (id_destino)
ALTER TABLE compra ADD FOREIGN KEY(id_destino) REFERENCES destinos (id_destino)
ALTER TABLE compra ADD FOREIGN KEY(id_vendedor) REFERENCES vendedor (id_vendedor)
ALTER TABLE compra ADD FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario)

```

## Implementação inicial

A implementação inicial do banco de dados será simplificada. Não será necessário implementar todas as entidades fracas no início. O modelo poderá ser refinado mais para frente do projeto.