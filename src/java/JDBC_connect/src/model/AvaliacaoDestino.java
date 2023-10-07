package model;

public class AvaliacaoDestino {
    private int nota;
    private String comentario;
    private Destinos destino;

    public AvaliacaoDestino(){}
    public AvaliacaoDestino(int nota, Destinos destino){
        this.nota= nota;
        this.destino = destino;
        this.comentario = null;
    }
    public AvaliacaoDestino(int nota, Destinos destino, String comentario){
        this.nota= nota;
        this.destino = destino;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao_destino [nota=" + nota + ", comentario=" + comentario + ", destino=" + destino.getId_destino() + "]";
    }

    public Destinos getDestino() {
        return destino;
    }

    public void setDestino(Destinos destino) {
        this.destino = destino;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
