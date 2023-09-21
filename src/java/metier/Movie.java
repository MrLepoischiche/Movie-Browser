package metier;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String genre;
    @Column(columnDefinition="VARCHAR(1000)")
    private String overview;
    private int yearOfOut;
    private int runtime;
    @Column(unique=true)
    private String title;
    @ElementCollection
    private List<String> casting;
    private String director;
    private String backdrop;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
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

    /**
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview the overview to set
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return the yearOfOut
     */
    public int getYearOfOut() {
        return yearOfOut;
    }

    /**
     * @param yearOfOut the yearOfOut to set
     */
    public void setYearOfOut(int yearOfOut) {
        this.yearOfOut = yearOfOut;
    }

    /**
     * @return the runtime
     */
    public int getRuntime() {
        return runtime;
    }

    /**
     * @param runtime the runtime to set
     */
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the casting
     */
    public List<String> getCasting() {
        return casting;
    }

    /**
     * @param casting the casting to set
     */
    public void setCasting(List<String> casting) {
        this.casting = casting;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the backdrop
     */
    public String getBackdrop() {
        return backdrop;
    }

    /**
     * @param backdrop the backdrop to set
     */
    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }
 
    @Override
    public String toString() {
        return this.title + " " + this.genre + " in " + this.yearOfOut + " by " + this.director;
    }
}
