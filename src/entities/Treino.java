package entities;

import java.util.Date;

public class Treino {

    private Integer id;
    private Date horaInicial;
    private Date horaFinal;
    private TreinoEquipamento idEquipamento;

    public Treino() {
    }

    public Treino(Integer id, Date horaInicial, Date horaFinal) {
        this.id = id;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Date horaInicial) {
        this.horaInicial = horaInicial;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public TreinoEquipamento getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(TreinoEquipamento idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public void agendarTreino(){
        idEquipamento.getIdEquipamento().reservarEquipamento();
    }

    public void encerrarTreino(String horaFinal){
        idEquipamento.getIdEquipamento().liberarEquipamento(horaFinal);
    }

}
