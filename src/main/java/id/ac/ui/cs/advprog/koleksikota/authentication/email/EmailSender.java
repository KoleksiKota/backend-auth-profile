package id.ac.ui.cs.advprog.koleksikota.authentication.email;

public interface EmailSender {
    void send(String to, String email);
}