create table pessoa 
(
    id_pessoa BIGINT AUTO_INCREMENT  NOT NULL PRIMARY KEY,
    data_nasc DATE NOT NULL,
    nome VARCHAR(255) NOT NULL
);
 
create table endereco 
(
    id_endereco BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    cidade VARCHAR(255) NOT NULL,
    endereco_principal BOOLEAN NOT NULL DEFAULT FALSE,
    numero INTEGER NOT NULL,
    estado VARCHAR(255) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    cep VARCHAR(255) NOT NULL,
    id_pessoa BIGINT NOT NULL,
    CONSTRAINT ID_PESSOA_FK FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa)
);

INSERT INTO pessoa (id_pessoa, data_nasc, nome) VALUES (1,'1991-12-22','GILBERTO');

INSERT INTO endereco (id_endereco, cidade, endereco_principal, numero, estado, rua, cep, id_pessoa) VALUES (1,'CAMARAGIBE',TRUE,82,'PERNAMBUCO','RUA LOURENCO FERNANDES','54774300',1);
INSERT INTO endereco (id_endereco, cidade, endereco_principal, numero, estado, rua, cep, id_pessoa) VALUES (2,'RECIFE',FALSE,90,'PERNAMBUCO','RUA TAMBIA','50960090',1);