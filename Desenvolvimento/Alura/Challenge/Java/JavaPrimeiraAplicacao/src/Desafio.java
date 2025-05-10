//===============================================================================
// PROJETO: Desafio Conta Bancária Interativa (Versão Simplificada)
// ARQUIVO: Desafio.java
// DESCRIÇÃO: Aplicação console para simular abertura e operações de conta bancária.
//            Nome do Banco: RMBank. Foco na interatividade básica.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

import java.util.Scanner;    // Importa a classe Scanner para ler a entrada do usuário.

/**
 * Simula uma aplicação de abertura e gestão de conta bancária com operações básicas via console.
 * Inclui pré-cadastro do cliente e opção de depósito inicial no RMBank.
 * Versão simplificada sem geração de número de conta ou tratamento avançado de exceções.
 * Projeto do desafio de Java da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.2 // Versão ajustada
 * @date 27 de Abril de 2025
 */
public class Desafio {

    //*******************************************************************************
    // METODO: main
    //*******************************************************************************
    // OBJETIVO:
    //   Ponto de entrada da aplicação. Gerencia o fluxo de abertura e operações da conta.
    //-------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in); // Objeto Scanner para ler entradas do usuário.
        String nomeBanco = "RMBank";

        //---------------------------------------------------------------------------
        // BLOCO 0: Pré-Cadastro do Cliente e Abertura de Conta no RMBank
        //---------------------------------------------------------------------------
        // OBJETIVO: Coletar dados do novo cliente e processar um possível depósito inicial.
        //---------------------------------------------------------------------------
        System.out.println("*************************************************");
        System.out.println("* BEM-VINDO AO " + nomeBanco.toUpperCase() + " - ABERTURA DE CONTA *");
        System.out.println("*************************************************");
        System.out.println("\nPor favor, forneça alguns dados para seu pré-cadastro:");

        System.out.print("Digite seu primeiro nome: ");
        String primeiroNome = leitura.nextLine();

        System.out.print("Digite seu sobrenome: ");
        String sobrenome = leitura.nextLine();
        String nomeCompletoCliente = primeiroNome + " " + sobrenome;

        String tipoContaCliente = "Corrente"; // Tipo de conta padrão
        double saldoCliente = 0.0;

        System.out.print("\n" + primeiroNome + ", deseja realizar um depósito inicial no " + nomeBanco + "? (S/N): ");
        String respostaDeposito = leitura.nextLine().trim().toUpperCase();

        if (respostaDeposito.equals("S")) {
            System.out.print("Digite o valor do depósito inicial: R$ ");
            double valorInicial = leitura.nextDouble();
            leitura.nextLine(); // Consumir a nova linha restante após nextDouble()

            if (valorInicial > 0) { // Simples validação se o valor é positivo
                saldoCliente = valorInicial;
                System.out.println("Depósito inicial de R$ " + String.format("%.2f", saldoCliente) + " realizado com sucesso!");
            } else {
                System.out.println("Valor de depósito inválido. Conta aberta com saldo R$ 0.00.");
                // saldoCliente permanece 0.00
            }
        } else {
            System.out.println("Ok, sua conta no " + nomeBanco + " será aberta com saldo R$ 0.00.");
        }

        //---------------------------------------------------------------------------
        // BLOCO 1: Exibição dos Dados da Conta Criada
        //---------------------------------------------------------------------------
        // OBJETIVO: Mostrar ao usuário os dados da conta recém-aberta.
        //---------------------------------------------------------------------------
        System.out.println("\n*************************************************");
        System.out.println("* CONTA ABERTA COM SUCESSO NO " + nomeBanco.toUpperCase() + "    *");
        System.out.println("*************************************************");
        System.out.println("Titular: " + nomeCompletoCliente);
        System.out.println("Tipo da conta: " + tipoContaCliente);
        // Número da conta foi removido conforme solicitação.
        System.out.println("Saldo atual: R$ " + String.format("%.2f", saldoCliente));
        System.out.println("*************************************************");

