package application.mail;

public interface IMailService {
	void sendSimpleMessage(String to, String subject, String text);
	void sendInvitation(String to) throws Exception;
}
