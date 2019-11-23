/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.Produto_dao;
import Model.Produto_mdl;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Produto_ctrl {
    Produto_mdl Model = new Produto_mdl();
    Produto_dao Dao = new Produto_dao();
    String[] vetorProduto = new String[3];
    ArrayList<Produto_mdl> ListaProduto = new ArrayList<>();

    public void salvar(String[] dados) {
        Model.setId(Integer.parseInt(dados[0]));
        Model.setNome(dados[1]);
        Model.setPreco(Double.parseDouble(dados[2]));
        Model.setUnidade(dados[3]);

        if (Model.getId() == 0) {
            Dao.inserir(Model);
        } else {
            Dao.update(Model);
        }
    }

    public String[] recuperar(int id) {
        Model = Dao.selecionar(id);

        vetorProduto[0] = String.valueOf(Model.getId());
        vetorProduto[1] = Model.getNome();
        vetorProduto[2] = String.valueOf(Model.getPreco());
        vetorProduto[3] = Model.getUnidade();

        return vetorProduto;
    }

    public String[] ultimo() {
        Model = Dao.ultimo();

        vetorProduto[0] = String.valueOf(Model.getId());
        vetorProduto[1] = Model.getNome();
        vetorProduto[2] = String.valueOf(Model.getPreco());
        vetorProduto[3] = Model.getUnidade();

        return vetorProduto;
    }

    public String[][] recuperarTodos() {
        ListaProduto = Dao.tudo();
        String[][] matriz = new String[ListaProduto.size()][4];

        for (int i = 0; i < ListaProduto.size(); i++) {
            matriz[i][0] = String.valueOf(ListaProduto.get(i).getId());
            matriz[i][1] = ListaProduto.get(i).getNome();
            matriz[i][2] = String.valueOf(ListaProduto.get(i).getPreco());
            matriz[i][3] = ListaProduto.get(i).getUnidade();
        }
        return matriz;
    }

    public void excluir(int id) {
        Dao.remove(id);
    }
    
    public String[] recuperaPrimeiro(){
        return null;
    }
    
    public String[] recuperaUltimo(){
        return null;
    }
}
