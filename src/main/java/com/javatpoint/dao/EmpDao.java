package com.javatpoint.dao;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.javatpoint.beans.Emp;  

@Component
public class EmpDao {  
	
//Klíčová knihovna Spring pro Db. Z ní jsou pujčeny metody queryForObject(), query()
//https://stackoverflow.com/questions/22019796/error-whats-missing-in-spring-namedjdbctemplate
		
@Autowired
  private JdbcTemplate template;  


  //Pomocí vlastnosti <property name="template"> v .xml dělám DI skrze tento setter
 public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
 
public List<Emp> getEmployees(){  
    return template.query("select * from Emp500",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt(1));  
            e.setFirstname(rs.getString(2));  
            e.setLastname(rs.getString(3));  
            return e;  
        }  
    });  
}  
}  