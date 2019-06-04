package controller;

import java.util.List;

import javax.ws.rs.client.ResponseProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import component.RestResponse;

import dto.MstUserDto;
import service.MstUserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	private MstUserService mstUserSvc;
	
	@RequestMapping(
			value="/all",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public RestResponse findAll(){
		try {
			if(mstUserSvc.findAll()!= null && mstUserSvc.findAll().size()>0){
				return new RestResponse(HttpStatus.OK.value(),"Success", mstUserSvc.findAll());
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return new RestResponse(HttpStatus.NOT_FOUND.value(),e.getLocalizedMessage(),null);
		}
		return null;
	}

}
