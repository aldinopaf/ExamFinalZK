package test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.MstDepartmentDao;
import dto.MstBilAddressDto;
import entity.MstDepartment;
import service.MstBilAddressService;
import entity.enumcol.GenderEnum;

public class TestBilAddress {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
		MstBilAddressService mstBilAddressSvc = context.getBean(MstBilAddressService.class);
		//MstDepartmentDao mstDepartmentDao = context.getBean(MstDepartmentDao.class);
		
		//MstDepartment dept = mstDepartmentDao.findByDeptName("DIVISI FINANCE");
		
		MstBilAddressDto dto = new MstBilAddressDto();
		dto.setCreatedDate(new Date());
		dto.setCreatedUser("ADMIN");
		dto.setDeleted(false);
		dto.setGender("");
		dto.setId(3);
		dto.setAddressName("Rizky");
		mstBilAddressSvc.save(dto);
		
		dto = mstBilAddressSvc.findByAddressName("Haqi");
		System.out.println(dto.getAddressName()  + " ADDRESSNAME: " + dto.getAddressName());
	}
}
