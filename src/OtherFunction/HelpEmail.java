package OtherFunction;

//import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;


import java.util.Properties;

public class HelpEmail {

	public static void sendMail(String email, String title, String content) {
		String username = "songsingur@gmail.com";
        String password = "xbmhypoperrsiyhf";

        Properties prop = new Properties();
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true"); //TLS
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
        
        prop.put("mail.smtp.user","username"); 
        prop.put("mail.smtp.host", "smtp.gmail.com"); 
        prop.put("mail.smtp.port", "25"); 
        prop.put("mail.debug", "true"); 
        prop.put("mail.smtp.auth", "true"); 
        prop.put("mail.smtp.starttls.enable","true"); 
        prop.put("mail.smtp.EnableSSL.enable","true");
        
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
        prop.setProperty("mail.smtp.socketFactory.fallback", "false");   
        prop.setProperty("mail.smtp.port", "465");   
        prop.setProperty("mail.smtp.socketFactory.port", "465"); 
    
       
        
        Session session = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {

//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("from@gmail.com"));
//            message.setRecipients(
//                    Message.RecipientType.TO,
//                    InternetAddress.parse("to_username_a@gmail.com, to_username_b@yahoo.com")
//            );
//            message.setSubject("Testing Gmail TLS");
//            message.setText("Dear Mail Crawler,"
//                    + "\n\n Please do not spam my email!");
//
//            Transport.send(message);
//
//            System.out.println("Done");
        	
        	MimeMessage message = new MimeMessage(session);
        	message.setFrom(new InternetAddress(username)); //from
        	message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));  // to
        	message.setSubject(title);
        	message.setText(content);
        	
//        	Transport transport = session.getTransport("smtps");   
        	
        	Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
    public static void main(String[] args) {
    	sendMail("nguyenthientu413@gmail.com", "Gửi từ SingUrSong karaoke", "Mã xác nhận của bạn là: 123456");
    }

}