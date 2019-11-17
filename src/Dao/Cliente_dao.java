/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente_mdl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Cliente_dao {

    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void inserir(Cliente_mdl Cliente) {
        sql = "insert into cliente(cliente_nome, cliente_sexo) values (?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Cliente.getNome());
            pst.setString(2, Cliente.getSexo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
    }

    public void update(Cliente_mdl Cliente) {
        sql = "update cliente set cliente_nome = ?, cliente_sexo = ? where cliente_id = ? ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, Cliente.getNome());
            pst.setString(2, Cliente.getSexo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }
    }

    public void remove(int Id) {
        sql = "delete from cliente where cliente_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());
        }
    }

    public Cliente_mdl selecionar(int Id) {
        Cliente_mdl cliente = new Cliente_mdl();
        sql = "select * from cliente where cliente_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            ResultSet resultado = pst.executeQuery();

            cliente.setId(resultado.getInt("cliente_id"));
            cliente.setNome(resultado.getString("cliente_nome"));
            cliente.setSexo(resultado.getString("cliente_sexo"));

        } catch (SQLException ex) {
            System.err.println("Erro ao recupera objeto do banco: " + ex.getMessage());
        }

        return cliente;
    }

    public ArrayList<Cliente_mdl> tudo() {
        ArrayList<Cliente_mdl> ListaCliente = new ArrayList<>();
        sql = "select * from cliente";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                Cliente_mdl cliente = new Cliente_mdl();

                cliente.setId(Resultado.getInt("id"));
                cliente.setNome(Resultado.getString("nome"));
                cliente.setSexo(Resultado.getString("sexo"));

                ListaCliente.add(cliente);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());;
        }

        return ListaCliente;
    }

    public Cliente_mdl ultimo() {
        Cliente_mdl cliente = new Cliente_mdl();
        sql = "select cliente_id, cliente_nome, cliente_sexo from cliente where cliente_id = (select  MAX(cliente_id) as cliente_id from cliente)";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            cliente.setId(Resultado.getInt("cliente_id"));
            cliente.setNome(Resultado.getString("cliente_nome"));
            cliente.setSexo(Resultado.getString("cliente_sexo"));

        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }

        return cliente;
    }
}
