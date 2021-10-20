package dz.acs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class ThridNonBean {
	
	private FirstBean fb;
	public FirstBean getFb() {
		return fb;
	}
	@Autowired
	public void setFb(FirstBean fb) {
		this.fb = fb;
	}
}
