package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Aluno extends Pessoa{

    private Double altura;
    private Double peso;
    private Double gordura;
    private char sexo;
    private List<Pessoa> alunos = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(Integer id, String nome, String email, String telefone, Date nascimento, Integer idade, Double altura, Double peso, Double gordura, char sexo) {
        super(id, nome, email, telefone, nascimento, idade);
        this.altura = altura;
        this.peso = peso;
        this.gordura = gordura;
        this.sexo = sexo;
    }

    public Aluno(Aluno aluno){
        super(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getNascimento(), aluno.getIdade());
        altura = aluno.getAltura();
        peso = aluno.getPeso();
        gordura = aluno.getGordura();
        sexo = aluno.getSexo();
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getGordura() {
        return gordura;
    }

    public void setGordura(Double gordura) {
        this.gordura = gordura;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void adicionar(Aluno pessoa){
        Pessoa p = new Aluno(pessoa);
        alunos.add(p);
    }

    public void remover(Integer id){
        boolean status = false;
        for(Pessoa p : alunos){
            if (p.getId() == id) {
                status = true;
                alunos.remove(p);
            }
        }
        if (!status) {
        System.out.print("Usuário não encontrado");
    }
        }

    public Pessoa pesquisar(Integer id){
        boolean status = false;
        for(Pessoa p : alunos){
            if (p.getId() == id) {
                status = true;
                return p;
            }
        }
        if (!status) {
            System.out.print("Usuário não encontrado");
        }
        return null;
    }

    public void listar(){
        for(Pessoa p : alunos) {
            System.out.println(p);
        }
    }

    public void listarOrdenado(){
        alunos.sort(Comparator.comparing(Pessoa::getNome));
        for(Pessoa p : alunos) {
            System.out.println(p);
        }
    }
}
