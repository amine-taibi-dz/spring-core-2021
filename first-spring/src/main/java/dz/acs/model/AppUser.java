package dz.acs.model;

import java.io.Serializable;

public class AppUser implements Serializable{
	@Override
	public String toString() {
		return "AppUser [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	private long id;
	private String name;
	private String email;
	private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AppUser(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public AppUser() {
		super();	
	}


}
