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

    private int pedido_id;
    private int vendedor_id;
    private int cliente_id;
    private double pedido_total;

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public double getPedido_total() {
        return pedido_total;
    }

    public void setPedido_total(double pedido_total) {
        this.pedido_total = pedido_total;
    }
    
    public String[] tovetor(){
        String vetor[] = new String[4];
        
        vetor[0] = String.valueOf(getPedido_id());
        vetor[1] = String.valueOf(getVendedor_id());
        vetor[2] = String.valueOf(getCliente_id());
        vetor[3] = String.valueOf(getPedido_total());
        
        return vetor;
    }

    public void vetorto(String[] dados) {
        this.setPedido_id(Integer.parseInt(dados[0]));
        this.setVendedor_id(Integer.parseInt(dados[1]));
        this.setCliente_id(Integer.parseInt(dados[2]));
        this.setPedido_total(Double.parseDouble(dados[3]));
    }
}
