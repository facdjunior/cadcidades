/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TESTE
 */
public class JpaUtil {
    
private static EntityManagerFactory factory;
static {
factory = Persistence.createEntityManagerFactory(
"Cadcidades_PU");
}
public static EntityManager getEntityManager() {
return factory.createEntityManager();
}
}
