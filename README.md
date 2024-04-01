# API de Cartórios
Esta API foi desenvolvida para gerenciar informações sobre cartórios. Ela permite listar, consultar, incluir, atualizar e excluir registros de cartórios.

# Endpoints
# Listar Cartórios
Retorna uma lista paginada de cartórios.

Método: GET
URL: /cartorio
Parâmetros:
page (opcional): Página desejada (padrão é 0)
size (opcional): Tamanho da página (padrão é 10)
Consultar Cartório por ID
Retorna os detalhes de um cartório específico com base no ID.

Método: GET
URL: /cartorio/{id}

# Incluir Cartório
Cria um novo registro de cartório.

Método: POST
URL: /cartorio
Corpo da Requisição (exemplo em JSON):
JSON

{
    "nome": "Nome do Cartório"
}

# Atualizar Cartório por ID
Atualiza os dados de um cartório existente com base no ID.

Método: PUT
URL: /cartorio/{id}
Corpo da Requisição (exemplo em JSON):
JSON

{
    "nome": "Novo Nome do Cartório"
}

# Excluir Cartório por ID
Remove um cartório com base no ID.

Método: DELETE
URL: /cartorio/{id}

# Validações
A API valida a integridade referencial na exclusão e apresenta a mensagem “Registro utilizado em outro cadastro” quando não é possível excluir.
Também valida tentativas de inclusão e alteração de registro com nome duplicado, apresentando a mensagem “Nome já informado no registro com código {id}” quando relevante.
Situações do Cartório
A API também inclui as situações iniciais “Ativo” e “Bloqueado” com os IDs “SIT_ATIVO” e “SIT_BLOQUEADO”.


# API de Atribuições
Esta API foi desenvolvida para gerenciar informações sobre atribuições. Ela permite listar, consultar, incluir, atualizar e excluir registros de atribuições.

# Endpoints
# Listar Atribuições
Retorna uma lista de todas as atribuições.

Método: GET
URL: /atribuicao

# Consultar Atribuição por ID
Retorna os detalhes de uma atribuição específica com base no ID.

Método: GET
URL: /atribuicao/{id}

# Incluir Atribuição
Cria um novo registro de atribuição.

Método: POST
URL: /atribuicao
Corpo da Requisição (exemplo em JSON):
JSON

{
    "nome": "Nome da Atribuição"
}

# Atualizar Atribuição por ID
Atualiza os dados de uma atribuição existente com base no ID.

Método: PUT
URL: /atribuicao/{id}
Corpo da Requisição (exemplo em JSON):
JSON

{
    "nome": "Novo Nome da Atribuição"
}

# Excluir Atribuição por ID
Remove uma atribuição com base no ID.

Método: DELETE
URL: /atribuicao/{id}


# Situação do Cartório
Esta é uma API para gerenciar informações sobre situações de cartórios. Ela permite listar, consultar, incluir, atualizar e excluir registros de situações.

# Endpoints
# Listar Situações
Retorna uma lista de todas as situações.

Método: GET
URL: /situacao

# Consultar Situação por ID
Retorna os detalhes de uma situação específica com base no ID.

Método: GET
URL: /situacao/{id}

# Incluir Situação
Cria um novo registro de situação.

Método: POST
URL: /situacao
Corpo da Requisição (exemplo em JSON):
JSON

{
    "nome": "Nome da Situação"
}

# Atualizar Situação por ID
Atualiza os dados de uma situação existente com base no ID.

Método: PUT
URL: /situacao/{id}
Corpo da Requisição (exemplo em JSON):
JSON

{
    "nome": "Novo Nome da Situação"
}

# Excluir Situação por ID
Remove uma situação com base no ID.

Método: DELETE
URL: /situacao/{id}
