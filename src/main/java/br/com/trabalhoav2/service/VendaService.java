package br.com.trabalhoav2.service;

import br.com.trabalhoav2.entity.Venda;

import java.util.Locale;
import java.util.Scanner;

public class VendaService {
    public static final VendaService service = new VendaService();
    private ClienteService clienteService = ClienteService.service;
    private FuncionarioService funcionarioService = FuncionarioService.funcionarioService;
    private ItemService itemService = ItemService.service;
    private VendaService() {
    }

    public void realizarVenda(){
        Scanner scanner = new Scanner(System.in);
        itemService.listar();
        String addItem = "sim";
        Venda venda = new Venda();
        while (addItem.equals("sim")){
            System.out.println("Informe o ID do produto que deseja adicionar ao carrinho: ");
            String idItem = scanner.nextLine();
            System.out.println("Informe a quantidade: ");
            String quantidade = scanner.nextLine();
            venda.adicionarItens(Integer.valueOf(idItem),Integer.valueOf(quantidade));

            System.out.println("\n O total eh: R$ "+ venda.getTotalVenda()+"\n");
            System.out.println("Deseja adicionar mais itens? SIM ou NAO");
            addItem = scanner.nextLine().toLowerCase(Locale.ROOT);
        }
        funcionarioService.listar();
        System.out.println("Informe o ID do funcionario que sera adicionado na venda: ");
        try{
            venda.adicionarFuncionario(scanner.nextInt());
        }catch (NullPointerException e){
            System.out.println("Funcionario nao existe!");
        }
        System.out.println("Funcionario "+ venda.getFuncionario().getNome() + " adicionado na venda!\n" );

        clienteService.listar();
        System.out.println("Informe o ID do Cliente que sera adicionado na venda: ");
        try{
            venda.adicionarCliente(scanner.nextInt());
        }catch(NullPointerException e){
            System.out.println("Cliente nao encontrado!");
        }
        System.out.println("Cliente "+ venda.getCliente().getNome() + " adicionado na venda!\n" );

        System.out.println("Informe o metodo de pagamento: PIX | DINHEIRO | CARTAO");
        String pagamento = scanner.next();
        venda.setPagamento(pagamento);

        System.out.println("****************************");
        System.out.println(">> INFORMACOES DA VENDA <<");
        System.out.println("Total: " + venda.getTotalVenda());
        System.out.println("Funcionario: "+ venda.getFuncionario().getNome().toUpperCase(Locale.ROOT));
        System.out.println("Cliente: "+ venda.getCliente().getNome().toUpperCase(Locale.ROOT));
        System.out.println("Metodo de pagamento: " + venda.getPagamento());
        System.out.println("****************************");
    }
}
