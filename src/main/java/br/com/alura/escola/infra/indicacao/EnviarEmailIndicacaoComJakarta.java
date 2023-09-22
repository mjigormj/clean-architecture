package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.ComunicacaoEmail;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EnviarEmailIndicacaoComJakarta implements EnviarEmailIndicacao {

    final String HOSTNAME = "smtp.outlook.com";

    @Override
    public void enviarPara(ComunicacaoEmail comunicacao) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOSTNAME);
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");


        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("seuEmail@outlook.com",
                                "senhaEmail");
                    }
                });

        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(""));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(comunicacao.getEmail() + ", outroEmail@email");

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Inicio das Aulas!!!");//Assunto
            message.setText(comunicacao.getMensagem());
            /**Método para enviar a mensagem criada*/
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
