/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author André Teixeira
 */
public class ItensPedidosFK_mdl {

    private int itens_id;
    private int pedido_id;
    private int produto_id;
    private double itens_qtd;
    private double itens_valor;

    public int getItens_id() {
        return itens_id;
    }

    public void setItens_id(int itens_id) {
        this.itens_id = itens_id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public double getItens_qtd() {
        return itens_qtd;
    }

    public void setItens_qtd(double itens_qtd) {
        this.itens_qtd = itens_qtd;
    }

    public double getItens_valor() {
        return itens_valor;
    }

    public void setItens_valor(double itens_valor) {
        this.itens_valor = itens_valor;
    }

    public String[] tovetor() {
        String vetor[] = new String[5];

        vetor[0] = String.valueOf(getItens_id());
        vetor[1] = String.valueOf(getPedido_id());
        vetor[2] = String.valueOf(getProduto_id());
        vetor[3] = String.valueOf(getItens_qtd());
        vetor[4] = String.valueOf(getItens_valor());

        return vetor;
    }

    public void vetorto(String[] dados) {
        this.setItens_id(Integer.parseInt(dados[0]));
        this.setPedido_id(Integer.parseInt(dados[1]));
        this.setProduto_id(Integer.parseInt(dados[2]));
        this.setItens_qtd(Double.parseDouble(dados[3]));
        this.setItens_valor(Double.parseDouble(dados[4]));
    }
}
