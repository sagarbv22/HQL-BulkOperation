package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp01 {

	public static void main(String[] args) {

		Session session = null;
		String selectQuery = "FROM in.ineuron.model.Product";
		try {

			session = HibernateUtil.getSession();

			if (session != null) {

				// Prepare Query object to hold HQL
				Query<Product> query = session.createQuery(selectQuery);

				// Execute the query
				List<Product> list = query.list();

				// process the List Object
				list.forEach(System.out::println);

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
