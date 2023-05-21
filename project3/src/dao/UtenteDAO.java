package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import entities.Utente;

public class UtenteDAO {

	private final EntityManager em;

	public UtenteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(Utente u) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(u);
		transaction.commit(); 
		System.out.println("Utente salvato!");
	}
}
