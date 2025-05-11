# Exercício: Java - Minha Primeira Aplicação (Conta Bancária)

Este projeto representa um dos primeiros exercícios práticos desenvolvidos durante a minha introdução à linguagem Java no programa Alura & Oracle ONE. O foco foi construir uma aplicação de consola simples para simular operações básicas de uma conta bancária.

## 🎯 Objetivo do Exercício

O objetivo principal deste exercício foi **criar uma aplicação de consola interativa para simular a gestão de uma conta bancária**, permitindo ao utilizador realizar operações como consultar saldo, transferir (sacar) e receber (depositar) valores. Este projeto serviu como uma introdução prática a:

* Estrutura básica de um programa Java.
* Declaração e utilização de variáveis de diferentes tipos.
* Entrada de dados do utilizador através da classe `Scanner`.
* Saída de dados para a consola.
* Utilização de estruturas de controlo de fluxo (condicionais `if/else if/else` e loops `while`).
* Formatação básica de texto e apresentação de menus.

## ✨ Funcionalidades e Aprendizados Principais

Durante o desenvolvimento desta aplicação, foram implementadas as seguintes funcionalidades e consolidados os seguintes aprendizados:

* **Exibição de Dados Iniciais:** Apresentação do nome do cliente, tipo de conta e saldo inicial.
* **Menu de Operações Interativo:** Um menu com opções para consultar saldo, transferir valor, receber valor e sair da aplicação.
* **Consulta de Saldo:** Exibição do saldo atual da conta.
* **Transferência (Saque):** Permite ao utilizador especificar um valor a ser retirado da conta, com validação para garantir que há saldo suficiente.
* **Recebimento (Depósito):** Permite ao utilizador especificar um valor a ser adicionado à conta.
* **Loop de Execução:** O menu de operações é exibido continuamente até que o utilizador escolha a opção de sair.
* **Validação de Opção Inválida:** Mensagem de erro para opções de menu não reconhecidas.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem Principal:** Java
* **Entrada/Saída:** `java.util.Scanner` para entrada de dados, `System.out.println` para saída.
* **Estruturas de Controlo:** `if-else if-else`, `while` loop.
* **Tipos de Dados Primitivos:** `String`, `double`, `int`.
* **Operadores:** Aritméticos, de atribuição, relacionais, lógicos.
* **Conceitos Fundamentais:** Variáveis, fluxo de programa, interação com o utilizador, blocos de texto (Text Blocks Java 15+).
* **Ambiente de Desenvolvimento:** JDK 17 (ou superior), IntelliJ IDEA (ou outra IDE Java).

## 🚀 Como Executar

O projeto é uma aplicação de consola Java. Para executar:

1.  **Pré-requisitos:**
    * JDK 17 ou superior instalado.
2.  **Compilação (se manual):**
    ```bash
    javac Desafio.java # (Ou o nome do seu ficheiro .java principal)
    ```
3.  **Execução:**
    * Se compilado manualmente:
        ```bash
        java Desafio # (Ou o nome da sua classe principal)
        ```
    * Se um JAR executável for gerado (ex: `AplicacaoBancaria.jar`):
        ```bash
        java -jar AplicacaoBancaria.jar
        ```
    A aplicação iniciará, exibirá os dados da conta e o menu de operações.

## 📄 Documentação Técnica Adicional

Para uma análise mais detalhada da lógica de cada operação do menu e do fluxo de interação com o utilizador, consulte (se disponível):
* `DETALHES_TECNICOS_PrimeiraAplicacao.md` (a ser criado nesta pasta, se necessário)

---

➡️ Voltar para a secção de [Exercícios de Java](../README.md)
➡️ Voltar para a secção principal da [Alura](../../../../../README.md)
➡️ Voltar para o [Portfólio Principal](../../../../../../README.md) *(Ajuste a profundidade do link se necessário)*

---
**Feito por RM By Alura+Oracle**
*Data: 10 de Maio de 2025*
