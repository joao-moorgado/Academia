package entities;

public class Pessoa {

    private String cpf;
    private String nome;
    private String email;
    private String dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String cpf, String nome, String email, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
