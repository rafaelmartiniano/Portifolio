//===============================================================================
// PROJETO: Desafio Cartão de Crédito
// ARQUIVO: Compra.java
// DESCRIÇÃO: Representa uma compra individual com descrição e valor.
//            Implementa Comparable para permitir ordenação por valor.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

// import java.util.Objects; // Removido pois não é usado diretamente, compareTo usa Double

/**
 * Representa uma compra feita com um cartão de crédito.
 * Contém uma descrição e o valor da compra.
 * Implementa a interface {@link Comparable} para permitir a ordenação das compras pelo valor.
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class Compra implements Comparable<Compra> {

    //-------------------------------------------------------------------------------
    // ATRIBUTO: descricao (String)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: A descrição textual da compra (ex: "Ingresso cinema").
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private String descricao;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: valor (double)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: O valor monetário da compra.
    // ACESSO: Privado (encapsulado).
    //-------------------------------------------------------------------------------
    private double valor;

    //*******************************************************************************
    // CONSTRUTOR: Compra
    //*******************************************************************************
    // OBJETIVO:
    //   Criar uma nova instância de Compra.
    // REQUISITO README: "Utilize construtores nas classes para passar as informações".
    // PARÂMETROS:
    //   descricao (String) - A descrição da compra.
    //   valor (double)     - O valor da compra.
    //-------------------------------------------------------------------------------
    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    //*******************************************************************************
    // METODO: getDescricao
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar a descrição da compra.
    // RETORNO: String (a descrição)
    //-------------------------------------------------------------------------------
    public String getDescricao() {
        return descricao;
    }

    //*******************************************************************************
    // METODO: getValor
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o valor da compra.
    // RETORNO: double (o valor)
    //-------------------------------------------------------------------------------
    public double getValor() {
        return valor;
    }

    //*******************************************************************************
    // METODO: toString (Sobrescrito de Object)
    //*******************************************************************************
    // OBJETIVO:
    //   Fornecer uma representação textual do objeto Compra.
    //   Útil para exibir informações da compra de forma legível.
    // RETORNO: String (representação da compra)
    //-------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Compra: " + descricao + ", Valor: R$" + String.format("%.2f", valor);
    }

    //*******************************************************************************
    // METODO: compareTo (Sobrescrito de Comparable)
    //*******************************************************************************
    // OBJETIVO:
    //   Comparar esta compra com outra compra com base no valor.
    //   Essencial para permitir a ordenação da lista de compras.
    //   Ordena em ordem crescente de valor.
    // PARÂMETROS:
    //   outraCompra (Compra) - A outra compra a ser comparada.
    // RETORNO: int (negativo se this.valor < outraCompra.valor,
    //                zero se this.valor == outraCompra.valor,
    //                positivo se this.valor > outraCompra.valor)
    //-------------------------------------------------------------------------------
    @Override
    public int compareTo(Compra outraCompra) {
        // Compara os valores das compras. Double.valueOf().compareTo() é uma forma segura.
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.valor));
    }
}

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Cartão de Crédito
// Data: 09 de Maio de 2025
//==========================================