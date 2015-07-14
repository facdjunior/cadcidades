package br.com.facdjunior.converter;

import br.com.facdjunior.modelo.Cidade;
import br.com.facdjunior.util.EnderecoDao;
import br.com.facdjunior.util.EnderecoDaoImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Francisco Junior 14/07/2015
 */
@FacesConverter(value="converterCidade")
public class ConverterCidade implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            EnderecoDao dao = new EnderecoDaoImpl();
            return dao.getByIdCidade(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Cidade) {
            Cidade municipio = (Cidade) value;
            return String.valueOf(municipio.getIdCidade());
        }
        return "";
    }

}

