package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MstBilAddress;
import entity.pk.MstBilAddressPk;

public interface MstBilAddressDao extends 
JpaRepository<MstBilAddress, MstBilAddressPk>{

	//join
@Query(value="SELECT p FROM MstBilAddress p, MstBilAddress a WHERE p.addressName = a.addressName AND p.addressName = :addressName")
public MstBilAddress findByAddressName(@Param("addressName") String addressName);

}
