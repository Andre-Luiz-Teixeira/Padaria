/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Vendedor_mdl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Vendedor_dao {

    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void inserir(Vendedor_mdl vendedor) {
        sql = "insert into vendedor(vendedor_nome, vendedor_sexo, vendedor_idade) values (?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, vendedor.getNome());
            pst.setString(2, vendedor.getSexo());
            pst.setInt(3, vendedor.getIdade());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }

    }

    public void update(Vendedor_mdl vendedor) {
        sql = "update vendedor set vendedor_nome = ? , vendedor_sexo = ?, vendedor_idade = ? where  vendedor_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, vendedor.getNome());
            pst.setString(2, vendedor.getSexo());
            pst.setInt(3, vendedor.getIdade());
            pst.setInt(4, vendedor.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }
    }

    public void remove(int Id) {
        sql = "delete from vendedor where vendedor_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);
            pst.execute();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());
        }
    }

    public Vendedor_mdl selecionar(int Id) {
        sql = "select vendedor_id, vendedor_nome, vendedor_sexo, vendedor_idade from vendedor where vendedor_id = ?";
        Vendedor_mdl vendedor = new Vendedor_mdl();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            ResultSet Resultado = pst.executeQuery();

            vendedor.setId(Resultado.getInt("vendedor_id"));
            vendedor.setNome(Resultado.getString("vendedor_nome"));
            vendedor.setSexo(Resultado.getString("vendedor_sexo"));
            vendedor.setIdade(Resultado.getInt("vendedor_idade"));
        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }
        return vendedor;
    }

    public ArrayList<Vendedor_mdl> tudo() {
        sql = "select vendedor_id, vendedor_nome, vendedor_sexo, vendedor_idade from vendedor";
        ArrayList<Vendedor_mdl> ListaVendedor = new ArrayList<>();

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                Vendedor_mdl vendedor = new Vendedor_mdl();

                vendedor.setId(Resultado.getInt("vendedor_id"));
                vendedor.setNome(Resultado.getString("vendedor_nome"));
                vendedor.setSexo(Resultado.getString("vendedor_sexo"));
                vendedor.setIdade(Resultado.getInt("vendedor_idade"));

                ListaVendedor.add(vendedor);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());
        }
        return ListaVendedor;
    }

    public Vendedor_mdl ultimo() {
        sql = "select vendedor_id, vendedor_nome, vendedor_sexo, vendedor_idade from vendedor where id = (select  MAX(vendedor_id) from vendedor) ";
        Vendedor_mdl vendedor = new Vendedor_mdl();

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            vendedor.setId(Resultado.getInt("vendedor_id"));
            vendedor.setNome(Resultado.getString("vendedor_nome"));
            vendedor.setSexo(Resultado.getString("vendedor_sexo"));
            vendedor.setIdade(Resultado.getInt("vendedor_idade"));
        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }
        return vendedor;
    }
}