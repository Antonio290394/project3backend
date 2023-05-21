package dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Prestito;
import entities.PubblicazioniCartacee;

public class PrestitoDAO {

	
	private final EntityManager em;

	public PrestitoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Prestito p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit(); 
		System.out.println("Prestito salvato!");
	}
	
	public List<PubblicazioniCartacee> getActiveByCode(String tessera) {
		TypedQuery<PubblicazioniCartacee> query = em.createNamedQuery("findActiveByCode", PubblicazioniCartacee.class);
		query.setParameter("tessera", UUID.fromString(tessera));
		return query.getResultList();
	}
	
	public List<PubblicazioniCartacee> getLateActive(){
		TypedQuery<PubblicazioniCartacee> query = em.createNamedQuery("findLateActive", PubblicazioniCartacee.class);
		return query.getResultList();
	}
}
