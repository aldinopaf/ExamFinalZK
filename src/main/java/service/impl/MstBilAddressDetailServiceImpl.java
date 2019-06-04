package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



//import dao.MstProductDao;
import dao.MstBilAddressDetailDao;
import dto.MstBilAddressDetailDto;
import dto.MstProductDto;
import dto.TrOrderDetailDto;
import entity.MstBilAddressDetail;
import entity.TrOrderDetail;
import entity.pk.MstBilAddressDetailPk;
import entity.pk.TrOrderDetailPk;
import service.MstBilAddressDetailService;
import service.MstProductService;

@Service(value="mstBilAddressDetailSvc")
@Transactional
public class MstBilAddressDetailServiceImpl implements MstBilAddressDetailService {

	
	@Autowired
	private MstBilAddressDetailDao mstBilAddressDetailDao;
	
//	@Autowired
//	private MstProductDao mstProductDao;
////	
//	@Autowired
//	private MstProductService mstProductSvc;
	
	@Override
	public List<MstBilAddressDetailDto> findAllDeletedFalse() {
		List<MstBilAddressDetailDto> list = new ArrayList<MstBilAddressDetailDto>();

		try {
			List<MstBilAddressDetail> bilAddress = mstBilAddressDetailDao.findAllDeletedFalse();
			if(bilAddress != null && !bilAddress.isEmpty() && bilAddress.size() > 0){
				for(MstBilAddressDetail bil : bilAddress){
					MstBilAddressDetailDto dto = new MstBilAddressDetailDto();
					dto.setCreatedDate(bil.getCreatedDate());
					dto.setCreatedUser(bil.getCreatedUser());
					dto.setDeleted(bil.getDeleted());
					dto.setDetailId(bil.getDetailId());
					
//					MstProductDto prodDto = mstProductSvc.findByProductCode(order.getProductCode());
//					dto.setProduct(prodDto);
					dto.setAddress(bil.getAddress());
					dto.setPostalCode(bil.getPostalCode());
					dto.setCity(bil.getCity());
					dto.setProvince(bil.getProvince());
					dto.setHomeAddress(bil.getHome_address());
					dto.setWorkAddress(bil.getWorkAddress());
					dto.setUpdatedDate(bil.getUpdatedDate());
					dto.setUpdatedUser(bil.getUpdatedUser());
					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void save(MstBilAddressDetailDto mstBilAddressDetailDto) {
		try {
			MstBilAddressDetail bil = new MstBilAddressDetail();
			bil.setCreatedDate(new Date());
			bil.setCreatedUser("ADMIN");
			bil.setDeleted(mstBilAddressDetailDto.getDeleted());
			bil.setDetailId(mstBilAddressDetailDto.getDetailId());
			bil.setAddress(mstBilAddressDetailDto.getAddress());
			bil.setPostalCode(mstBilAddressDetailDto.getPostalCode());
			bil.setCity(mstBilAddressDetailDto.getCity());
			
			bil.setProvince(mstBilAddressDetailDto.getProvince());
			bil.setHome_address(mstBilAddressDetailDto.getHomeAddress());
			bil.setWorkAddress(mstBilAddressDetailDto.getWorkAddress());
			bil.setUpdatedDate(mstBilAddressDetailDto.getUpdatedDate());
			bil.setUpdatedUser(mstBilAddressDetailDto.getUpdatedUser());
			mstBilAddressDetailDao.save(bil);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(MstBilAddressDetailDto mstBilAddressDetailDto) {
		try {
			MstBilAddressDetail bil = mstBilAddressDetailDao.findOne(new MstBilAddressDetailPk(mstBilAddressDetailDto.getDetailId()));
			if(bil != null && !bil.getDetailId().equalsIgnoreCase("")){
				bil.setDeleted(mstBilAddressDetailDto.getDeleted());
				bil.setDetailId(mstBilAddressDetailDto.getDetailId());
				bil.setAddress(mstBilAddressDetailDto.getAddress());
				bil.setPostalCode(mstBilAddressDetailDto.getPostalCode());
				bil.setCity(mstBilAddressDetailDto.getCity());
				bil.setProvince(mstBilAddressDetailDto.getProvince());
				bil.setHome_address(mstBilAddressDetailDto.getHomeAddress());
				bil.setWorkAddress(mstBilAddressDetailDto.getHomeAddress());
				bil.setUpdatedDate(new Date());
				bil.setUpdatedUser("ADMIN");

				mstBilAddressDetailDao.save(bil);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(MstBilAddressDetailDto mstBilAddressDetailDto) {
		try {
			MstBilAddressDetail bil = mstBilAddressDetailDao.findOne(new MstBilAddressDetailPk(mstBilAddressDetailDto.getDetailId()));
			if(bil != null && !bil.getDetailId().equalsIgnoreCase("")){
				bil.setDeleted(Boolean.TRUE);
				bil.setUpdatedDate(new Date());
				bil.setUpdatedUser("ADMIN");
	
				mstBilAddressDetailDao.save(bil);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public MstBilAddressDetailDto findOneById(String detailId) {
		try{
			MstBilAddressDetail bil = mstBilAddressDetailDao.findOne(new MstBilAddressDetailPk(detailId));
			if(bil != null && !bil.getDetailId().equalsIgnoreCase("")){
				MstBilAddressDetailDto dto = new MstBilAddressDetailDto();
				dto.setCreatedDate(bil.getCreatedDate());
				dto.setCreatedUser(bil.getCreatedUser());
				dto.setDeleted(bil.getDeleted());
				dto.setDetailId(bil.getDetailId());

//				MstProductDto prodDto = mstProductSvc.findByProductCode(order.getProductCode());
//				dto.setProduct(prodDto);
				dto.setAddress(bil.getAddress());
				dto.setPostalCode(bil.getPostalCode());
				dto.setCity(bil.getCity());
				dto.setProvince(bil.getProvince());
				dto.setHomeAddress(bil.getHome_address());
				dto.setWorkAddress(bil.getWorkAddress());
				dto.setUpdatedDate(bil.getUpdatedDate());
				dto.setUpdatedUser(bil.getUpdatedUser());
				
				return dto;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MstBilAddressDetailDto> findByAddressName(String addressName) {
		try {
			List<MstBilAddressDetail> bilAddress = mstBilAddressDetailDao.findByAddressName(addressName);
			if(bilAddress != null && !bilAddress.isEmpty() && bilAddress.size() > 0){
				List<MstBilAddressDetailDto> list = new ArrayList<>();
				
				for(MstBilAddressDetail bil : bilAddress){
					MstBilAddressDetailDto dto = new MstBilAddressDetailDto();
					dto.setCreatedDate(bil.getCreatedDate());
					dto.setCreatedUser(bil.getCreatedUser());
					dto.setDeleted(bil.getDeleted());
					dto.setDetailId(bil.getDetailId());
					
//					MstProductDto prodDto = mstProductSvc.findByProductCode(order.getProductCode());
//					dto.setProduct(prodDto);
					dto.setAddress(bil.getAddress());
					dto.setPostalCode(bil.getPostalCode());
					dto.setCity(bil.getCity());
					dto.setProvince(bil.getProvince());
					dto.setHomeAddress(bil.getHome_address());
					dto.setWorkAddress(bil.getWorkAddress());
					dto.setUpdatedDate(bil.getUpdatedDate());
					dto.setUpdatedUser(bil.getUpdatedUser());
					list.add(dto);
					return list;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
