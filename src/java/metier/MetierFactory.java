package metier;

public class MetierFactory {
    // A CHANGER EN FONCTION DE VOTRE PROMOTION !
    private static final Promotion promotion = Promotion.JUPITER;
    private MetierFactory() {}
    
    private static MovieService movieSrv = null;
    
    public synchronized static MovieService getMovieService() throws Exception {
        if (MetierFactory.promotion == Promotion.UNKNOWN) {
            throw new Exception("Vous devez spécifier si votre promotion est Jupiter ou Saturne via la méthode MetierFactory.setSession");
        }
        
        if (movieSrv == null) {
            setSession();
        }
        
        return MetierFactory.movieSrv;
    }
    
    public static void setSession() {
        switch (promotion) {
            case SATURNE:
                movieSrv = new MovieServiceImpl("VideoBrowserSaturnePU");
                break;
            case JUPITER:
                movieSrv = new MovieServiceImpl("VideoBrowserJupiterPU");
                break;
        }
   
        
    }
}
