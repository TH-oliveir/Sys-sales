package br.com.trabalhoav2.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED) // usado para que as classes que herdrem virem tabelas
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa")
    private Integer idPessoa;

    @Column(name = "nome_pessoa")
    private String nome;

    @Column(name = "cpf_pessoa")
    private String cpf;

    public Pessoa() {
        this(null,null);
    }

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Integer getId() {
        return idPessoa;
    }

    public void setId(Integer id) {
        this.idPessoa = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
