/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.Cliente_dao;
import Model.Cliente_mdl;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Cliente_ctrl {
    Cliente_mdl Model = new Cliente_mdl();
    Cliente_dao Dao = new Cliente_dao();
    String[] vetorCliente = new String[3];
    ArrayList<Cliente_mdl> ListaCliente = new ArrayList<>();

    public void salvar(String[] dados) {
        Model.setId(Integer.parseInt(dados[0]));
        Model.setNome(dados[1]);
        Model.setSexo(dados[2]);

        if (Model.getId() == 0) {
            Dao.inserir(Model);
        } else {
            Dao.update(Model);
        }
    }

    public String[] recuperar(int id) {
        Model = Dao.selecionar(id);
        
        vetorCliente[0] = String.valueOf(Model.getId());
        vetorCliente[1] = Model.getNome();
        vetorCliente[2] = Model.getSexo();

        return vetorCliente;
    }

    public String[] recuperaUltimo() {
        Model = Dao.ultimo();

        vetorCliente[0] = String.valueOf(Model.getId());
        vetorCliente[1] = Model.getNome();
        vetorCliente[2] = Model.getSexo();

        return vetorCliente;
    }

    public String[][] recuperarTodos() {
        ListaCliente = Dao.tudo();

        String[][] matriz = new String[ListaCliente.size()][3];

        for (int i = 0; i < ListaCliente.size(); i++) {
            matriz[i][0] = String.valueOf(ListaCliente.get(i).getId());
            matriz[i][1] = ListaCliente.get(i).getNome();
            matriz[i][3] = ListaCliente.get(i).getSexo();
        }
        return matriz;
    }

    public void excluir(int id) {
        Dao.remove(id);
    }
}
