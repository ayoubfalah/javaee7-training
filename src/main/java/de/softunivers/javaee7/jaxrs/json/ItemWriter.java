
package de.softunivers.javaee7.jaxrs.json;

import de.softunivers.javaee7.entities.Item;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ayoubfalah
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ItemWriter implements MessageBodyWriter<Item>
{

    @Override
    public boolean isWriteable(Class<?> type,
                               Type genericType,
                               Annotation[] annotations,
                               MediaType mediaType) 
    {
        return Item.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Item t,
                        Class<?> type,
                        Type genericType,
                        Annotation[] annotations,
                        MediaType mediaType) 
    {
        // In JAX-RS 2.0, this method is deprecated
        return -1;
    }

    @Override
    public void writeTo(Item item,
                        Class<?> type, 
                        Type genericType, 
                        Annotation[] annotations,
                        MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, 
                        OutputStream out) throws IOException, 
                                                WebApplicationException 
    {
        JsonGenerator generator = Json.createGenerator(out);
        generator.writeStartObject()
                .write("itemname", item.getItemname())
                .write("unitprice", item.getUnitprice())
                .writeEnd();
        generator.flush();
    }

}
