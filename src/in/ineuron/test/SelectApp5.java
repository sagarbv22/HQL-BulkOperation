package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp5 {

	public static void main(String[] args) {

		Session session = null;
		Integer id = 1;
		try {

			session = HibernateUtil.getSession();
			
			// Prepare Query object to hold HQL
			Query<Product> query = session.createQuery("FROM in.ineuron.model.Product WHERE pid=:id");
			
			// Set values to Named Parameter
			query.setParameter("id", id);
			
			// Execute the query(select * from product where pid = ?)
			List<Product> list = query.list();
			
			// process the List object
			if (list.isEmpty()) {
				System.out.println("Product is not found for id :- " + id);
			} else {
				Product product = list.get(0);
				System.out.println(product);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
