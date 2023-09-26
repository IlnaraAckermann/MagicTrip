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
    private Destinos destino;
    private Usuario usuario;
    private Vendedor vendedor;
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
    public Destinos getDestino() {
        return destino;
    }
    public void setDestino(Destinos destino) {
        this.destino = destino;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
