
package de.softunivers.javaee7.jaxrs.json;

import de.softunivers.javaee7.entities.Item;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author ayoubfalah
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class ItemReader implements MessageBodyReader<Item>
{

    @Override
    public boolean isReadable(Class<?> type,
                              Type genericType,
                              Annotation[] annotations,
                              MediaType mediaType)
    {
        // checking if the method can produce an instance of type Item
        return Item.class.isAssignableFrom(type);
    }

    @Override
    public Item readFrom(Class<Item> type,
                         Type genericType,
                         Annotation[] annotations,
                         MediaType mediaType,
                         MultivaluedMap<String, String> httpHeaders,
                         InputStream in) throws IOException,
                                                   WebApplicationException
    {
        Item item = new Item();
        JsonParser parser = Json.createParser(in);
        while (parser.hasNext())
        {
            switch(parser.next())
            {
                case KEY_NAME:
                    String key = parser.getString();
                    parser.next();
                    switch(key)
                    {
                       case "itemno":
                           item.setItemno(parser.getInt());
                           break;
                        case "itemname":
                            item.setItemname(parser.getString());
                            break;
                        case "unitprice":
                            item.setUnitprice(Float.valueOf(parser.getString()));
                            break;                       
                    }
                    break;
                default:
                    break;                   
            }           
        }
        return item;
    }

}
