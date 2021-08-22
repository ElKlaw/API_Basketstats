package application.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.bean.Invitation;
import application.mail.IMailService;
import application.service.IInvitationService;

@RestController
public class InvitationController {
	@Autowired
	private IInvitationService invitationService;
	
	@Autowired
	private IMailService mailService;

	@GetMapping("invitation/{id}")
	public ResponseEntity<Invitation> getInvitationById(@PathVariable("id") Integer id) {
		Optional<Invitation> invitation = invitationService.getInvitationById(id);
		if(invitation.isPresent()) {
			return new ResponseEntity<>(invitation.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="invitation")
	public ResponseEntity<List<Invitation>> addInvitation(@RequestBody List<Invitation> invitations) {
		List<Invitation> invitationsResponse = new ArrayList<Invitation>();
		try {
			for(Invitation invitation : invitations) {
				mailService.sendInvitation(invitation.getEmail());
				Invitation invitationResponse = invitationService.addInvitation(invitation);
				invitationsResponse.add(invitationResponse);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(invitationsResponse, HttpStatus.OK);
	}
	
	@PutMapping("invitation")
	public ResponseEntity<Invitation> updateInvitation(@RequestBody Invitation invitation) {
		Invitation invitationResponse = invitationService.updateInvitation(invitation);
		return new ResponseEntity<>(invitationResponse, HttpStatus.OK);
	}
	
	@DeleteMapping("invitation/{id}")
	public ResponseEntity<Void> deleteInvitation(@PathVariable("id") Integer id) {
		invitationService.deleteInvitation(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

