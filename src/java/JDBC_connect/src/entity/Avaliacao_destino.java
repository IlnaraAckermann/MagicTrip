package entity;

public class Avaliacao_destino {
    private int nota;
    private String comentario;
    private Destinos destino;
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
