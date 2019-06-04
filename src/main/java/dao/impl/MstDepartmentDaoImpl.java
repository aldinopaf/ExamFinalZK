package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.custom.MstDepartmentCustomDao;
import entity.MstDepartment;

public class MstDepartmentDaoImpl implements MstDepartmentCustomDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public MstDepartment getLastInserted() {
		String sql = "SELECT "
				+ "p.id, p.dept_name, "
				+ "p.created_date, p.created_user, "
				+ "p.updated_date, p.updated_user, "
				+ "p.deleted  "
				+ "FROM MST_DEPARTMENT p ORDER BY CREATED_DATE DESC";
		try {
			Query query = entityManager.createNativeQuery(sql);
			List<Object[]> obj = query.getResultList();
			Object[] objc = obj.get(0);
			System.out.println("Dept: " + objc[0] + ", Name: " + objc[1]);
			MstDepartment mstDepartment = new MstDepartment();//(MstDepartment) query.getResultList().get(0);
			mstDepartment.setCreatedDate((Date)objc[2]);
			mstDepartment.setCreatedUser((String)objc[3]);
			mstDepartment.setDeleted((Boolean)objc[6]);
			mstDepartment.setDeptName((String)objc[1]);
			mstDepartment.setId((Integer)objc[0]);
			mstDepartment.setUpdatedDate((Date)objc[4]);
			mstDepartment.setUpdatedUser((String)objc[5]);
			return mstDepartment;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
