package br.com.facdjunior.util;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.Estado;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Francisco Junior 01/07/2015
 */
@WebFilter(servletNames = {"Faces Servlet"})
public class JPAFilter implements Filter{
    
    private EntityManagerFactory factory;
    
     
    @Override
    public void init (FilterConfig filterConfig) throws ServletException{
        this.factory = Persistence.createEntityManagerFactory("Cadcidades_PU");
    }
    @Override
    public void destroy(){
        this.factory.close();
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException{
        
        //CHEGADA das requisições Salvar/Alterar / excluir consultar
        EntityManager manager = this.factory.createEntityManager();
        request.setAttribute("EntityManager", manager);
        manager.getTransaction().begin();
        //CHEGADA das requisições Salvar/Alterar / excluir consultar
        // Faces Servlet
        chain.doFilter(request, response);
        // Faces Servlet
        //Saida
        try{
        manager.getTransaction().commit();
        
    }catch(Exception e){
        manager.getTransaction().rollback();
    }finally{
            manager.close();
        }
    }
    
    public static void main(String [] args) {
        
    }
        //Saida
}


