package br.com.trabalhoav2.service;

import br.com.trabalhoav2.entity.Cliente;
import br.com.trabalhoav2.repository.ClienteRepository;

import java.util.List;
import java.util.Scanner;

public class ClienteService {
    public static final ClienteService service = new ClienteService();
    private ClienteRepository repository = ClienteRepository.repository;
    private ClienteService() {
    }

    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do(a) cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do(a) cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("Informe o endereco do(a) cliente: ");
        String endereco = scanner.nextLine();

        repository.cadastrar(new Cliente(nome,cpf,endereco));
        System.out.println("Cliente cadastrado!");
    }
    public void listar(){
        List<Cliente> clientes = repository.listar();
        for(Cliente cliente:clientes){
            System.out.println("****");
            System.out.println(cliente);
        }
    }
}
