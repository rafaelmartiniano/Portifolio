//===============================================================================
// PROJETO: Desafio Consulta CEP e Geração JSON
// ARQUIVO: ConsultaCep.java
// DESCRIÇÃO: Classe responsável por consultar a API ViaCEP para obter
//            dados de endereço a partir de um número de CEP.
//            Utiliza HttpClient do Java e a biblioteca GSon para parsing.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

import com.google.gson.Gson; // Biblioteca para converter JSON para objeto Java e vice-versa.

import java.io.IOException; // Exceção para erros de I/O (não diretamente lançada aqui, mas comum em HTTP).
import java.net.URI; // Para representar o endereço (URL) da API.
import java.net.http.HttpClient; // Cliente HTTP para fazer requisições.
import java.net.http.HttpRequest; // Objeto que representa a requisição HTTP.
import java.net.http.HttpResponse; // Objeto que representa a resposta HTTP.

/**
 * Realiza a consulta de um CEP na API ViaCEP (https://viacep.com.br).
 * Converte a resposta JSON em um objeto {@link Endereco}.
 * Projeto do desafio de Java, API e JSON da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class ConsultaCep {

    //*******************************************************************************
    // METODO: buscaEndereco
    //*******************************************************************************
    // OBJETIVO:
    //   Consultar a API ViaCEP com um CEP fornecido e retornar os dados
    //   do endereço correspondente como um objeto Endereco.
    // REQUISITO README: "Criar uma classe que consulta a API ViaCEP..."
    // PARÂMETROS:
    //   cep (String) - O número do CEP a ser consultado (somente números).
    // RETORNO: Endereco - Um objeto Endereco preenchido com os dados da API,
    //                     ou lança uma RuntimeException se ocorrer um erro.
    // OBSERVAÇÕES:
    //   - Utiliza o HttpClient nativo do Java (a partir do Java 11).
    //   - Utiliza a biblioteca GSon para deserializar o JSON da resposta.
    //-------------------------------------------------------------------------------
    public Endereco buscaEndereco(String cep) {
        //---------------------------------------------------------------------------
        // PASSO 1: Montar a URI da API ViaCEP
        //---------------------------------------------------------------------------
        // Exemplo de URI: "https://viacep.com.br/ws/01001000/json/"
        //---------------------------------------------------------------------------
        URI enderecoApi = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

        //---------------------------------------------------------------------------
        // PASSO 2: Criar o objeto HttpRequest
        //---------------------------------------------------------------------------
        // Define o tipo de requisição (GET por padrão) e o URI de destino.
        //---------------------------------------------------------------------------
        HttpRequest request = HttpRequest.newBuilder()
                .uri(enderecoApi)
                .build();

        //---------------------------------------------------------------------------
        // PASSO 3: Enviar a Requisição e Obter a Resposta
        //---------------------------------------------------------------------------
        // Tenta enviar a requisição e processar a resposta.
        // Se ocorrer qualquer erro (rede, parsing, etc.), uma RuntimeException é lançada.
        //---------------------------------------------------------------------------
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient() // Cria uma nova instância do HttpClient.
                    .send(request, HttpResponse.BodyHandlers.ofString()); // Envia a requisição e espera uma resposta como String.

            //-----------------------------------------------------------------------
            // PASSO 4: Converter a Resposta JSON para um objeto Endereco
            //-----------------------------------------------------------------------
            // REQUISITO README: "Utilize a biblioteca GSon para converter o JSON..."
            // O corpo da resposta (response.body()) é uma String JSON.
            // A biblioteca GSon a converte para um objeto Endereco.
            //-----------------------------------------------------------------------
            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (IOException | InterruptedException e) {
            // Captura exceções comuns de rede (IOException) ou se a thread for interrompida (InterruptedException).
            // O código original usava `catch (Exception e)`, que é mais genérico.
            // Especificar as exceções é uma prática ligeiramente melhor.
            System.err.println("Erro ao conectar ou processar a resposta da API ViaCEP: " + e.getMessage());
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP devido a um erro de comunicação ou interrupção.");
        } catch (Exception e) {
            // Captura outras exceções inesperadas durante o processo.
            System.err.println("Ocorreu um erro inesperado ao buscar o endereço: " + e.getMessage());
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }
}

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Consulta CEP
// Data: 09 de Maio de 2025
//==========================================