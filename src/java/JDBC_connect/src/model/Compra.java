package model;

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
    private int id_compra;

    // contrutores

    public Compra() {
    }

    public Compra(BigDecimal valor, int qnt_pessoas, String tipo_pacote, BigDecimal comissao, Date data_fim,
            Date data_inicio, Destinos destino, Usuario usuario, Vendedor vendedor) {
        this.valor = valor;
        this.qnt_pessoas = qnt_pessoas;
        this.tipo_pacote = tipo_pacote;
        this.comissao = comissao;
        this.data_fim = data_fim;
        this.data_inicio = data_inicio;
        this.destino = destino;
        this.usuario = usuario;
        this.vendedor = vendedor;
    }

    public Compra(BigDecimal valor, int qnt_pessoas, String tipo_pacote, Date data_fim, Date data_inicio,
            Destinos destino, Usuario usuario) {
        this.valor = valor;
        this.qnt_pessoas = qnt_pessoas;
        this.tipo_pacote = tipo_pacote;
        this.data_fim = data_fim;
        this.data_inicio = data_inicio;
        this.destino = destino;
        this.usuario = usuario;
        this.vendedor = null;
        this.comissao = null;
    }

    // metodos

    @Override
    public String toString() {
        return "Compra [valor=" + valor + ", qnt_pessoas=" + qnt_pessoas + ", tipo_pacote=" + tipo_pacote
                + ", comissao=" + comissao + ", data_fim=" + data_fim + ", data_inicio=" + data_inicio + ", destino="
                + destino.getId_destino() + ", usuario=" + usuario.getId_usuario() + ", vendedor=" + vendedor.getId_vendedor() + ", id_compra=" + id_compra + "]";
    }

    // getters e setters
    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

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
