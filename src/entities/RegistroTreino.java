package entities;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class RegistroTreino {

    private Integer id;
    private String nomeAluno;
    private String nomeInstrutor;
    private List<Treino> treinos = new ArrayList<>();

    public RegistroTreino() {
    }

    public RegistroTreino(Integer id, String nomeAluno, String nomeInstrutor) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.nomeInstrutor = nomeInstrutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void registrarTreino(Integer id, Date horaInicial, Date horaFinal){
        Treino treino = new Treino(id, horaInicial, horaFinal);
        treino.agendarTreino();
        treinos.add(treino);
    }

    public void encerrarTreino() {
        for (Treino treino : treinos) {
            treino.encerrarTreino(String.valueOf(treino.getHoraFinal()));
        }
    }
}
