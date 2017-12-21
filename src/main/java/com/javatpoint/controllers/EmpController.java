package com.javatpoint.controllers;

import java.util.ArrayList;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

import com.javatpoint.beans.Emp;  
import com.javatpoint.dao.EmpDao;  

@Controller
public class EmpController {  
	
	/*Tady je jeden zajímavý moment. Nad třídou EmpDao.java není!! anotace @Component
	  injektuju pomocí beany <bean id="dao" class="com.javatpoint.dao.EmpDao">  ve speing-servlet.xml 
	  =>z toho vyplývá, že můžu injektova buď pomocí @Autowired a @Component nebo pomocí 
	  @Autowired a beany v spring-servlet.xml
	  */
	
    @Autowired  
    EmpDao dao;//will inject dao from xml file  
      
    /* It provides list of employees in model object */  
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp(){  
        List<Emp> list=dao.getEmployees();  
        return new ModelAndView("viewemp","list",list);  
    }  

}  
