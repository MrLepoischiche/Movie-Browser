package metier;

import java.util.List;
import lml.persistence.CrudService;

/**
 *
 * @author fanou
 */
public interface MovieService extends CrudService<Movie> {
    List<Movie> getByGenre(String genre, int begin, int size) throws Exception;
    int getCountByGenre(String genre) throws Exception; 
     List<String> getGenre() throws Exception; 
}
