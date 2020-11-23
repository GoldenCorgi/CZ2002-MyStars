package mystars;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Properties;

public class Mail {
    Session session = null;

    public Mail(Boolean login) {
        if (session == null & login == true) {
            init();
        }
        else if (!login){
            System.out.println("[NO LOGIN EMAIL - DEBUGGING]");

        }
    }


    public static void main(String[] args) {
//        Mail ma = new Mail(true);
        try {
            System.out.println(java.net.InetAddress.getLocalHost());
            System.out.println(System.getProperty("user.name"));
            System.out.println(System.getProperty("user.home"));
            System.out.println(System.getProperty("user.dir"));
            System.out.println(System.getProperties());

        } catch (UnknownHostException e) {
            System.out.println("");
        }

    }

    public static void sendNotification(String messageText, String targetEmail, boolean login) {
        Mail ma = new Mail(login);
        ma.sendMail("test2", "whattohec@gmail.com","CZ2002 - OODP - Email Notification");
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

    public void sendMail(String messageText, String targetEmail, String subject) {
        if (session == null) {
            System.out.println("[EMAIL NOT SENT - SESSION NULL]");
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

            message.setSubject(subject);
            message.setText(messageText);

            Transport.send(message);

            System.out.println("[EMAIL SENT OK]");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Not Sent...");
        }
    }
}
