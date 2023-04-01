package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class UpdateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {

			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			// Prepare Query object to hold HQL
			Query query = session.createQuery("UPDATE in.ineuron.model.Product SET pqty=pqty+:qty1 WHERE pqty<:qty2 ");
			// Set the Parameter values
			query.setParameter("qty1", 5);
			query.setParameter("qty2", 4);
			// Execute the query
			int update = query.executeUpdate();
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
			flag=false;
		}

		finally {
			if (flag) {
				transaction.commit();
				System.out.println("Updation Successful");
			} else {
				transaction.rollback();
				System.out.println("Updation Failed");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
