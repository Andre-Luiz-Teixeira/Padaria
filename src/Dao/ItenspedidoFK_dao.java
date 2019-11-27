/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ItensPedidosFK_mdl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class ItenspedidoFK_dao {

    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void inserir(ItensPedidosFK_mdl item) {
        sql = "insert into itenspedidos(pedido_id, produto_id, itens_qtd, itens_valor) values (?, ?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, item.getPedido_id());
            pst.setInt(2, item.getProduto_id());
            pst.setDouble(3, item.getItens_qtd());
            pst.setDouble(4, item.getItens_valor());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
    }

    public void update(ItensPedidosFK_mdl item) {
        sql = "update itenspedidos set pedido_id = ? , produto_id = ? , itens_qtd = ? , itens_valor = ?  where itens_id = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, item.getPedido_id());
            pst.setInt(2, item.getProduto_id());
            pst.setDouble(3, item.getItens_qtd());
            pst.setDouble(4, item.getItens_valor());
            pst.setInt(5, item.getItens_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }
    }

    public void remove(int Id) {
        sql = "delete from itenspedidos where itens_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());
        }
    }

    public ItensPedidosFK_mdl selecionar(int Id) {
        ItensPedidosFK_mdl item = new ItensPedidosFK_mdl();
        sql = "select itens_id, pedido_id, produto_id, itens_qtd, itens_valor from itenspedidos where itens_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            ResultSet resultado = pst.executeQuery();
            resultado.next();

            item.setItens_id(resultado.getInt("itens_id"));
            item.setPedido_id(resultado.getInt("pedido_id"));
            item.setProduto_id(resultado.getInt("produto_id"));
            item.setItens_qtd(resultado.getDouble("itens_qtd"));
            item.setItens_valor(resultado.getDouble("itens_valor"));

        } catch (SQLException ex) {
            System.err.println("Erro ao recupera objeto do banco: " + ex.getMessage());
        }

        return item;
    }

    public ArrayList<ItensPedidosFK_mdl> tudo() {
        ArrayList<ItensPedidosFK_mdl> ListaItem = new ArrayList<>();
        sql = "select itens_id, pedido_id, produto_id, itens_qtd, itens_valor from itenspedidos";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();

            while (resultado.next()) {
                ItensPedidosFK_mdl item = new ItensPedidosFK_mdl();

                item.setItens_id(resultado.getInt("itens_id"));
                item.setPedido_id(resultado.getInt("pedido_id"));
                item.setProduto_id(resultado.getInt("produto_id"));
                item.setItens_qtd(resultado.getDouble("itens_qtd"));
                item.setItens_valor(resultado.getDouble("itens_valor"));

                ListaItem.add(item);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());;
        }

        return ListaItem;
    }

    public ItensPedidosFK_mdl ultimo() {
        ItensPedidosFK_mdl item = new ItensPedidosFK_mdl();
        sql = "select itens_id, pedido_id, produto_id, itens_qtd, itens_valor from itenspedidos where itens_id = (select  MAX(itens_id) as itens_id from itenspedidos)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();
            resultado.next();

            item.setItens_id(resultado.getInt("itens_id"));
            item.setPedido_id(resultado.getInt("pedido_id"));
            item.setProduto_id(resultado.getInt("produto_id"));
            item.setItens_qtd(resultado.getDouble("itens_qtd"));
            item.setItens_valor(resultado.getDouble("itens_valor"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return item;
    }

    public ItensPedidosFK_mdl primeiro() {
        ItensPedidosFK_mdl item = new ItensPedidosFK_mdl();
        sql = "select itens_id, pedido_id, produto_id, itens_qtd, itens_valor from itenspedidos where itens_id = (select  MIN(itens_id) as itens_id from itenspedidos)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery();
            resultado.next();

            item.setItens_id(resultado.getInt("itens_id"));
            item.setPedido_id(resultado.getInt("pedido_id"));
            item.setProduto_id(resultado.getInt("produto_id"));
            item.setItens_qtd(resultado.getDouble("itens_qtd"));
            item.setItens_valor(resultado.getDouble("itens_valor"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return item;
    }
}
