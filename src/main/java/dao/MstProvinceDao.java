package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.MstProduct;
import entity.MstProvince;
import entity.pk.MstProvincePk;


public interface MstProvinceDao extends JpaRepository<MstProvince, MstProvincePk>{

	@Query(value="SELECT p FROM MstProvince p WHERE p.deleted = false")
	public List<MstProvince> findAllDeleteFalse();
	
}
