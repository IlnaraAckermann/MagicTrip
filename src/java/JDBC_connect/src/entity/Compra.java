package entity;
import java.sql.Date;
import java.math.BigDecimal;

public class Compra {
    private BigDecimal valor;
    private int qnt_pessoas;
    private String tipo_pacote;
    private BigDecimal comissao;
    private Date data_fim;
    private Date data_inicio;
    private int id_destino;
    private int id_usuario;
    private int id_vendedor;
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public int getQnt_pessoas() {
        return qnt_pessoas;
    }
    public void setQnt_pessoas(int qnt_pessoas) {
        this.qnt_pessoas = qnt_pessoas;
    }
    public String getTipo_pacote() {
        return tipo_pacote;
    }
    public void setTipo_pacote(String tipo_pacote) {
        this.tipo_pacote = tipo_pacote;
    }
    public BigDecimal getComissao() {
        return comissao;
    }
    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }
    public Date getData_fim() {
        return data_fim;
    }
    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }
    public Date getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }
    public int getId_destino() {
        return id_destino;
    }
    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public int getId_vendedor() {
        return id_vendedor;
    }
    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

}
