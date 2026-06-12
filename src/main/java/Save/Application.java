package Save;

import java.util.Scanner;
import Save.entities.VideoGames;
import Save.entities.BoardGames;
import Save.entities.Collezione;
import Save.entities.Genere;
import Save.entities.Games;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("AVVIO APPLICAZIONE");
        System.out.println("-------------------");
        Collezione miaCollezione = new Collezione();

        // PROVO MANUALMENTE
        VideoGames videogame = new VideoGames(1, "Minecarft", 2009, 15, "Pc", 20, Genere.SURVIVAL);
        BoardGames boardgame = new BoardGames(2, "Risiko", 1977, 25.00, 4, 50);

        System.out.println("Giochi già presenti nella mia collezione:");
        miaCollezione.aggiungi(videogame);
        miaCollezione.aggiungi(boardgame);

        System.out.println("-------------------------------------");
        System.out.println("INSERISCI UN NUOVO GIOCO DA CMD");

        // AGGIUNGO UNO SCANNER
        Scanner scanner = new Scanner(System.in);

        // MENU DI SCELTA INIZIALE
        System.out.println("Quale tipo di gioco vuoi inserire?");
        System.out.println("1 X videogioco");
        System.out.println("2 X gioco da tavolo");
        int controlloG = scanner.nextInt();
        scanner.nextLine();
        if (controlloG != 1 && controlloG != 2) {
            System.out.println("Numero non valido");
            scanner.close();
            return;
        }

        // Chiediamo prima del if, i dati correlati.
        System.out.print("Inserisci ID (numero): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Inserisci Titolo: ");
        String titolo = scanner.nextLine();

        System.out.print("Inserisci Anno di Pubblicazione: ");
        Integer anno = scanner.nextInt();
        // Piccolo controllo per non inserire più di 5 caratteri.
        if (anno > 9999) {
            System.out.println("L'anno non può avere più di 4 caratteri!");
            return;
        }
        scanner.nextLine();

        System.out.print("Inserisci Prezzo: ");
        // 1. Leggiamo l'input come String invece di nextDouble
        String prezzoString = scanner.nextLine();
        // 2. Sostituiamo la virgola con il punto
        prezzoString = prezzoString.replace(",", ".");
        // 3. Convertiamo la String in Double
        double prezzo = Double.parseDouble(prezzoString);

        // Scelta tra 1 videoGames o 2 boardGames
        if (controlloG == 1) {
            System.out.print("Inserisci Piattaforma: ");
            String piattaforma = scanner.nextLine();
            System.out.print("Inserisci Ore di Gioco: ");
            Integer ore = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Genere? (Azione, Avventura, Survival, Soulslike o GDR): ");
            //  Provo toUpperCase
            String testoUpper = scanner.nextLine().toUpperCase();
            // converto per l' Enum
            Genere genereScelto = Genere.valueOf(testoUpper);

            VideoGames nuovoVideogame = new VideoGames(id, titolo, anno, prezzo, piattaforma, ore, genereScelto);
            System.out.println("Inserimento in libreria");
            miaCollezione.aggiungi(nuovoVideogame);

        } else if (controlloG == 2) {
            System.out.print("Inserisci Numero Giocatori: ");
            Integer numeroGiocatori = scanner.nextInt();
            System.out.print("Inserisci Durata (in minuti): ");
            Integer durata = scanner.nextInt();
            scanner.nextLine();
            BoardGames nuovoBoardgame = new BoardGames(id, titolo, anno, prezzo, numeroGiocatori, durata);
            System.out.println("Inserimento in libreria");
            miaCollezione.aggiungi(nuovoBoardgame);
        }

        // Lista Aggiornata
        System.out.println("-------------");
        System.out.println("Verifica finale");
        int totaleGiochi = miaCollezione.getListaGiochi().size();
        System.out.println("Totale giochi salvati: " + totaleGiochi);

        // RICERCA
        System.out.println("-------------------------------------");
        System.out.println("RICERCA DI UN GIOCO TRAMITE ID");
        System.out.print("Inserisci l'ID del gioco da cercare: ");
        Integer idRicerca = scanner.nextInt();
        scanner.nextLine();

        Games giocoTrovato = miaCollezione.cercaPerId(idRicerca);

        if (giocoTrovato != null) {
            System.out.println("Titolo: " + giocoTrovato.getTitolo() + " Prezzo: " + giocoTrovato.getPrezzo() + "€");
        } else {
            System.out.println("Nessun gioco trovato" + idRicerca);
        }

        // AGGIUNTA RICERCA PER PREZZO
        System.out.println("-------------------------------------");
        System.out.println("RICERCA GIOCHI");
        System.out.print("Inserisci il tuo budget massimo: ");
        // Accettare punto e virgola
        String budgetString = scanner.nextLine();
        budgetString = budgetString.replace(",", ".");
        double budget = Double.parseDouble(budgetString);

        List<Games> giochiEconomici = miaCollezione.cercaPerPrezzoInferiore(budget);

        if (giochiEconomici.isEmpty()) {
            System.out.println("Non ci sono giochi che costano meno di " + budget + "€");
        } else {
            System.out.println("Giochi trovati entro il budget di " + budget + "€:");
            for (Games g : giochiEconomici) {
                System.out.println(g.getTitolo() + " (" + g.getPrezzo() + "€)");
            }
        }
        System.out.println("-------------------------------------");
        System.out.println("RICERCA GIOCHI DA TAVOLO PER GIOCATORI");
        System.out.print("Inserisci il numero di giocatori per la partita: ");
        Integer nrGiocatoriCercati = scanner.nextInt();
        scanner.nextLine();

        List<Games> giochiPerGiocatori = miaCollezione.cercaPerNumeroGiocatori(nrGiocatoriCercati);

        if (giochiPerGiocatori.isEmpty()) {
            System.out.println("Nessun gioco da tavolo supporta" + nrGiocatoriCercati + " giocatori.");
        } else {
            System.out.println("Giochi da tavolo per " + nrGiocatoriCercati + " giocatori:");
            for (Games g : giochiPerGiocatori) {
                System.out.println(g.getTitolo());
            }
        }
    }
}