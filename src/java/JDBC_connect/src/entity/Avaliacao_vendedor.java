package entity;

public class Avaliacao_vendedor {
    private int nota;
    private String comentario;
    private int id_vendedor;

    @Override
    public String toString() {
        return "Avaliacao_vendedor [nota=" + nota + ", comentario=" + comentario + ", id_vendedor=" + id_vendedor + "]";
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
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
