/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Mail.sendHtmlEmail;

/**
 *
 * @author PC-Cristopher
 */
public class MailController {

    private final String mailFrom = "misofertasretail@gmail.com";
    private final String password = "qbcymakunmleqiqq";
    private final String port = "587";
    private final String host = "smtp.gmail.com";

    public void enviarBienvenida(String mailTo, String subject, String titulo, String message, String piePagina) {
        try {
            sendHtmlEmail mailer = new sendHtmlEmail();
            String cuerpoMensaje;
//            String cuerpoMensaje = "<i>Wena Ñejoso!</i><br>";
//            cuerpoMensaje += "<b>¿Como esta quedando esta wea?</b><br>";
//            cuerpoMensaje += "<font color=red>shut up vieja culia</font>";
            cuerpoMensaje = "<center>"
                    + "<h1>" + titulo + "</h1><br>"
                    + message
                    + "<br>"
                    + "Vitanos en <a href='http://192.168.1.33:17225/MisOfertasWeb/'>MisOfertas.cl</a>"
                    + "</center>";

            mailer.sendHtmlEmail(host, port, mailFrom, password,
                    mailTo, subject, cuerpoMensaje);
        } catch (Exception e) {
            System.err.println("¡Error! " + e.getMessage());
            System.err.println("¡Error! en -> " + e.getLocalizedMessage());
        }
    }

    public void enviarNewsletter(String mailTo, String subject, String titulo, String urlProducto, String urlImagenProducto, String message, String piePagina) {
        try {
            sendHtmlEmail mailer = new sendHtmlEmail();
            String cuerpoMensaje;
//            String cuerpoMensaje = "<i>Wena Ñejoso!</i><br>";
//            cuerpoMensaje += "<b>¿Como esta quedando esta wea?</b><br>";
//            cuerpoMensaje += "<font color=red>shut up vieja culia</font>";
            cuerpoMensaje = "<center>"
                    + "<h1>" + titulo + "</h1><br>"
                    + message
                    + "<a "
                    + "href='" + urlProducto + "'>"
                    + "<img width='300px'"
                    + "<img heigth='300px'"
                    + "src='" + urlProducto + "'>"
                    + "</a>"
                    + "</img><br>"
                    + "Vitanos en <a href='localhost:17225/MisOfertasWeb/'>MisOfertas.cl</a>"
                    + "</center>";

            mailer.sendHtmlEmail(host, port, mailFrom, password,
                    mailTo, subject, cuerpoMensaje);
        } catch (Exception e) {
            System.err.println("¡Error! " + e.getMessage());
            System.err.println("¡Error! en -> " + e.getLocalizedMessage());
        }
    }
}
