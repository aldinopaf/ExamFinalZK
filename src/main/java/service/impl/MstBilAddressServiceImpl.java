package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstBilAddressDao;
import dto.MstBilAddressDto;
import entity.MstBilAddress;
import entity.pk.MstBilAddressPk;
import service.MstBilAddressService;

@Service(value="mstBilAddressSvc")
@Transactional
public class MstBilAddressServiceImpl implements MstBilAddressService{

	@Autowired
	private MstBilAddressDao mstBilAddressDao;
	
	@Override
	public void save(MstBilAddressDto mstBilAddressDto) {
		try {
			MstBilAddress mstBilAddress = new MstBilAddress();
			mstBilAddress.setCreatedDate(mstBilAddressDto.getCreatedDate());
			mstBilAddress.setCreatedUser(mstBilAddressDto.getCreatedUser());
			mstBilAddress.setDeleted(mstBilAddressDto.getDeleted());
			mstBilAddress.setId(mstBilAddressDto.getId());
			mstBilAddress.setJob(mstBilAddressDto.getJob());
			mstBilAddress.setAddressName(mstBilAddressDto.getAddressName());
			mstBilAddress.setUpdatedDate(mstBilAddressDto.getUpdatedDate());
			mstBilAddress.setUpdatedUser(mstBilAddressDto.getUpdatedUser());
			mstBilAddress.setGender(mstBilAddressDto.getGender());
			mstBilAddressDao.save(mstBilAddress);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<MstBilAddressDto> findAll() {
		List<MstBilAddressDto> list = null;
		try {
			List<MstBilAddress> res = mstBilAddressDao.findAll();
			if(res != null && !res.isEmpty() && res.size() > 0){
				list = new ArrayList<MstBilAddressDto>();
				
				for(MstBilAddress mstBilAddress : res){
					MstBilAddressDto dto = new MstBilAddressDto();
					dto.setCreatedDate(mstBilAddress.getCreatedDate());
					dto.setCreatedUser(mstBilAddress.getCreatedUser());

					dto.setDeleted(mstBilAddress.getDeleted());
					dto.setId(mstBilAddress.getId());
					dto.setGender(mstBilAddress.getGender());
					dto.setJob(mstBilAddress.getJob());
					dto.setAddressName(mstBilAddress.getAddressName());
					dto.setUpdatedDate(mstBilAddress.getUpdatedDate());
					dto.setUpdatedUser(mstBilAddress.getUpdatedUser());

					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		return list;
	}

	@Override
	public void delete(MstBilAddressDto mstBilAddressDto) {
		try {
			MstBilAddressPk billAddPk = new MstBilAddressPk();
			billAddPk.setId(mstBilAddressDto.getId());
			
			MstBilAddress mstBilAddress = mstBilAddressDao.findOne(billAddPk);
			if(mstBilAddress != null && mstBilAddress.getId() != null){
				mstBilAddress.setDeleted(true);
				mstBilAddress.setUpdatedDate(new Date());
				mstBilAddress.setUpdatedUser("ADMIN");
				mstBilAddressDao.save(mstBilAddress);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public MstBilAddressDto findByEmpId(Integer addressId) {
//		try {
//			MstBilAddressPk billAddPk = new MstBilAddressPk();
//			billAddPk.setId(addressId);
//			MstBilAddressDto dto = null;
//			MstBilAddress mstBilAddress = mstBilAddressDao.findOne(billAddPk);
//			if(mstBilAddress != null && mstBilAddress.getIdAddress() != null){
//				dto = new MstBilAddressDto();
//				dto.setCreatedDate(mstBilAddress.getCreatedDate());
//				dto.setCreatedUser(mstBilAddress.getCreatedUser());
//				dto.setDeleted(mstBilAddress.getDeleted());
//				dto.setGender(mstBilAddress.getGender());
//				dto.setIdAddress(mstBilAddress.getIdAddress());
//				dto.setAddressName(mstBilAddress.getAddressName());
//				dto.setUpdatedDate(mstBilAddress.getUpdatedDate());
//				dto.setUpdatedUser(mstBilAddress.getUpdatedUser());
//			}
//			return dto;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	@Override
	public void update(MstBilAddressDto mstBilAddressDto) {
		try {
			MstBilAddressPk bilAddressPk = new MstBilAddressPk();
			bilAddressPk.setId(mstBilAddressDto.getId());
			
			MstBilAddress mstBilAddress = mstBilAddressDao.findOne(bilAddressPk);
			if(mstBilAddress != null && mstBilAddress.getId() != null){
				mstBilAddress.setDeleted(mstBilAddressDto.getDeleted());
				mstBilAddress.setUpdatedDate(new Date());
				mstBilAddress.setUpdatedUser("ADMIN");
				mstBilAddress.setGender(mstBilAddressDto.getGender());
				mstBilAddress.setAddressName(mstBilAddressDto.getAddressName());

				mstBilAddressDao.save(mstBilAddress);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public MstBilAddressDto findByAddressName(String addressName) {
		try {
			MstBilAddress mstBilAddress = mstBilAddressDao.findByAddressName(addressName);
			if(mstBilAddress != null && !mstBilAddress.getId().equals(0) && !mstBilAddress.getAddressName().equalsIgnoreCase("")){
				MstBilAddressDto dto = new MstBilAddressDto();
				dto.setCreatedDate(mstBilAddress.getCreatedDate());
				dto.setCreatedUser(mstBilAddress.getCreatedUser());
				dto.setDeleted(mstBilAddress.getDeleted());
				dto.setGender(mstBilAddress.getGender());
				dto.setId(mstBilAddress.getId());
				dto.setJob(mstBilAddress.getJob());
				dto.setAddressName(mstBilAddress.getAddressName());
				dto.setUpdatedDate(mstBilAddress.getUpdatedDate());
				dto.setUpdatedUser(mstBilAddress.getUpdatedUser());

				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MstBilAddressDto findByEmpId(Integer addressId) {
		// TODO Auto-generated method stub
		return null;
	}

}
