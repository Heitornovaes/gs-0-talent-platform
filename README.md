# GS 0 – Talent Platform

API desenvolvida como parte do **GS0** da FIAP, com o objetivo de expor informações sobre o tema do grupo e demonstrar o uso de **Spring Boot**, **Swagger** e **CI/CD com Docker Hub**.

---

## 👤 Integrantes do grupo

- **Gustavo Matos** – RM551268 
- **Heitor Novaes do Santos** – RM98342  


---

## 🎯 Tema escolhido

**Plataformas que conectam talentos a projetos com propósito**

> Plataforma digital que conecta profissionais a projetos alinhados a causas sociais, ambientais ou de impacto positivo, permitindo que organizações encontrem talentos com habilidades adequadas e interesse no propósito.

---

## 📌 Finalidade da API

Esta API foi criada para:

- Expor, via endpoint REST, as principais informações do grupo e do tema:  
  - tema  
  - nomes dos membros  
  - descrição da ideia  
- Servir como base para práticas de:
  - organização de projeto Spring Boot,
  - documentação com Swagger,
  - construção e **deploy de imagem Docker** via **GitHub Actions (CI/CD)**.

Endpoint principal:

- `GET /info` – retorna um JSON com:
  ```json
  {
    "tema": "Plataformas que conectam talentos a projetos com propósito",
    "membro1": "Gustavo Matos",
    "membro2": "Heitor Novaes",
    "descricao": "Plataforma digital que conecta profissionais a projetos alinhados a causas sociais, ambientais ou de impacto positivo, permitindo que organizações encontrem talentos com habilidades adequadas e interesse no propósito."
  }


## Como executar o projeto localmente

Java 17 instalado
Maven instalado
(Opcional, para rodar via container) Docker instalado e Docker Engine em execução

2. Clonar o repositório
``` bash
git clone https://github.com/Heitornovaes/gs-0-talent-platform.git
cd gs-0-talent-platform
```

3. Execução via Maven (sem Docker)
``` bash
mvn clean package -DskipTests
mvn spring-boot:run
```

O Spring Boot irá subir na porta 8081.

Acesse no navegador:

API: http://localhost:8081/info

Swagger UI: http://localhost:8081/swagger-ui/index.html

4. Execução via Docker
``` bash
docker pull heitornovaes/gs-0-talent-platform:latest
//4.2. Rodar o container
docker run --rm -p 8081:8081 --name gs0-talent \
  heitornovaes/gs-0-talent-platform:latest
```

## URL da imagem no Docker Hub
Docker Hub: https://hub.docker.com/r/heitornovaes/gs-0-talent-platform


## Workflows de CI/CD   

O projeto utiliza GitHub Actions com dois workflows principais, localizados em .github/workflows/:

1. CI – Integração Contínua

Arquivo: ci.yml

Objetivo: garantir que o projeto builda corretamente a cada alteração de código.

Gatilho (trigger):

push e/ou pull_request para o repositório (ex.: branches de feature).

Principais etapas:

Checkout do repositório

Setup do JDK 17

Build com Maven (mvn -B clean package -DskipTests)

(Opcional, se configurado) Execução de testes

Esse workflow não publica nada, apenas valida o código (quebra o build se algo estiver errado).

2. CD – Continuous Delivery (Entrega Contínua)

Nome do workflow: CD - Continuous Delivery

Arquivo: cd.yml

Gatilho (trigger):

workflow_dispatch – executado manualmente a partir da branch main (após o código estar aprovado).

Responsável por:

Fazer checkout do código na branch main

Configurar o JDK 17

Buildar o projeto com Maven (gera o .jar da aplicação)

Fazer login no Docker Hub usando os secrets:

DOCKERHUB_USERNAME

DOCKERHUB_TOKEN

Configurar Docker Buildx

Buildar e publicar a imagem no Docker Hub:

Repositório: heitornovaes/gs-0-talent-platform

Tag: latest

Com isso, sempre que o workflow de CD é executado com sucesso, uma nova versão da imagem Docker é gerada e já fica disponível para ser executada em qualquer ambiente que tenha Docker.

3. Versioning (release-please.yml)
Gatilho: push na branch main.

Função: Utiliza o release-please para analisar os commits. Ele cria e atualiza um Pull Request de "release". Ao aceitar este PR, o workflow automaticamente gera uma nova tag de versão no repositório, cumprindo o requisito de automação de versão.