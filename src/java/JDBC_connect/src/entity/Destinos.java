package entity;

public class Destinos {

    private int id_destino;
    private String nome;
    private String descricao;

    public Destinos(){}
    public Destinos (String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Destinos [id_destino=" + id_destino + ", nome=" + nome + ", descricao=" + descricao + "]";
    }

    public int getId_destino() {
        return id_destino;
    }

    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
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
    };

}
