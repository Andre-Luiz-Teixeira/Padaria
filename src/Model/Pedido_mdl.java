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
public class Pedido_mdl {

   private int pedido_id ;
   private String pedido_vendedor ;
   private String pedido_cliente ;
   private double pedido_total ;

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public String getPedido_vendedor() {
        return pedido_vendedor;
    }

    public void setPedido_vendedor(String pedido_vendedor) {
        this.pedido_vendedor = pedido_vendedor;
    }

    public String getPedido_cliente() {
        return pedido_cliente;
    }

    public void setPedido_cliente(String pedido_cliente) {
        this.pedido_cliente = pedido_cliente;
    }

    public double getPedido_total() {
        return pedido_total;
    }

    public void setPedido_total(double pedido_total) {
        this.pedido_total = pedido_total;
    }
}
