package mystars;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * Demo app that shows how to construct and send an RFC822
 * (singlepart) message.
 * <p>
 * XXX - allow more than one recipient on the command line
 *
 * @author Max Spivak
 * @author Bill Shannon
 */

public class sg {
    public static void main(String[] argv) throws MessagingException, IOException {
        String to, subject = null, from = null,
                cc = null, bcc = null, url = null;
//        String mailhost = null;
//        String mailer = "msgsend";
//        String file = null;
//        String protocol = null, user = "incognitomaster2000@gmail.com", password = "shibamaster1!";
//        String record = null;
//        String username = "incognitomaster2000@gmail.com";
//        String host = "smtp.gmail.com";

//        Properties props = System.getProperties();


        String host = "smtp.gmail.com";
        String username = "user";
        String password = "passwd";
        Properties props = new Properties();
        props.setProperty("mail.smtp.ssl.enable", "true");
        // set any other needed mail.smtp.* properties here
        Session session = Session.getInstance(props);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("??????????@gmail.fooooobar"));
        to = "whattohec@gmail.com";
        subject = "?@gm";
        cc = null;
        bcc = "whattohec@gmail.com";

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
        if (cc != null)
            msg.setRecipients(Message.RecipientType.CC,
                    InternetAddress.parse(cc, false));
        if (bcc != null)
            msg.setRecipients(Message.RecipientType.BCC,
                    InternetAddress.parse(bcc, false));

        msg.setSubject(subject);

        String text = "test";
        String file = null;

        if (file != null) {
            // Attach the specified file.
            // We need a multipart message to hold the attachment.
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText(text);
            MimeBodyPart mbp2 = new MimeBodyPart();
            mbp2.attachFile(file);
            MimeMultipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);
            msg.setContent(mp);
        } else {
            // If the desired charset is known, you can use
            // setText(text, charset)
            msg.setText(text);
        }
        String mailer = "msgsend";

        msg.setHeader("X-Mailer", mailer);
        msg.setSentDate(new Date());
        Transport.send(msg, username, password);


        // Setup mail server
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

//        props.setProperty("mail.imap.ssl.enable", "true");
        // set any other needed mail.imap.* properties here
//        Session session = Session.getInstance(props);
//        session.setDebug(true);
//
//        Store store = session.getStore("smtp");
//        store.connect(host, username, password);
//
//        to = "whattohec@gmail.com";
//        subject = "?@gm";
//        cc = null;
//        bcc = "whattohec@gmail.com";
//
//        /*
//         * Construct the message and send it.
//         */
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("??????????@gmail.fooooobar"));
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
//        if (cc != null)
//            msg.setRecipients(Message.RecipientType.CC,
//                    InternetAddress.parse(cc, false));
//        if (bcc != null)
//            msg.setRecipients(Message.RecipientType.BCC,
//                    InternetAddress.parse(bcc, false));
//
//        msg.setSubject(subject);
//
//        String text = "test";
//
//        if (file != null) {
//            // Attach the specified file.
//            // We need a multipart message to hold the attachment.
//            MimeBodyPart mbp1 = new MimeBodyPart();
//            mbp1.setText(text);
//            MimeBodyPart mbp2 = new MimeBodyPart();
//            mbp2.attachFile(file);
//            MimeMultipart mp = new MimeMultipart();
//            mp.addBodyPart(mbp1);
//            mp.addBodyPart(mbp2);
//            msg.setContent(mp);
//        } else {
//            // If the desired charset is known, you can use
//            // setText(text, charset)
//            msg.setText(text);
//        }
//
//        msg.setHeader("X-Mailer", mailer);
//        msg.setSentDate(new Date());
//
//        // send the thing off
//        Transport.send(msg);


    }
}

