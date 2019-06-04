package service;

import java.util.List;

import dto.MstBilAddressDto;

public interface MstBilAddressService {

	public void save(MstBilAddressDto mstBilAddressDto);
	public List<MstBilAddressDto> findAll();
	public void delete(MstBilAddressDto MstBilAddressDto);
	public MstBilAddressDto findByEmpId(Integer addressId);
	public void update(MstBilAddressDto MstBilAddressDto);
	public MstBilAddressDto findByAddressName(String addressName);
}
