# Exercício: MusicasPreferidas (Java Aplicando POO)

Este projeto foi desenvolvido como um exercício prático durante a minha formação em Java no programa Alura & Oracle ONE, com foco na aplicação dos conceitos fundamentais da Programação Orientada a Objetos (POO). Este exercício específico está contido na pasta `JavaAplicandoPOO`.

## 🎯 Objetivo do Exercício

O objetivo principal deste exercício foi **criar um sistema simples para gestão de músicas e podcasts, modelando as classes e suas interações utilizando os princípios da POO**: abstração, encapsulamento, herança e polimorfismo.

## ✨ Funcionalidades e Aprendizados Principais

Durante o desenvolvimento deste sistema, foram implementadas e exploradas as seguintes funcionalidades e conceitos:

* **Modelagem de Classes:** Criação de uma classe base `Audio` e classes derivadas `Musica` e `Podcast`.
* **Encapsulamento:** Utilização de atributos privados com getters e setters.
* **Herança:** Reutilização de código e especialização de comportamento das classes `Musica` e `Podcast` a partir de `Audio`.
* **Polimorfismo:** Demonstração através de métodos sobrescritos (como `getClassificacao()`) e o tratamento de objetos `Audio` de forma genérica.
* **Gestão de Coleções (Básica):** Criação de uma classe para simular uma lista de "preferidas".
* **Lógica de Negócio Simples:** Implementação de regras para classificação de músicas e podcasts baseadas em reproduções e curtidas.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem Principal:** Java
* **Paradigma:** Programação Orientada a Objetos (POO)
* **Conceitos Chave:** Classes, Objetos, Atributos, Métodos, Construtores, Herança, Polimorfismo, Encapsulamento.
* **Ambiente de Desenvolvimento:** JDK 17 (ou superior), IntelliJ IDEA (ou outra IDE Java).

## 🚀 Como Executar

O projeto é uma aplicação de consola Java e pode ser executado da seguinte forma (após compilação):

```bash
# Compilar os ficheiros .java (exemplo, se não estiver a usar uma IDE com build automático,
# e assumindo que está na pasta que contém a estrutura de pacotes com/rm/musicaspreferidas):
# javac com/rm/musicaspreferidas/modelos/*.java com/rm/musicaspreferidas/principal/*.java
# java com.rm.musicaspreferidas.principal.Principal

# Se um JAR executável for gerado (MusicasPreferidas.jar):
java -jar MusicasPreferidas.jar