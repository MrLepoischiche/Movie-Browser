package metier;

import java.util.List;
import javax.persistence.Query;
import lml.persistence.jpa.AbstracCrudServiceJPA;

public class MovieServiceImpl extends AbstracCrudServiceJPA<Movie> implements MovieService {
     MovieServiceImpl(String PU) {
        super(PU);
    }

    @Override
    public List<Movie> getByGenre(String genre, int begin, int size) throws Exception {
        List<Movie> movies = null;
        try {
            this.open();
            Query query = em.createQuery("SELECT m FROM Movie m WHERE m.genre = :fgenre ORDER BY m.title ASC");
            query.setParameter("fgenre", genre);
            query.setFirstResult(begin);
            query.setMaxResults(size);
            movies = query.getResultList();
        } finally {
            this.close();
        }
        return movies;
    }

    @Override
    public int getCountByGenre(String genre) throws Exception {
        Long count = -1l;
        try {
            this.open();
            Query query = em.createQuery("SELECT count(m) FROM Movie m WHERE m.genre = :fgenre");
            query.setParameter("fgenre", genre);
            count = ((Long) query.getSingleResult()).longValue();
        } finally {
            this.close();
        }

        return count.intValue();
    }

    @Override
    public List<String> getGenre() throws Exception {
        List<String> genres = null;
        try {
            this.open();
            Query query = em.createQuery("SELECT DISTINCT(m.genre) FROM Movie m ORDER BY m.genre ASC");
            genres = query.getResultList();
        } finally {
            this.close();
        }
        return genres;
    }
}
