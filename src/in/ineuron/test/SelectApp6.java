package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectApp6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = null;
		int id = 1;
		try {

			session = HibernateUtil.getSession();
			
			// Prepare Query object to hold HQL
			Query<Product> query = session.createQuery("FROM in.ineuron.model.Product WHERE pid=:id");
			
			// Set values to Named Parameter
			query.setParameter("id", id);
			
			// Execute the query(select * from product where pid = ?)
			//uniqueResult() is going to avoid creating an object of List for only one row
			Product product = query.uniqueResult();

			if (product != null)
				System.out.println(product);
			else
				System.out.println("Product not found for id :-" + id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
