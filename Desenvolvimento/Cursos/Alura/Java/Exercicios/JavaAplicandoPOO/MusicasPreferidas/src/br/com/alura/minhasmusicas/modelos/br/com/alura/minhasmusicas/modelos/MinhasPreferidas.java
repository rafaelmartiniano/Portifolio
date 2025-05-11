//===============================================================================
// PACOTE: br.com.alura.minhasmusicas.modelos
// ARQUIVO: MinhasPreferidas.java
//===============================================================================
package br.com.alura.minhasmusicas.modelos;

/**
 * Classe para gerenciar e exibir mensagens sobre áudios preferidos.
 * Demonstra o uso de polimorfismo com o metodo inclui().
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class MinhasPreferidas {

    //*******************************************************************************
    // METODO: inclui
    //*******************************************************************************
    // OBJETIVO:
    //   Receber um objeto do tipo Audio (pode ser Musica ou Podcast)
    //   e exibir uma mensagem baseada na sua classificação.
    //
    // DEMONSTRAÇÃO DE POLIMORFISMO:
    //   - O metodo 'audio.getClassificacao()' será resolvido em tempo de execução,
    //     chamando a implementação específica de Musica ou Podcast.
    //
    // LÓGICA DAS MENSAGENS (Conforme README.md):
    //   - Se classificação >= 9: "é considerado sucesso absoluto e preferido por todos!"
    //   - Se classificação < 9:  "também é um dos que as pessoas do mundo estão curtindo"
    //
    // PARÂMETROS:
    //   audio (Audio) - O objeto de áudio a ser processado (Musica ou Podcast).
    //-------------------------------------------------------------------------------
    public void inclui(Audio audio) {
        if (audio.getClassificacao() >= 9) {
            System.out.println(audio.getTitulo() + " é considerado sucesso absoluto" +
                    " e preferido por todos!");
        } else {
            System.out.println(audio.getTitulo() + " também é um dos que todos no mundo estão " +
                    "curtindo");
        }
    }
}