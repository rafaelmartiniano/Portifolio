# Exercício: Java - Consumindo API, Gravando Arquivos e Tratando Erros (Consulta CEP)

Este projeto foi desenvolvido como um exercício prático durante a minha formação em Java no programa Alura & Oracle ONE. O foco foi na integração com APIs externas, manipulação de dados em formato JSON e implementação de um tratamento robusto de exceções.

## 🎯 Objetivo do Exercício

O objetivo principal deste exercício foi **criar um sistema para consulta de endereços a partir de um CEP, utilizando a API ViaCEP**. Além disso, o projeto visava praticar:

* Consumo de uma API RESTful externa.
* Parsing de respostas JSON (utilizando a biblioteca GSon).
* Gravação de dados estruturados (o endereço obtido) num ficheiro JSON.
* Implementação de tratamento de erros e exceções que podem ocorrer durante a comunicação com a API ou a manipulação de ficheiros.

## ✨ Funcionalidades e Aprendizados Principais

Durante o desenvolvimento deste sistema, foram implementadas e exploradas as seguintes funcionalidades e conceitos:

* **Consulta de CEP em API Externa:** Realização de requisições HTTP GET para a API ViaCEP.
* **Manipulação de JSON com GSon:** Conversão da resposta JSON da API num objeto Java (`Endereco`) e a serialização deste objeto de volta para JSON para gravação em ficheiro.
* **Gravação de Ficheiros:** Criação e escrita de ficheiros `.json` contendo os dados do endereço.
* **Tratamento de Exceções:** Implementação de blocos `try-catch` para lidar com potenciais erros como `IOException` (ao gravar ficheiro) e `RuntimeException` (erros na API, CEP inválido, problemas de parsing JSON).
* **Utilização de Records (Java):** Definição da classe `Endereco` como um `record` para uma representação concisa de dados.
* **Cliente HTTP do Java:** Uso do `java.net.http.HttpClient` para realizar as requisições à API.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem Principal:** Java
* **Bibliotecas:** GSon (para manipulação de JSON)
* **APIs:** ViaCEP (`https://viacep.com.br/ws/`)
* **Conceitos Chave:** Consumo de API REST, HTTP GET, JSON (Parsing e Geração), Manipulação de Ficheiros (FileWriter), Tratamento de Erros e Exceções, Records Java, HttpClient.
* **Ambiente de Desenvolvimento:** JDK 17 (ou superior), IntelliJ IDEA (ou outra IDE Java).

## 🚀 Como Executar

O projeto é uma aplicação de consola Java. Para executar:

1.  **Pré-requisitos:**
    * JDK 17 ou superior instalado.
    * Biblioteca GSon adicionada ao classpath do projeto (ex: `gson-2.10.1.jar`).
2.  **Compilação (se manual):**
    ```bash
    javac -cp gson-2.10.1.jar *.java  # (Ajuste o comando conforme a estrutura de pacotes e localização do JAR)
    ```
3.  **Execução:**
    * Se compilado manualmente e as classes estiverem no diretório atual (ou num pacote):
        ```bash
        java -cp .:gson-2.10.1.jar Principal # (Ajuste para o nome completo da classe Principal se estiver em pacotes)
        ```
    * Se um JAR executável for gerado (ex: `ConsultaCEP.jar`, configurado para incluir o GSon ou referenciá-lo):
        ```bash
        java -jar ConsultaCEP.jar
        ```
    A aplicação solicitará um CEP e, se bem-sucedida, imprimirá o endereço no consola e guardará um ficheiro `[CEP].json`.

## 📄 Documentação Técnica Adicional

Para uma análise detalhada da arquitetura das classes (`Endereco`, `ConsultaCep`, `GeradorDeArquivo`, `Principal`), a lógica de cada método e o tratamento específico de exceções, consulte (se disponível):
* `DETALHES_TECNICOS_ConsultaCEP.md` (a ser criado nesta pasta, se necessário)

---

➡️ Voltar para a secção de [Exercícios de Java](../README.md)
➡️ Voltar para a secção principal da [Alura](../../../../../README.md)
➡️ Voltar para o [Portfólio Principal](../../../../../../README.md) *(Ajuste a profundidade do link se necessário)*

---
**Feito por RM By Alura+Oracle**

