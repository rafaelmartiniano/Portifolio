
    //===============================================================================
    // PACOTE: com.rm.conversorconsole.app
    // ARQUIVO: Principal.java
    // PROJETO: Conversor de Moedas Console (Backend)
    //===============================================================================
    package com.rm.conversorconsole.app;
    
    import com.rm.conversorconsole.client.TaxaCambioCliente;
    import com.rm.conversorconsole.client.TaxaCambioClienteImpl;
    import com.rm.conversorconsole.enums.Moeda;
    import com.rm.conversorconsole.service.ConversorServico;
    
    import java.util.InputMismatchException;
    import java.util.Scanner;

    /**
     * Classe principal para a aplicação de console do Conversor de Moedas.
     * Interage com o usuário para obter os dados da conversão e exibe o resultado.
     * Projeto do desafio de Java da Alura + Oracle sob projeto ONE.
     * Customizações e comentários explicativos por RM.
     *
     * @autor Rafael Martiniano
     * @versão 1.0
     * @data 09 de Maio de 2025
     **/
    public class Principal {
    
        //*******************************************************************************
        // METODO: main
        //*******************************************************************************
        // OBJETIVO:
        //   Ponto de entrada da aplicação. Gerencia o fluxo de interação com o usuário.
        //-------------------------------------------------------------------------------
        public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                TaxaCambioCliente clienteApi = new TaxaCambioClienteImpl();
                ConversorServico conversor = new ConversorServico(clienteApi);
                
                //---------------------------------------------------------------------------
                // BOAS-VINDAS
                //---------------------------------------------------------------------------
                System.out.println("**************************************************************");
                System.out.println("*         BEM-VINDO AO CONVERSOR DE MOEDAS GLOBAIS           *");
                System.out.println("*                                                            *");
                System.out.println("*                     Rafael Martiniano                      *");
                System.out.println("*                                                            *");
                System.out.println("*                   (Oracle - ONE by Alura)                  *");
                System.out.println("*                                                            *");
                System.out.println("**************************************************************");
                System.out.println("*                                                            *");
                System.out.println("*     ATENÇÃO: Tecnologia fornecida pela ExchangeRate-API.   *");
                System.out.println("*                                                            *");
                System.out.println("*              https://www.exchangerate-api.com/             *");
                System.out.println("*                    ACESSE E SAIBA MAIS                     *");
                System.out.println("**************************************************************");
                int opcaoContinuar;

                do {
                    //-----------------------------------------------------------------------
                    // PASSO 1: Obter o valor a ser convertido
                    //-----------------------------------------------------------------------
                    double valorParaConverter = 0;
                    boolean valorValido = false;
                    while (!valorValido) {
                        try {
                            System.out.print("Digite o valor que deseja converter: ");
                            valorParaConverter = scanner.nextDouble();
                            scanner.nextLine(); // Consome nova linha
                            if (valorParaConverter > 0) {
                                valorValido = true;
                            } else {
                                System.out.println("O valor deve ser positivo. Tente novamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, digite um número.");
                            scanner.nextLine(); // Limpa buffer do scanner
                        }
                    }
                    
                    //-----------------------------------------------------------------------
                    // PASSO 2: Obter a moeda de origem
                    //-----------------------------------------------------------------------
                    Moeda moedaOrigem = null;
                    while (moedaOrigem == null) {
                        System.out.println("\n--- Moedas Suportadas ---");
                        int index = 1;
                        for (Moeda m : Moeda.values()) {
                            System.out.printf("%2d. %s (%s)\n", index++, m.name(), m.getNomeCompleto());
                        }
                        System.out.print("Digite o CÓDIGO da MOEDA DE ORIGEM (ex: USD, BRL): ");
                        String codigoOrigem = scanner.nextLine().trim().toUpperCase();
                        try {
                            moedaOrigem = Moeda.fromString(codigoOrigem);
                        } catch (IllegalArgumentException e) {
                            System.out.println("ERRO: " + e.getMessage() + ". Tente novamente.");
                        }
                    }
                    
                    //-----------------------------------------------------------------------
                    // PASSO 3: Obter a moeda de destino
                    //-----------------------------------------------------------------------
                    Moeda moedaDestino = null;
                    while (moedaDestino == null) {
                        // Reexibe a lista se necessário, ou assume que o usuário lembra
                        System.out.print("DIGITE O CÓDIGO da MOEDA DE DESTINO (ex: EUR, JPY): ");
                        String codigoDestino = scanner.nextLine().trim().toUpperCase();
                        try {
                            moedaDestino = Moeda.fromString(codigoDestino);
                        } catch (IllegalArgumentException e) {
                            System.out.println("ERRO: " + e.getMessage() + ". Tente novamente.");
                        }
                    }
                    
                    //-----------------------------------------------------------------------
                    // PASSO 4: Realizar a conversão e exibir o resultado
                    //-----------------------------------------------------------------------
                    System.out.println("\nProcessando conversão...");
                    String resultadoConversao = conversor.converterMoeda(valorParaConverter, moedaOrigem, moedaDestino);
                    System.out.println(resultadoConversao);
                    
                    //-----------------------------------------------------------------------
                    // PASSO 5: Perguntar se deseja continuar
                    //-----------------------------------------------------------------------
                    opcaoContinuar = -1; // Faz reset para entrar no loop de validação
                    while (opcaoContinuar != 0 && opcaoContinuar != 1) {
                        System.out.println("\nDESEJA REALIZAR OUTRA CONVERSÃO? (1 para SIM, 0 para NÃO): ");
                        try {
                            opcaoContinuar = scanner.nextInt();
                            scanner.nextLine(); // Consome nova linha
                            if (opcaoContinuar != 0 && opcaoContinuar != 1) {
                                System.out.println("OPÇÃO INVALIDA, DIGITE (1 PARA SIM OU 0 PARA NÃO): ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ENTRADA INVALIDA, (DIGITE 1 PARA SIM OU 0 PARA NÃO): ");
                            scanner.nextLine(); // Limpa buffer
                        }
                    }
                    System.out.println(); // Linha em branco para separar as conversões
                    
                } while (opcaoContinuar == 1);
                
                //---------------------------------------------------------------------------
                // ENCERRAMENTO
                //---------------------------------------------------------------------------
                System.out.println("**************************************************");
                System.out.println("*    Obrigado por usar o Conversor de Moedas!    *");
                System.out.println("**************************************************");
            }
        }
    }
    
