package br.com.trabalhoav2.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class Connect {
    public static final Connect connect = new Connect();
    private EntityManager em;
    private EntityManagerFactory emf;

    private Connect(){
        Map<String,String> configurcaoBanco = new HashMap<>();
        configurcaoBanco.put("javax.persistence.jdbc.url","jdbc:postgresql://localhost:5432/exercicio");
        configurcaoBanco.put("javax.persistence.jdbc.driver","org.postgresql.Driver");
        configurcaoBanco.put("javax.persistence.jdbc.password","12345");
        configurcaoBanco.put("javax.persistence.jdbc.user","postgres");

        this.emf = Persistence.createEntityManagerFactory("exercicio",configurcaoBanco);
        this.em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }
}
