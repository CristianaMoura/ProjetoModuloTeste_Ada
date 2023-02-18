package model;

/**
 * @author CrisMoura on 17/02/2023
 */
public class Cliente {
    String nome;
    String telefone;
    Integer id;

    Celular celular;

    public Cliente(String nome, String telefone, Integer id, Celular celular) {
        this.nome = nome;
        this.telefone = telefone;
        this.id = id;
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }
}
