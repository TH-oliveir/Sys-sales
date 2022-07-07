package br.com.trabalhoav2.entity;

public class ItemVenda {
    private Item item;
    private Integer quantidade;
    public ItemVenda() {
    }

    public ItemVenda(Item item, Integer quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Float getTotal(){
        return this.item.getValor() * this.quantidade;
    }
}
