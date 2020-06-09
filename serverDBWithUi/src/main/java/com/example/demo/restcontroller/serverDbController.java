package com.example.demo.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.serverDbRepo;
import com.example.demo.model.StringResponse;
import com.example.demo.model.serverDb;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class serverDbController {
	
	@Autowired
	serverDbRepo repo;
	

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "home.jsp";
	}
	
	@PutMapping("/modify")
	@ResponseBody
	public StringResponse updateServerDb(@RequestBody serverDb server) {
		
		StringResponse response=new StringResponse();
		
		System.out.println("Inside catch of /modify/{sno} ");
		
		try {
			repo.save(server);
			response.setResponse("updated successfully");
			return response;
		}
		catch(Exception e){
			System.out.println("Inside catch of /modify/{sno} "+e);
			response.setResponse("failed");
			return response;
		}
	}
	
	@RequestMapping("/addServer")
	@ResponseBody
	public StringResponse addServer(@RequestBody serverDb server) {
	 
		StringResponse response = new StringResponse();
		try{
			System.out.println("inside addServer");
			repo.save(server);
			
			response.setResponse("success");
			return response;
		}
		catch(Exception e) {
			System.out.println("Error while saving "+e);
			response.setResponse("failed");
			return response;
		}
		
	}
	
	@RequestMapping("/servers")
	@ResponseBody
	public List<serverDb> getServers() {
		System.out.println("inside servers");
		return repo.findAll();
		
	}
	
	@DeleteMapping("/deleteServer/{sno}")
	@ResponseBody
	public StringResponse deleteStudent(@PathVariable int sno) {
		StringResponse response=new StringResponse();
		serverDb a = repo.getOne(sno);
		repo.delete(a);
		response.setResponse("Deleted Successfully");
		return response;
	}
	
	@RequestMapping("/server/{sno}")
	@ResponseBody
	public Optional<serverDb> getServerById(@PathVariable("sno") int sno) {
		
		return repo.findById(sno);
		
	}
	
	
}