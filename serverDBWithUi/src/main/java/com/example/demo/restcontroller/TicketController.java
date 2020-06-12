package com.example.demo.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.TicketRepo;
import com.example.demo.dao.LoginRepo;
import com.example.demo.model.Ticket;
import com.example.demo.service.ResourceNotFoundException;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketRepo repo;
	
	@Autowired
	LoginRepo loginRepo;
	
	@GetMapping("/getAll")
	@ResponseBody
	public Iterable<Ticket> getAllTickets(){
		return repo.findAll();
	}
	
	@PostMapping("/raise/{empid}")
	@ResponseBody
    public Ticket raiseTicket(@PathVariable (value = "empid") String empid,
                                 @Validated @RequestBody Ticket ticket) {
		
		Date date=new Date();
		DateFormat dateFormat = new SimpleDateFormat("MMyyHHddmmss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));
        
		
		return loginRepo.findById(empid).map(user -> {
            ticket.setUser(user);
            ticket.setTicketId("OmniS-"+ticket.getUser().getUsername()+"-"+dateFormat.format(date));
            return repo.save(ticket);
        }).orElseThrow(() -> new ResourceNotFoundException("USERID " + empid + " not found"));
    }

	@GetMapping("/get/{empid}")
	@ResponseBody
	public List<Ticket> getTicketsByEmpId(@PathVariable(value = "empid") String empid) {	
	
		List<Ticket> ticketsById=null;
		List<Ticket> tickets=repo.findAll();
		for(Ticket ticket: tickets){
			if(ticket.getUser().getUsername().equals(empid)) {
				if(ticketsById==null) {
					ticketsById=new ArrayList<>(); 
				}
				ticketsById.add(ticket);
			}
		}
		return ticketsById;
	}
	
}
