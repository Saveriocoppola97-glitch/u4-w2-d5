package Save.entities;

public class VideoGames extends Games{
    private String piattaforma;
    private Integer oreDiGioco;
    private Genere genere;

    public VideoGames(Integer id, String titolo, Integer annoDiProduzione, double prezzo,
                      String piattaforma, Integer oreDiGioco, Genere genere) {
        super(id,titolo,annoDiProduzione,prezzo);
        this.piattaforma = piattaforma;
        this.oreDiGioco = oreDiGioco;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public Integer getOreDiGioco() {
        return oreDiGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "VideoGames{" +
                "piattaforma='" + piattaforma + '\'' +
                ", oreDiGioco=" + oreDiGioco +
                ", genere=" + genere +
                '}';
    }
}

