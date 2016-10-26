package com.bootsample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;

@SpringBootApplication
public class SpringBootExample1Application {

	public static HashMap<Long,Student> hmStudent;
	
	public static void main(String[] args) {
		
		
		hmStudent=new HashMap<Long,Student>();
 
		Student one=new Student("John","math");
		hmStudent.put(new Long(one.getId()),one);
		
		SpringApplication.run(SpringBootExample1Application.class, args);
 
		Student two=new Student("Jane","history");
		hmStudent.put(new Long(two.getId()),two);
		
		Student three=new Student("Pradipta","physics");
		hmStudent.put(new Long(three.getId()),three);
		
	}
}
