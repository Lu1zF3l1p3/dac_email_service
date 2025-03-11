package br.edu.ifpb.dac.email.amqp;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.edu.ifpb.dac.email.Email;
import br.edu.ifpb.dac.email.EmailService;

@Component
public class EmailEventConsumer {

    private EmailService emailService;

    public EmailEventConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = { "email-queue" })
    public void sendEmail(@Payload String json) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Email email = mapper.readValue(json, Email.class);
            System.out.println(email);
            emailService.sendEmail(email);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }



    }

}
