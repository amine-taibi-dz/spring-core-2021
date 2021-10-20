package dz.acs.spring;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {
  public int calculate() {
	  return 42;
  }
  
  public long result() {
	  return 42*42L;
  }
}
