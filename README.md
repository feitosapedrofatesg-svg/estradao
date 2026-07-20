# Estradão

MVP em Java/Spring Boot para conectar produtores rurais a caminhoneiros.

## Sprints entregues

### Sprint 1 — Estrutura do Projeto
- Projeto Spring Boot criado.
- Docker + PostgreSQL configurados.
- Estrutura de pacotes.
- BaseModel e BaseDTO.
- Tratamento global de exceções.
- Core genérico: Repository, Mapper, Validation e Service.

### Sprint 2 — Cadastro de Usuários
- CRUD de Localização.
- CRUD de Produtor.
- CRUD de Caminhoneiro.
- CRUD de Caminhão.
- CRUD de Assinatura.
- DTOs, Mappers e Validações.

## Como rodar

Na raiz do projeto:

```bash
docker compose up -d
```

Depois execute a aplicação Spring Boot.

A API sobe em:

```text
http://localhost:8080
```

## Banco

- Host: localhost
- Porta: 5433
- Database: estradao
- User: estradao
- Password: estradao123

## Endpoints principais

```text
GET    /localizacoes
POST   /localizacoes
GET    /produtores
POST   /produtores
GET    /caminhoneiros
POST   /caminhoneiros
GET    /caminhoes
POST   /caminhoes
GET    /assinaturas
POST   /assinaturas
```

## Observação

O pacote `chatbot` está preparado como camada de lógica. O estado da conversa fica salvo na entidade `ConversaModel`.
