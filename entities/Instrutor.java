package entities;

public class Instrutor extends Pessoa {

    private String senha;
    private Registro registro;

    public Instrutor() {
    }

    public Instrutor(String cpf, String nome, String email, String dataNascimento, String senha) {
        super(cpf, nome, email, dataNascimento);
        this.senha = senha;
        registro = new Registro();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public void criarTreino(Treino treino, Aluno aluno) {
        registro.addTreino(treino, aluno);
    }

    public void consultarAlunos() {
        registro.consultarAlunos();
    }

    public void consultarAlunosOrdenado() {
        registro.consultarAlunosOrdenado();
    }

    public void consultarTreino(Integer id) {
        registro.consultarTreino(id);
    }
}
