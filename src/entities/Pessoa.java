package entities;

import java.util.Date;
import java.util.List;

public class Pessoa {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private Date nascimento;
    private Integer idade;

    public Pessoa(){

    }

    public Pessoa(Integer id, String nome, String email, String telefone, Date nascimento, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.idade = idade;
    }

    public Pessoa(Pessoa pessoa){
        id = pessoa.getId();
        nome = pessoa.getNome();
        email = pessoa.getEmail();
        telefone = pessoa.getTelefone();
        nascimento = pessoa.getNascimento();
        idade = pessoa.getIdade();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nascimento=" + nascimento +
                ", idade=" + idade +
                '}';
    }
}
