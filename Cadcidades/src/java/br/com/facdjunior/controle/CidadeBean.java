/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.CidadeRepository;
import br.com.facdjunior.modelo.Estado;
import br.com.facdjunior.modelo.EstadoRepository;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Francisco Junior 15/07/2015
 */
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable{
    
    private Cidade cidade = new Cidade();
    private CidadeRepository rep = new CidadeRepository(null);

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public CidadeRepository getRep() {
        return rep;
    }

    public void setRep(CidadeRepository rep) {
        this.rep = rep;
    }
    
    
    //ADICIONA NOVO REGISTRO
    public void adicionaCidade(){
        EntityManager manager = this.getEntityManager();
        CidadeRepository repository = new CidadeRepository(manager);
        
        repository.adicionaCidade(this.cidade);
        this.cidade = new Cidade();
    }
    
    //MOSTRA REGISTROS CADASTRADOS
    public List<Cidade> getCidades(){
        EntityManager  manager = this.getEntityManager();
        CidadeRepository repository = new CidadeRepository(manager);
        return repository.buscaTodos();
    }
	
    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest)ec.getRequest();
        EntityManager manager = (EntityManager)request.getAttribute("EntityManager");
        
        return manager;
    }
    
    
}
