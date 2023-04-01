package in.ineuron.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class NamedNativeQuery {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {

			session = HibernateUtil.getSession();

			NativeQuery<Product> query = session.getNamedNativeQuery("get_All_Products");

			query.setParameter("cost", 10000);

			query.addEntity(Product.class);

			List<Product> list = query.getResultList();

			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