        //---------------------------------------------------------------------------
        // BLOCO 2: Definição do Menu de Operações
        //---------------------------------------------------------------------------
        String menuOperacoes = """
                \nOperações Disponíveis no %s:
                ** Digite sua opção **
                1 - Consultar saldo
                2 - Transferir valor
                3 - Receber valor (Depositar)
                4 - Sair
                """.formatted(nomeBanco); // Inclui o nome do banco no menu

        int opcaoMenu = 0;

        //---------------------------------------------------------------------------
        // BLOCO 3: Loop Principal de Operações
        //---------------------------------------------------------------------------
        // OBJETIVO: Manter o menu ativo e processar as opções do usuário
        //           até que a opção 'Sair' (4) seja escolhida.
        //           Entradas são lidas de forma simplificada.
        //---------------------------------------------------------------------------
        while (opcaoMenu != 4) {
            System.out.println(menuOperacoes);
            System.out.print("Opção desejada: ");
            opcaoMenu = leitura.nextInt();
            leitura.nextLine(); // Consumir a nova linha restante após nextInt()

            if (opcaoMenu == 1) {
                //-------------------------------------------------------------------
                // OPÇÃO 1: Consultar Saldo
                //-------------------------------------------------------------------
                System.out.println("-------------------------");
                System.out.println("Saldo atual: R$ " + String.format("%.2f", saldoCliente));
                System.out.println("-------------------------");

            } else if (opcaoMenu == 2) {
                //-------------------------------------------------------------------
                // OPÇÃO 2: Transferir Valor (Saída de valor)
                //-------------------------------------------------------------------
                System.out.println("-------------------------");
                System.out.print("Qual o valor que deseja transferir? R$ ");
                double valorTransferencia = leitura.nextDouble();
                leitura.nextLine(); // Consumir nova linha

                if (valorTransferencia <= 0) {
                    System.out.println("Valor de transferência inválido. Deve ser maior que zero.");
                } else if (valorTransferencia > saldoCliente) {
                    System.out.println("Saldo insuficiente para realizar a transferência.");
                } else {
                    saldoCliente -= valorTransferencia;
                    System.out.println("Transferência realizada com sucesso!");
                    System.out.println("Novo saldo: R$ " + String.format("%.2f", saldoCliente));
                }
                System.out.println("-------------------------");

            } else if (opcaoMenu == 3) {
                //-------------------------------------------------------------------
                // OPÇÃO 3: Receber Valor (Entrada de valor / Depósito)
                //-------------------------------------------------------------------
                System.out.println("-------------------------");
                System.out.print("Qual o valor a ser depositado/recebido? R$ ");
                double valorRecebido = leitura.nextDouble();
                leitura.nextLine(); // Consumir nova linha

                if (valorRecebido <= 0) {
                    System.out.println("Valor de depósito inválido. Deve ser maior que zero.");
                } else {
                    saldoCliente += valorRecebido;
                    System.out.println("Valor recebido com sucesso!");
                    System.out.println("Novo saldo: R$ " + String.format("%.2f", saldoCliente));
                }
                System.out.println("-------------------------");

            } else if (opcaoMenu == 4) {
                //-------------------------------------------------------------------
                // OPÇÃO 4: Sair
                //-------------------------------------------------------------------
                System.out.println("-------------------------");
                System.out.println("Finalizando aplicação... Obrigado, " + primeiroNome + ", por utilizar o " + nomeBanco + "!");
                System.out.println("-------------------------");

            } else {
                //-------------------------------------------------------------------
                // OPÇÃO INVÁLIDA
                //-------------------------------------------------------------------
                System.out.println("-------------------------");
                System.out.println("Opção inválida! Por favor, digite um número entre 1 e 4.");
                System.out.println("-------------------------");
            }
        }

        //---------------------------------------------------------------------------
        // BLOCO 4: Fechamento do Scanner
        //---------------------------------------------------------------------------
        leitura.close();
        System.out.println("\nAplicação " + nomeBanco + " encerrada.");
    }
}

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Conta Bancária Interativa (Simplificado)
// Data: 09 de Maio de 2025
//==========================================