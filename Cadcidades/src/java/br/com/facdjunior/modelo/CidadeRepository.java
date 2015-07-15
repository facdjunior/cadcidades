/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Francisco Junior
 */
public class CidadeRepository {
    
    private EntityManager manager;
    
    private Cidade nome;
    private Cidade idEstado;
    private Cidade codibge;

    public CidadeRepository(EntityManager manager){
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

    public Cidade getCodibge() {
        return codibge;
    }

    public void setCodibge(Cidade codibge) {
        this.codibge = codibge;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
    
    public void adicionaCidade(Cidade cidade){
        this.manager.persist(cidade);
    }
            
    public List<Cidade> buscaTodos(){
        Query query = this.manager.createQuery("select x from Cidade x ORDER BY X.nome");
        return query.getResultList();
    }
}
