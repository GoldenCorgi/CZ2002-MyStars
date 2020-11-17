package mystars;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailMan {
    Session session = null;

    public MailMan() {
        if (session == null) {
            init();
        }
    }

    public static void main(String[] args) {
        MailMan ma = new MailMan();
        ma.sendMail("test2", "whattohec@gmail.com");
    }


    public void init() {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("incognitomaster2000@gmail.com", "shibamaster1!");
            }
        });
        if (session != null) {
            System.out.println("[EMAIL LOGIN OK]");
        } else {
            System.out.println("[EMAIL LOGIN NOK]");
        }
    }

    public void sendMail(String messageText, String targetEmail) {
        if (session == null) {
            System.exit(0);
        }
        try {

            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress("ihatejava@gmail.com", "Nam Joo-Hyuk"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            message.setReplyTo(InternetAddress.parse("yliew004@e.ntu.edu.sg"));


            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(targetEmail));
            message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse("youshingzxc@gmail.com", false));

            message.setSubject("CZ2002 - OODP - Email Notification");
            message.setText(messageText);

            Transport.send(message);

            System.out.println("[EMAIL SENT OK]");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Not Sent...");
        }
    }
}
