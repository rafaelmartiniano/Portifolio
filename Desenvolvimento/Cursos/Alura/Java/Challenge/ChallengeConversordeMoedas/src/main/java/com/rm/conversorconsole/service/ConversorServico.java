//===============================================================================
// PACOTE: com.rm.conversorconsole.service
// ARQUIVO: ConversorServico.java
// PROJETO: Conversor de Moedas Console (Backend)
//===============================================================================
package com.rm.conversorconsole.service;

import com.rm.conversorconsole.client.TaxaCambioCliente;
import com.rm.conversorconsole.dto.TaxaCambioApiResponse;
import com.rm.conversorconsole.enums.Moeda;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime; // Importação adicionada
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Serviço responsável pela lógica de negócio da conversão de moedas.
 * Utiliza um TaxaCambioCliente para obter as taxas de câmbio.
 * Projeto do desafio de Java da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @autor RM
 * @versão 1.2 // Versão atualizada devido à correção na formatação da data (usando VV)
 * @data 09 de Maio de 2025
 */
public class ConversorServico {

    //-------------------------------------------------------------------------------
    // ATRIBUTO: clienteTaxas (TaxaCambioCliente)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Instância do cliente para buscar as taxas de câmbio.
    //            Insere dados via construtor (princípio de Inversão de Dependência).
    //-------------------------------------------------------------------------------
    private final TaxaCambioCliente clienteTaxas;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: formatadorValor (DecimalFormat)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Utilizado para formatar os valores monetários com duas casas decimais.
    //-------------------------------------------------------------------------------
    private final DecimalFormat formatadorValor;


    //*******************************************************************************
    // CONSTRUTOR: ConversorServico
    //*******************************************************************************
    // OBJETIVO:
    //   Cria uma nova instância do serviço de conversão.
    // PARÂMETROS:
    //   clienteTaxas (TaxaCambioCliente) - O cliente HTTP para a API de taxas.
    //-------------------------------------------------------------------------------
    public ConversorServico(TaxaCambioCliente clienteTaxas) {
        this.clienteTaxas = clienteTaxas;
        // Configura o DecimalFormat para usar ponto como separador decimal (padrão US/API)
        // e formatar com duas casas decimais.
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        this.formatadorValor = new DecimalFormat("#,##0.00", symbols);
    }

    //*******************************************************************************
    // METODO: converterMoeda
    //*******************************************************************************
    // OBJETIVO:
    //   Realiza a conversão de um valor de uma moeda de origem para uma de destino.
    // PARÂMETROS:
    //   valor (double)       - O valor a ser convertido.
    //   moedaOrigem (Moeda)  - A moeda de origem da conversão.
    //   moedaDestino (Moeda) - A moeda de destino da conversão.
    // RETORNO: String - Uma mensagem formatada com o resultado da conversão,
    //                   ou uma mensagem de erro se a conversão falhar.
    //-------------------------------------------------------------------------------
    public String converterMoeda(double valor, Moeda moedaOrigem, Moeda moedaDestino) {
        //---------------------------------------------------------------------------
        // VALIDAÇÃO INICIAL: Valor
        //---------------------------------------------------------------------------
        if (valor <= 0) {
            return "ERRO: O valor para conversão deve ser positivo.";
        }
        if (moedaOrigem == moedaDestino) {
            return """
                   As moedas de origem e destino são iguais. Nenhuma conversão necessária.
                   Valor: """ + moedaOrigem.name() + " " + formatadorValor.format(valor);
        }

        try {
            //-----------------------------------------------------------------------
            // PASSO 1: Obtem a taxa de câmbio da API
            //-----------------------------------------------------------------------
            System.out.println("Buscando taxa de câmbio para " + moedaOrigem.name() + " -> " + moedaDestino.name() + "...");
            TaxaCambioApiResponse respostaApi = clienteTaxas.obterTaxaDeConversao(moedaOrigem, moedaDestino);

            //-----------------------------------------------------------------------
            // PASSO 2: Calcula o valor convertido
            //-----------------------------------------------------------------------
            double taxaConversao = respostaApi.conversion_rate();
            double valorConvertido = valor * taxaConversao;

            //-----------------------------------------------------------------------
            // PASSO 3: Formatar a data da última atualização da taxa (CORRIGIDO v2)
            //-----------------------------------------------------------------------
            // Cria um ZonedDateTime a partir do Instant (que é UTC) e aplica o fuso horário do sistema
            ZonedDateTime dataHoraTaxaComZona = ZonedDateTime.ofInstant(
                    Instant.ofEpochSecond(respostaApi.time_last_update_unix()),
                    ZoneId.systemDefault() // Converte para o fuso horário padrão do sistema
            );
            // Customiza o ZonedDateTime usando VV para o ID da Zona, que é mais robusto (Gostei dessa palavra).
            DateTimeFormatter formatadorDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss VV", Locale.getDefault());


            //-----------------------------------------------------------------------
            // PASSO 4: Montar a string de resultado
            //-----------------------------------------------------------------------
            StringBuilder resultado = new StringBuilder();
            resultado.append("\n--- Resultado da Conversão ---\n");
            resultado.append("Valor Original: ").append(moedaOrigem.name()).append(" ").append(formatadorValor.format(valor)).append("\n");
            resultado.append("Moeda Destino: ").append(moedaDestino.getNomeCompleto()).append(" (").append(moedaDestino.name()).append(")\n");
            resultado.append("Taxa de Câmbio (1 ").append(moedaOrigem.name()).append(" = ").append(moedaDestino.name()).append(" ").append(String.format("%.6f", taxaConversao)).append(")\n"); // Exibe taxa com 6 casas decimais
            resultado.append("Valor Convertido: ").append(moedaDestino.name()).append(" ").append(formatadorValor.format(valorConvertido)).append("\n");
            resultado.append("Última atualização da taxa: ").append(dataHoraTaxaComZona.format(formatadorDataHora)).append("\n"); // Usa dataHoraTaxaComZona
            resultado.append("------------------------------");

            return resultado.toString();

        } catch (IOException | InterruptedException e) {
            // Erros de comunicação com a API
            return "ERRO DE COMUNICAÇÃO: Não foi possível obter a taxa de câmbio. (" + e.getMessage() + ")";
        } catch (RuntimeException e) {
            // Outros erros (ex: chave de API não configurada, resposta inesperada da API, moeda não suportada pela API, erro de formatação de data)
            // Adicionamos a causa original ao log para melhor depuração, se necessário.
            // System.err.println("Detalhe do erro em converterMoeda: " + e.toString());
            // e.printStackTrace(); // Descomente para ver o stack trace completo no console de erro.
            return "ERRO NA CONVERSÃO: " + e.getMessage();
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
