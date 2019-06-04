package component;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.query.spi.NativeSQLQueryPlan;

public class Repository<T> {
	
	protected List<T> dataList;
	
	protected Class<T> objClass;
	
	
	public static <T> List<T> executeNativeQuery(
			String nativeQuery, Class<T> objClass){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		List<T> list = new ArrayList<>();
		
		try {
			list = session.createSQLQuery(nativeQuery).addEntity(objClass).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

}
