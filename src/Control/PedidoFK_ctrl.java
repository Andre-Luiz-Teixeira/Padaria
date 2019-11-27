/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.PedidoFK_dao;
import Model.PedidoFK_mdl;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class PedidoFK_ctrl {

    PedidoFK_mdl Model = new PedidoFK_mdl();
    PedidoFK_dao Dao = new PedidoFK_dao();
    String[] vetorPedido = new String[3];
    ArrayList<PedidoFK_mdl> ListaPedido = new ArrayList<>();

    public void salvar(String[] dados) {
        Model.setPedido_id(Integer.parseInt(dados[0]));
        Model.setVendedor_id(Integer.parseInt(dados[1]));
        Model.setCliente_id(Integer.parseInt(dados[2]));
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
        vetorPedido[1] = String.valueOf(Model.getVendedor_id());
        vetorPedido[2] = String.valueOf(Model.getCliente_id());
        vetorPedido[3] = String.valueOf(Model.getPedido_total());

        return vetorPedido;
    }

    public String[] recuperaUltimo() {
        Model = Dao.ultimo();

        vetorPedido[0] = String.valueOf(Model.getPedido_id());
        vetorPedido[1] = String.valueOf(Model.getVendedor_id());
        vetorPedido[2] = String.valueOf(Model.getCliente_id());
        vetorPedido[3] = String.valueOf(Model.getPedido_total());

        return vetorPedido;
    }

    public String[] recuperaPrimeiro() {
        Model = Dao.primeiro();

        vetorPedido[0] = String.valueOf(Model.getPedido_id());
        vetorPedido[1] = String.valueOf(Model.getVendedor_id());
        vetorPedido[2] = String.valueOf(Model.getCliente_id());
        vetorPedido[3] = String.valueOf(Model.getPedido_total());

        return vetorPedido;
    }

    public String[][] recuperarTodos() {
        ListaPedido = Dao.tudo();

        String[][] matriz = new String[ListaPedido.size()][3];

        for (int i = 0; i < ListaPedido.size(); i++) {
            matriz[i][0] = String.valueOf(Model.getPedido_id());
            matriz[i][1] = String.valueOf(Model.getVendedor_id());
            matriz[i][2] = String.valueOf(Model.getCliente_id());
            matriz[i][3] = String.valueOf(Model.getPedido_total());
        }
        return matriz;
    }

    public void excluir(int id) {
        Dao.remove(id);
    }
}
