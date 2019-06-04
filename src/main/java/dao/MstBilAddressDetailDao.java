package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MstBilAddress;
import entity.MstBilAddressDetail;
import entity.pk.MstBilAddressDetailPk;

public interface MstBilAddressDetailDao extends JpaRepository<MstBilAddressDetail, MstBilAddressDetailPk>{

	@Query(value="SELECT p FROM MstBilAddressDetail p WHERE p.deleted = false")
	public List<MstBilAddressDetail> findAllDeletedFalse();
	
	@Query(value="SELECT p FROM MstBilAddressDetail p WHERE p.addressName = :addressName")
	public List<MstBilAddressDetail> findByAddressName(@Param("addressName") String addressName);
}
