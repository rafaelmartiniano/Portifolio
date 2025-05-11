
    //===============================================================================
    // PACOTE: com.rm.conversorconsole.client
    // ARQUIVO: TaxaCambioCliente.java
    // PROJETO: Conversor de Moedas Console (Backend)
    //===============================================================================
    package com.rm.conversorconsole.client;
    
    import com.rm.conversorconsole.dto.TaxaCambioApiResponse;
    import com.rm.conversorconsole.enums.Moeda;
    
    import java.io.IOException;
    
    /**
     * Interface para o cliente que busca taxas de câmbio de uma API externa.
     * Define o contrato para obter a taxa de conversão entre duas moedas.
     * Projeto do desafio de Java da Alura + Oracle.
     * Customizações e comentários explicativos por RM.
     *
     * @author RM
     * @version 1.0
     * @date 09 de Maio de 2025
     */
    public interface TaxaCambioCliente {
    
        //*******************************************************************************
        // METODO: obterTaxaDeConversao
        //*******************************************************************************
        // OBJETIVO:
        //   Buscar a taxa de câmbio atualizada entre uma moeda de origem e uma de destino.
        // PARÂMETROS:
        //   moedaOrigem (Moeda)  - O enum da moeda de origem.
        //   moedaDestino (Moeda) - O enum da moeda de destino.
        // RETORNO: TaxaCambioApiResponse - Um objeto contendo os detalhes da taxa de câmbio
        //                                  retornados pela API.
        // LANÇA:
        //   IOException - Se ocorrer um erro de entrada/saída durante a comunicação com a API.
        //   InterruptedException - Se a thread for interrompida durante a requisição.
        //   RuntimeException - Para outros erros (ex: API indisponível, parsing do JSON).
        //-------------------------------------------------------------------------------
        TaxaCambioApiResponse obterTaxaDeConversao(Moeda moedaOrigem, Moeda moedaDestino)
                throws IOException, InterruptedException, RuntimeException;
    }
    
    //==========================================
    // Feito por RM By Alura+Oracle
    // Projeto: Conversor de Moedas Console
    // Data: 09 de Maio de 2025
    //==========================================
    