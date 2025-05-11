//===============================================================================
// PROJETO: Desafio Consulta CEP e Geração JSON
// ARQUIVO: Endereco.java
// DESCRIÇÃO: Representa os dados de um endereço postal.
//            Utilizada como um Data Transfer Object (DTO) para os dados
//            retornados pela API ViaCEP e para a serialização em JSON.
//            Implementada como um 'record' para concisão.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

/**
 * Representa um endereço postal com seus componentes padrão.
 * Esta classe é um {@code record}, o que automaticamente provê construtor,
 * getters, {@code equals()}, {@code hashCode()}, e {@code toString()}.
 * Os campos correspondem aos dados fornecidos pela API ViaCEP.
 * Projeto do desafio de Java, API e JSON da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @param cep         CEP (Código de Endereçamento Postal)
 * @param logradouro  Nome da rua, avenida, etc.
 * @param complemento Informações adicionais do endereço (ex: Apt 101)
 * @param bairro      Nome do bairro
 * @param localidade  Nome da cidade
 * @param uf          Sigla da Unidade Federativa (Estado)
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public record Endereco(String cep,
                       String logradouro,
                       String complemento,
                       String bairro,
                       String localidade,
                       String uf) {
    //-------------------------------------------------------------------------------
    // OBSERVAÇÕES SOBRE RECORDS:
    //-------------------------------------------------------------------------------
    // 1. Construtor canônico (recebendo todos os parâmetros) é gerado automaticamente.
    // 2. Métodos de acesso (getters) para cada campo (ex: cep(), logradouro()) são gerados.
    // 3. Métodos equals(), hashCode(), e toString() são gerados automaticamente.
    //    O toString() gerado é bastante útil para exibir os dados do endereço.
    //-------------------------------------------------------------------------------
}

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Consulta CEP
// Data: 09 de Maio de 2025
//==========================================