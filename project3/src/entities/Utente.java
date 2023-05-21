package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {

	@Id
	@GeneratedValue
	private UUID tessera;
	
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	
	
	public Utente(String nome, String cognome, LocalDate dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	
}
