package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.example.demo.dao.loginRepo;
import com.example.demo.model.Login;
import com.example.demo.model.Ticket;
import com.example.demo.service.ResourceNotFoundException;

import javassist.expr.NewArray;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketRepo repo;
	
	@Autowired
	loginRepo loginRepo;
	
	@GetMapping("/getAll")
	@ResponseBody
	public Iterable<Ticket> getAllTickets(){
		return repo.findAll();
	}
	
	@PostMapping("/raise/{empid}")
	@ResponseBody
    public Ticket raiseTicket(@PathVariable (value = "empid") String empid,
                                 @Validated @RequestBody Ticket ticket) {
        return loginRepo.findById(empid).map(user -> {
            ticket.setUser(user);
            return repo.save(ticket);
        }).orElseThrow(() -> new ResourceNotFoundException("USERID " + empid + " not found"));
    }

	@GetMapping("/get/{empid}/ticket")
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
