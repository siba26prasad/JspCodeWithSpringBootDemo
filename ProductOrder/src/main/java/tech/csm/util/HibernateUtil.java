package tech.csm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tech.csm.entity.ProductDetails;
import tech.csm.entity.Sales;

public class HibernateUtil {
	private static Session session=null;
	static {
		Configuration cfg=new Configuration().configure();
		cfg.addAnnotatedClass(ProductDetails.class);
		cfg.addAnnotatedClass(Sales.class);

		SessionFactory sessionFactory=cfg.buildSessionFactory();
		session=sessionFactory.openSession();
	}
	public static Session getSession() {
		return session;
	}

}
