/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Estado;
import br.com.facdjunior.modelo.EstadoRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author TESTE
 */
@ManagedBean
@ViewScoped
public class EstadoBean {
    
        private Estado estado = new Estado();
        private EstadoRepository rep = new EstadoRepository(null);
        
        //ADICIONA NOVO REGISTRO
    public void adicionaEstado(){
        EntityManager manager = this.getEntityManager();
        EstadoRepository repository = new EstadoRepository(manager);
        
        repository.adiciona(this.estado);
        this.estado = new Estado();
    }
    
    //MOSTRA REGISTROS CADASTRADOS
    public List<Estado> getEstados(){
        EntityManager manager = this.getEntityManager();
        EstadoRepository repository = new EstadoRepository(manager);
        return repository.buscaTodos();
    }
	
    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        EntityManager manager = (EntityManager)request.getAttribute("EntityManager");
        
        return manager;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public EstadoRepository getRep() {
        return rep;
    }

    public void setRep(EstadoRepository rep) {
        this.rep = rep;
    }
}
