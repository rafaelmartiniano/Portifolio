# Especificações Técnicas e Funcionais - API Conversor de Moedas

Este documento detalha os aspectos técnicos, funcionais, a arquitetura e as tecnologias utilizadas no projeto da API REST para Conversão de Moedas.

## 🎯 Objetivos Principais do Desafio
* Desenvolver uma API REST que converta valores de uma moeda para outra.
* Integrar com uma API externa para obter taxas de câmbio.
* Organizar o projeto de forma modular (Controller, Service).
* Implementar validação de parâmetros e tratamento de erros.
* (Opcional/Próximos Passos) Garantir cobertura com testes automatizados, documentação Swagger, cache, monitoramento e containerização.

---

## 🛠️ Especificações Detalhadas

### 1. Requisitos Funcionais

* **Endpoint de Conversão:**
    * **URL:** `/api/converter`
    * **Método HTTP:** `GET`
    * **Parâmetros da Query (Query Parameters):**
        * `valor` (obrigatório, `double`): Valor numérico a ser convertido. Deve ser um número positivo.
        * `moedaOrigem` (obrigatório, `String`): Código da moeda de origem (ex: USD, BRL, EUR). Deve ser um código de 3 letras maiúsculas.
        * `moedaDestino` (obrigatório, `String`): Código da moeda de destino (ex: USD, BRL, EUR). Deve ser um código de 3 letras maiúsculas.
    * **Resposta em Caso de Sucesso (JSON - HTTP 200 OK):**
        ```json
        {
          "moedaOrigem": "USD",
          "moedaDestino": "BRL",
          "valorOriginal": 100.00,
          "taxaCambio": 5.25,
          "valorConvertido": 525.00,
          "dataHoraTaxa": "2025-05-09T14:30:00Z" // Formato ISO 8601
        }
        ```
    * **Resposta em Caso de Erro de Validação (JSON - HTTP 400 Bad Request):**
        ```json
        {
          "timestamp": "2025-05-09T14:35:00.123Z",
          "status": 400,
          "error": "Bad Request",
          "message": "Parâmetro 'valor' deve ser positivo."
          // ou "Moeda de origem 'XYZ' não suportada."
          // ou "Parâmetro 'moedaOrigem' é obrigatório."
        }
        ```
    * **Resposta em Caso de Erro na API Externa (JSON - HTTP 503 Service Unavailable ou HTTP 500 Internal Server Error):**
        ```json
        {
          "timestamp": "2025-05-09T14:40:00.456Z",
          "status": 503,
          "error": "Service Unavailable",
          "message": "Serviço de taxas de câmbio indisponível no momento. Tente novamente mais tarde."
        }
        ```

