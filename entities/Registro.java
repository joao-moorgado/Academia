package entities;

import java.util.ArrayList;
import java.util.List;

public class Registro {

    private Integer id;
    private List<Aluno> alunos = new ArrayList<>();
    private List<Treino> treinos = new ArrayList<>();

    public Registro() {
    }

    public Registro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void addTreino(Treino treino, Aluno aluno) {
        treino.salvarTreino(aluno);
        treinos.add(treino);
        alunos.add(aluno);
    }

    public void consultarAlunos() {
        for(Aluno a : alunos) {
            System.out.println("Nome: " + a.getNome());
        }
    }

    public void consultarAlunosOrdenado() {
        List<Aluno> list = alunos;
        list.sort((x, y) -> x.getNome().compareTo(y.getNome()));
        for (Aluno a : list) {
            System.out.println("Nome: " + a.getNome());
        }
    }

    public void consultarTreino(Integer id2) {
        for (Treino t : treinos) {
            if (t.getId() == id2) {
                t.consultarTreino();
            }
        }
    }

}
