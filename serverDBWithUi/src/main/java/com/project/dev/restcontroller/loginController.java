package com.project.dev.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dev.dao.LoginRepo;
import com.project.dev.models.Login;
import com.project.dev.models.StringResponse;



@RestController
@CrossOrigin(origins = "*")
public class loginController {

	@Autowired
	LoginRepo repo;
	
	@GetMapping("/auth")
	@ResponseBody
	public StringResponse doLogin() {
		StringResponse resp=new StringResponse(); 
		if(true)
			resp.setResponse("Successful");
		else
			resp.setResponse("Failed");
		return resp;
	}
	
	@PostMapping("/users")
	@ResponseBody
	public Login addUser(@Validated @RequestBody Login user) throws Exception {
		
		String username=user.getUsername();
		
		Boolean b =repo.existsById(user.getUsername());
		
		if(username!=null && !"".equals(username)) {
			if(!b) {
				return repo.save(user);
			}
			else {
				throw new Exception("Cannot proceed: User with this username alreadt exists");
			}	
		}
		else {
			throw new Exception("Cannot proceed: Username cannot be null");
			//new UserAlreadyExistException("User already exist");
		}
	}
	
	@GetMapping("/getusers")
	@ResponseBody
	public List<Login> getAllUser() {
		List<Login>user=repo.findAll();
		return user;
	}
	
	@GetMapping("/get/{username}")
	@ResponseBody
	public Login getUser(@PathVariable(value = "username") String username) {
		Login user=repo.findByUsername(username);
		return user;
	}
	
	/*@GetMapping("/get/{username}")
	@ResponseBody
	public List<Login> getUser(@PathVariable(value = "username") String username) {
		List<Login>user=repo.findAll();
		return user;
	}*/
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