* **Integração com API Externa de Taxas de Câmbio:**
    * API Utilizada: [ExchangeRate-API](https://www.exchangerate-api.com/) (plano gratuito).
    * Endpoint da API Externa (Exemplo para obter taxas baseadas em USD): `https://v6.exchangerate-api.com/v6/SUA_CHAVE_API/latest/USD`
    * O sistema deve extrair a taxa de conversão entre `moedaOrigem` e `moedaDestino` a partir da resposta da API externa. Se a API externa fornecer taxas relativas a uma base (ex: USD), pode ser necessário um cálculo intermediário (triangulação) se nenhuma das moedas do par for a base. Idealmente, a API permite buscar a taxa para um par específico: `https://v6.exchangerate-api.com/v6/SUA_CHAVE_API/pair/USD/BRL/100` (para converter 100 USD para BRL).
    * Tratamento de Falhas: Se a API externa estiver indisponível ou retornar um erro, a API local deve retornar um erro apropriado (ex: HTTP 503) com uma mensagem clara.

* **Validação dos Parâmetros:**
    * `valor`: Deve ser um número e maior que zero.
    * `moedaOrigem`, `moedaDestino`: Devem ser códigos de 3 letras maiúsculas e pertencer à lista de moedas suportadas.
    * Todos os parâmetros são obrigatórios.

* **Moedas Suportadas:**
    * **América do Sul:** ARS (Peso Argentino), BOB (Boliviano da Bolívia), BRL (Real Brasileiro), CLP (Peso Chileno), COP (Peso Colombiano), PYG (Guarani Paraguaio), PEN (Sol Peruano), UYU (Peso Uruguaio), VES (Bolívar Venezuelano).
        * *Nota: SRD (Dólar do Suriname) e GYD (Dólar Guianense) serão incluídos se a API de taxas fornecer suporte consistente.*
    * **Globais Adicionais:** USD (Dólar Americano), EUR (Euro).
    * **Outras Moedas Globais Relevantes:** JPY (Iene Japonês), GBP (Libra Esterlina), AUD (Dólar Australiano), CAD (Dólar Canadense), CHF (Franco Suíço), CNY (Yuan Chinês), SEK (Coroa Sueca), NZD (Dólar Neozelandês), HKD (Dólar de Hong Kong), INR (Rúpia Indiana).
    * A lista exata de moedas suportadas deve ser facilmente configurável/extensível no código.

### 2. Arquitetura e Fluxo de Dados

1.  **Recepção da Requisição:** O cliente (usuário/outro sistema) chama o endpoint `GET /api/converter` com os parâmetros `valor`, `moedaOrigem` e `moedaDestino`.
2.  **Controller (`ConversorController` - Pacote `com.rm.conversor.controller`):**
    * Mapeia a rota `/api/converter`.
    * Recebe os parâmetros da requisição HTTP.
    * Delega a lógica de negócio para o `ConversorService`.
    * Trata exceções específicas lançadas pelo serviço (ex: `ParametroInvalidoException`, `TaxaCambioException`) e as converte em respostas HTTP apropriadas (usando `@ExceptionHandler` ou `ResponseEntity`).
3.  **Service (`ConversorService` - Pacote `com.rm.conversor.service`):**
    * Contém a lógica de negócio principal.
    * Valida os parâmetros de entrada (lança exceções customizadas em caso de falha).
    * Chama o `TaxaCambioCliente` para obter a taxa de câmbio.
    * Realiza o cálculo da conversão.
    * Retorna um objeto de resposta (DTO - Data Transfer Object, ex: `ConversaoResponse`) para o controller.
4.  **Cliente API Externa (`TaxaCambioCliente` - Pacote `com.rm.conversor.client` ou `com.rm.conversor.integration`):**
    * Interface e sua implementação.
    * Responsável por interagir com a API externa de taxas de câmbio.
    * Constrói a URL da requisição.
    * Utiliza `java.net.http.HttpClient` para fazer a chamada HTTP GET.
    * Deserializa a resposta JSON (usando GSon ou Jackson) para um DTO que represente a estrutura da resposta da API externa (ex: `TaxaCambioApiResponse`).
    * Extrai a taxa de câmbio relevante e a data/hora da cotação.
    * Trata erros de comunicação com a API externa (timeout, host não encontrado, erros HTTP da API).
5.  **DTOs (Data Transfer Objects - Pacote `com.rm.conversor.dto`):**
    * `ConversaoRequest` (opcional, se fosse POST): Para agrupar parâmetros de entrada.
    * `ConversaoResponse`: Para estruturar a resposta JSON da nossa API.
    * `TaxaCambioApiResponse`: Para mapear a resposta da API externa de taxas.
6.  **Tratamento de Erros (Pacote `com.rm.conversor.exception` e no Controller):**
    * Exceções customizadas (ex: `ParametroInvalidoException`, `MoedaNaoSuportadaException`, `ServicoExternoIndisponivelException`).
    * Uso de `@RestControllerAdvice` e `@ExceptionHandler` no Spring Boot para centralizar o tratamento de exceções e retornar respostas HTTP padronizadas.

### 3. Tecnologias e Bibliotecas

* **Java:** Versão 17 ou superior.
* **Spring Boot:** (Versão mais recente estável)
    * `spring-boot-starter-web`: Para criar APIs REST.
    * `spring-boot-starter-validation` (opcional): Para validações declarativas (Bean Validation).
    * `spring-boot-starter-actuator` (Opcional): Para monitoramento.
    * `spring-boot-starter-cache` (Opcional): Para caching.
* **Gson (Google):** Para manipulação de JSON (serialização/desserialização). Alternativamente, Jackson (padrão no Spring Boot).
    * Dependência Maven/Gradle: `com.google.code.gson:gson:<versao>`
* **java.net.http.HttpClient:** Cliente HTTP nativo do Java (desde Java 11).
* **Build Tool:** Maven ou Gradle.
* **Testes (Opcional):**
    * JUnit 5: Para testes unitários.
    * Mockito: Para mocking de dependências em testes.
    * Spring Boot Test: Para testes de integração.
* **Documentação (Opcional):**
    * Springdoc OpenAPI (Swagger): Para documentação automática da API.
* **Logging (Opcional):**
    * SLF4J com Logback (padrão no Spring Boot).

---

## 🚀 Como Executar (Instruções Detalhadas)

1.  **Pré-requisitos:**
    * JDK 17 ou superior instalado e configurado (variável de ambiente `JAVA_HOME`).
    * Maven 3.6+ ou Gradle 7+ instalado e configurado.
    * Uma chave de API válida da [ExchangeRate-API](https://www.exchangerate-api.com/) (o plano gratuito é suficiente para começar).

2.  **Configuração do Projeto:**
    * Clone o repositório do projeto: `git clone <url-do-seu-repositorio>`
    * Navegue até a pasta do projeto: `cd nome-do-projeto`
    * Configure sua chave da API ExchangeRate-API no arquivo `src/main/resources/application.properties`:
        ```properties
        # application.properties
        server.port=8080

        # Configurações da API de Taxas de Câmbio
        exchangerateapi.key=SUA_CHAVE_API_AQUI
        exchangerateapi.baseurl=[https://v6.exchangerate-api.com/v6](https://v6.exchangerate-api.com/v6)
        ```

3.  **Build do Projeto:**
    * **Com Maven:**
        ```bash
        mvn clean package
        ```
    * **Com Gradle:**
        ```bash
        gradle clean build
        ```
    Isso irá compilar o código, executar testes (se houver) e empacotar a aplicação em um arquivo JAR executável (geralmente em `target/` para Maven ou `build/libs/` para Gradle).

4.  **Execução da Aplicação:**
    * **Usando o plugin do Spring Boot (desenvolvimento):**
        * Com Maven: `mvn spring-boot:run`
        * Com Gradle: `gradle bootRun`
    * **Executando o JAR gerado:**
        ```bash
        java -jar target/nome-do-seu-artefato-0.0.1-SNAPSHOT.jar
        # (Ajuste o nome do JAR conforme gerado pelo seu build)
        ```
    A API estará rodando em `http://localhost:8080` (ou na porta configurada).

5.  **Testando a API:**
    * Use um cliente HTTP como Postman, Insomnia, curl, ou diretamente no navegador para o método GET.
    * **Exemplo de Requisição:**
        ```
        GET http://localhost:8080/api/converter?valor=150&moedaOrigem=EUR&moedaDestino=JPY
        ```
    * **Exemplo de Requisição com Moeda Inválida:**
        ```
        GET http://localhost:8080/api/converter?valor=100&moedaOrigem=XYZ&moedaDestino=BRL
        ```
        (Deverá retornar HTTP 400 com uma mensagem de erro).

    * **Documentação Swagger/OpenAPI (se implementada):**
        Acesse `http://localhost:8080/swagger-ui.html` (ou o endpoint configurado para o Swagger) no seu navegador para ver a documentação interativa da API.

---

## 📈 Melhorias Futuras e Desafios Extras

* **Testes Automatizados:** Implementação completa de testes unitários para services e componentes, e testes de integração para o fluxo do controller.
* **Documentação da API:** Geração de documentação interativa com Springdoc OpenAPI (Swagger).
* **Cache:** Implementação de cache para as taxas de câmbio utilizando `@Cacheable` do Spring Boot para otimizar chamadas à API externa.
* **Logging Avançado:** Configuração de logs mais detalhados com SLF4J/Logback para monitoramento e depuração.
* **Monitoramento:** Integração com Spring Boot Actuator para expor endpoints de health check, métricas, etc.
* **Containerização:** Criação de um `Dockerfile` para empacotar a aplicação em um container Docker, facilitando o deploy.
* **Segurança:** Adicionar mecanismos básicos de segurança (ex: rate limiting, validação de headers) se a API for exposta publicamente.
* **Resiliência:** Implementar padrões de resiliência como Circuit Breaker (ex: com Resilience4J) para lidar com falhas na API externa de forma mais robusta.
* **Endpoint de Moedas Suportadas:** Criar um endpoint (ex: `GET /api/moedas`) que retorne a lista de todas as moedas suportadas pela API.