/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.ItemPedido_mdl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class ItemPedido_dao {

    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void inserir(ItemPedido_mdl Item) {
        sql = "insert into pedidoitem(pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total) "
                + "values (?, ?, ?, ?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Item.getPedidoItem_pedido());
            pst.setInt(2, Item.getPedidoItem_cod());
            pst.setString(3, Item.getPedidoItem_produto());
            pst.setDouble(4, Item.getPedidoItem_quantidade());
            pst.setDouble(5, Item.getPedidoItem_valor());
            pst.setDouble(6, Item.getPedidoItem_total());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
    }

    public void update(ItemPedido_mdl Item) {
        sql = "update pedidoitem set pedidoItem_id = ?, pedidoItem_pedido = ?, pedidoItem_cod = ?, pedidoItem_produto = ?, pedidoItem_quantidade = ?, pedidoItem_valor = ?, pedidoItem_total = ? "
                + "where PedidoItem_id = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Item.getPedidoItem_pedido());
            pst.setInt(2, Item.getPedidoItem_cod());
            pst.setString(3, Item.getPedidoItem_produto());
            pst.setDouble(4, Item.getPedidoItem_quantidade());
            pst.setDouble(5, Item.getPedidoItem_valor());
            pst.setDouble(6, Item.getPedidoItem_total());
            pst.setInt(7, Item.getPedidoItem_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }
    }

    public void remove(int Id) {
        sql = "delete from pedidoitem where PedidoItem_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());
        }
    }

    public ItemPedido_mdl selecionar(int Id) {
        ItemPedido_mdl Item = new ItemPedido_mdl();
        sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem "
                + "where PedidoItem_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Item.setPedidoItem_id(Resultado.getInt("pedidoItem_id"));
            Item.setPedidoItem_pedido(Resultado.getInt("pedidoItem_pedido"));
            Item.setPedidoItem_cod(Resultado.getInt("pedidoItem_cod"));
            Item.setPedidoItem_produto(Resultado.getString("pedidoItem_produto"));
            Item.setPedidoItem_quantidade(Resultado.getDouble("pedidoItem_quantidade"));
            Item.setPedidoItem_valor(Resultado.getDouble("pedidoItem_valor"));
            Item.setPedidoItem_total(Resultado.getDouble("pedidoItem_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ao recupera objeto do banco: " + ex.getMessage());
        }
        return Item;
    }

    public ArrayList<ItemPedido_mdl> tudo() {
        ArrayList<ItemPedido_mdl> ListaItem = new ArrayList<>();
        sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem ";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                ItemPedido_mdl Item = new ItemPedido_mdl();

                Item.setPedidoItem_id(Resultado.getInt("pedidoItem_id"));
                Item.setPedidoItem_pedido(Resultado.getInt("pedidoItem_pedido"));
                Item.setPedidoItem_cod(Resultado.getInt("pedidoItem_cod"));
                Item.setPedidoItem_produto(Resultado.getString("pedidoItem_produto"));
                Item.setPedidoItem_quantidade(Resultado.getDouble("pedidoItem_quantidade"));
                Item.setPedidoItem_valor(Resultado.getDouble("pedidoItem_valor"));
                Item.setPedidoItem_total(Resultado.getDouble("pedidoItem_total"));

                ListaItem.add(Item);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());;
        }
        return ListaItem;
    }

    public ArrayList<ItemPedido_mdl> tudo(String campo, String pesquisa) {
        ArrayList<ItemPedido_mdl> ListaItem = new ArrayList<>();

        switch (campo) {
            case "0":
                sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem where pedidoItem_id like ?";
                break;
            case "1":
                sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem where pedidoItem_pedido like ?";
                break;
            case "2":
                sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem where pedidoItem_cod like ?";
                break;
            case "3":
                sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem where pedidoItem_produto like ?";
                break;
            case "4":
                sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem where pedidoItem_quantidade like ?";
                break;
            case "5":
                sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem where pedidoItem_valor like ?";
                break;
            case "6":
                sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem where pedidoItem_total like ?";
                break;
        }

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, pesquisa);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                ItemPedido_mdl Item = new ItemPedido_mdl();

                Item.setPedidoItem_id(Resultado.getInt("pedidoItem_id"));
                Item.setPedidoItem_pedido(Resultado.getInt("pedidoItem_pedido"));
                Item.setPedidoItem_cod(Resultado.getInt("pedidoItem_cod"));
                Item.setPedidoItem_produto(Resultado.getString("pedidoItem_produto"));
                Item.setPedidoItem_quantidade(Resultado.getDouble("pedidoItem_quantidade"));
                Item.setPedidoItem_valor(Resultado.getDouble("pedidoItem_valor"));
                Item.setPedidoItem_total(Resultado.getDouble("pedidoItem_total"));

                ListaItem.add(Item);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());;
        }
        return ListaItem;
    }

    public ItemPedido_mdl ultimo() {
        ItemPedido_mdl Item = new ItemPedido_mdl();
        sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem "
                + "where pedidoItem_id = (select  MAX(pedidoItem_id) as pedidoItem_id from pedidoItem)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Item.setPedidoItem_id(Resultado.getInt("pedidoItem_id"));
            Item.setPedidoItem_pedido(Resultado.getInt("pedidoItem_pedido"));
            Item.setPedidoItem_cod(Resultado.getInt("pedidoItem_cod"));
            Item.setPedidoItem_produto(Resultado.getString("pedidoItem_produto"));
            Item.setPedidoItem_quantidade(Resultado.getDouble("pedidoItem_quantidade"));
            Item.setPedidoItem_valor(Resultado.getDouble("pedidoItem_valor"));
            Item.setPedidoItem_total(Resultado.getDouble("pedidoItem_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return Item;
    }

    public ItemPedido_mdl primeiro() {
        ItemPedido_mdl Item = new ItemPedido_mdl();
        sql = "select PedidoItem_id, pedidoItem_id, pedidoItem_pedido, pedidoItem_cod, pedidoItem_produto , pedidoItem_quantidade, pedidoItem_valor, pedidoItem_total from PedidoItem "
                + "where pedidoItem_id = (select  MIN(pedidoItem_id) as pedidoItem_id from pedidoItem)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Item.setPedidoItem_id(Resultado.getInt("pedidoItem_id"));
            Item.setPedidoItem_pedido(Resultado.getInt("pedidoItem_pedido"));
            Item.setPedidoItem_cod(Resultado.getInt("pedidoItem_cod"));
            Item.setPedidoItem_produto(Resultado.getString("pedidoItem_produto"));
            Item.setPedidoItem_quantidade(Resultado.getDouble("pedidoItem_quantidade"));
            Item.setPedidoItem_valor(Resultado.getDouble("pedidoItem_valor"));
            Item.setPedidoItem_total(Resultado.getDouble("pedidoItem_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return Item;
    }
}
