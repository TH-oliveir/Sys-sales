package br.com.trabalhoav2.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem")
    private Integer id;

    @Column(name = "nome_item")
    private String nome;

    @Column(name = "unidade_item")
    private Integer unidade;

    @Column(name = "valor_item")
    private Float valor;

    public Item() {
        this(null, null, null);
    }

    public Item(String nome, Integer unidade, Float valor) {
        this.nome = nome;
        this.unidade = unidade;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", unidade: " + unidade +
                ", valor: " + valor +
                '}';
    }
}
