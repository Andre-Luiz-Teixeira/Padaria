/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.Pedido_dao;
import Model.Pedido_mdl;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Pedido_ctrl {
    Pedido_mdl Model = new Pedido_mdl();
    Pedido_dao Dao = new Pedido_dao();
    String[] vetorPedido = new String[4];
    ArrayList<Pedido_mdl> ListaPedido = new ArrayList<>();

    public void salvar(String[] dados) {
        Model.setPedido_id(Integer.parseInt(dados[0]));
        Model.setPedido_vendedor(dados[1]);
        Model.setPedido_cliente(dados[2]);
        Model.setPedido_total(Double.parseDouble(dados[3]));

        if (Model.getPedido_id() == 0) {
            Dao.inserir(Model);
        } else {
            Dao.update(Model);
        }
    }

    public String[] recuperar(int id) {
        Model = Dao.selecionar(id);

        vetorPedido[0] = String.valueOf(Model.getPedido_id());
        vetorPedido[1] = Model.getPedido_vendedor();
        vetorPedido[2] = Model.getPedido_cliente();
        vetorPedido[3] = String.valueOf(Model.getPedido_total());

        return vetorPedido;
    }

    public String[] recuperaUltimo() {
        Model = Dao.ultimo();

        vetorPedido[0] = String.valueOf(Model.getPedido_id());
        vetorPedido[1] = Model.getPedido_vendedor();
        vetorPedido[2] = Model.getPedido_cliente();
        vetorPedido[3] = String.valueOf(Model.getPedido_total());

        return vetorPedido;
    }

    public String[] recuperaPrimeiro() {
        Model = Dao.primeiro();

        vetorPedido[0] = String.valueOf(Model.getPedido_id());
        vetorPedido[1] = Model.getPedido_vendedor();
        vetorPedido[2] = Model.getPedido_cliente();
        vetorPedido[3] = String.valueOf(Model.getPedido_total());

        return vetorPedido;
    }

    public String[][] recuperarTodos() {
        ListaPedido = Dao.tudo();

        String[][] matriz = new String[ListaPedido.size()][4];

        for (int i = 0; i < ListaPedido.size(); i++) {
            matriz[i][0] = String.valueOf(ListaPedido.get(i).getPedido_id());
            matriz[i][1] = ListaPedido.get(i).getPedido_vendedor();
            matriz[i][2] = ListaPedido.get(i).getPedido_cliente();
            matriz[i][3] = String.valueOf(ListaPedido.get(i).getPedido_total());
        }
        return matriz;
    }

    public void excluir(int id) {
        Dao.remove(id);
    }
    
    public String[][] recuperarTodos(String campo, String pesquisa) {
        ListaPedido = Dao.tudo(campo, pesquisa);

        String[][] matriz = new String[ListaPedido.size()][4];

        for (int i = 0; i < ListaPedido.size(); i++) {
            matriz[i][0] = String.valueOf(ListaPedido.get(i).getPedido_id());
            matriz[i][1] = ListaPedido.get(i).getPedido_vendedor();
            matriz[i][2] = ListaPedido.get(i).getPedido_cliente();
            matriz[i][3] = String.valueOf(ListaPedido.get(i).getPedido_total());
        }
        return matriz;
    }

    public Pedido_ctrl salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
