package entity;

public class Avaliacao_vendedor {
    private int nota;
    private String comentario;

    private Vendedor vendedor;

    public Avaliacao_vendedor() {
    }

    public Avaliacao_vendedor(int nota, Vendedor vendedor){
        this.nota= nota;
        this.vendedor = vendedor;
        this.comentario = null;
    }

    public Avaliacao_vendedor(int nota, Vendedor vendedor, String comentario){
        this.nota= nota;
        this.vendedor = vendedor;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao_vendedor [nota=" + nota + ", comentario=" + comentario + ", id_vendedor="
                + vendedor.getId_vendedor() + "]";
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
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
