package com.services.impl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

@Service
public class MailService {

	Session newSession = null;

	// fonction d'envoi du message
	public void sendMail(Session newSession, MimeMessage mimeMessage) throws MessagingException {
		// declaration des identifiants de l'expediteur pour le service considéré
		// (ici gmail)
		String fromUser = "GDLTest0@gmail.com";
		String fromUserPassword = "test0MDP@";
		String emailHost = "smtp.gmail.com";

		// definition du protocole de transport
		Transport transport = newSession.getTransport("smtp");

		// connection
		transport.connect(emailHost, fromUser, fromUserPassword);

		// envoi du message
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

		// fermeture de la connection
		transport.close();
	}

	public MimeMessage draftMail(List<String> rec, String sub, String txt) throws AddressException, MessagingException {

		// creation du message
		MimeMessage mimeMessage = new MimeMessage(newSession);

		// ajout des recepteurs
		for(String r:rec) {
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(r));
		}
		// definition du sujet du message
		mimeMessage.setSubject(sub);

		// definition du multipart du message (au cas ou on veut joindre un fichier)
		MimeMultipart multiPart = new MimeMultipart();

		// definition du corps de texte
		MimeBodyPart bodyPart = new MimeBodyPart();

		// ajout du texte au corps du message et selection du style d'ecriture
		bodyPart.setText(txt); 

		// ajout du corps au multipart
		multiPart.addBodyPart(bodyPart);

		// ajout du multipart au message
		mimeMessage.setContent(multiPart);

		return mimeMessage;
	}

	
	//definition de la session utilisée pour le message
	public Session setupServerProperties() {
		
		//definition des propriétés de la session
		Properties prop = System.getProperties();
		
		//definition et ajout du port à utiliser dans les propriétés
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		//ajout des propirétés dans la session
		newSession = Session.getDefaultInstance(prop, null);
		return newSession;
	}
	
	public void mail(List<String> rec, String sub, String txt) {
		newSession=this.setupServerProperties();
		
		try {
			MimeMessage mimeMessage=this.draftMail(rec, sub, txt);
			this.sendMail(newSession, mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
