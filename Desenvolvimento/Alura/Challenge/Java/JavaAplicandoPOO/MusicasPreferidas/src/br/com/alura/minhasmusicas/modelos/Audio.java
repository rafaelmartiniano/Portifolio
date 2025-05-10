//===============================================================================
// PACOTE: br.com.alura.minhasmusicas.modelos
// ARQUIVO: Audio.java
//===============================================================================
package br.com.alura.minhasmusicas.modelos;

/**
 * Classe base para todos os tipos de áudio, como músicas e podcasts.
 * Define atributos e comportamentos comuns.
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class Audio {

    //-------------------------------------------------------------------------------
    // ATRIBUTO: titulo (String)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Armazena o título do áudio.
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private String titulo;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: totalReproducoes (int)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Contador de quantas vezes o áudio foi reproduzido.
    // ACESSO: Privado. Modificado internamente pelo metodo reproduz().
    //-------------------------------------------------------------------------------
    private int totalReproducoes;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: totalCurtidas (int)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Contador de quantas vezes o áudio foi curtido.
    // ACESSO: Privado. Modificado internamente pelo metodo curte().
    //-------------------------------------------------------------------------------
    private int totalCurtidas;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: classificacao (double)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Armazena a classificação geral do áudio.
    //            Nas subclasses, o metodo getClassificacao() é sobrescrito
    //            para calcular este valor de forma específica.
    // ACESSO: Privado.
    //-------------------------------------------------------------------------------
    private double classificacao; // No README original não especificava tipo, mas double é usado.

    //*******************************************************************************
    // METODO: getTitulo
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o título do áudio.
    // RETORNO: String (o título)
    //-------------------------------------------------------------------------------
    public String getTitulo() {
        return titulo;
    }

    //*******************************************************************************
    // METODO: setTitulo
    //*******************************************************************************
    // OBJETIVO:
    //   Definir/alterar o título do áudio.
    // PARÂMETROS:
    //   titulo (String) - O novo título para o áudio.
    //-------------------------------------------------------------------------------
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //*******************************************************************************
    // METODO: getTotalReproducoes
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o número total de reproduções.
    // RETORNO: int (o total de reproduções)
    //-------------------------------------------------------------------------------
    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    //*******************************************************************************
    // METODO: getTotalCurtidas
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o número total de curtidas.
    // RETORNO: int (o total de curtidas)
    //-------------------------------------------------------------------------------
    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    //*******************************************************************************
    // METODO: getClassificacao
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar a classificação base do áudio.
    //   Este metodo é destinado a ser sobrescrito pelas subclasses (Musica, Podcast)
    //   para implementar lógicas de classificação específicas.
    // RETORNO: double (a classificação)
    //-------------------------------------------------------------------------------
    public double getClassificacao() {
        return classificacao;
    }

    //*******************************************************************************
    // METODO: curte
    //*******************************************************************************
    // OBJETIVO:
    //   Incrementar o contador de curtidas do áudio.
    // EFEITO COLATERAL:
    //   Modifica o atributo 'totalCurtidas'.
    //-------------------------------------------------------------------------------
    public void curte() {
        this.totalCurtidas++;
    }

    //*******************************************************************************
    // METODO: reproduz
    //*******************************************************************************
    // OBJETIVO:
    //   Incrementar o contador de reproduções do áudio.
    // EFEITO COLATERAL:
    //   Modifica o atributo 'totalReproducoes'.
    //-------------------------------------------------------------------------------
    public void reproduz() {
        this.totalReproducoes++;
    }
}