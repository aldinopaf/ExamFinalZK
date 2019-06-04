package service;

import java.util.List;

import dto.MstBilAddressDetailDto;

public interface MstBilAddressDetailService {

	public List<MstBilAddressDetailDto> findAllDeletedFalse();
	public void save(MstBilAddressDetailDto mstBilAddressDetailDto);
	public void update(MstBilAddressDetailDto mstBilAddressDetailDto);
	public void delete(MstBilAddressDetailDto mstBilAddressDetailDto);
	public MstBilAddressDetailDto findOneById(String detailId);
	public List<MstBilAddressDetailDto> findByAddressName(String addressName);
}
