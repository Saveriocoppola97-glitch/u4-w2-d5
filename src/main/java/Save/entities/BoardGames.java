package Save.entities;

public class BoardGames extends Games {
    private Integer numeroGiocatori;
    private Integer durata;

    public BoardGames(Integer id, String titolo, Integer annoDiProduzione, double prezzo, Integer numeroGiocatori, Integer durata) {
        super(id,titolo,annoDiProduzione,prezzo);
        this.numeroGiocatori = numeroGiocatori;
        this.durata = durata;
    }

    public Integer getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public Integer getDurata() {
        return durata;
    }

    @Override
    public String toString() {
        return "BoardGames{" +
                "numeroGiocatori=" + numeroGiocatori +
                ", durata=" + durata +
                '}';
    }
}
