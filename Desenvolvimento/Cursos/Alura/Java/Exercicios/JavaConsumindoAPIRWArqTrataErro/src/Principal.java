//===============================================================================
// PROJETO: Desafio Consulta CEP e Geração JSON
// ARQUIVO: Principal.java
// DESCRIÇÃO: Classe principal da aplicação. Solicita um CEP ao usuário,
//            consulta a API ViaCEP usando ConsultaCep, e salva o endereço
//            resultante em um arquivo JSON usando GeradorDeArquivo.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

import java.io.IOException; // Para tratar exceções de I/O ao salvar o arquivo.
import java.util.Scanner;   // Para ler a entrada do usuário (o CEP).

/**
 * Classe principal que executa a aplicação de consulta de CEP.
 * Interage com o usuário para obter um CEP, utiliza {@link ConsultaCep}
 * para buscar o endereço na API ViaCEP, e {@link GeradorDeArquivo}
 * para salvar o endereço em um arquivo JSON.
 * Projeto do desafio de Java, API e JSON da Alura + Oracle.
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
    //   Ponto de entrada da aplicação. Orquestra o fluxo de:
    //   1. Solicitar um CEP ao usuário.
    //   2. Consultar a API ViaCEP para obter o endereço.
    //   3. Exibir o endereço obtido no console.
    //   4. Salvar o endereço em um arquivo JSON.
    //   Trata possíveis erros durante o processo.
    // REQUISITO README: "Criar uma classe com metodo main que deve solicitar..."
    //-------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in); // Objeto Scanner para entrada do usuário.
        ConsultaCep consultaApiCep = new ConsultaCep(); // Objeto para consultar a API.
        GeradorDeArquivo geradorJson = new GeradorDeArquivo(); // Objeto para gerar o arquivo JSON.

        //---------------------------------------------------------------------------
        // PASSO 1: Solicitar CEP ao Usuário
        //---------------------------------------------------------------------------
        System.out.println("*******************************************");
        System.out.println("* CONSULTA DE ENDEREÇO POR CEP     *");
        System.out.println("*******************************************\n");
        System.out.print("Digite um número de CEP para consulta (somente números): ");
        String cepParaConsulta = leitura.nextLine().trim(); // Lê a linha inteira e remove espaços extras.

        //---------------------------------------------------------------------------
        // PASSO 2, 3 e 4: Consultar, Exibir e Salvar
        //---------------------------------------------------------------------------
        // Bloco try-catch para lidar com possíveis exceções durante a consulta
        // à API (RuntimeException de ConsultaCep) ou a gravação do arquivo (IOException).
        //---------------------------------------------------------------------------
        try {
            //-----------------------------------------------------------------------
            // PASSO 2.1: Consultar a API ViaCEP
            //-----------------------------------------------------------------------
            System.out.println("\nConsultando CEP: " + cepParaConsulta + "...");
            Endereco enderecoObtido = consultaApiCep.buscaEndereco(cepParaConsulta);

            //-----------------------------------------------------------------------
            // PASSO 2.2: Exibir o Endereço Obtido
            //-----------------------------------------------------------------------
            // O record Endereco tem um metodo toString() gerado automaticamente
            // que formata bem a saída.
            System.out.println("\nEndereço encontrado:");
            System.out.println(enderecoObtido); // Ex: Endereco[cep=01001-000, logradouro=Praça da Sé, ...]

            //-----------------------------------------------------------------------
            // PASSO 2.3: Salvar o Endereço em Arquivo JSON
            //-----------------------------------------------------------------------
            // REQUISITO README: "...salvar os dados do endereço em um arquivo json."
            System.out.println("\nSalvando endereço em arquivo JSON...");
            geradorJson.salvaJson(enderecoObtido); // O metodo já imprime "Arquivo salvo com sucesso!"

        } catch (RuntimeException e) {
            // Captura RuntimeException lançada por ConsultaCep (ex: erro na API, CEP inválido)
            System.err.println("\nERRO NA CONSULTA: " + e.getMessage());
        } catch (IOException e) {
            // Captura IOException lançada por GeradorDeArquivo (ex: erro ao escrever o arquivo)
            System.err.println("\nERRO AO SALVAR ARQUIVO: " + e.getMessage());
        } catch (Exception e) {
            // Captura qualquer outra exceção inesperada.
            System.err.println("\nERRO INESPERADO: " + e.getMessage());
            e.printStackTrace(); // Imprime o stack trace para depuração.
        } finally {
            //-----------------------------------------------------------------------
            // FINALIZAÇÃO
            //-----------------------------------------------------------------------
            System.out.println("\n-------------------------------------------");
            System.out.println("Finalizando a aplicação de consulta de CEP.");
            System.out.println("-------------------------------------------");
            leitura.close(); // Fecha o Scanner para liberar recursos.
        }
    }
}

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Consulta CEP
// Data: 09 de Maio de 2025
//==========================================