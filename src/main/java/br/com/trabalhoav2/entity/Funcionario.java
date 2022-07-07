package br.com.trabalhoav2.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private float salario;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, float salario) {
        super(nome, cpf);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "id: " + super.getId() + "\n" +
                "nome: '" + super.getNome() + "'\n"+
                "cpf: '" + super.getCpf() + "'\n" +
                "salario: " + salario;
    }
}

