package application.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Invitation;
import application.repository.InvitationRepository;
import application.service.IInvitationService;

@Service
public class InvitationService implements IInvitationService {
	@Autowired
	private InvitationRepository invitationRepository;
	
	public Optional<Invitation> getInvitationById(int id) {
		return invitationRepository.findById(id);
	}
	
	public Invitation addInvitation(Invitation invitation) {
		invitationRepository.save(invitation);
		return invitation;
	}
	
	public Invitation updateInvitation(Invitation invitation) {
		invitationRepository.save(invitation);
		return invitation;
	}
	
	public boolean deleteInvitation(int id) {
		Optional<Invitation> invitation = getInvitationById(id);
		if(invitation.isPresent()) {
			invitationRepository.delete(invitation.get());
			return true;
		}else {
			return false;
		}
	}
}
