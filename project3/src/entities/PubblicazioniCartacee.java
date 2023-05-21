package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "searchByISBN", query = "SELECT pc FROM PubblicazioniCartacee pc WHERE pc.ISBN = :ISBN")
@NamedQuery(name = "searchByYear", query = "SELECT pc FROM PubblicazioniCartacee pc WHERE pc.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "searchByTitle", query = "SELECT pc FROM PubblicazioniCartacee pc WHERE pc.titolo LIKE CONCAT('%', :titolo, '%')")
public abstract class PubblicazioniCartacee {

	@Id
	@GeneratedValue
	protected long ISBN;
	
	protected String titolo;
	protected int annoPubblicazione;
	protected int pagine;
	
	
	protected PubblicazioniCartacee(String titolo, int annoPubblicazione, int pagine) {
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.pagine = pagine;
	}
	
	
	@Override
    public String toString() {
        return "ISBN: " + ISBN + ", Titolo: " + titolo + ", Anno di pubblicazione: " + annoPubblicazione + ", Pagine: " + pagine;
    }
	
}
