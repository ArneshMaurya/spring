package com.cg.hr.core.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
public static EntityManagerFactory emf=null;
private static EntityManager em=null;
//entity manager as a connection
public static EntityManager getEntityManager()
	{
	emf=Persistence.createEntityManagerFactory("Oracle-JPA-PU");
	em=emf.createEntityManager();
	return em;
	}
}
