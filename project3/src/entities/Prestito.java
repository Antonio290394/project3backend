package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestiti")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "findActiveByCode", query = "SELECT p.elementoPrestato FROM Prestito p JOIN p.utente u WHERE u.tessera = :tessera AND p.dataEffettivaFine IS NULL")
@NamedQuery(name = "findLateActive", query = "SELECT p.elementoPrestato FROM Prestito p WHERE p.dataPrevistaFine < CURRENT_DATE AND p.dataEffettivaFine IS NULL")
public class Prestito {

	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Utente utente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private PubblicazioniCartacee elementoPrestato;
	
	private LocalDate dataInizioPrestito;
	private LocalDate dataPrevistaFine;
	private LocalDate dataEffettivaFine;
	
	public Prestito(Utente utente, PubblicazioniCartacee elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataPrevistaFine, LocalDate dataEffettivaFine) {
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataPrevistaFine = dataInizioPrestito.plusDays(30);
		this.dataEffettivaFine = dataEffettivaFine;
	}
	
}
