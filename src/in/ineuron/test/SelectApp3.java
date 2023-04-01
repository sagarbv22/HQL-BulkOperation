package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class SelectApp3 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();
			
			// Prepare Query object to hold HQL
			Query<String> query = session.createQuery("SELECT pname FROM in.ineuron.model.Product WHERE pcost>=:cost");
			
			//Set values to Named Parameter
			query.setParameter("cost", 10000);
			
			// Execute the query(select pname from product where pcost>=1000)
			List<String> list = query.getResultList();
			
			list.forEach(System.out::println);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
