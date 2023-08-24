package SFRS.SF_Replay_Sport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import SFRS.SF_Replay_Sport.repositories.sfrsRepositories;

@RestController // para poder manejar solicitudes HTTP 
@RequestMapping("")
@CrossOrigin (origins = "http:/localhost:4200")
public class sfrsControllers {

 @Autowired
    private sfrsRepositories repositories; //para conectarse a la base de d y atender las peticiones
    
    
}
