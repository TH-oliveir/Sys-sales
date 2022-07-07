package br.com.trabalhoav2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Cliente extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "endereco")
    private String endereco;

    public Cliente() {
        this(null, null, null);
    }

    public Cliente(String nome, String cpf, String endereco) {
        super(nome, cpf);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return
                "Id: " + super.getId() +
                        " Nome: '" + super.getNome() + '\'' +
                        " CPF: '" + super.getCpf() + '\'' +
                        " Endereco: '" + endereco + '\n';
    }
}
