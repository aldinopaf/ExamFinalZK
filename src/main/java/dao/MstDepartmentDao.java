package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dao.custom.MstDepartmentCustomDao;
import entity.MstDepartment;
import entity.pk.MstDepartmentPk;

public interface MstDepartmentDao extends 
		JpaRepository<MstDepartment, MstDepartmentPk>,
		MstDepartmentCustomDao{
	
	@Query(value="SELECT p FROM MstDepartment p WHERE p.deptName = :deptName")
	public MstDepartment findByDeptName(@Param("deptName") String deptName);
	
	@Query(value="SELECT p FROM MstDepartment p WHERE p.deleted = false")
	public List<MstDepartment> findAllNotDeleted();
	
}
