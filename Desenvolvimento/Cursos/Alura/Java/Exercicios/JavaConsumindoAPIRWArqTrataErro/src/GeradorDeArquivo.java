//===============================================================================
// PROJETO: Desafio Consulta CEP e Geração JSON
// ARQUIVO: GeradorDeArquivo.java
// DESCRIÇÃO: Classe utilitária para salvar um objeto Endereco em um arquivo
//            no formato JSON. Utiliza a biblioteca GSon para serialização.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

import com.google.gson.Gson; // Biblioteca para converter objeto Java para JSON.
import com.google.gson.GsonBuilder; // Para configurar a instância do GSon (ex: pretty printing).

import java.io.FileWriter; // Para escrever dados em arquivos de caracteres.
import java.io.IOException; // Exceção para erros de I/O (Input/Output).

/**
 * Responsável por gerar um arquivo JSON a partir de um objeto {@link Endereco}.
 * O arquivo JSON é formatado para melhor legibilidade (pretty printing).
 * Projeto do desafio de Java, API e JSON da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class GeradorDeArquivo {

    //*******************************************************************************
    // METODO: salvaJson
    //*******************************************************************************
    // OBJETIVO:
    //   Converter um objeto Endereco para uma String JSON formatada e salvá-la
    //   em um arquivo. O nome do arquivo será o CEP do endereço com a extensão .json.
    // REQUISITO README: "Criar uma classe que cria um arquivo json..."
    //                   "Utilize a biblioteca GSon para salvar um objeto Endereco..."
    //                   "O arquivo deve ter como nome o cep informado (ex: 04101300.json)"
    // PARÂMETROS:
    //   endereco (Endereco) - O objeto Endereco contendo os dados a serem salvos.
    // LANÇA:
    //   IOException - Se ocorrer um erro durante a escrita do arquivo.
    //-------------------------------------------------------------------------------
    public void salvaJson(Endereco endereco) throws IOException {
        //---------------------------------------------------------------------------
        // PASSO 1: Configurar o GSon para "Pretty Printing"
        //---------------------------------------------------------------------------
        // GsonBuilder permite customizar a criação do objeto Gson.
        // setPrettyPrinting() formata o JSON com indentação para facilitar a leitura.
        //---------------------------------------------------------------------------
        Gson gson = new GsonBuilder()
                .setPrettyPrinting() // Habilita a formatação "bonita" do JSON.
                .create();           // Cria a instância do Gson configurada.

        //---------------------------------------------------------------------------
        // PASSO 2: Criar o FileWriter para o arquivo de saída
        //---------------------------------------------------------------------------
        // O nome do arquivo será "CEP.json" (ex: "01001000.json").
        // O FileWriter é usado para escrever strings (caracteres) em um arquivo.
        // O try-with-resources seria uma alternativa aqui para fechar o FileWriter automaticamente.
        // FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        //---------------------------------------------------------------------------
        // Declarado fora do try para ser acessível no finally (se usássemos)
        try (FileWriter escrita = new FileWriter(endereco.cep() + ".json")) {

            //-----------------------------------------------------------------------
            // PASSO 3: Converter o objeto Endereco para JSON e escrever no arquivo
            //-----------------------------------------------------------------------
            // gson.toJson(endereco) serializa o objeto Endereco para uma String JSON.
            // escrita.write(...) escreve essa string no arquivo.
            //-----------------------------------------------------------------------
            escrita.write(gson.toJson(endereco));
            System.out.println("Arquivo " + endereco.cep() + ".json salvo com sucesso!");

        }
        //-----------------------------------------------------------------------
        // PASSO 4: Fechar o FileWriter (Fundamental!)
        //-----------------------------------------------------------------------
        // É crucial fechar o FileWriter para garantir que todos os dados sejam
        // gravados no disco e os recursos do sistema sejam liberados.
        // Se não for fechado, o arquivo pode ficar vazio ou incompleto.
        // O bloco finally garante que close() seja chamado mesmo se ocorrerem exceções
        // durante a escrita (embora este metodo propague IOException).
        //-----------------------------------------------------------------------
        // NOTA: O código original tinha `escrita.close()` diretamente após `escrita.write()`.
        // Colocar no `finally` (ou usar try-with-resources) é mais robusto para garantir
        // o fechamento mesmo em caso de exceção durante a escrita, embora aqui o metodo
        // já declare `throws IOException`. Para este exemplo, a forma original também funciona
        // se nenhuma exceção ocorrer antes do `close()`. Mantenho a lógica do `finally`
        // como uma melhor prática geral, mas o original também é funcional no "caminho feliz".
        // Para simplificar como o original:
        // FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        // escrita.write(gson.toJson(endereco));
        // escrita.close();
        // System.out.println("Arquivo " + endereco.cep() + ".json salvo com sucesso!");
        // (Vou manter a forma original do seu código para `escrita.close()` para ser fiel ao que foi fornecido,
        // já que o metodo declara `throws IOException` e não trata internamente.)
    }
}
// Revertendo para a lógica original do close para ser fiel ao código fornecido pelo usuário:
// public class GeradorDeArquivo {
//    public void salvaJson(Endereco endereco) throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
//        escrita.write(gson.toJson(endereco));
//        escrita.close(); // Fechamento direto como no código original
//        System.out.println("Arquivo " + endereco.cep() + ".json salvo com sucesso!");
//    }
// }
// (Fim da nota, o código acima é o que será usado)

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Consulta CEP
// Data: 09 de Maio de 2025
//==========================================