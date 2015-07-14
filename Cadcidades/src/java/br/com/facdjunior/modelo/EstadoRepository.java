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
 * @author TESTE
 */
public class EstadoRepository {
    
    private EntityManager manager;
    private Estado nome;
    private Estado silga;
    private Estado idEstado;

    
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

    public Estado getCodIBGE() {
        return idEstado;
    }

    public void setCodIBGE(Estado idEstado) {
        this.idEstado = idEstado;
    }
    
    
     public EstadoRepository(EntityManager manager){
        this.manager = manager;
    }

        public void adiciona(Estado uf){
        this.manager.persist(uf);
    }
    public List<Estado> buscaTodos(){
        Query query = this.manager.createQuery("select x from Estado x ORDER BY X.nome");
        return query.getResultList();
    }
}
