package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class DeleteApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		int id = 3;
		boolean flag = false;
		try {

			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			// Prepare Query object to hold HQL
			Query query = session.createQuery("DELETE FROM in.ineuron.model.Product WHERE pid=:id");
			
			// Set the Parameter values
			query.setParameter("id", id);
			
			//Execute Query
			query.executeUpdate();
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		finally {
			if (flag) {
				transaction.commit();
				System.out.println("DELETED SUCCESSFULLY");
			}

			else {
				transaction.rollback();
				System.out.println("DELETION FAILED");

			}
		}

	}

}
