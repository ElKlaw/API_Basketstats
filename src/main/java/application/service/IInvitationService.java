package application.service;

import java.util.Optional;

import application.bean.Invitation;

public interface IInvitationService {
	Optional<Invitation> getInvitationById(int id);
	Invitation addInvitation(Invitation invitation);
	Invitation updateInvitation(Invitation invitation);
	boolean deleteInvitation(int id);
}
