# 📜 Objetivo

- **Introdução:** Nossa empresa é especializada em equipamentos de monitoramento de energia
para uso residencial e comercial. Nosso principal produto são os adaptadores elétricos que
permitem monitorar o quanto de energia é utilizado por um aparelho eletrônico. Esses
equipamentos podem ser conectados a redes WiFi e integrados a serviços em nuvem,
criando um painel de informações de consumo elétrico.
- **Nossos Produtos:** Nossos adaptadores elétricos são compatíveis com a maioria dos
aparelhos eletrônicos e eletrodomésticos. Eles permitem que os usuários monitorem o
consumo de energia em tempo real e visualizem o histórico de consumo em um painel de
controle online. Isso permite que os usuários identifiquem aparelhos com alto consumo de
energia e adotem medidas para reduzir o consumo.
- **Nossa Tecnologia:** Nossos equipamentos utilizam tecnologia avançada para garantir a
precisão na medição de energia elétrica. Eles possuem uma interface fácil de usar e se
conectam automaticamente a redes WiFi. Os dados são enviados para serviços em nuvem,
onde são processados e apresentados em um painel de controle online.
- **Benefícios para os Usuários:** Nossos equipamentos oferecem uma série de benefícios para
os usuários. Com eles, é possível:
  1. Monitorar o consumo de energia em tempo real.
  2. Identificar aparelhos com alto consumo de energia.
  3. Reduzir o consumo de energia.
  4. Economizar na conta de luz.
  5. Contribuir para a preservação do meio ambiente.

# ⚒️ Documentação das APIs
**Path do projeto:**
**`/tech-challenge-grupo01`**
## **Pessoas**

### **Cadastro de pessoas**

**Requisição**

**`POST /pessoas`**

**Parâmetros da requisição**

| Parâmetro       | Tipo     |
|-----------------|----------|
| nome            | String   |
| dataNascimento  | String   |
| sexo            | String   |
| parentesco      | String   |
**Request**

```
{
  "nome": "Jose dos Santos",
  "dataNascimento": "19/03/1992",
  "sexo": "Masculino",
  "parentesco": "Irmão"
}
```
**Resposta**

