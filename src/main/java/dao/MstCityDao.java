package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MstCity;
import entity.pk.MstCityPk;

public interface MstCityDao extends JpaRepository<MstCity, MstCityPk>{

	@Query(value="SELECT p FROM MstCity p WHERE p.provinceCode = :provinceCode")
	public List<MstCity> findByProvCode(@Param("provinceCode") String provinceCode);
	
	@Query(value="SELECT p FROM MstCity p WHERE p.deleted = false")
	public List<MstCity> findAllDeletedFalse();
	
}
