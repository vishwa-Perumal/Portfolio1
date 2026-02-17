package BasciMail;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class BasicMail1 {

    public static void main(String[] args) {

        final String fromEmail = "vishwa.contact10@gmail.com";
        final String password = "fznuhhugjwspkzym"; 
        final String toEmail = "vishwavip300@gmail.com";

        // 1️⃣ SMTP configuration
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // 2️⃣ Create authenticated session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            // 3️⃣ Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject("Hello from Java SMTP");
            message.setText("This email was sent using Java SMTP.");

            // 4️⃣ Send email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

