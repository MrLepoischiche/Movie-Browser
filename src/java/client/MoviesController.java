package client;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import metier.MetierFactory;
import metier.Movie;
import metier.MovieService;
import metier.Promotion;

@ManagedBean
@ViewScoped
public class MoviesController implements Serializable {
    private String genre;
    private Map<String, String> genres; // you need to use a map for populate a dropdown !
    private List<Movie> movies;
    private MovieService movieSrv;
    private int count;
    
    @PostConstruct
    public void init() {
        try {
            this.movieSrv = MetierFactory.getMovieService();
            List<String> datas = this.movieSrv.getGenre();
            this.genres = new HashMap<String, String>();
            for (String st : datas) {
                if (st != null) {
                    st = st.trim();
                    this.genres.put(st, st);
                }
            }       
            this.count = (int) this.movieSrv.getCount();
            this.movies = this.movieSrv.getAll(0, this.count);
            System.out.println("-------------------------INIT OK---------------------------");
        } catch (Exception ex) {
            System.err.println("Error in MoviesController.init() : " + ex.getMessage());
        }
    }

     public void onGenreChange() {
        if (this.genre != null && !"".equals(this.genre)) {
            try {
                this.count = this.movieSrv.getCountByGenre(this.genre);
                this.movies = this.movieSrv.getByGenre(this.genre, 0, this.count);
            } catch (Exception ex) {
                Logger.getLogger(MoviesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.count = (int) this.movieSrv.getCount();
                this.movies = this.movieSrv.getAll(0, this.count);
            } catch (Exception ex) {
                Logger.getLogger(MoviesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the movies
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * @param movies the movies to set
     */
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the genres
     */
    public Map<String, String> getGenres() {
        return genres;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
