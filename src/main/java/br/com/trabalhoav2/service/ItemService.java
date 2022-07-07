package br.com.trabalhoav2.service;

import br.com.trabalhoav2.entity.Item;
import br.com.trabalhoav2.repository.ItemRepository;

import java.util.List;
import java.util.Scanner;

public class ItemService {
    public static final ItemService service = new ItemService();
    private ItemRepository repository = ItemRepository.repository;

    private ItemService() {
    }

    public void cadastrar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do item: ");
        String nome = scanner.nextLine();
        System.out.println("Informe a unidade do item: ");
        String unidade = scanner.nextLine();
        System.out.println("Informe o preco do item: ");
        String valor = scanner.nextLine();

        Item item = new Item(nome,Integer.valueOf(unidade),Float.valueOf(valor));
        repository.cadastrar(item);
        System.out.println("Item cadastrado!\n");
    }

    public void listar(){
        List<Item> items = repository.listar();
        for (Item item:items) {
            System.out.println("****");
            System.out.println(item);
            System.out.println("\n");
        }
    }
}
