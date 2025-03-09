package br.edu.ifpb.dac.email.amqp;

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
    public void sendEmail(@Payload Message<Email> message) {
        Email email = message.getPayload();
        emailService.sendEmail(email);
    }

}
