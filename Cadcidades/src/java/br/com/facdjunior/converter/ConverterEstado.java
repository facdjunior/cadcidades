package br.com.facdjunior.converter;

import br.com.facdjunior.modelo.Estado;
import br.com.facdjunior.util.EnderecoDao;
import br.com.facdjunior.util.EnderecoDaoImpl;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author TESTE
 */
@FacesConverter(value = "converterEstado")
public class ConverterEstado implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.equals("")) {
            EnderecoDao dao = new EnderecoDaoImpl();
            return dao.getByIdEstado(Long.valueOf(value));
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value instanceof Estado) {
            Estado estado = (Estado) value;
            return String.valueOf(estado.getIdEstado());
        }
        return "";
    }
}
