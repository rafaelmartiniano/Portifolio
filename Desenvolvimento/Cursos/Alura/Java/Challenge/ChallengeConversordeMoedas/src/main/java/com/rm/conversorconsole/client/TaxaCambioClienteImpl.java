
    //===============================================================================
    // PACOTE: com.rm.conversorconsole.client
    // ARQUIVO: TaxaCambioClienteImpl.java
    // PROJETO: Conversor de Moedas Console (Backend)
    //===============================================================================
    package com.rm.conversorconsole.client;
    
    import com.google.gson.Gson;
    import com.rm.conversorconsole.dto.TaxaCambioApiResponse;
    import com.rm.conversorconsole.enums.Moeda;
    
    import java.io.IOException;
    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    
    /**
     * Implementação do cliente para consultar a API ExchangeRate-API.
     * Utiliza HttpClient do Java para requisições HTTP e GSon para parsing de JSON.
     * Projeto do desafio de Java da Alura + Oracle.
     * Customizações e comentários explicativos por RM.
     *
     * @autor RM
     * @versão 1.0
     * @data 09 de Maio de 2025
     */
    public class TaxaCambioClienteImpl implements TaxaCambioCliente {
    
        //-------------------------------------------------------------------------------
        // CONSTANTE: API_KEY_EXCHANGERATE
        //-------------------------------------------------------------------------------
        // ATENÇÃO: Substitua "SUA_CHAVE_API_AQUI" pela sua chave da ExchangeRate-API.
        // Você pode obter uma chave gratuita em https://www.exchangerate-api.com/
        //-------------------------------------------------------------------------------
        private static final String API_KEY_EXCHANGERATE = "c7fb71b31dc91bf2a974f880";
    
        //-------------------------------------------------------------------------------
        // CONSTANTE: BASE_URL_EXCHANGERATE
        //-------------------------------------------------------------------------------
        // URL base da API para consultar um par de moedas.
        // Formato: https://v6.exchangerate-api.com/v6/CHAVE_API/pair/MOEDA_ORIGEM/MOEDA_DESTINO
        //-------------------------------------------------------------------------------
        private static final String BASE_URL_EXCHANGERATE = "https://v6.exchangerate-api.com/v6/";
    
        //*******************************************************************************
        // METODO: obterTaxaDeConversao (Implementação da Interface)
        //*******************************************************************************
        @Override
        public TaxaCambioApiResponse obterTaxaDeConversao(Moeda moedaOrigem, Moeda moedaDestino)
                throws IOException, InterruptedException, RuntimeException {
    
            //---------------------------------------------------------------------------
            // VALIDAÇÃO INICIAL: Chave da API
            //---------------------------------------------------------------------------
            if (API_KEY_EXCHANGERATE.equals("https://v6.exchangerate-api.com/v6/c7fb71b31dc91bf2a974f880/latest/USD") || API_KEY_EXCHANGERATE.trim().isEmpty()) {
                throw new RuntimeException("ERRO: Chave da API (API_KEY_EXCHANGERATE) não configurada em TaxaCambioClienteImpl.java. Obtenha uma chave em https://www.exchangerate-api.com/");
            }

            //---------------------------------------------------------------------------
            // PASSO 1: Montar a URL completa da API
            //---------------------------------------------------------------------------
            String urlCompleta = BASE_URL_EXCHANGERATE + API_KEY_EXCHANGERATE + "/pair/" +
                                 moedaOrigem.name() + "/" + moedaDestino.name();
            URI uriApi = URI.create(urlCompleta);

            //---------------------------------------------------------------------------
            // PASSO 2: Criar o objeto HttpRequest
            //---------------------------------------------------------------------------
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uriApi)
                    .GET() // Metodo GET é o padrão, mas pode ser explícito.
                    .build();

            //---------------------------------------------------------------------------
            // PASSO 3: Criar o HttpClient e Enviar a Requisição
            //---------------------------------------------------------------------------
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //---------------------------------------------------------------------------
            // PASSO 4: Verificar o Status da Resposta HTTP
            //---------------------------------------------------------------------------
            if (response.statusCode() != 200) {
                // Tenta extrair uma mensagem de erro do corpo da resposta, se houver
                String corpoErro = response.body();
                String mensagemErroApi = "";
                if (corpoErro != null && !corpoErro.isEmpty()) {
                    try {
                        // A API ExchangeRate-API retorna um JSON de erro com um campo "error-type"
                        // Exemplo: {"result":"error","error-type":"unsupported-code"}
                        // Vamos tentar um parse simples ou usar a string bruta.
                        // Para simplificar, usamos a mensagem genérica baseada no status code.
                        // Vamos usar GSon para parsear a estrutura de erro específica da API.
                        if (corpoErro.contains("error-type")) {
                             mensagemErroApi = " Detalhe da API: " + corpoErro;
                        }
                    } catch (Exception ignored) {}
                }
                throw new RuntimeException("Falha ao buscar taxa de câmbio. Status HTTP: " +
                                           response.statusCode() + "." + mensagemErroApi +
                                           " URL: " + urlCompleta);
            }

            //---------------------------------------------------------------------------
            // PASSO 5: Converter a Resposta JSON para um objeto TaxaCambioApiResponse
            //---------------------------------------------------------------------------
            // Utiliza a biblioteca GSon para desserializar a String JSON (response.body()).
            //---------------------------------------------------------------------------
            Gson gson = new Gson();
            try {
                return gson.fromJson(response.body(), TaxaCambioApiResponse.class);
            } catch (com.google.gson.JsonSyntaxException e) {
                System.err.println("Erro ao parsear JSON da API: " + response.body());
                throw new RuntimeException("Resposta da API de taxas não está no formato JSON esperado.", e);
            }
        }
    }
    
                            /*
                            ==========================================
                             Feito por RAFAEL MARTINIANO By Alura+Oracle
                             Projeto: Conversor de Moedas Console
                             Data: 09 de Maio de 2025
                            ==========================================
                            */

    