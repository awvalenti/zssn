package com.github.awvalenti.zssn.resource;

import static com.github.awvalenti.zssn.model.Item.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.github.awvalenti.zssn.model.Gender;
import com.github.awvalenti.zssn.model.ItemCollection;
import com.github.awvalenti.zssn.model.Location;
import com.github.awvalenti.zssn.model.Survivor;

public class IntegrationTest {

	private static EntityManagerFactory emf;

	protected EntityManager em;

	@BeforeClass
	public final static void createEmf() {
		emf = Persistence.createEntityManagerFactory("hsqldb");
	}

	@Before
	public final void openEm() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	@After
	public final void closeEm() {
		em.getTransaction().rollback();
		em.close();
	}

	@AfterClass
	public final static void closeEmf() {
		emf.close();
	}

	protected Survivor createJohnDoe() {
		Survivor john = new Survivor();
		john.setZombie(false);
		john.setName("John Doe");
		john.setAge(21);
		john.setGender(Gender.MALE);
		john.setLocation(new Location(1.0, 1.0));
		john.setInventory(ItemCollection.with(WATER, 2));
		return john;
	}

}
