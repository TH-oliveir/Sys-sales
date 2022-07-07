package br.com.trabalhoav2.repository;

import br.com.trabalhoav2.config.Connect;
import br.com.trabalhoav2.entity.Cliente;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ClienteRepository {
    public static final ClienteRepository repository = new ClienteRepository();
    private Connect a = Connect.connect; // conexao com o banco de dados

    private ClienteRepository() {
    }

    public void cadastrar(Cliente cliente){
        a.getEm().getTransaction().begin();
        a.getEm().persist(cliente);
        a.getEm().flush();
        a.getEm().getTransaction().commit();
    }

    public List<Cliente> listar() {
        CriteriaBuilder cb = a.getEm().getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> root = cq.from(Cliente.class);
        TypedQuery<Cliente> query = a.getEm().createQuery(cq);
        return query.getResultList();
    }
    public Cliente buscar(Integer id) {
        return a.getEm().find(Cliente.class, id);
    }
}
