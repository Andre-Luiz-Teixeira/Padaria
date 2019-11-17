/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.Vendedor_dao;
import Model.Vendedor_mdl;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Vendedor_ctrl {
    Vendedor_mdl Model = new Vendedor_mdl();
    Vendedor_dao Dao = new Vendedor_dao();
    String[] vetorVendedor = new String[4];
    ArrayList<Vendedor_mdl> ListaVendedor = new ArrayList<>();

    public void salvar(String[] dados) {
        Model.setId(Integer.parseInt(dados[0]));
        Model.setNome(dados[1]);
        Model.setSexo(dados[2]);
        Model.setIdade(Integer.parseInt(dados[3]));

        if (Model.getId() == 0) {
            Dao.inserir(Model);
        } else {
            Dao.update(Model);
        }
    }

    public String[] recuperar(int id) {
        Model = Dao.selecionar(id);

        vetorVendedor[0] = String.valueOf(Model.getId());
        vetorVendedor[1] = Model.getNome();
        vetorVendedor[2] = Model.getSexo();
        vetorVendedor[3] = String.valueOf(Model.getIdade());

        return vetorVendedor;
    }

    public String[] ultimo(){
        Model = Dao.ultimo();

        vetorVendedor[0] = String.valueOf(Model.getId());
        vetorVendedor[1] = Model.getNome();
        vetorVendedor[2] = Model.getSexo();
        vetorVendedor[3] = String.valueOf(Model.getIdade());

        return vetorVendedor;
    }

    public String[][] recuperarTodos() {
        ListaVendedor = Dao.tudo();
        String[][] matriz = new String[ListaVendedor.size()][4];

        for (int i = 0; i < ListaVendedor.size(); i++) {
            matriz[i][0] = String.valueOf(ListaVendedor.get(i).getId());
            matriz[i][1] = ListaVendedor.get(i).getNome();
            matriz[i][2] = ListaVendedor.get(i).getSexo();
            matriz[i][3] = String.valueOf(ListaVendedor.get(i).getIdade());
        }
        return matriz;
    }

    public void excluir(int id) {
        Dao.remove(id);
    }
}
