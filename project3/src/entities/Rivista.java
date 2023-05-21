package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "riviste")
@Getter
@Setter
@NoArgsConstructor
public class Rivista extends PubblicazioniCartacee{
	
	@Enumerated(EnumType.STRING)
	private Periodicità periodicità;;
	
	public Rivista(String titolo, int annoPubblicazione, int pagine, Periodicità periodicità) {
		super(titolo, annoPubblicazione, pagine);
		this.periodicità = periodicità;
	}
	
	@Override
    public String toString() {
        return super.toString() + ", Periodicità " + periodicità ;
    }
}
