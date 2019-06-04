package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MstDepartmentDao;
import dto.MstDepartmentDto;
import entity.MstDepartment;
import service.MstDepartmentService;

@Service(value="mstDepartmentSvc")
@Transactional
public class MstDepartmentServiceImpl implements MstDepartmentService {

	@Autowired
	private MstDepartmentDao mstDepartmentDao;
	
	@Override
	public void save(MstDepartmentDto mstDepartmentDto) {
		try {
			MstDepartment mstDepartment = new MstDepartment();
			mstDepartment.setCreatedDate(mstDepartmentDto.getCreatedDate());
			mstDepartment.setCreatedUser(mstDepartmentDto.getCreatedUser());
			mstDepartment.setDeleted(mstDepartmentDto.getDeleted());
			mstDepartment.setDeptName(mstDepartmentDto.getDeptName());
			mstDepartment.setUpdatedDate(mstDepartmentDto.getUpdatedDate());
			mstDepartment.setUpdatedUser(mstDepartmentDto.getUpdatedUser());
			mstDepartment.setId(mstDepartmentDto.getId());
			mstDepartmentDao.save(mstDepartment);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MstDepartmentDto> findAll() {
		
		List<MstDepartmentDto> list = null;
		
		try {
			List<MstDepartment> results = mstDepartmentDao.findAll();
			
			if(results != null && !results.isEmpty() && results.size() > 0){
				
				list = new ArrayList<MstDepartmentDto>();
				
				for(MstDepartment dept : results){
					MstDepartmentDto dto = new MstDepartmentDto();
					dto.setCreatedDate(dept.getCreatedDate());
					dto.setCreatedUser(dept.getCreatedUser());
					dto.setDeleted(dept.getDeleted());
					dto.setDeptName(dept.getDeptName());
					dto.setId(dept.getId());
					dto.setUpdatedDate(dept.getUpdatedDate());
					dto.setUpdatedUser(dept.getUpdatedUser());
					
					list.add(dto);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public MstDepartmentDto getLastInserted() {
		MstDepartmentDto mstDeptDto = new MstDepartmentDto();
		try{
			MstDepartment mstDepartment = mstDepartmentDao.getLastInserted();
			
			mstDeptDto.setCreatedDate(mstDepartment.getCreatedDate());
			mstDeptDto.setCreatedUser(mstDepartment.getCreatedUser());
			mstDeptDto.setDeleted(mstDepartment.getDeleted());
			mstDeptDto.setDeptName(mstDepartment.getDeptName());
			mstDeptDto.setId(mstDepartment.getId());
			mstDeptDto.setUpdatedDate(mstDepartment.getUpdatedDate());
			mstDeptDto.setUpdatedUser(mstDepartment.getUpdatedUser());
		}catch(Exception e){
			e.printStackTrace();
		}
		return mstDeptDto;
	}

	@Override
	public MstDepartmentDto findByDeptName(String deptName) {
		MstDepartmentDto dto = null;

		try {
			MstDepartment dept = mstDepartmentDao.findByDeptName(deptName);
			if(dept != null){
				dto = new MstDepartmentDto();
				dto.setCreatedDate(dept.getCreatedDate());
				dto.setCreatedUser(dept.getCreatedUser());
				dto.setDeleted(dept.getDeleted());
				dto.setDeptName(dept.getDeptName());
				dto.setId(dept.getId());
				dto.setUpdatedDate(dept.getUpdatedDate());
				dto.setUpdatedUser(dept.getUpdatedUser());
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto = null;
		}
		return dto;
	}

	@Override
	public List<MstDepartmentDto> findAllNotDeleted() {
List<MstDepartmentDto> list = null;
		
		try {
			List<MstDepartment> results = mstDepartmentDao.findAllNotDeleted();
			
			if(results != null && !results.isEmpty() && results.size() > 0){
				
				list = new ArrayList<MstDepartmentDto>();
				
				for(MstDepartment dept : results){
					MstDepartmentDto dto = new MstDepartmentDto();
					dto.setCreatedDate(dept.getCreatedDate());
					dto.setCreatedUser(dept.getCreatedUser());
					dto.setDeleted(dept.getDeleted());
					dto.setDeptName(dept.getDeptName());
					dto.setId(dept.getId());
					dto.setUpdatedDate(dept.getUpdatedDate());
					dto.setUpdatedUser(dept.getUpdatedUser());
					
					list.add(dto);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
