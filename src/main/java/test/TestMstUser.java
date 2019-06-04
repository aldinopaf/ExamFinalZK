package test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dto.MstUserDto;
import service.MstUserService;

public class TestMstUser {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
		MstUserService mstUserSvc = context.getBean(MstUserService.class);
		
//		MstUserDto dto = mstUserSvc.findByUsernamePassword("tester", "tester");
		
		MstUserDto user = new MstUserDto();
		user.setCreatedDate(new Date());
		user.setCreatedUser("ADMIN");
		user.setUsername("kaizan");
		user.setPassword("kaizan");
		user.setDeleted(false);
//		mstUserSvc.save(user);
//		System.out.println("Username: " + dto.getUsername() + " Password: " + dto.getPassword());
		for(MstUserDto dto : mstUserSvc.findAll()){
			System.out.println("Username: " + dto.getUsername() + " Password: " + dto.getPassword());
		}
		
		
	}

}