```
{
  "id": 1
  "nome": "Jose dos Santos",
  "dataNascimento": "19/03/1992",
  "sexo": "Masculino",
  "parentesco": "Irmão"
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Buscar pessoa por ID**

**Requisição**

**`GET /pessoas/{ID}`**


**Resposta**

```
{
  "id": 1
  "nome": "Jose dos Santos",
  "dataNascimento": "19/03/1992",
  "sexo": "Masculino",
  "parentesco": "Irmão"
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Lista de pessoas**

**Requisição**

**`GET /pessoas`**

**Resposta**

```
[
  {
    "id": 1
    "nome": "Jose dos Santos",
    "dataNascimento": "19/03/1992",
    "sexo": "Masculino",
    "parentesco": "Irmão"
  }
]
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Update de pessoas**

**Requisição**

**`PUT /pessoas/{ID}`**

**Request**

```
{
  "nome": "Jose dos Santos",
  "dataNascimento": "19/03/1992",
  "sexo": "Masculino",
  "parentesco": "Irmão"
}
```

**Resposta**

```
{
  "id": 1
  "nome": "Jose dos Santos",
  "dataNascimento": "19/03/1992",
  "sexo": "Masculino",
  "parentesco": "Irmão"
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **DELETE de pessoas**

**Requisição**

**`DELETE /pessoas/{ID}`**

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |


## **Endereços**

### **Cadastro de endereços**

**Requisição**

**`POST /enderecos`**

**Parâmetros da requisição**

| Parâmetro | Tipo     |
|-----------|----------|
| rua       | String   |
| bairro    | String   |
| cidade    | String   |
| estado    | String   |
| cep       | String   |
| numero    | String   |

**Request**

```
{
  "rua": "Rua amazona",
  "bairro": "Centro",
  "cidade": "São Caetano do Sul",
  "estado": "SP",
  "cep": "05784513",
  "numero": "16"
}
```
**Resposta**

```
{
  "id": 1
  "rua": "Rua amazona",
  "bairro": "Centro",
  "cidade": "São Caetano do Sul",
  "estado": "SP",
  "cep": "05784513",
  "numero": "16"
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Buscar endereço por ID**

**Requisição**

**`GET /enderecos/{ID}`**


**Resposta**

```
{
  "id": 1
  "bairro": "Centro",
  "cidade": "São Caetano do Sul",
  "estado": "SP",
  "cep": "05784513",
  "numero": "16"
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Lista de endereços**


**Requisição**

**`GET /enderecos`**


**Resposta**

```
[
  {
    "id": 1
    "bairro": "Centro",
    "cidade": "São Caetano do Sul",
    "estado": "SP",
    "cep": "05784513",
    "numero": "16"
  }
]
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Update de endereços**

**Requisição**

**`PUT /enderecos/{ID}`**

**Request**

```
  {
    "bairro": "Centro",
    "cidade": "São Caetano do Sul",
    "estado": "SP",
    "cep": "05784513",
    "numero": "16"
  }
```

**Resposta**

```
  {
    "id": 1
    "bairro": "Centro",
    "cidade": "São Caetano do Sul",
    "estado": "SP",
    "cep": "05784513",
    "numero": "16"
  }
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **DELETE de pessoas**

**Requisição**

**`DELETE /enderecos/{ID}`**

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |


## **Eletrodomesticos**

### **Cadastro de eletrodomesticos**

**Requisição**

**`POST /eletrodomesticos`**

**Parâmetros da requisição**

| Parâmetro | Tipo    |
|-----------|---------|
| tipo      | String  |
| modelo    | String  |
| marca     | String  |
| potencia  | Integer |

**Request**

```
{
  "tipo": "Geladeira",
  "modelo": "W11",
  "marca": "Brastemp",
  "potencia": 3000
}
```
**Resposta**

```
{
  "id": 1
  "tipo": "Geladeira",
  "modelo": "W11",
  "marca": "Brastemp",
  "potencia": 3000
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **Buscar eletrodomesticos por ID**

**Requisição**

**`GET /eletrodomesticos/{ID}`**


**Resposta**

```
{
  "id": 1,
  "tipo": "Geladeira",
  "modelo": "W11",
  "marca": "Brastemp",
  "potencia": 3000
}
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Lista de eletrodomesticos**


**Requisição**

**`GET /eletrodomesticos`**


**Resposta**

```
[
  {
    "id": 1,
    "tipo": "Geladeira",
    "modelo": "W11",
    "marca": "Brastemp",
    "potencia": 3000
  }
]
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

### **Update de endereços**

**Requisição**

**`PUT /eletrodomesticos/{ID}`**

**Request**

```
  {
    "tipo": "Geladeira",
    "modelo": "W11",
    "marca": "Brastemp",
    "potencia": 3000
  }
```

**Resposta**

```
   {
    "id": 1,
    "tipo": "Geladeira",
    "modelo": "W11",
    "marca": "Brastemp",
    "potencia": 3000
  }
```

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

### **DELETE de pessoas**

**Requisição**

**`DELETE /eletrodomesticos/{ID}`**

**Códigos de resposta**

| Código | Descrição   |
|--------|-------------|
| 200    | OK          |
| 404    | Not Found   |

# ✔️ Tecnologias e Ferramentas utilizadas

- ``Java``
- ``Maven``
- ``Spring Boot``
- ``Intellij``
- ``Postman``


# 📋Desafios e soluções

## Arquitetura
Na primeira fase do projeto, decidimos utilizar uma arquitetura monolítica devido ao fato de termos poucas APIs e a simplicidade de manutenção que ela oferece. Nesse contexto, com um número limitado de APIs e funcionalidades, a arquitetura monolítica se mostrou uma escolha adequada.

Optar por uma arquitetura monolítica simplifica o desenvolvimento e a manutenção da aplicação, uma vez que todas as funcionalidades estão agrupadas em um único sistema. 

É importante ressaltar que essa decisão arquitetural foi tomada considerando o contexto atual da aplicação. Conforme a aplicação evolui e a complexidade aumenta, poderemos avaliar a possibilidade de migrar para uma arquitetura mais distribuída, como a arquitetura de microserviços, para melhor atender às necessidades futuras.

## Gestão de tempo
Um dos principais desafios que enfrentamos foi conciliar os horários disponíveis de cada membro da equipe.
Com compromissos individuais, como estudos e trabalhos paralelos, houve divergências de disponibilidade de tempo.

Para contornar essa situação, optamos por realizar reuniões nos fins de semana. Além disso, utilizamos ferramentas de comunicação online, como
videoconferências, para manter a conexão e avançar nos trabalhos mesmo à distância.

Essa abordagem nos permitiu superar os desafios de disponibilidade de tempo e manter um fluxo de trabalho
eficiente, alcançando nossos objetivos com sucesso.