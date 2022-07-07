package br.com.trabalhoav2.service;

import br.com.trabalhoav2.entity.Funcionario;
import br.com.trabalhoav2.repository.FuncionarioRepository;

import java.util.List;
import java.util.Scanner;

public class FuncionarioService {

    public static final FuncionarioService funcionarioService = new FuncionarioService();
    private FuncionarioRepository repository = FuncionarioRepository.repository;

    private FuncionarioService() {
    }

    public void cadastrarFuncionario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do funcionario(a): ");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do funcionario(a): ");
        String cpf = scanner.nextLine();
        System.out.println("Informe o salario do funcionario(a): ");
        String salario = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome,cpf,Float.valueOf(salario));
        repository.cadastrar(funcionario);
        System.out.println("Fucnionario cadastrado!\n");
    }
    public void listar(){
        List<Funcionario> funcionarios = repository.listar();
        for (Funcionario funcionario:funcionarios){
            System.out.println("****");
            System.out.println(funcionario);
            System.out.println("\n");
        }
    }

}
