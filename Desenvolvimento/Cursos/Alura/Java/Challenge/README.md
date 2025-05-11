# Challenge: Conversor de Moedas (Versão Console)

Este projeto é um "Challenge" significativo desenvolvido durante a minha formação em Java no programa Alura & Oracle ONE. O desafio consistiu em criar uma aplicação de consola capaz de converter valores entre diferentes moedas, utilizando taxas de câmbio obtidas em tempo real de uma API externa.

## 🎯 Objetivo do Challenge

O objetivo principal deste challenge foi **desenvolver um conversor de moedas funcional e interativo via linha de comando**, aplicando conhecimentos de:

* Consumo de APIs RESTful externas (ExchangeRate-API).
* Manipulação de dados em formato JSON (utilizando a biblioteca GSon).
* Programação Orientada a Objetos para estruturar o código (DTOs, Clientes HTTP, Serviços).
* Tratamento de exceções e erros de comunicação.
* Interação com o utilizador através da classe `Scanner`.
* Formatação de datas e valores monetários.
* Utilização de Enums para representar tipos de dados fixos (as moedas).

## ✨ Funcionalidades e Aprendizados Principais

As principais funcionalidades implementadas e os aprendizados obtidos incluem:

* **Seleção de Moedas:** O utilizador pode escolher a moeda de origem e a moeda de destino a partir de uma lista de moedas suportadas (incluindo moedas da América do Sul e principais moedas globais).
* **Entrada de Valor:** O utilizador informa o valor que deseja converter.
* **Consulta de Taxa em Tempo Real:** A aplicação conecta-se à ExchangeRate-API para obter a taxa de câmbio mais recente entre as moedas selecionadas.
* **Cálculo da Conversão:** O valor é convertido utilizando a taxa obtida.
* **Exibição Detalhada do Resultado:** Apresentação do valor original, a taxa de câmbio utilizada, o valor convertido e a data/hora da última atualização da taxa.
* **Interface de Linha de Comando (CLI):** Toda a interação ocorre através do consola.
* **Tratamento de Erros:** Implementação de mecanismos para lidar com entradas inválidas do utilizador, falhas na comunicação com a API, ou moedas não suportadas.
* **Loop de Conversão:** Permite ao utilizador realizar múltiplas conversões numa única execução do programa.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem Principal:** Java
* **Bibliotecas:** GSon (para manipulação de JSON)
* **APIs:** ExchangeRate-API (`https://www.exchangerate-api.com/`)
* **Conceitos Chave:** Consumo de API REST, HTTP GET (com `java.net.http.HttpClient`), JSON (Parsing e Geração), Programação Orientada a Objetos (DTOs - Data Transfer Objects, Interfaces, Implementações), Tratamento de Erros e Exceções, Enums, Manipulação de Datas (`java.time`), Formatação de Números (`DecimalFormat`).
* **Entrada/Saída:** `Scanner` para entrada de dados, `System.out.println` para saída.
* **Ambiente de Desenvolvimento:** JDK 17 (ou superior), IntelliJ IDEA (ou outra IDE Java).

## 🚀 Como Executar

O projeto é uma aplicação de consola Java. Para executar:

1.  **Pré-requisitos:**
    * JDK 17 ou superior instalado.
    * Biblioteca GSon adicionada ao classpath do projeto (ex: `gson-2.10.1.jar`).
    * **Chave de API Válida:** É crucial configurar a sua chave pessoal da ExchangeRate-API no ficheiro `com/rm/conversorconsole/client/TaxaCambioClienteImpl.java` (na constante `API_KEY_EXCHANGERATE`).
2.  **Compilação (se manual, considerando a estrutura de pacotes):**
    ```bash
    javac -cp gson-2.10.1.jar com/rm/conversorconsole/app/*.java com/rm/conversorconsole/client/*.java com/rm/conversorconsole/dto/*.java com/rm/conversorconsole/enums/*.java com/rm/conversorconsole/service/*.java
    ```
3.  **Execução:**
    * Se compilado manualmente:
        ```bash
        java -cp .:gson-2.10.1.jar com.rm.conversorconsole.app.Principal
        ```
    * Se um JAR executável for gerado (ex: `ConversorMoedas.jar`), configurado para incluir as dependências:
        ```bash
        java -jar ConversorMoedas.jar
        ```
    A aplicação iniciará, solicitará os dados para conversão e exibirá os resultados.

## 📄 Documentação Técnica Adicional

Para uma análise aprofundada da arquitetura das classes (`Moeda`, `TaxaCambioApiResponse`, `TaxaCambioCliente`, `ConversorServico`, `Principal`), a lógica de interação com a API, o tratamento de erros e a formatação dos dados, consulte (se disponível):
* `DETALHES_TECNICOS_ConversorMoedasConsole.md` (a ser criado nesta pasta, se necessário)

---

➡️ Voltar para a secção de [Challenges de Java](../README.md)
➡️ Voltar para a secção principal da [Alura](../../../../../README.md)
➡️ Voltar para o [Portfólio Principal](../../../../../../README.md) *(Ajuste a profundidade do link se necessário)*

---
**Feito por RM By Alura+Oracle**
*Data: 10 de Maio de 2025*
