package br.com.facdjunior.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Francisco Junior 15/07/2015
 */
public class CidadeRepository {
    
    private EntityManager manager;
    
    private Cidade nome;
    private Cidade idEstado;
    private Cidade codIBGE;

    public CidadeRepository(EntityManager manager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public Cidade getNome() {
        return nome;
    }

    public void setNome(Cidade nome) {
        this.nome = nome;
    }

    public Cidade getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Cidade idEstado) {
        this.idEstado = idEstado;
    }

    public Cidade getCodIBGE() {
        return codIBGE;
    }

    public void setCodIBGE(Cidade codIBGE) {
        this.codIBGE = codIBGE;
    }


    public void adiciona(Cidade cidade){
        this.manager.persist(cidade);
    }
    public List<Cidade> buscaTodos(){
        Query query = this.manager.createQuery("select x from Cidade x ORDER BY X.nome");
        return query.getResultList();
    }
}
