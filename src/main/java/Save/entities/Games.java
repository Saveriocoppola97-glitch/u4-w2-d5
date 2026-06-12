package Save.entities;

public class Games {
   private Integer id;
   private String titolo;
   private Integer annoDiProduzione;
   private double prezzo;

   public Games(Integer id, String titolo, Integer annoDiProduzione, double prezzo) {
     this.id = id;
     this.titolo = titolo;
     this.annoDiProduzione = annoDiProduzione;
     this.prezzo = prezzo;
   }

    public Integer getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public Integer getAnnoDiProduzione() {
        return annoDiProduzione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "VideoGames{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", annoDiProduzione=" + annoDiProduzione +
                ", prezzo=" + prezzo +
                '}';
    }
}
