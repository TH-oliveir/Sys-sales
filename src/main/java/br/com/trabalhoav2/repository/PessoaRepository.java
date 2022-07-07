package br.com.trabalhoav2.repository;

import br.com.trabalhoav2.config.Connect;
import br.com.trabalhoav2.entity.Pessoa;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PessoaRepository {

    public static final PessoaRepository PESSOA_REPOSITORY= new PessoaRepository();
    private Connect a = Connect.connect;

    private PessoaRepository() {
    }

    public void cadastrar(Pessoa p){
        a.getEm().getTransaction().begin();
        a.getEm().persist(p);
        a.getEm().flush();
        a.getEm().getTransaction().commit();
    }
    
    public List<Pessoa> listar() {
        CriteriaBuilder cb = a.getEm().getCriteriaBuilder();
        CriteriaQuery<Pessoa> cq = cb.createQuery(Pessoa.class);
        Root<Pessoa> pessoaRoot = cq.from(Pessoa.class);
        TypedQuery<Pessoa> query = a.getEm().createQuery(cq);
        return query.getResultList();
    }

}
