package vmd;

import java.util.List;

import page.SidebarPage;
import page.SidebarPageConfig;
import page.SidebarPageConfigAjaxBasedImpl;

public class SidebarAjaxBasedVmd {

	private SidebarPageConfig pageConfig = new SidebarPageConfigAjaxBasedImpl();
	
	public List<SidebarPage> getSidebarPages(){
		return pageConfig.getPages();
	}
	
}
