# Exemplos para testar no Postman

## Criar localização

POST `http://localhost:8080/localizacoes`

```json
{
  "cidade": "Rio Verde",
  "uf": "GO",
  "latitude": -17.7923,
  "longitude": -50.9192
}
```

## Criar produtor

POST `http://localhost:8080/produtores`

```json
{
  "nome": "João Produtor",
  "telefone": "64999990000",
  "email": "joao@fazenda.com",
  "localizacaoId": 1,
  "nomePropriedade": "Fazenda Boa Safra",
  "tipoProdutor": "PESSOA_FISICA"
}
```

## Criar caminhoneiro

POST `http://localhost:8080/caminhoneiros`

```json
{
  "nome": "Carlos Caminhoneiro",
  "telefone": "64999991111",
  "email": "carlos@email.com",
  "localizacaoId": 1,
  "cpf": "12345678901",
  "cnh": "12345678900",
  "disponibilidade": true,
  "raioAtuacaoKm": 150,
  "avaliacaoMedia": 4.8
}
```

## Criar caminhão

POST `http://localhost:8080/caminhoes`

```json
{
  "placa": "ABC1D23",
  "marca": "Volvo",
  "modelo": "FH 540",
  "ano": 2020,
  "capacidadeToneladas": 30,
  "tipoCaminhao": "GRANELEIRO",
  "caminhoneiroId": 2
}
```

## Criar assinatura

POST `http://localhost:8080/assinaturas`

```json
{
  "plano": "PROFISSIONAL",
  "status": "ATIVA",
  "dataInicio": "2026-07-02",
  "dataFim": "2026-08-02",
  "caminhoneiroId": 2
}
```

## Testar chatbot simulado

POST `http://localhost:8080/chatbot/mensagem`

```json
{
  "telefone": "64999990000",
  "mensagem": "Tenho uma carga de soja para transportar"
}
```
