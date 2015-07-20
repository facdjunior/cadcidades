package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.CidadeRepository;
import br.com.facdjunior.modelo.Estado;
import br.com.facdjunior.modelo.EstadoRepository;
import br.com.facdjunior.util.JpaUtil;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UISelectOne;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    private EntityManager manager;
    private List<Estado> ufs;
    private Estado estado = new Estado();
    
     
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cadcidades_PU");
    private EntityManager em = factory.createEntityManager();

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
    
  public void atualizaEstados(AjaxBehaviorEvent event) {
		this.cidade = null;

		if (ufs != null) {
			this.estado = (Estado) em
					.createQuery("select c from Estado c where c.idEstado = :'#{cidades}' order by c.nome", Estado.class)
					.setParameter("uf", ufs)
					.getResultList();
		}
        }

    private EntityManager getManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
