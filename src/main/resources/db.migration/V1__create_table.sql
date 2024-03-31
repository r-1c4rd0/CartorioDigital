-- Migração para criar a tabela de situações do cartório
CREATE TABLE situacoes (
       id VARCHAR(20) NOT NULL,
       nome VARCHAR(50) NOT NULL,
       PRIMARY KEY (id)
);

-- Inserir dados iniciais na tabela de situações do cartório
INSERT INTO situacoes (id, nome) VALUES ('SIT_ATIVO', 'Ativo');
INSERT INTO situacoes (id, nome) VALUES ('SIT_BLOQUEADO', 'Bloqueado');

-- Migração para criar a tabela de atribuições do cartório
CREATE TABLE atribuicoes (
     id VARCHAR(20) NOT NULL,
     nome VARCHAR(50) NOT NULL,
     situacao BOOLEAN DEFAULT TRUE NOT NULL,
     PRIMARY KEY (id)
);

-- Migração para criar a tabela de cartórios
CREATE TABLE cartorios (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(150) NOT NULL,
       observacao VARCHAR(250),
       situacaoCartorio VARCHAR(20) NOT NULL,
       FOREIGN KEY (situacaoCartorio) REFERENCES situacoes(id)
);

-- Migração para criar a tabela de relação entre cartórios e atribuições
CREATE TABLE cartorioAtribuicoes (
     cartorioID INT,
     atribuicaoID VARCHAR(20),
     PRIMARY KEY (cartorioID, atribuicaoID),
     FOREIGN KEY (cartorioID) REFERENCES cartorios(id),
     FOREIGN KEY (atribuicaoID) REFERENCES atribuicoes(id)
);
