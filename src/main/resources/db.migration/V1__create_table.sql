CREATE TABLE situacao (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE atribuicao (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    situacao_id VARCHAR(255) NOT NULL,
    FOREIGN KEY (situacao_id) REFERENCES situacao(id)
);

-- Adicione outras colunas necessárias
CREATE TABLE cartorio (
    id INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    observacao VARCHAR(255)
);


