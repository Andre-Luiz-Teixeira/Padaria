/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente_mdl;
import Model.PedidoFK_mdl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class PedidoFK_dao {

    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void inserir(PedidoFK_mdl Pedido) {
        sql = "insert into pedido(vendedor_id, cliente_id, pedido_total) values (?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Pedido.getVendedor_id());
            pst.setInt(2, Pedido.getCliente_id());
            pst.setDouble(3, Pedido.getPedido_total());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
    }

    public void update(PedidoFK_mdl Pedido) {
        sql = "update pedido set vendedor_id = ? , cliente_id = ? , pedido_total = ? where Pedido_id = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Pedido.getVendedor_id());
            pst.setInt(2, Pedido.getCliente_id());
            pst.setDouble(3, Pedido.getPedido_total());
            pst.setInt(4, Pedido.getPedido_id());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }
    }

    public void remove(int Id) {
        sql = "delete from pedido where Pedido_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());
        }
    }

    public PedidoFK_mdl selecionar(int Id) {
        PedidoFK_mdl Pedido = new PedidoFK_mdl();
        sql = "select Pedido_id, vendedor_id, cliente_id, pedido_total from pedido where Pedido_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Pedido.setPedido_id(Resultado.getInt("Pedido_id"));
            Pedido.setVendedor_id(Resultado.getInt("vendedor_id"));
            Pedido.setCliente_id(Resultado.getInt("cliente_id"));
            Pedido.setPedido_total(Resultado.getDouble("pedido_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ao recupera objeto do banco: " + ex.getMessage());
        }

        return Pedido;
    }

    public ArrayList<PedidoFK_mdl> tudo() {
        ArrayList<PedidoFK_mdl> ListaPedido = new ArrayList<>();
        sql = "select Pedido_id, vendedor_id, cliente_id, pedido_total from pedido";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                PedidoFK_mdl Pedido = new PedidoFK_mdl();

                Pedido.setPedido_id(Resultado.getInt("Pedido_id"));
                Pedido.setVendedor_id(Resultado.getInt("vendedor_id"));
                Pedido.setCliente_id(Resultado.getInt("cliente_id"));
                Pedido.setPedido_total(Resultado.getDouble("pedido_total"));

                ListaPedido.add(Pedido);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());;
        }
        return ListaPedido;
    }

    public PedidoFK_mdl ultimo() {
        PedidoFK_mdl Pedido = new PedidoFK_mdl();
        sql = "select Pedido_id, vendedor_id, cliente_id, pedido_total from pedido where Pedido_id = (select  MAX(Pedido_id) as Pedido_id from pedido)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Pedido.setPedido_id(Resultado.getInt("Pedido_id"));
            Pedido.setVendedor_id(Resultado.getInt("vendedor_id"));
            Pedido.setCliente_id(Resultado.getInt("cliente_id"));
            Pedido.setPedido_total(Resultado.getDouble("pedido_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return Pedido;
    }

    public PedidoFK_mdl primeiro() {
        PedidoFK_mdl Pedido = new PedidoFK_mdl();
        sql = "select Pedido_id, vendedor_id, cliente_id, pedido_total from pedido where Pedido_id = (select  MIN(Pedido_id) as Pedido_id from pedido)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();
            Resultado.next();

            Pedido.setPedido_id(Resultado.getInt("Pedido_id"));
            Pedido.setVendedor_id(Resultado.getInt("vendedor_id"));
            Pedido.setCliente_id(Resultado.getInt("cliente_id"));
            Pedido.setPedido_total(Resultado.getDouble("pedido_total"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return Pedido;
    }
}
