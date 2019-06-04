package service;

import java.util.List;

import dto.MstUserDto;

public interface MstUserService {
	
	public List<MstUserDto> findAll();
	public MstUserDto findByUsernamePassword(String username, String password);
	public void save(MstUserDto mstUserDto);

}
