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
public class ItemPedido_mdl {

    private int pedidoItem_id ;
    private int pedidoItem_pedido ;
    private int pedidoItem_cod ;
    private String pedidoItem_produto ;
    private double pedidoItem_quantidade ;
    private double pedidoItem_valor ;
    private double pedidoItem_total ;

    public int getPedidoItem_id() {
        return pedidoItem_id;
    }

    public void setPedidoItem_id(int pedidoItem_id) {
        this.pedidoItem_id = pedidoItem_id;
    }

    public int getPedidoItem_pedido() {
        return pedidoItem_pedido;
    }

    public void setPedidoItem_pedido(int pedidoItem_pedido) {
        this.pedidoItem_pedido = pedidoItem_pedido;
    }

    public int getPedidoItem_cod() {
        return pedidoItem_cod;
    }

    public void setPedidoItem_cod(int pedidoItem_cod) {
        this.pedidoItem_cod = pedidoItem_cod;
    }

    public String getPedidoItem_produto() {
        return pedidoItem_produto;
    }

    public void setPedidoItem_produto(String pedidoItem_produto) {
        this.pedidoItem_produto = pedidoItem_produto;
    }

    public double getPedidoItem_quantidade() {
        return pedidoItem_quantidade;
    }

    public void setPedidoItem_quantidade(double pedidoItem_quantidade) {
        this.pedidoItem_quantidade = pedidoItem_quantidade;
    }

    public double getPedidoItem_valor() {
        return pedidoItem_valor;
    }

    public void setPedidoItem_valor(double pedidoItem_valor) {
        this.pedidoItem_valor = pedidoItem_valor;
    }

    public double getPedidoItem_total() {
        return pedidoItem_total;
    }

    public void setPedidoItem_total(double pedidoItem_total) {
        this.pedidoItem_total = pedidoItem_total;
    }
}
