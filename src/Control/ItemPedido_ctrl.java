/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ItemPedido_dao;
import Model.ItemPedido_mdl;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class ItemPedido_ctrl {

    ItemPedido_mdl Model = new ItemPedido_mdl();
    ItemPedido_dao Dao = new ItemPedido_dao();
    String[] vetorItem = new String[7];
    ArrayList<ItemPedido_mdl> ListaItem = new ArrayList<>();

    public void salvar(String[] dados) {
        Model.setPedidoItem_id(Integer.parseInt(dados[0]));
        Model.setPedidoItem_pedido(Integer.parseInt(dados[1]));
        Model.setPedidoItem_cod(Integer.parseInt(dados[2]));
        Model.setPedidoItem_produto((dados[3]));
        Model.setPedidoItem_quantidade(Double.parseDouble(dados[4]));
        Model.setPedidoItem_valor(Double.parseDouble(dados[5]));
        Model.setPedidoItem_total(Double.parseDouble(dados[6]));

        if (Model.getPedidoItem_id() == 0) {
            Dao.inserir(Model);
        } else {
            Dao.update(Model);
        }
    }

    public String[] recuperar(int id) {
        Model = Dao.selecionar(id);

        vetorItem[0] = String.valueOf(Model.getPedidoItem_id());
        vetorItem[1] = String.valueOf(Model.getPedidoItem_pedido());
        vetorItem[2] = String.valueOf(Model.getPedidoItem_cod());
        vetorItem[3] = Model.getPedidoItem_produto();
        vetorItem[4] = String.valueOf(Model.getPedidoItem_quantidade());
        vetorItem[5] = String.valueOf(Model.getPedidoItem_valor());
        vetorItem[6] = String.valueOf(Model.getPedidoItem_total());

        return vetorItem;
    }

    public String[] recuperaUltimo() {
        Model = Dao.ultimo();

        vetorItem[0] = String.valueOf(Model.getPedidoItem_id());
        vetorItem[1] = String.valueOf(Model.getPedidoItem_pedido());
        vetorItem[2] = String.valueOf(Model.getPedidoItem_cod());
        vetorItem[3] = Model.getPedidoItem_produto();
        vetorItem[4] = String.valueOf(Model.getPedidoItem_quantidade());
        vetorItem[5] = String.valueOf(Model.getPedidoItem_valor());
        vetorItem[6] = String.valueOf(Model.getPedidoItem_total());

        return vetorItem;
    }

    public String[] recuperaPrimeiro() {
        Model = Dao.primeiro();

        vetorItem[0] = String.valueOf(Model.getPedidoItem_id());
        vetorItem[1] = String.valueOf(Model.getPedidoItem_pedido());
        vetorItem[2] = String.valueOf(Model.getPedidoItem_cod());
        vetorItem[3] = Model.getPedidoItem_produto();
        vetorItem[4] = String.valueOf(Model.getPedidoItem_quantidade());
        vetorItem[5] = String.valueOf(Model.getPedidoItem_valor());
        vetorItem[6] = String.valueOf(Model.getPedidoItem_total());

        return vetorItem;
    }

    public String[][] recuperarTodos() {
        ListaItem = Dao.tudo();

        String[][] Matriz = new String[ListaItem.size()][7];

        for (int i = 0; i < ListaItem.size(); i++) {
            Matriz[i][0] = String.valueOf(ListaItem.get(i).getPedidoItem_id());
            Matriz[i][1] = String.valueOf(ListaItem.get(i).getPedidoItem_pedido());
            Matriz[i][2] = String.valueOf(ListaItem.get(i).getPedidoItem_cod());
            Matriz[i][3] = ListaItem.get(i).getPedidoItem_produto();
            Matriz[i][4] = String.valueOf(ListaItem.get(i).getPedidoItem_quantidade());
            Matriz[i][5] = String.valueOf(ListaItem.get(i).getPedidoItem_valor());
            Matriz[i][6] = String.valueOf(ListaItem.get(i).getPedidoItem_total());
        }
        return Matriz;
    }

    public void excluir(int id) {
        Dao.remove(id);
    }

    public String[][] recuperarTodos(String campo, String pesquisa) {
        ListaItem = Dao.tudo(campo, pesquisa);

        String[][] Matriz = new String[ListaItem.size()][7];

        for (int i = 0; i < ListaItem.size(); i++) {
            Matriz[i][0] = String.valueOf(ListaItem.get(i).getPedidoItem_id());
            Matriz[i][1] = String.valueOf(ListaItem.get(i).getPedidoItem_pedido());
            Matriz[i][2] = String.valueOf(ListaItem.get(i).getPedidoItem_cod());
            Matriz[i][3] = ListaItem.get(i).getPedidoItem_produto();
            Matriz[i][4] = String.valueOf(ListaItem.get(i).getPedidoItem_quantidade());
            Matriz[i][5] = String.valueOf(ListaItem.get(i).getPedidoItem_valor());
            Matriz[i][6] = String.valueOf(ListaItem.get(i).getPedidoItem_total());
        }
        return Matriz;
    }
}
