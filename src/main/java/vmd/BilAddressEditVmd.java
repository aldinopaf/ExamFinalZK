package vmd;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;

import service.MstBilAddressService;
import service.MstCityService;
import service.MstDepartmentService;
import service.MstProvinceService;
import dao.MstDepartmentDao;
import dto.MstBilAddressDetailDto;
import dto.MstBilAddressDto;
import dto.MstCityDto;
import dto.MstDepartmentDto;
import dto.MstEmployeeDto;
import dto.MstProvinceDto;
import dto.TrOrderDetailDto;
import entity.MstDepartment;
import entity.enumcol.GenderEnum;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class BilAddressEditVmd {

	@WireVariable
	private MstBilAddressService mstBilAddressSvc;
//	
//	@WireVariable
//	private MstDepartmentService mstDepartmentSvc;
//	
//	@WireVariable
//	private MstDepartmentDao mstDepartmentDao;
//	
//	@WireVariable
//	private MstCityService mstCitySvc;
//	
//	@WireVariable
//	private MstProvinceService mstProvinceSvc;
//	
//	private MstDepartment mstDepartment;
//	
//	private List<MstCityDto> listCity = new ArrayList<MstCityDto>();
//	private List<MstProvinceDto> listProvince = new ArrayList<MstProvinceDto>();
//	private MstCityDto mstCityDto;
//	private MstProvinceDto mstProvinceDto;
	private MstBilAddressDetailDto mstBilAddressDetailDto = new MstBilAddressDetailDto();
	private List<MstBilAddressDetailDto> listBilAddressDetails = new ArrayList<MstBilAddressDetailDto>();
	private MstBilAddressDto mstBilAddressDto = new MstBilAddressDto();
	private GenderEnum gender;
//	private List<MstDepartmentDto> listDepartment = new ArrayList<MstDepartmentDto>();
//	private MstDepartmentDto mstDepartmentDto;
	
	private String genderChoice;
	
	private Messagebox msgBox = new Messagebox();
	private String strMsg = "";
	
	private Boolean visible = true;
	private Boolean statusPopup = false;
	private Boolean readonly = false;

	@Init
	@NotifyChange(value={"genderChoice", "listProvince", "mstProvinceDto","mstCityDto"})
	public void load(){
		mstBilAddressDto = (MstBilAddressDto) Sessions.getCurrent().getAttribute("objBilAddress");
		
		if(mstBilAddressDto != null && mstBilAddressDto.getId() !=  null){
		}
		else{
			mstBilAddressDto = new MstBilAddressDto();
		}
//		genderChoice = mstBilAddressDto.getGender() != null ? mstBilAddressDto.getGender().getCode() : "";
//		getAllDepartment();
//		getAllProvince();
	}
	
	@Command(value="save")
	@NotifyChange(value={"mstBilAddressDto"})
	public void save(){
		MstBilAddressDto mstBilAddressFindOne = new MstBilAddressDto();
		mstBilAddressFindOne = mstBilAddressSvc.findByEmpId(mstBilAddressDto.getId());
		
		if(mstBilAddressFindOne != null && mstBilAddressFindOne.getId() != null){
//			MstDepartmentPk deptPk = new MstDepartmentPk();
//			deptPk.setId(mstDepartmentDto.getId());
//			mstDepartment = mstDepartmentDao.findOne(deptPk);
			
//			mstEmployeeDto.setDepartment(mstDepartment);
//			gender = genderChoice.equalsIgnoreCase("M")? GenderEnum.MALE : GenderEnum.FEMALE;
//			mstBilAddressDto.setGender(gender);
			mstBilAddressSvc.update(mstBilAddressDto);
			Clients.showNotification("Data berhasil diupdate", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("/master/biladdress/biladdress.zul");
		}
		else{
			mstBilAddressSvc.save(mstBilAddressDto);
			Clients.showNotification("Data berhasil disimpan", Clients.NOTIFICATION_TYPE_INFO, null, null, 1500);
			Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
			inc.setSrc("/master/biladdress/biladdress.zul");
		}
	}
	
	@Command(value="back")
	public void back(){
		Include inc = (Include) Executions.getCurrent().getDesktop().getPage("index").getFellow("mainInclude");
		inc.setSrc("/master/biladdress/biladdress.zul");
	}

	@Command(value="addDetail")
	@NotifyChange(value={"statusPopup", "mstBilAddressDetailDto"})
	public void addDetail(){
		setStatusPopup(Boolean.TRUE);
		mstBilAddressDto = new MstBilAddressDto();
	}
	@Command(value="saveDetail")
	@NotifyChange(value={"listBilAddressDetails", "statusPopup"})
	public void saveDetail(){
		listBilAddressDetails.add(mstBilAddressDetailDto);
		
		for(MstBilAddressDetailDto detail : listBilAddressDetails){
			
		}
		setStatusPopup(Boolean.FALSE);
		
	}
	
	@Command(value="backDetail")
	@NotifyChange(value={"statusPopup"})
	public void backDetail(){
		setStatusPopup(Boolean.FALSE);
	}
	
	@Command(value="removeDetail")
	@NotifyChange(value={"listBilAddressDetails"})
	public void removeDetail(){
		listBilAddressDetails.remove(mstBilAddressDetailDto);
	}
	
	
	public MstBilAddressService getMstBilAddressSvc() {
		return mstBilAddressSvc;
	}

	public void setMstBilAddressSvc(MstBilAddressService mstBilAddressSvc) {
		this.mstBilAddressSvc = mstBilAddressSvc;
	}

	public MstBilAddressDto getMstBilAddressDto() {
		return mstBilAddressDto;
	}

	public void setMstBilAddressDto(MstBilAddressDto mstBilAddressDto) {
		this.mstBilAddressDto = mstBilAddressDto;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public String getGenderChoice() {
		return genderChoice;
	}

	public void setGenderChoice(String genderChoice) {
		this.genderChoice = genderChoice;
	}

	public Messagebox getMsgBox() {
		return msgBox;
	}

	public void setMsgBox(Messagebox msgBox) {
		this.msgBox = msgBox;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getStatusPopup() {
		return statusPopup;
	}

	public void setStatusPopup(Boolean statusPopup) {
		this.statusPopup = statusPopup;
	}

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	public MstBilAddressDetailDto getMstBilAddressDetailDto() {
		return mstBilAddressDetailDto;
	}

	public void setMstBilAddressDetailDto(
			MstBilAddressDetailDto mstBilAddressDetailDto) {
		this.mstBilAddressDetailDto = mstBilAddressDetailDto;
	}

	public List<MstBilAddressDetailDto> getListBilAddressDetails() {
		return listBilAddressDetails;
	}

	public void setListBilAddressDetails(
			List<MstBilAddressDetailDto> listBilAddressDetails) {
		this.listBilAddressDetails = listBilAddressDetails;
	}
	
//	@Command(value="findCity")
//	@NotifyChange(value={"listCity","mstCityDto"})
//	public void findCity(){
//		listCity = mstCitySvc.findByProvCode(mstProvinceDto.getProvinceCode());
//	}
	
//	private void getAllDepartment(){
//		if(mstDepartmentSvc.findAllNotDeleted() != null 
//				&& !mstDepartmentSvc.findAllNotDeleted().isEmpty()
//				&& mstDepartmentSvc.findAllNotDeleted().size() > 0){
//			listDepartment = mstDepartmentSvc.findAllNotDeleted();
//		}
//		else{
//			Messagebox.show("Tidak ada daftar Department yang bisa ditampilkan");
//		}
//	}
	
//	private void getAllProvince(){
//		if(mstProvinceSvc.findAllDeletedFalse().size() > 0  
//				&& mstProvinceSvc.findAllDeletedFalse() != null 
//				&& mstProvinceSvc.findAllDeletedFalse().size() > 0){
//			listProvince = mstProvinceSvc.findAllDeletedFalse();
//		}
//		else{
//			Messagebox.show("Tidak ada data Provinsi yang bisa ditampilkan.");
//		}
//	}
}
