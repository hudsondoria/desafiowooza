# API Planos de Telefonia - Desafio Wooza
---------------------
API de Planos de Telefonia criada como resolução do desafio da Wooza para processo seletivo. Devido a familiaridade com a linguagem, a mesma foi desenvolvida em Java utilizando Spring Boot e MongoDB como repositório local.

## Requerimentos
------------------
Antes de executar o projeto, por favor instalar:

- [MongoDB](https://www.mongodb.com/)


## API
------------------
Todos os métodos da API são chamados partindo do path base.

Path Base no Localhost (Caso execute em outro ambiente, ajustar o path)
> http://localhost:8080/planos

### Cadastrar Plano
>	POST /cadastrar

**Exemplo de Objeto para cadastro do Plano**
```
{
    "minutos": 5000,
    "franquia": 10,
    "valor": 20.90,
    "tipo": "Pós",
    "operadora": "TIM",
    "dddsDisponiveis": [
        "044"
    ]
 }
```

### Alterar Plano
>	POST /alterar

**Exemplo de Objeto para alteração do Plano**
```
{
    "codPlano": "5d7435c8f3bd192f9cf20975",
    "minutos": 1000,
    "franquia": 4,
    "valor": 59.9,
    "tipo": "Controle",
    "operadora": "Oi",
    "dddsDisponiveis": [
        "031"
    ],
    "dataInclusao": "2019-09-07T22:57:12.265+0000",
    "dataUltModificacao": "2019-09-07T22:57:12.265+0000"
}
```

### Consultar Plano por Código
> GET /{id}

**Exemplo de consulta por Código**
> http://localhost:8080/planos/5d7435c8f3bd192f9cf20975

### Remover Plano
> POST /remover/{id}

**Exemplo de chamada de remoção**
> http://localhost:8080/planos/remover/5d744a92f3bd191d886ae4c3

### Consolta por Tipo de Plano _(Controle, Pós, Pré)_

> POST /consultar/tipo

**Exemplo de Objeto de Consulta**
```
{
	"tipo":"Controle",
	"ddd":"021"
}
```

**Retorno**
> Rotarna uma lista de Planos.

### Consulta por Operadora _(Claro, Vivo, TIM, OI, ..., etc)_
> POST /consultar/operadora

**Exemplo de Objeto de Consulta**

```
{
	"operadora":"Vivo",
	"ddd":"021"
}
```
**Retorno**
> Rotarna uma lista de Planos.



**Para as consultas por Tipo e Operadora o DDD é obrigatório.**


## Testes Unitários
------------------

Excutar a classe abaixo usando Junit:
> DesafiowoozaApplicationTests.java
