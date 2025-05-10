//===============================================================================
// PROJETO: Desafio Cartão de Crédito
// ARQUIVO: CartaoDeCredito.java
// DESCRIÇÃO: Representa um cartão de crédito com limite, saldo e um histórico de compras.
//            Baseado no desafio proposto por Alura + Oracle.
//===============================================================================

import java.util.ArrayList;
import java.util.List;
// import java.util.Collections; // Não é usado diretamente aqui, mas será útil na Principal para ordenar.

/**
 * Representa um cartão de crédito com um limite definido.
 * Gerencia o saldo disponível e armazena uma lista de compras realizadas.
 * Projeto do desafio de Java POO da Alura + Oracle.
 * Customizações e comentários explicativos por RM.
 *
 * @author RM
 * @version 1.0
 * @date 09 de Maio de 2025
 */
public class CartaoDeCredito {

    //-------------------------------------------------------------------------------
    // ATRIBUTO: limite (double)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: O limite total de crédito do cartão. Definido no construtor.
    // ACESSO: Privado.
    //-------------------------------------------------------------------------------
    private double limite;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: saldo (double)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: O saldo disponível no cartão. Inicializado com o valor do limite
    //            e decrementado a cada compra aprovada.
    // ACESSO: Privado.
    //-------------------------------------------------------------------------------
    private double saldo;

    //-------------------------------------------------------------------------------
    // ATRIBUTO: compras (List<Compra>)
    //-------------------------------------------------------------------------------
    // DESCRIÇÃO: Uma lista para armazenar todas as compras realizadas com o cartão.
    //            Inicializada como uma ArrayList vazia.
    // ACESSO: Privado, mas uma cópia (ou a referência) pode ser obtida via getCompras().
    //-------------------------------------------------------------------------------
    private List<Compra> compras;

    //*******************************************************************************
    // CONSTRUTOR: CartaoDeCredito
    //*******************************************************************************
    // OBJETIVO:
    //   Criar uma nova instância de CartaoDeCredito com um limite específico.
    //   O saldo inicial é igual ao limite. A lista de compras é inicializada.
    // REQUISITO README: "Utilize construtores nas classes para passar as informações".
    // PARÂMETROS:
    //   limite (double) - O limite de crédito para este cartão.
    //-------------------------------------------------------------------------------
    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite; // Saldo inicial é igual ao limite
        this.compras = new ArrayList<>();
    }

    //*******************************************************************************
    // METODO: lancaCompra
    //*******************************************************************************
    // OBJETIVO:
    //   Tentar registrar uma nova compra no cartão.
    //   A compra só é aprovada se o valor dela for menor ou igual ao saldo disponível.
    //   Se aprovada, o saldo é decrementado e a compra é adicionada à lista.
    // REQUISITO README: "...deve possuir um metodo para registrar uma compra".
    // PARÂMETROS:
    //   compra (Compra) - O objeto Compra a ser lançado.
    // RETORNO: boolean (true se a compra foi aprovada e lançada, false caso contrário)
    //-------------------------------------------------------------------------------
    public boolean lancaCompra(Compra compra) {
        if (this.saldo >= compra.getValor()) { // Condição correta: saldo DEVE SER >= valor da compra
            this.saldo -= compra.getValor();
            this.compras.add(compra);
            return true; // Compra aprovada
        }
        return false; // Saldo insuficiente
    }
    // NOTA: O código original tinha `if(this.saldo > compra.getValor())`.
    //       Ajustei para `>=` pois uma compra pode ser igual ao saldo. Se preferir manter `>` me avise.

    //*******************************************************************************
    // METODO: getLimite
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o limite total do cartão de crédito.
    // RETORNO: double (o limite do cartão)
    //-------------------------------------------------------------------------------
    public double getLimite() {
        return limite;
    }

    //*******************************************************************************
    // METODO: getSaldo
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar o saldo atualmente disponível no cartão.
    // RETORNO: double (o saldo disponível)
    //-------------------------------------------------------------------------------
    public double getSaldo() {
        return saldo;
    }

    //*******************************************************************************
    // METODO: getCompras
    //*******************************************************************************
    // OBJETIVO:
    //   Retornar a lista de todas as compras realizadas com o cartão.
    //   A lista retornada pode ser usada para exibir o histórico de compras.
    //   A ordenação da lista (por valor) será feita na classe Principal.
    // RETORNO: List<Compra> (a lista de compras)
    //-------------------------------------------------------------------------------
    public List<Compra> getCompras() {
        return compras; // Retorna a referência à lista interna.
        // Para maior encapsulamento, poderia retornar uma cópia:
        // return new ArrayList<>(this.compras);
        // Ou uma lista não modificável:
        // return Collections.unmodifiableList(this.compras);
        // Mas para este desafio, retornar a referência direta é comum.
    }
}

//==========================================
// Feito por RM By Alura+Oracle
// Projeto: Desafio Cartão de Crédito
// Data: 09 de Maio de 2025
//==========================================