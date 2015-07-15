package br.com.facdjunior.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Francisco Junior 15/07/2015
 */
public class EstadoRepository {
    
    private EntityManager manager;
    
    private Estado nome;
    private Estado silga;
    private Estado codIBGE;

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public Estado getcodIBGE() {
        return codIBGE;
    }

    public void setcodIBGE(Estado codIBGE) {
        this.codIBGE = codIBGE;
    }

    
    public Estado getNome() {
        return nome;
    }

    public void setNome(Estado nome) {
        this.nome = nome;
    }

    public Estado getSilga() {
        return silga;
    }

    public void setSilga(Estado silga) {
        this.silga = silga;
    }

    
     public EstadoRepository(EntityManager manager){
        this.manager = manager;
    }

    public void adiciona(Estado estado){
        this.manager.persist(estado);
    }
    public List<Estado> buscaTodos(){
        Query query = this.manager.createQuery("select x from Estado x ORDER BY X.nome");
        return query.getResultList();
    }
}
