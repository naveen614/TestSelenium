package com.sendmail;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail

{
	public void method(){
		
	}
	
   public static void main(String [] args)
   {    SendEmail em=new SendEmail();

      String to = "nvadla@corp.untd.com";
      String from ="nvadla@corp.untd.com";
      String host = "10.103.32.60";

      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);

      Session session = Session.getDefaultInstance(properties);

      try{
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         message.setSubject("This is the Subject Line!");
         message.setText("This is actual message");
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
