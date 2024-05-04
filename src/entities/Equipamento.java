package entities;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

public class Equipamento {

    private Integer id;
    private String nome;
    private String descricao;
    private boolean status;
    private TreinoEquipamento idTreino;

    public Equipamento() {
    }

    public Equipamento(Integer id, String nome, String descricao, boolean status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getstatus() {
        return status;
    }

    public void setstatus(boolean status) {
        this.status = status;
    }

    public TreinoEquipamento getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(TreinoEquipamento idTreino) {
        this.idTreino = idTreino;
    }

    public void reservarEquipamento(){
        if (status == true) {
            System.out.print("Equipamento ocupado.");
        } else {
            status = true;
        }
    }

    public void liberarEquipamento(String horaFinal){
        if (LocalTime.now() == LocalTime.parse(horaFinal)){
            status = false;
        }
    }
}
