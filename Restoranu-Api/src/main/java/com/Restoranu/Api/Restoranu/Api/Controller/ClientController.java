package com.Restoranu.Api.Restoranu.Api.Controller;


import com.Restoranu.Api.Restoranu.Api.Entity.ClientsEntity;
import com.Restoranu.Api.Restoranu.Api.Service.ClientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientService ClientService;

	@PostMapping("/clients")
	public ClientsEntity create(@RequestBody ClientsEntity client){
		return ClientService.create(client);
	}

	@GetMapping("/clients")
	public List<ClientsEntity> getClients(){
        return ClientService.getClients();
    }
}
