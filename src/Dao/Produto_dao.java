/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Produto_mdl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André Teixeira
 */
public class Produto_dao {
    // variaveis usadas em todas as clases
    Connection conexao = FabricaConexao.GeraConexao(); // Gera conexao com o banco
    String sql = "";// recebe o comando no sql
    PreparedStatement pst;

    public void inserir(Produto_mdl produto) {
        sql = "insert into produto(produto_nome, produto_preco, produto_unidade) values (?, ?, ?)";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getPreco());
            pst.setString(3, produto.getUnidade());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar o objeto: " + ex.getMessage());
        }
    }

    public void update(Produto_mdl produto) {
        sql = "update produto set produto_nome = ? , produto_preco = ?, produto_unidade = ? where  produto_id = ? ";

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getPreco());
            pst.setString(3, produto.getUnidade());
            pst.setInt(4, produto.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar o objeto: " + ex.getMessage());
        }
    }

    public void remove(int Id) {
        sql = "delete from produto where produto_id = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro ao excluir objeto do banco: " + ex.getMessage());
        }
    }

    public Produto_mdl selecionar(int Id) {
        Produto_mdl produto = new Produto_mdl();
        sql = "select * from produto where produto_id= ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, Id);

            ResultSet Resultado = pst.executeQuery();

            produto.setId(Resultado.getInt("produto_id"));
            produto.setNome(Resultado.getString("produto_nome"));
            produto.setPreco(Resultado.getDouble("produto_preco"));
            produto.setUnidade(Resultado.getString("produto_unidade"));

        } catch (SQLException ex) {
            System.err.println("Erro ao recupera objeto do banco: " + ex.getMessage());
        }
        return produto;
    }

    public ArrayList<Produto_mdl> tudo() {
        ArrayList<Produto_mdl> ListaProduto = new ArrayList<>();
        sql = "select * from produto";

        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            while (Resultado.next()) {
                Produto_mdl produto = new Produto_mdl();

                produto.setId(Resultado.getInt("id"));
                produto.setNome(Resultado.getString("nome"));
                produto.setPreco(Resultado.getDouble("preco"));
                produto.setUnidade(Resultado.getString("unidade"));

                ListaProduto.add(produto);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao recupera todos objeto do banco: " + ex.getMessage());
        }
        return ListaProduto;
    }

    public Produto_mdl ultimo() {
            Produto_mdl produto = new Produto_mdl();
        sql = "select produto_id, produto_nome, produto_preco, produto_unidade from produto where produto_id = (select  MAX(produto_id) from produto) ";
        
        try {
            pst = conexao.prepareStatement(sql);
            ResultSet Resultado = pst.executeQuery();

            if (Resultado.next()) {
                produto.setId(Resultado.getInt("produto_id"));
                produto.setNome(Resultado.getString("produto_nome"));
                produto.setPreco(Resultado.getDouble("produto_preco"));
                produto.setUnidade(Resultado.getString("produto_unidade"));
            }
        } catch (SQLException ex) {
            System.err.println("Erro ão recupera objeto do banco: " + ex.getMessage());
        }
        return null;
    }
}
