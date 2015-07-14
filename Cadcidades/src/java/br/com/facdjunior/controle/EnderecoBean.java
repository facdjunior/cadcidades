/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.controle;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.Estado;
import br.com.facdjunior.util.EnderecoDao;
import br.com.facdjunior.util.EnderecoDaoImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author TESTE
 */
@ManagedBean
@ViewScoped
public class EnderecoBean implements Serializable {
    
    private final EnderecoDao dao = new EnderecoDaoImpl();
    private List<Estado> estados;
    private List<Cidade> cidades;
    private Cidade cidade;
    private Estado estado;
    
    public EnderecoBean() {
        
    }
    
    @PostConstruct
    public void init() {
        estados = dao.consultaTodosEstados();
    }
    
    public void listaCidades(AjaxBehaviorEvent event) {
        cidades = dao.consultaCidades(estado);
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
}
