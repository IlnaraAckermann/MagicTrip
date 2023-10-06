package model;

public class Usuario {
    private int id_usuario;
    private String cpf;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String nome_primeiro;
    private String nome_meio;
    private String nome_ultimo;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String cpf, String logradouro, int numero, String complemento, String cep,
            String bairro, String cidade, String estado, String nome_primeiro, String nome_meio,
            String nome_ultimo, String email, String senha) {
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.nome_primeiro = nome_primeiro;
        this.nome_meio = nome_meio;
        this.nome_ultimo = nome_ultimo;
        this.email = email;
        this.senha = senha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome_primeiro() {
        return nome_primeiro;
    }

    public void setNome_primeiro(String nome_primeiro) {
        this.nome_primeiro = nome_primeiro;
    }

    public String getNome_meio() {
        return nome_meio;
    }

    public void setNome_meio(String nome_meio) {
        this.nome_meio = nome_meio;
    }

    public String getNome_ultimo() {
        return nome_ultimo;
    }

    public void setNome_ultimo(String nome_ultimo) {
        this.nome_ultimo = nome_ultimo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [id_usuario=" + id_usuario + ", cpf=" + cpf + ", logradouro=" + logradouro + ", numero="
                + numero + ", complemento=" + complemento + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade
                + ", estado=" + estado + ", nome_primeiro=" + nome_primeiro + ", nome_meio=" + nome_meio
                + ", nome_ultimo=" + nome_ultimo + ", email=" + email + ", senha=" + senha + "]";
    }

}
