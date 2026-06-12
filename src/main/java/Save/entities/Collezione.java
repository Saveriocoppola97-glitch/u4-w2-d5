package Save.entities;

import java.util.ArrayList;
import java.util.List;
// LISTA ATTRIBBUTI(in questo caso creo un contenitore lista)
public class Collezione {
    private List<Games> lista;
//  COSTRUTTORE che che dalla lista crea un arreyList
    public Collezione() {
        this.lista = new ArrayList<>();
    }
    // METODO DI AGGIUNGA GAMES
    public void aggiungi(Games nuovo) {
        for (Games giocoEsistente : lista) {
            if (giocoEsistente.getId().equals(nuovo.getId())) {
                System.out.println("L'ID " + nuovo.getId() + " è già presente" +" "+ nuovo.getTitolo() +" " + "non può essere aggiunto");
                return;
            }
        }
        lista.add(nuovo);
        System.out.println("Aggiunto nella collezione: " + nuovo.getTitolo());
    }
//    METODO DI RICERCA
    public Games cercaPerId(Integer idDaCercare) {
        Games risultato = null;

        for (Games gioco : lista) {
            if (gioco.getId().equals(idDaCercare)) {
                risultato = gioco;
                break;
            }
        }
        return risultato;
    }
    // METODO PREZZO INFERIORE
    public List<Games> cercaPerPrezzoInferiore(double prezzoMassimo) {
        List<Games> giochiFiltrati = new ArrayList<>();

        for (Games gioco : lista) {
            if (gioco.getPrezzo() < prezzoMassimo) {
                giochiFiltrati.add(gioco);
            }
        }
        return giochiFiltrati;
    }
    // METODO RICERCA PER GIOCATORI
    public List<Games> cercaPerNumeroGiocatori(Integer giocatoriCercati) {
        List<Games> giochiTrovati = new ArrayList<>();
        for (Games gioco : lista) {
            if (gioco instanceof BoardGames) {
                BoardGames bg = (BoardGames) gioco;
                if (bg.getNumeroGiocatori() >= (giocatoriCercati)) {
                    giochiTrovati.add(gioco);
                }
            }
        }
        return giochiTrovati;
    }
    // Ritorna lista completa
    public List<Games> getListaGiochi() {
        return lista;
    }
}
