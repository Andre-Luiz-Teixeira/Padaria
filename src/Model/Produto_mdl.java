/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author André Teixeira
 */
public class Produto_mdl {
    private int Id;
    private String Nome;
    private double Preco;
    private String Unidade;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public String getUnidade() {
        return Unidade;
    }

    public void setUnidade(String Unidade) {
        this.Unidade = Unidade;
    }
     
    public String[] tovetor(){
        String vetor[] = new String[4];
        
        vetor[0] = String.valueOf(getId());
        vetor[1] = getNome();
        vetor[2] = String.valueOf(getPreco());
        vetor[3] = getUnidade();
        
        return vetor;
    }

    public void vetorto(String[] dados) {
        this.setId(Integer.parseInt(dados[0]));
        this.setNome(dados[1]);
        this.setPreco(Double.parseDouble(dados[2]));
        this.setUnidade(dados[3]);
    }
}
