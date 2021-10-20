package dz.acs.spring.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import dz.acs.model.AppUser;

@Service
public class UserServiceImpl implements UserService {

	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	@Cacheable("users")
	public AppUser getUserById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM APP_USER WHERE ID=?",new Object[] {id}, new RowMapper<AppUser>() {
			@Override
			public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new AppUser(rs.getLong("ID"),
				rs.getString("NAME"),rs.getString("USER_NAME"),rs.getString("PASSWORD"));				
			}
		});		
		
		 
	}

}
