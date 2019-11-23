/*
 * To change Model license header, choose License Headers in Project Properties.
 * To change Model template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.Itenspedido_dao;
import Model.ItensPedidos_mdl;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class ItensPedido_ctrl {

    ItensPedidos_mdl Model = new ItensPedidos_mdl();
    Itenspedido_dao Dao = new Itenspedido_dao();
    String[] vetorPedido = new String[3];
    ArrayList<ItensPedidos_mdl> ListaPedido = new ArrayList<>();

    public void salvar(String[] dados) {
        Model.setItens_id(Integer.parseInt(dados[0]));
        Model.setPedido_id(Integer.parseInt(dados[1]));
        Model.setProduto_id(Integer.parseInt(dados[2]));
        Model.setItens_qtd(Double.parseDouble(dados[3]));
        Model.setItens_valor(Double.parseDouble(dados[4]));

        if (Model.getItens_id() == 0) {
            Dao.inserir(Model);
        } else {
            Dao.update(Model);
        }
    }

    public String[] recuperar(int id) {
        Model = Dao.selecionar(id);

        vetorPedido[0] = String.valueOf(Model.getItens_id());
        vetorPedido[1] = String.valueOf(Model.getPedido_id());
        vetorPedido[2] = String.valueOf(Model.getProduto_id());
        vetorPedido[3] = String.valueOf(Model.getItens_qtd());
        vetorPedido[4] = String.valueOf(Model.getItens_valor());

        return vetorPedido;
    }

    public String[] recuperaUltimo() {
        Model = Dao.ultimo();

        vetorPedido[0] = String.valueOf(Model.getItens_id());
        vetorPedido[1] = String.valueOf(Model.getPedido_id());
        vetorPedido[2] = String.valueOf(Model.getProduto_id());
        vetorPedido[3] = String.valueOf(Model.getItens_qtd());
        vetorPedido[4] = String.valueOf(Model.getItens_valor());

        return vetorPedido;
    }

    public String[] recuperaPrimeiro() {
        Model = Dao.primeiro();

        vetorPedido[0] = String.valueOf(Model.getItens_id());
        vetorPedido[1] = String.valueOf(Model.getPedido_id());
        vetorPedido[2] = String.valueOf(Model.getProduto_id());
        vetorPedido[3] = String.valueOf(Model.getItens_qtd());
        vetorPedido[4] = String.valueOf(Model.getItens_valor());

        return vetorPedido;
    }

    public String[][] recuperarTodos() {
        ListaPedido = Dao.tudo();

        String[][] matriz = new String[ListaPedido.size()][3];

        for (int i = 0; i < ListaPedido.size(); i++) {
            vetorPedido[0] = String.valueOf(Model.getItens_id());
            vetorPedido[1] = String.valueOf(Model.getPedido_id());
            vetorPedido[2] = String.valueOf(Model.getProduto_id());
            vetorPedido[3] = String.valueOf(Model.getItens_qtd());
            vetorPedido[4] = String.valueOf(Model.getItens_valor());
        }
        return matriz;
    }

    public void excluir(int id) {
        Dao.remove(id);
    }
}
