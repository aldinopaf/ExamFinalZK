package service;

import java.util.List;

import dto.MstCityDto;

public interface MstCityService {
	
	public List<MstCityDto> findAllDeletedFalse();
	public void save(MstCityDto mstCityDto);
	public void update(MstCityDto mstCityDto);
	public void delete(MstCityDto mstCityDto);
	public List<MstCityDto> findByProvCode(String provinceCode);
	public MstCityDto findByCityCode(String cityCode);

}
