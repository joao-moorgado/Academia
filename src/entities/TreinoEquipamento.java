package entities;

public class TreinoEquipamento {

    private Treino idTreino;
    private Equipamento idEquipamento;

    public TreinoEquipamento() {
    }

    public TreinoEquipamento(Treino idTreino, Equipamento idEquipamento) {
        this.idTreino = idTreino;
        this.idEquipamento = idEquipamento;
    }

    public Treino getIdTreino() {
        return idTreino;
    }

    public void setIdTreino(Treino idTreino) {
        this.idTreino = idTreino;
    }

    public Equipamento getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Equipamento idEquipamento) {
        this.idEquipamento = idEquipamento;
    }
}
