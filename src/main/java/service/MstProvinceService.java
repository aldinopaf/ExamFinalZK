package service;

import java.sql.SQLException;
import java.util.List;

import dto.MstProductDto;
import dto.MstProvinceDto;


public interface MstProvinceService {

		public List<MstProvinceDto> findAllDeletedFalse();
		public void save(MstProvinceDto mstProvinceDto);
		public void update(MstProvinceDto mstProvinceDto);
		public void deleted(MstProvinceDto mstProvinceDto);
		public MstProvinceDto findOneByProvCode(String provinceCode);
		
}
