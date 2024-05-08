package entities;

public class Aluno extends Pessoa {

    private Double peso;
    private Double altura;

    public Aluno() {
    }

    public Aluno(String cpf, String nome, String email, String dataNascimento, Double peso, Double altura) {
        super(cpf, nome, email, dataNascimento);
        this.peso = peso;
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return super.getCpf() +
                "," + super.getNome() +
                "," + super.getEmail() +
                "," + super.getDataNascimento() +
                "," + peso +
                "," + altura;
    }
}
