package com.example.demo;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/emails")
public class emailController {

    @Autowired
    private emailService emailService;
    

	


   @PostMapping("/registrar")
    public void sendRegistrationEmail(@RequestBody List<String> u) {
    	email email = new email(u.get(1), "Registro correctamente en MADCLOTHES, disfrute de nuestra Web","¡Gracias por resgistrarte, disfruta de nuestra tienda");
        emailService.sendEmail(email);
    }
    
    @PostMapping("/borrar")
    public void sendDeleteEmail(@RequestBody List<String> u) {
    	email email = new email(u.get(1), "Has eliminado tu cuenta en  MADCLOTHES esperamos que vuelva en un futuro ","¡Gracias por por todo");
        emailService.sendEmail(email);
    }
  

}
