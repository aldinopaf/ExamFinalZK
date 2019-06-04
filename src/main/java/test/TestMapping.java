package test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dto.MstDepartmentDto;
import service.MstDepartmentService;

public class TestMapping {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
		MstDepartmentService mstDepartmentSvc = context.getBean(MstDepartmentService.class);
		
		MstDepartmentDto mstDeptDto = new MstDepartmentDto();
		mstDeptDto.setCreatedDate(new Date());
		mstDeptDto.setCreatedUser("ADMIN");
		mstDeptDto.setDeleted(false);
		mstDeptDto.setDeptName("DIVISI FINANCE");
		mstDeptDto.setId(1);
		mstDepartmentSvc.save(mstDeptDto);
		
		MstDepartmentDto deptLastInsert = mstDepartmentSvc.getLastInserted();
		System.out.println("DEPT NAME: " + deptLastInsert.getDeptName() + ", DEPT ID: " + deptLastInsert.getId());
	}

}
