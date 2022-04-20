package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class emailService {
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendEmail(email e) {

	        SimpleMailMessage email = new SimpleMailMessage();
	        
	        email.setFrom("MADCLOTHESemail@gmail.com");
	        email.setTo(e.getDestinatario());
	        email.setSubject(e.getOrigen());
	        email.setText(e.getTexto());


	        mailSender.send(email);
	    }
}
