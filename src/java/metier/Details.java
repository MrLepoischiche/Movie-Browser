package metier;

/**
 * Classe qui permet la lecture des fichiers XML
 */
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Details {
    private String genre;    
    private String overview;
    private String year;
    private int runtime;
    private String title;
    private String cast;
    private String director;
    private String backdrop;
    
    private Details() {}
    
    public static Details getDetail(File xmlFile) {
        Details details = null;
        try {
            JAXBContext context = JAXBContext.newInstance(Details.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            details = (Details) unmarshaller.unmarshal(xmlFile);            
        } catch (JAXBException ex) {
            System.out.println("erreur lecture fichier xml : " + xmlFile.getName());
        }
        
        return details;
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
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
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
     * @return the cast
     */
    public String getCast() {
        return cast;
    }

    /**
     * @param cast the cast to set
     */
    public void setCast(String cast) {
        this.cast = cast;
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
}
