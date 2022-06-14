create database financeiro;

create table clientes(
id int not null auto_increment primary key,
nome varchar(40),
cpf  varchar(40),
cnpj varchar(40),
endereco varchar(80),
telefone varchar(40),
empresa int,
dataCadastro date)

