# language: pt


@post @create @user
Funcionalidade: Criar usuario

  @CreateUserSuccessful @rAegression
  Cenario: [POST] - Criar um usuario com dados corretos
    Dado que desejo criar usuario com name "morpheus" e job "leader"
    Quando executo a requisicao para criar um usuario
    Entao deve retornar o status code 201
    E valido que o campo "name" retornou "morpheus"
    E valido que o campo "job" retornou "leader"

  @CreateUserUnsuccessful @bug
  Esquema do Cenario: [POST] - Tentativa de criar um usuario com dados incorretos
    Dado que desejo criar usuario com name "<name>" e job "<job>"
    Quando executo a requisicao para criar um usuario
    Entao deve retornar o status code 400
    E valido que o campo "message" retornou "<error>"
    Exemplos:
      | name  | job      | error                          |
      |       |          | name and job field is required |
      | Paulo |          | job field is required          |
      |       | Analyst | name field is required         |

    @CreateUserSuccessful @ContractApi @regression
    Cenario: [POST] - Criar um usuario e validar o contrato
      Dado que desejo criar usuario com name "Robert" e job "QA Analyst"
      Quando executo a requisicao para criar um usuario
      Entao deve retornar o status code 201
      E valido que o campo "name" retornou "Robert"
      E valido que o campo "job" retornou "QA Analyst"
      E valido o contrato "createUserContract.json"
