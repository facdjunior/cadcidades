/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author TESTE
 */
public class GeraTabelas {
    public static void main (String[] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Cadcidades_PU");
        factory.close();
    }
}