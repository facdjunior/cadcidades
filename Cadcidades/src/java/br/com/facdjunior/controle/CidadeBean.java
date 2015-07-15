package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.CidadeRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Francisco Juniro 15/07/2015
 */
@ManagedBean
@ViewScoped
public class CidadeBean {
    
        private Cidade cidade = new Cidade();
        private CidadeRepository  rep = new CidadeRepository(null);
        
        //ADICIONA NOVO REGISTRO
    public void adicionaCidade(){
        EntityManager manager = this.getEntityManager();
        CidadeRepository repository = new CidadeRepository(manager);
        
        rep.adiciona(this.cidade);
        this.cidade = new Cidade();
    }
    
    //MOSTRA REGISTROS CADASTRADOS
    public List<Cidade> getCidades(){
        EntityManager manager = this.getEntityManager();
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

   


}
