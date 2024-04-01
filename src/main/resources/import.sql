
-- Inserir dados na tabela de atribuições do cartório
INSERT INTO atribuicoes (id, nome, situacao) VALUES ('ATRIB_1', 'Atribuição 1', TRUE);
INSERT INTO atribuicoes (id, nome, situacao) VALUES ('ATRIB_2', 'Atribuição 2', TRUE);
INSERT INTO atribuicoes (id, nome, situacao) VALUES ('ATRIB_3', 'Atribuição 3', FALSE);
INSERT INTO atribuicoes (id, nome, situacao) VALUES ('ATRIB_4', 'Atribuição 4', TRUE);
INSERT INTO atribuicoes (id, nome, situacao) VALUES ('ATRIB_5', 'Atribuição 5', FALSE);

-- Inserir dados adicionais na tabela de cartórios
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 3', 'Observação 3', 'SIT_ATIVO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 4', 'Observação 4', 'SIT_ATIVO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 5', 'Observação 5', 'SIT_BLOQUEADO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 6', 'Observação 6', 'SIT_ATIVO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 7', 'Observação 7', 'SIT_BLOQUEADO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 8', 'Observação 8', 'SIT_ATIVO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 9', 'Observação 9', 'SIT_BLOQUEADO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 10', 'Observação 10', 'SIT_ATIVO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 11', 'Observação 11', 'SIT_BLOQUEADO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 12', 'Observação 12', 'SIT_ATIVO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 13', 'Observação 13', 'SIT_BLOQUEADO');
INSERT INTO cartorios (nome, observacao, situacaoCartorio) VALUES ('Cartório 14', 'Observação 14', 'SIT_ATIVO');

-- Inserir dados na tabela de relação entre cartórios e atribuições
INSERT INTO cartorioAtribuicoes (cartorioID, atribuicaoID) VALUES (1, 'ATRIB_1');
INSERT INTO cartorioAtribuicoes (cartorioID, atribuicaoID) VALUES (1, 'ATRIB_2');
INSERT INTO cartorioAtribuicoes (cartorioID, atribuicaoID) VALUES (2, 'ATRIB_3');
INSERT INTO cartorioAtribuicoes (cartorioID, atribuicaoID) VALUES (2, 'ATRIB_4');
INSERT INTO cartorioAtribuicoes (cartorioID, atribuicaoID) VALUES (2, 'ATRIB_5');