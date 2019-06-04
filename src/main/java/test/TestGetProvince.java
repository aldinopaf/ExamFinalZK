package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dto.MstProvinceDto;
import service.MstProvinceService;

public class TestGetProvince {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");
		
		MstProvinceService mstProvinceSvc = context.getBean(MstProvinceService.class);
		
		if(mstProvinceSvc.findOneByProvCode("PROV_01") != null){
			MstProvinceDto dto = mstProvinceSvc.findOneByProvCode("PROV_01");
			System.out.println("Province: " + dto.getProvinceName());
		}
		else{
			System.out.println("GAGAL");
		}
	}

}
