# Exercício: Java - Trabalhando com Listas e Coleções de Dados (Cartão de Crédito)

Este projeto foi desenvolvido como um exercício prático durante a minha formação em Java no programa Alura & Oracle ONE. O foco principal foi a utilização e manipulação de listas e coleções de dados em Java, aplicadas a um cenário de gestão de compras de um cartão de crédito.

## 🎯 Objetivo do Exercício

O objetivo central deste exercício foi **implementar um sistema simples para registar e gerir compras realizadas num cartão de crédito, utilizando a interface `List` e a classe `ArrayList` da Java Collections Framework**. Pretendia-se também praticar:

* Criação de classes para representar entidades (`Compra`, `CartaoDeCredito`).
* Utilização de construtores para inicialização de objetos.
* Implementação da interface `Comparable` para permitir a ordenação de objetos.
* Interação básica com o utilizador via consola para entrada de dados.
* Lógica de negócio para validar compras com base no limite e saldo do cartão.

## ✨ Funcionalidades e Aprendizados Principais

Durante o desenvolvimento deste sistema, foram implementadas e exploradas as seguintes funcionalidades e conceitos:

* **Gestão de Compras:** Adição de novas compras a uma lista associada a um cartão de crédito.
* **Controlo de Limite e Saldo:** Verificação se uma compra pode ser realizada com base no saldo disponível do cartão, que é inicializado com um limite.
* **Armazenamento de Compras:** Utilização de `ArrayList<Compra>` para guardar o histórico de compras realizadas.
* **Ordenação de Compras:** Implementação do método `compareTo` na classe `Compra` para permitir que a lista de compras seja ordenada por valor, utilizando `Collections.sort()`.
* **Entrada de Dados do Utilizador:** Uso da classe `Scanner` para obter o limite do cartão e os detalhes de cada compra (descrição e valor).
* **Representação de Objetos:** Sobrescrita do método `toString` na classe `Compra` para uma exibição formatada dos detalhes da compra.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem Principal:** Java
* **Coleções Java:** `List`, `ArrayList`, `Collections.sort()`
* **Interfaces:** `Comparable`
* **Programação Orientada a Objetos:** Classes (`Compra`, `CartaoDeCredito`), Objetos, Atributos, Métodos, Construtores, Encapsulamento.
* **Entrada/Saída:** `Scanner` para entrada de dados, `System.out.println` para saída.
* **Ambiente de Desenvolvimento:** JDK 17 (ou superior), IntelliJ IDEA (ou outra IDE Java).

## 🚀 Como Executar

O projeto é uma aplicação de consola Java. Para executar:

1.  **Pré-requisitos:**
    * JDK 17 ou superior instalado.
2.  **Compilação (se manual):**
    ```bash
    javac *.java # (Compile todas as classes .java do projeto)
    ```
3.  **Execução:**
    * Se compilado manualmente e as classes estiverem no diretório atual (ou num pacote):
        ```bash
        java Principal # (Ajuste para o nome completo da classe Principal se estiver em pacotes)
        ```
    * Se um JAR executável for gerado (ex: `ListaCartoes.jar` ou `CartaoDeCreditoApp.jar`):
        ```bash
        java -jar NomeDoJar.jar
        ```
    A aplicação solicitará o limite do cartão e, em seguida, os detalhes das compras até que o utilizador decida sair ou o saldo seja insuficiente. No final, exibirá as compras ordenadas e o saldo final.

## 📄 Documentação Técnica Adicional

Para uma análise detalhada da interação entre as classes `Compra` e `CartaoDeCredito`, a lógica de validação de compras, e o processo de ordenação, consulte (se disponível):
* `DETALHES_TECNICOS_ListaColecoes.md` (a ser criado nesta pasta, se necessário)

---

➡️ Voltar para a secção de [Exercícios de Java](../README.md)
➡️ Voltar para a secção principal da [Alura](../../../../../README.md)
➡️ Voltar para o [Portfólio Principal](../../../../../../README.md) *(Ajuste a profundidade do link se necessário)*

---
**Feito por RM By Alura+Oracle**
*Data: 10 de Maio de 2025*
