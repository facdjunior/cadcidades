/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.facdjunior.util;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.modelo.Estado;
import java.util.List;

/**
 *
 * @author TESTE
 */
public interface EnderecoDao {
    
    public List<Estado> consultaTodosEstados();
    
    public List<Cidade> consultaCidades(Estado estado);
    
    public Cidade getByIdCidade(Long id);
    
    public Estado getByIdEstado(Long id);
}
