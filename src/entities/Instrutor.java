package entities;

import java.util.Date;

public class Instrutor extends Pessoa{

    private String senha;

    public Instrutor() {
    }

    public Instrutor(Integer id, String nome, String email, String telefone, Date nascimento, Integer idade, String senha) {
        super(id, nome, email, telefone, nascimento, idade);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void matricularAluno(){

    }

    public void criarRegistro(RegistroTreino registroTreino){

    }

    public RegistroTreino verificarRegistro(){
        return null;
    }
}
