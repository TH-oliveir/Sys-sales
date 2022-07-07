package br.com.trabalhoav2.entity;

import br.com.trabalhoav2.repository.ClienteRepository;
import br.com.trabalhoav2.repository.FuncionarioRepository;
import br.com.trabalhoav2.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<ItemVenda> itens = new ArrayList<>();
    private Funcionario funcionario;
    private Cliente cliente;
    private String pagamento;

    public void adicionarItens(Integer idItem,Integer quantidade) {
        ItemRepository repository = ItemRepository.repository;
        itens.add(new ItemVenda(repository.buscar(idItem), quantidade));
    }
    public Float getTotalVenda(){
        float subtotal = 0;
        for (ItemVenda itemVenda:itens){
            subtotal += itemVenda.getTotal();
        }
        return subtotal;
    }
    public void adicionarFuncionario(Integer idFuncionario){
        FuncionarioRepository repository = FuncionarioRepository.repository;
        this.funcionario = repository.buscar(idFuncionario);
    }
    public void adicionarCliente(Integer idCliente){
        ClienteRepository repository = ClienteRepository.repository;
        this.cliente = repository.buscar(idCliente);
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
}
