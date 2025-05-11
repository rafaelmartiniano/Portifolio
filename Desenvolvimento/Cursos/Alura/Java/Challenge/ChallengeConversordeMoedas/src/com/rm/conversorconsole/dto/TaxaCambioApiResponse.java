
    //===============================================================================
    // PACOTE: com.rm.conversorconsole.dto
    // ARQUIVO: TaxaCambioApiResponse.java
    // PROJETO: Conversor de Moedas Console (Backend)
    //===============================================================================
    package com.rm.conversorconsole.dto;
    
    /**
     * Record para mapear a resposta JSON da API ExchangeRate-API ao consultar um par de moedas.
     * Contém os campos relevantes da resposta da API.
     * Projeto do desafio de Java da Alura + Oracle.
     * Customizações e comentários explicativos por RM.
     *
     * @param base_code Código da moeda base da conversão.
     * @param target_code Código da moeda alvo da conversão.
     * @param conversion_rate A taxa de câmbio aplicada.
     * @param time_last_update_unix Timestamp Unix da última atualização da taxa.
     * @param time_last_update_utc String da data/hora UTC da última atualização.
     *
     * @author RM
     * @version 1.0
     * @date 09 de Maio de 2025
     */
    public record TaxaCambioApiResponse(
            String base_code,         // Ex: "USD"
            String target_code,       // Ex: "BRL"
            double conversion_rate,   // Ex: 5.25
            long time_last_update_unix, // Timestamp Unix
            String time_last_update_utc // Data em formato string UTC
    ) {
        //-------------------------------------------------------------------------------
        // OBSERVAÇÕES SOBRE RECORDS:
        //-------------------------------------------------------------------------------
        // 1. Construtor canônico, getters, equals(), hashCode(), e toString()
        //    são gerados automaticamente.
        // 2. Os nomes dos parâmetros do record DEVEM corresponder exatamente
        //    aos nomes dos campos no JSON da API para que o GSon funcione corretamente
        //    na desserialização automática.
        //-------------------------------------------------------------------------------
    }
    
    //==========================================
    // Feito por RM By Alura+Oracle
    // Projeto: Conversor de Moedas Console
    // Data: 09 de Maio de 2025
    //==========================================
    