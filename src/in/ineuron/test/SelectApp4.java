package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class SelectApp4 {

	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			Query<Object[]> query = session
					.createQuery("SELECT pid,pname,pcost FROM in.ineuron.model.Product WHERE pname IN(:name1,:name2)");

			query.setParameter("name1", "ferari");
			query.setParameter("name2", "titan");
			List<Object[]> list = query.getResultList();
			System.out.println("ID\tNAME\tCOST");
			list.forEach(

					row -> {
						for (Object object : row) {
							System.out.print(object + "\t");
						}
						System.out.println();
					}

			);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}

}
