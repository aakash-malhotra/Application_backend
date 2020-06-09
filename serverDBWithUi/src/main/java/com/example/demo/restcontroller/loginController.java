package com.example.demo.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.loginRepo;
import com.example.demo.model.Login;
import com.example.demo.model.StringResponse;

@RestController
@CrossOrigin(origins = "*")
public class loginController {

	@Autowired
	loginRepo repo;
	
	@GetMapping("/auth")
	@ResponseBody
	public StringResponse doLogin() {
		StringResponse resp=new StringResponse(); 
		resp.setResponse("Successful");
		return resp;
	}
	
	@PostMapping("/adduser")
	@ResponseBody
	public Login addUser(@Validated @RequestBody Login user) {
		return repo.save(user);
		
	}
	
	@GetMapping("/getusers")
	@ResponseBody
	public List<Login> getAllUser() {
		List<Login>user=repo.findAll();
		return user;
	}
/*

	loginRepo repo;
	

	@PostMapping("/login")
	@ResponseBody
	public StringResponse getLogin(@RequestBody Login log) {
		System.out.println("Inside \\login"+log);
		//output string
		StringResponse output=new StringResponse();
		
		try {
			//For looking inside the db
			Login l = repo.findById(log.getUsername()).get();
	
			if(!l.equals(null))
			{
				
				
				String passowrd = l.getPassword();
				String user = l.getUsername();
				
				if(passowrd.equals(log.getPassword())) {
					output.setResponse("true");
				}
				else {
					output.setResponse("false");
				}
			}
			else {
				output.setResponse("false");;
			}
			return output;
		}
		catch(Exception e){
			
			output.setResponse("false");
			return output;
		}
	}
	
	
*/
}