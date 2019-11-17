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
public class Vendedor_mdl {

    private int Id;
    private String Nome;
    private String Sexo;
    private int idade;
    
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
    
    public String getSexo() {
        return Sexo;
    }
    
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String[] tovetor() {
        String vetor[] = new String[4];
        
        vetor[0] = String.valueOf(getId());
        vetor[1] = getNome();
        vetor[2] = getSexo();
        vetor[3] = String.valueOf(getIdade());
        
        return vetor;
    }
    
    public void vetorto(String[] dados) {
        this.setId(Integer.parseInt(dados[0]));
        this.setNome(dados[1]);
        this.setSexo(dados[2]);
        this.setIdade(Integer.parseInt(dados[3]));
    }
}
