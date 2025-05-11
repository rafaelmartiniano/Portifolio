
    //===============================================================================
    // PACOTE: com.rm.conversorconsole.enums
    // ARQUIVO: Moeda.java
    // PROJETO: Conversor de Moedas Console (Backend)
    //===============================================================================
    package com.rm.conversorconsole.enums;
    
    /**
     * Enumeração para representar as moedas suportadas pelo conversor.
     * Inclui moedas da América do Sul, principais globais e outras relevantes.
     * Projeto do desafio de Java da Alura + Oracle.
     * Customizações e comentários explicativos por RM.
     *
     * @autor RM
     * @versão 1.0
     * @data to custom tags 09 de Maio de 2025
     */
    public enum Moeda {
        // Moedas da América do Sul
        ARS("Peso Argentino"),
        BOB("Boliviano da Bolívia"),
        BRL("Real Brasileiro"),
        CLP("Peso Chileno"),
        COP("Peso Colombiano"),
        PYG("Guarani Paraguaio"),
        PEN("Sol Peruano"),
        UYU("Peso Uruguaio"),
        VES("Bolívar Venezuelano"),
    
        // Globais Adicionais
        USD("Dólar Americano"),
        EUR("Euro"),
    
        // Outras Moedas Globais Relevantes
        JPY("Iene Japonês"),
        GBP("Libra Esterlina"),
        AUD("Dólar Australiano"),
        CAD("Dólar Canadense"),
        CHF("Franco Suíço"),
        CNY("Yuan Chinês"),
        SEK("Coroa Sueca"),
        NZD("Dólar Neozelandês"),
        HKD("Dólar de Hong Kong"),
        INR("Rúpia Indiana");
    
        //-------------------------------------------------------------------------------
        // ATRIBUTO: nomeCompleto (String)
        //-------------------------------------------------------------------------------
        // DESCRIÇÃO: O nome completo da moeda para exibição.
        //-------------------------------------------------------------------------------
        private final String nomeCompleto;
    
        //*******************************************************************************
        // CONSTRUTOR: Moeda
        //*******************************************************************************
        // OBJETIVO:
        //   Associar um nome completo a cada código de moeda.
        // PARÂMETROS:
        //   nomeCompleto (String) - O nome descritivo da moeda.
        //-------------------------------------------------------------------------------
        Moeda(String nomeCompleto) {
            this.nomeCompleto = nomeCompleto;
        }
    
        //*******************************************************************************
        // METODO: getNomeCompleto
        //*******************************************************************************
        // OBJETIVO:
        //   Retorna o nome completo da moeda.
        // RETORNO: String (o nome completo)
        //-------------------------------------------------------------------------------
        public String getNomeCompleto() {
            return nomeCompleto;
        }
    
        //*******************************************************************************
        // METODO: fromString
        //*******************************************************************************
        // OBJETIVO:
        //   Converte uma String (código da moeda) para o enum Moeda correspondente.
        //   Sem diferenciar maiúsculas/minúsculas.
        // PARÂMETROS:
        //   codigo (String) - O código da moeda (ex: "USD", "brl").
        // RETORNO: Moeda - O enum Moeda correspondente.
        // LANÇA: IllegalArgumentException se o código não for suportado.
        //-------------------------------------------------------------------------------
        public static Moeda fromString(String codigo) {
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new IllegalArgumentException("O código da moeda não pode ser nulo ou vazio.");
            }
            try {
                return Moeda.valueOf(codigo.trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Moeda não suportada: " + codigo);
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
