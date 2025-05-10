//===============================================================================
// PACOTE: br.com.alura.minhasmusicas.principal
// ARQUIVO: Principal.java
//===============================================================================
package br.com.alura.minhasmusicas.principal;

import br.com.alura.minhasmusicas.modelos.MinhasPreferidas;
import br.com.alura.minhasmusicas.modelos.Musica;
import br.com.alura.minhasmusicas.modelos.Podcast;

/**
 * Classe principal para demonstrar a funcionalidade do sistema de áudios.
 * Cria instâncias de Musica e Podcast, simula interações e usa a classe MinhasPreferidas.
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class Principal {

    //*******************************************************************************
    // METODO: main
    //*******************************************************************************
    // OBJETIVO:
    //   Ponto de entrada da aplicação. Executa a simulação descrita no README.md.
    //-------------------------------------------------------------------------------
    public static void main(String[] args) {

        //---------------------------------------------------------------------------
        // BLOCO 1: Criação e configuração do objeto Musica
        //---------------------------------------------------------------------------
        // OBJETIVO: Instanciar uma música, definir alguns atributos e simular
        //           reproduções e curtidas.
        //---------------------------------------------------------------------------
        Musica minhaMusica = new Musica();
        minhaMusica.setTitulo("Forever");
        minhaMusica.setCantor("Kiss");
        // Nota: Atributos como 'album' e 'genero' não foram preenchidos nesta demo,
        // mas os getters/setters existem na classe Musica.

        // Simulação de reproduções
        for (int i = 0; i < 1000; i++) {
            minhaMusica.reproduz();
        }
        // Simulação de curtidas
        for (int i = 0; i < 50; i++) {
            minhaMusica.curte();
        }
        // Com 1000 reproduções, a classificação esperada é 8.

        //---------------------------------------------------------------------------
        // BLOCO 2: Criação e configuração do objeto Podcast
        //---------------------------------------------------------------------------
        // OBJETIVO: Instanciar um podcast, definir alguns atributos e simular
        //           reproduções e curtidas.
        //---------------------------------------------------------------------------
        Podcast meuPodcast = new Podcast();
        meuPodcast.setTitulo("BolhaDev");
        meuPodcast.setApresentador("Marcus Mendes");
        // Nota: Atributo 'descricao' não foi preenchido nesta demo.

        // Simulação de reproduções
        for (int i = 0; i < 5000; i++) {
            meuPodcast.reproduz();
        }
        // Simulação de curtidas
        for (int i = 0; i < 1000; i++) {
            meuPodcast.curte();
        }
        // Com 1000 curtidas, a classificação esperada é 10.

        //---------------------------------------------------------------------------
        // BLOCO 3: Uso da classe MinhasPreferidas
        //---------------------------------------------------------------------------
        // OBJETIVO: Demonstrar o polimorfismo ao adicionar a música e o podcast
        //           à lista de preferidas e exibir as mensagens apropriadas.
        //---------------------------------------------------------------------------
        MinhasPreferidas preferidas = new MinhasPreferidas();
        preferidas.inclui(meuPodcast);  // Deve imprimir mensagem de "sucesso absoluto"
        preferidas.inclui(minhaMusica); // Deve imprimir mensagem de "também é um dos que as pessoas do mundo estão curtindo"
    }
}