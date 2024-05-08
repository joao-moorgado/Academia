package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Treino {
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer id;
    private LocalDate data;
    private Turno turno;
    private String idAluno;
    private List<entities.Equipamento> equipamentos;

    public Treino() {
    }

    public Treino(Integer id, LocalDate data, Turno turno, String idAluno) {
        this.id = id;
        this.data = data;
        this.turno = turno;
        this.idAluno = idAluno;
        equipamentos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public List<entities.Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void salvarTreino() {
        for (entities.Equipamento e : equipamentos) {
            e.setStatus(true);
        }
    }

    public void addEquipamento(entities.Equipamento e) {
        equipamentos.add(e);
    }

    public void consultarTreino() {
        System.out.println("Data do treino: " + data.format(dtf) + "\nTurno: " + turno.name() + "\nAlunoCPF: "
                + idAluno + "\nEquipamentos: " + equipamentos);
    }

    @Override
    public String toString() {
        return id +
                "," + data +
                "," + turno +
                "," + idAluno +
                "," + equipamentos;
    }
}
