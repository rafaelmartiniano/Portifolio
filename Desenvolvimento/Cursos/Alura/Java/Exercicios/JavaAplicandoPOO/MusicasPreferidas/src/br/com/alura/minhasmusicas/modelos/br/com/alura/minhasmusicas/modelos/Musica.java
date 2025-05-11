//===============================================================================
// PACOTE: br.com.alura.minhasmusicas.modelos
// ARQUIVO: Musica.java
//===============================================================================
package br.com.alura.minhasmusicas.modelos;

/**
 * Representa uma Música, especialização da classe Audio.
 * Contém atributos específicos de músicas como álbum, cantor e gênero.
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class Musica extends Audio {

    //-------------------------------------------------------------------------------
    // ATRIBUTO: album (String)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Nome do álbum ao qual a música pertence.
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private String album;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: cantor (String)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Nome do cantor ou banda da música.
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private String cantor;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: genero (String)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Gênero musical da música.
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private String genero;

    //*******************************************************************************
    // METODO: getAlbum
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o nome do álbum da música.
    // RELAÇÃO COM REQUISITOS DO README:
    //   - Getter para encapsulamento.
    // USO NA DEMONSTRAÇÃO ATUAL (Principal.java):
    //   - Não utilizado para exibição ou definição na classe Principal.
    //   - Criado para completar a interface da classe.
    // RETORNO: String (o nome do álbum)
    //-------------------------------------------------------------------------------
    public String getAlbum() {
        return album;
    }

    //*******************************************************************************
    // METODO: setAlbum
    //*******************************************************************************
    // OBJETIVO:
    //   Definir o nome do álbum da música.
    // PARÂMETROS:
    //   album (String) - O novo nome do álbum.
    //-------------------------------------------------------------------------------
    public void setAlbum(String album) {
        this.album = album;
    }

    //*******************************************************************************
    // METODO: getCantor
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o nome do cantor da música.
    // USO NA DEMONSTRAÇÃO ATUAL (Principal.java):
    //   - O metodo setCantor() é usado, mas este getter não é chamado para exibição.
    // RETORNO: String (o nome do cantor)
    //-------------------------------------------------------------------------------
    public String getCantor() {
        return cantor;
    }

    //*******************************************************************************
    // METODO: setCantor
    //*******************************************************************************
    // OBJETIVO:
    //   Definir o nome do cantor da música.
    // PARÂMETROS:
    //   cantor (String) - O novo nome do cantor.
    //-------------------------------------------------------------------------------
    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    //*******************************************************************************
    // METODO: getGenero
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o gênero musical da música.
    // RELAÇÃO COM REQUISITOS DO README:
    //   - Getter para encapsulamento.
    // USO NA DEMONSTRAÇÃO ATUAL (Principal.java):
    //   - Não utilizado para exibição ou definição na classe Principal.
    //   - Criado para completar a interface da classe.
    // RETORNO: String (o gênero musical)
    //-------------------------------------------------------------------------------
    public String getGenero() {
        return genero;
    }

    //*******************************************************************************
    // METODO: setGenero
    //*******************************************************************************
    // OBJETIVO:
    //   Definir o gênero musical da música.
    // PARÂMETROS:
    //   genero (String) - O novo gênero musical.
    //-------------------------------------------------------------------------------
    public void setGenero(String genero) {
        this.genero = genero;
    }

    //*******************************************************************************
    // METODO: getClassificacao (Sobrescrito de Audio)
    //*******************************************************************************
    // OBJETIVO:
    //   Calcular e retornar a classificação específica para uma música.
    // LÓGICA (Conforme README.md ajustado):
    //   - Se o total de reproduções for maior que 2000, a classificação é 10.
    //   - Caso contrário, a classificação é 8.
    // RELAÇÃO COM OUTRAS CLASSES:
    //   - Chamado polimorficamente pela classe MinhasPreferidas.
    // RETORNO: double (a classificação da música)
    //-------------------------------------------------------------------------------
    @Override
    public double getClassificacao() {
        if (this.getTotalReproducoes() > 2000) {
            return 10;
        } else {
            return 8; // Ajustado conforme README.md
        }
    }
}