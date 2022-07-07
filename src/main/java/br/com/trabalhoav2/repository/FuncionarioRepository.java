package br.com.trabalhoav2.repository;

import br.com.trabalhoav2.config.Connect;
import br.com.trabalhoav2.entity.Funcionario;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FuncionarioRepository {

    public static final FuncionarioRepository repository = new FuncionarioRepository();
    private Connect a = Connect.connect;

    private FuncionarioRepository() {
    }

    public void cadastrar(Funcionario funcionario){
        a.getEm().getTransaction().begin();
        a.getEm().persist(funcionario);
        a.getEm().flush();
        a.getEm().getTransaction().commit();
    }
    public List<Funcionario> listar() {
        CriteriaBuilder cb = a.getEm().getCriteriaBuilder();
        CriteriaQuery<Funcionario> cq = cb.createQuery(Funcionario.class);
        Root<Funcionario> root = cq.from(Funcionario.class);
        TypedQuery<Funcionario> query = a.getEm().createQuery(cq);
        return query.getResultList();
    }
    public Funcionario buscar(Integer id) {
        return a.getEm().find(Funcionario.class, id);
    }
}
