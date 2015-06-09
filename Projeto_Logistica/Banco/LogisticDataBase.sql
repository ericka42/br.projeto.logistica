create DataBase LogisticDataBase

use LogisticDataBase


create table funcionario(
id_user INT IDENTITY(1,1) NOT NULL,
usuario VARCHAR(30) NOT NULL,
senha VARCHAR(15) NOT NULL
PRIMARY KEY(id_user)) 


create table motorista(
ID INT IDENTITY(1,1) NOT NULL,
nome VARCHAR(100) NOT NULL,
cpf CHAR(11) NOT NULL CHECK(LEN(cpf) = 11),
cnh CHAR(11) NOT NULL,
categoria CHAR(2) NOT NULL,
logradouro VARCHAR(50) NOT NULL,
numero int NOT NULL CHECK(numero >0),
bairro VARCHAR(100) NOT NULL,
cidade VARCHAR(40) NOT NULL,
cep CHAR(8) NOT NULL check(len(cep) = 8),
PRIMARY KEY(ID))


create table contato(
id_mot INT NOT NULL,
id_contato INT IDENTITY (1,1) NOT NULL,
tipo VARCHAR(15) NOT NULL,
telefone VARCHAR(11)NOT NULL CHECK(LEN(telefone)>=9 ),
descricao VARCHAR(50)NULL,
operadora VARCHAR(10)NULL,
PRIMARY KEY (id_mot,id_contato),
FOREIGN KEY (id_mot) REFERENCES motorista(ID))

 
create table caminhao(
placa CHAR(7) NOT NULL CHECK(LEN(placa) = 7),
renavam CHAR(11) NOT NULL CHECK(LEN(renavam) = 11),
chassi CHAR(17) NOT NULL CHECK(LEN(chassi) = 17),
modelo VARCHAR(30) NOT NULL,
marca VARCHAR(30) NOT NULL,
categoria VARCHAR(50) NOT NULL, 
anomodelo INT NOT NULL, 
eixo INT NOT NULL,
cor VARCHAR(20) NOT NULL, 
PRIMARY KEY(placa))




create table usocaminhao(
id_mot INT NOT NULL,
id_placa CHAR(7) NOT NULL,
dt_retirada DATETIME NOT NULL,
hr_retirada DATETIME NOT NULL,
dt_retorno DATETIME NOT NULL,
hr_retorno DATETIME NOT NULL,
PRIMARY KEY (id_mot, id_placa,dt_retirada,hr_retirada),
FOREIGN KEY (id_mot) REFERENCES motorista(ID),
FOREIGN KEY (id_placa) REFERENCES caminhao(placa))


create table produto(
ID INT IDENTITY(1001,1) NOT NULL,
nome VARCHAR(50) NOT NULL,
fragil  CHAR(1) DEFAULT('S') CHECK (fragil ='S' OR fragil='N') NULL,
descricao VARCHAR(50) NULL,
peso DECIMAL(7,2) NOT NULL,
pesagem CHAR(2),
comprimento DECIMAL(7,2) NOT NULL,
altura DECIMAL(7,2) NOT NULL,
largura DECIMAL(7,2) NOT NULL,
unid_medida CHAR(2) DEFAULT('mm') CHECK (unid_medida ='mm' OR unid_medida='cm') NOT NULL, 
quantidade INT NOT NULL,
PRIMARY KEY(ID))




create table empresa(
cnpj CHAR(14) NOT NULL CHECK(LEN(cnpj) = 14),
nome VARCHAR(200) NOT NULL,
insc_estadual CHAR(12) NOT NULL CHECK(LEN(insc_estadual) = 12),
ramo VARCHAR(50) NULL,
logradouro VARCHAR(50) NOT NULL,
num INT NOT NULL,
complemento VARCHAR(40) NULL,
bairro VARCHAR(30) NOT NULL,
cidade VARCHAR(30) NOT NULL,
cep CHAR(8) NOT NULL CHECK(LEN(cep) = 8),
informacao VARCHAR(100) NULL,
PRIMARY KEY(cnpj))


create table contato_emp(
cnpj_emp CHAR(14)NOT NULL,
tipo_emp VARCHAR(15) NOT NULL,
ddd CHAR(2)  NOT NULL DEFAULT ('11') check(LEN(ddd) = 2),
telefone VARCHAR(9)  NOT NULL CHECK(LEN(telefone)>=8 ),
descricao VARCHAR(50) NULL,
operadora VARCHAR(10) NULL,
representante VARCHAR(50) NULL,
PRIMARY KEY(cnpj_emp,tipo_emp),
FOREIGN KEY(cnpj_emp) REFERENCES empresa(cnpj))


create table relacao(
id_prod INT NOT NULL,
cnpj_emp CHAR(14)NOT NULL,
especificacao VARCHAR(50) NOT NULL, -- Relacao entre o produto e empresa atraves do segmento ou ramo da empresa exemplo" alimentício"
PRIMARY KEY(id_prod, cnpj_emp,especificacao),
FOREIGN KEY(id_prod) REFERENCES produto(ID),
FOREIGN KEY(cnpj_emp) REFERENCES empresa(cnpj))


create table rota(
registro INT IDENTITY(101,1) NOT NULL ,
origem VARCHAR(100) NOT NULL,
destino VARCHAR(100) NOT NULL,
data DATETIME NOT NULL,
hora DATETIME NOT NULL,
PRIMARY KEY(registro))


create table carga(
registro_rota INT NOT NULL,
id_prod INT NOT NULL,
placa_cam CHAR(7) NOT NULL,
tipo_carga VARCHAR(50)NOT NULL,
descricao VARCHAR(50) NOT NULL,
condicao VARCHAR(20) NULL,
PRIMARY KEY(registro_rota, id_prod, placa_cam,tipo_carga),
FOREIGN KEY (registro_rota) REFERENCES rota(registro),
FOREIGN KEY (id_prod) REFERENCES produto(ID),
FOREIGN KEY (placa_cam) REFERENCES caminhao(placa))




#retorna o ultimo id do motorista cadastrado
SELECT TOP (1) WITH TIES ID
from motorista
ORDER BY ID DESC 














