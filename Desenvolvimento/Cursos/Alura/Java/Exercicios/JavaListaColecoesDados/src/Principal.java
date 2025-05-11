//===============================================================================
// PROJETO: Desafio Cartão de Crédito
// ARQUIVO: Principal.java
// DESCRIÇÃO: Classe principal para simular o registro de compras em um cartão de crédito.
//            Interage com o usuário para definir limite, registrar compras e exibir
//            o extrato final ordenado.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

import java.util.Collections; // Para ordenar a lista de compras
import java.util.Scanner;     // Para ler a entrada do usuário
// ArrayList e List são usados em CartaoDeCredito, não precisam ser importados aqui
// a menos que se manipule diretamente uma nova lista neste arquivo.

/**
 * Classe principal que executa a simulação de uso de um cartão de crédito.
 * Permite ao usuário definir um limite, registrar compras interativamente e,
 * ao final, exibe o saldo e a lista de compras ordenadas por valor.
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class Principal {

    //*******************************************************************************
    // METODO: main
    //*******************************************************************************
    // OBJETIVO:
    //   Ponto de entrada da aplicação. Orquestra o fluxo de interação com o usuário
    //   para simulação do cartão de crédito, conforme os objetivos do README.md.
    //-------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in); // Objeto Scanner para entradas do usuário.

        //---------------------------------------------------------------------------
        // BLOCO 1: Definição do Limite do Cartão
        //---------------------------------------------------------------------------
        // REQUISITO README: "1. Solicitar que o usuário informe o limite do cartão de crédito;"
        //---------------------------------------------------------------------------
        System.out.println("*******************************************");
        System.out.println("* SISTEMA DE REGISTRO DE COMPRAS      *");
        System.out.println("*******************************************\n");
        System.out.print("Digite o limite do cartão de crédito: R$ ");
        double limite = leitura.nextDouble();
        leitura.nextLine(); // Consome a nova linha restante após nextDouble()

        //---------------------------------------------------------------------------
        // BLOCO 2: Criação do Objeto CartaoDeCredito
        //---------------------------------------------------------------------------
        // REQUISITO README: "2. Criar um objeto cartão de crédito com o limite informado;"
        //---------------------------------------------------------------------------
        CartaoDeCredito cartao = new CartaoDeCredito(limite);
        System.out.println("Cartão criado com limite de R$ " + String.format("%.2f", cartao.getLimite()));

        int sair = 1; // Variável de controle do loop de compras (1 para continuar, 0 para sair)

        //---------------------------------------------------------------------------
        // BLOCO 3: Loop de Registro de Compras
        //---------------------------------------------------------------------------
        // OBJETIVO: Permitir que o usuário registre múltiplas compras até decidir sair.
        // REQUISITOS README: Pontos 3, 4, 5 e 6.
        //---------------------------------------------------------------------------
        while (sair != 0) {
            System.out.println("\n--- Nova Compra ---");
            // REQUISITO README: "3. Solicitar que o usuário informe a descrição e o valor da compra;"
            System.out.print("Digite a descrição da compra: ");
            String descricao = leitura.nextLine(); // Usar nextLine() para descrições com espaços

            System.out.print("Digite o valor da compra: R$ ");
            double valor = leitura.nextDouble();
            leitura.nextLine(); // Consome a nova linha restante

            // REQUISITO README: "4. Criar um objeto compra com a descrição e valor informados;"
            Compra compra = new Compra(descricao, valor);

            // REQUISITO README: "5. Registrar a compra no cartão de crédito e imprimir na tela
            //                    se ela foi realizada ou não (de acordo com o saldo remanescente);"
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println(">>> Compra realizada com sucesso!");
                // REQUISITO README: "6. Perguntar se o usuário deseja registrar uma nova compra ou finalizar;"
                System.out.print("Digite 0 para SAIR ou 1 para CONTINUAR registrando: ");
                sair = leitura.nextInt();
                leitura.nextLine(); // Consome a nova linha restante
            } else {
                System.out.println(">>> Saldo insuficiente para esta compra!");
                System.out.println("    Saldo disponível: R$ " + String.format("%.2f", cartao.getSaldo()));
                sair = 0; // Força a saída do loop se o saldo for insuficiente
            }
        }

        //---------------------------------------------------------------------------
        // BLOCO 4: Exibição do Extrato Final de Compras
        //---------------------------------------------------------------------------
        // REQUISITO README: "7. ...imprimir na tela o saldo final do cartão e a lista
        //                    de compras realizadas, ordenadas pelo valor."
        //---------------------------------------------------------------------------
        System.out.println("\n*******************************************");
        System.out.println("* EXTRATO DE COMPRAS            *");
        System.out.println("*******************************************");

        // Ordena a lista de compras. A classe Compra implementa Comparable.
        Collections.sort(cartao.getCompras());

        if (cartao.getCompras().isEmpty()) {
            System.out.println("\nNenhuma compra realizada.");
        } else {
            System.out.println("\nCOMPRAS REALIZADAS (ordenadas por valor):\n");
            for (Compra c : cartao.getCompras()) {
                // Exibe usando o toString() da classe Compra, que já está formatado.
                // Ou, se preferir o formato original do seu código:
                // System.out.println(c.getDescricao() + " - R$ " + String.format("%.2f", c.getValor()));
                System.out.println(c.toString());
            }
        }
        System.out.println("\n-------------------------------------------");
        System.out.println("Saldo final do cartão: R$ " + String.format("%.2f", cartao.getSaldo()));
        System.out.println("Limite inicial do cartão: R$ " + String.format("%.2f", cartao.getLimite()));
        System.out.println("*******************************************");

        //---------------------------------------------------------------------------
        // BLOCO 5: Fechamento do Scanner
        //---------------------------------------------------------------------------
        leitura.close();
        System.out.println("\nAplicação finalizada.");
    }
}

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Cartão de Crédito
// Data: 09 de Maio de 2025
//==========================================