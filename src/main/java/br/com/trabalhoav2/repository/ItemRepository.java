package br.com.trabalhoav2.repository;

import br.com.trabalhoav2.config.Connect;
import br.com.trabalhoav2.entity.Item;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ItemRepository {

    public static final ItemRepository repository = new ItemRepository();
    private Connect a = Connect.connect;

    private ItemRepository() {
    }

    public void cadastrar(Item item){
        a.getEm().getTransaction().begin();
        a.getEm().persist(item);
        a.getEm().flush();
        a.getEm().getTransaction().commit();
    }

    public List<Item> listar() {
        CriteriaBuilder cb = a.getEm().getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(Item.class);
        Root<Item> root = cq.from(Item.class);
        TypedQuery<Item> query = a.getEm().createQuery(cq);
        return query.getResultList();
    }
    public Item buscar(Integer id) {
        return a.getEm().find(Item.class, id);
    }
}
