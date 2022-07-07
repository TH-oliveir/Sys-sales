package br.com.trabalhoav2;

import br.com.trabalhoav2.config.Connect;
import br.com.trabalhoav2.entity.Pessoa;
import br.com.trabalhoav2.repository.PessoaRepository;
import br.com.trabalhoav2.service.ClienteService;
import br.com.trabalhoav2.service.FuncionarioService;
import br.com.trabalhoav2.service.ItemService;
import br.com.trabalhoav2.service.VendaService;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FuncionarioService funcionarioService = FuncionarioService.funcionarioService;
        ItemService itemService = ItemService.service;
        ClienteService clienteService = ClienteService.service;
        VendaService vendaService = VendaService.service;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Qual opção deseja executar: ");
            System.out.println("1 - Visualizar os Itens");
            System.out.println("2 - Visualizar os funcionarios");
            System.out.println("3 - Visualizar os Clientes");
            System.out.println("4 - Cadastro de Cliente");
            System.out.println("5 - Cadastro de Funcionario");
            System.out.println("6 - Cadastro de Item");
            System.out.println("7 - Efetuar Venda");
            System.out.println("----------------------------------");
            System.out.println("SAIR - Encerrar o programa.\n");
            String texto = scanner.nextLine();
            switch (texto.toUpperCase(Locale.ROOT)){
                case "1":
                    itemService.listar();
                    break;
                case "2":
                    funcionarioService.listar();
                    break;
                case "3":
                    clienteService.listar();
                    break;
                case "4":
                    clienteService.cadastrar();
                    break;
                case "5":
                    funcionarioService.cadastrarFuncionario();
                    break;
                case "6":
                    itemService.cadastrar();
                    break;
                case "7":
                    vendaService.realizarVenda();
                    break;
                case "SAIR":
                    System.out.println("Programa Encerrado!!!!");
                    System.exit(0);
            }

        }
    }
}
