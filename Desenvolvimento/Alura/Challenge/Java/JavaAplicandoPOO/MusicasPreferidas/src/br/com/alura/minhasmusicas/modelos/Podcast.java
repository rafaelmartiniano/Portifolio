//===============================================================================
// PACOTE: br.com.alura.minhasmusicas.modelos
// ARQUIVO: Podcast.java
//===============================================================================
package br.com.alura.minhasmusicas.modelos;

/**
 * Representa um Podcast, especialização da classe Audio.
 * Contém atributos específicos de podcasts como apresentador e descrição.
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class Podcast extends Audio {

    //-------------------------------------------------------------------------------
    // ATRIBUTO: apresentador (String)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Nome do apresentador (host) do podcast.
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private String apresentador;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: descricao (String)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Breve descrição sobre o conteúdo do podcast.
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private String descricao;

    //*******************************************************************************
    // METODO: getApresentador
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o nome do apresentador do podcast.
    // USO NA DEMONSTRAÇÃO ATUAL (Principal.java):
    //   - O metodo setApresentador() é usado, mas este getter não é chamado para exibição.
    // RETORNO: String (o nome do apresentador)
    //-------------------------------------------------------------------------------
    public String getApresentador() {
        return apresentador;
    }

    //*******************************************************************************
    // METODO: setApresentador
    //*******************************************************************************
    // OBJETIVO:
    //   Definir o nome do apresentador do podcast.
    // PARÂMETROS:
    //   apresentador (String) - O novo nome do apresentador.
    //-------------------------------------------------------------------------------
    public void setApresentador(String apresentador) {
        this.apresentador = apresentador;
    }

    //*******************************************************************************
    // METODO: getDescricao
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar a descrição do podcast.
    // RELAÇÃO COM REQUISITOS DO README:
    //   - Getter para encapsulamento.
    // USO NA DEMONSTRAÇÃO ATUAL (Principal.java):
    //   - Não utilizado para exibição ou definição na classe Principal.
    //   - Criado para completar a interface da classe.
    // RETORNO: String (a descrição do podcast)
    //-------------------------------------------------------------------------------
    public String getDescricao() {
        return descricao;
    }

    //*******************************************************************************
    // METODO: setDescricao
    //*******************************************************************************
    // OBJETIVO:
    //   Definir a descrição do podcast.
    // PARÂMETROS:
    //   descricao (String) - A nova descrição do podcast.
    //-------------------------------------------------------------------------------
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //*******************************************************************************
    // METODO: getClassificacao (Sobrescrito de Audio)
    //*******************************************************************************
    // OBJETIVO:
    //   Calcular e retornar a classificação específica para um podcast.
    // LÓGICA (Conforme README.md ajustado):
    //   - Se o total de curtidas for maior que 500, a classificação é 10.
    //   - Caso contrário, a classificação é 7.
    // RELAÇÃO COM OUTRAS CLASSES:
    //   - Chamado polimorficamente pela classe MinhasPreferidas.
    // RETORNO: double (a classificação do podcast)
    //-------------------------------------------------------------------------------
    @Override
    public double getClassificacao() {
        if (this.getTotalCurtidas() > 500) {
            return 10;
        } else {
            return 7; // Ajustado conforme README.md
        }
    }
}