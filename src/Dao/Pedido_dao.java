/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Pedido_mdl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Pedido_dao {

    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void inserir(Pedido_mdl Pedido) {
        sql = "insert into pedido(pedido_vendedor, pedido_cliente, pedido_total) values (?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Pedido.getPedido_vendedor());
            pst.setString(2, Pedido.getPedido_cliente());
            pst.setDouble(3, Pedido.getPedido_total());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
    }

    public void update(Pedido_mdl Pedido) {
        sql = "update pedido set pedido_vendedor = ?, pedido_cliente = ?, pedido_total = ? where pedido_id = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Pedido.getPedido_vendedor());
            pst.setString(2, Pedido.getPedido_cliente());
            pst.setDouble(3, Pedido.getPedido_total());
            pst.setInt(4, Pedido.getPedido_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }
    }

    public void remove(int Id) {
        sql = "delete from pedido where pedido_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());
        }
    }

    public Pedido_mdl selecionar(int Id) {
        Pedido_mdl pedido = new Pedido_mdl();
        sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido where pedido_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            ResultSet resultado = pst.executeQuery();
            resultado.next();

            pedido.setPedido_id(resultado.getInt("pedido_id"));
            pedido.setPedido_vendedor(resultado.getString("pedido_vendedor"));
            pedido.setPedido_cliente(resultado.getString("pedido_cliente"));
            pedido.setPedido_total(resultado.getDouble("pedido_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ao recupera objeto do banco: " + ex.getMessage());
        }

        return pedido;
    }

    public ArrayList<Pedido_mdl> tudo() {
        ArrayList<Pedido_mdl> ListaPedido = new ArrayList<>();
        sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                Pedido_mdl pedido = new Pedido_mdl();

                pedido.setPedido_id(Resultado.getInt("pedido_id"));
                pedido.setPedido_vendedor(Resultado.getString("pedido_vendedor"));
                pedido.setPedido_cliente(Resultado.getString("pedido_cliente"));
                pedido.setPedido_total(Resultado.getDouble("pedido_total"));

                ListaPedido.add(pedido);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());;
        }

        return ListaPedido;
    }

    public ArrayList<Pedido_mdl> tudo(String campo, String pesquisa) {
        ArrayList<Pedido_mdl> ListaPedido = new ArrayList<>();

        switch (campo) {
            case "0":
                sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido where pedido_id like ?";
                break;
            case "1":
                sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido where pedido_vendedor like ?";
                break;
            case "2":
                sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido where pedido_cliente like ?";
                break;
            case "3":
                sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido where pedido_total like ?";
                break;
        }

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, pesquisa);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                Pedido_mdl pedido = new Pedido_mdl();

                pedido.setPedido_id(Resultado.getInt("pedido_id"));
                pedido.setPedido_vendedor(Resultado.getString("pedido_vendedor"));
                pedido.setPedido_cliente(Resultado.getString("pedido_cliente"));
                pedido.setPedido_total(Resultado.getDouble("pedido_total"));

                ListaPedido.add(pedido);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());;
        }
        return ListaPedido;
    }

    public Pedido_mdl ultimo() {
        Pedido_mdl pedido = new Pedido_mdl();
        sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido where pedido_id = (select  MAX(pedido_id) as pedido_id from pedido)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            pedido.setPedido_id(Resultado.getInt("pedido_id"));
            pedido.setPedido_vendedor(Resultado.getString("pedido_vendedor"));
            pedido.setPedido_cliente(Resultado.getString("pedido_cliente"));
            pedido.setPedido_total(Resultado.getDouble("pedido_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return pedido;
    }

    public Pedido_mdl primeiro() {
        Pedido_mdl pedido = new Pedido_mdl();
        sql = "select pedido_id, pedido_vendedor, pedido_cliente, pedido_total from pedido where pedido_id = (select  MIN(pedido_id) as pedido_id from pedido)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            pedido.setPedido_id(Resultado.getInt("pedido_id"));
            pedido.setPedido_vendedor(Resultado.getString("pedido_vendedor"));
            pedido.setPedido_cliente(Resultado.getString("pedido_cliente"));
            pedido.setPedido_total(Resultado.getDouble("pedido_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return pedido;
    }
}
