package com.fin.homeloan.app.servicei;

import java.util.List;

import javax.mail.MessagingException;

import com.fin.homeloan.app.model.EmailSender;
import com.fin.homeloan.app.model.LoanApprovedList;
import com.fin.homeloan.app.model.LoanDetails;
import com.fin.homeloan.app.model.PermanantAddress;
import com.fin.homeloan.app.model.SanctionLetter;

public interface CreditManagerServicei {

	LoanApprovedList savelal(LoanApprovedList lal);

	List<LoanApprovedList> getLoanApprovedList();

	LoanApprovedList getLoanApprovedList(int id);

	SanctionLetter savesanction(int id, LoanApprovedList lallist, SanctionLetter sl);

	List<SanctionLetter> getSanctionLetterData();

	SanctionLetter getDataForLetter(int id);

	void sendEmailWithAttachment(EmailSender es) throws MessagingException; 
	
	PermanantAddress savePAddress(PermanantAddress paddr);

	LoanDetails saveLoanData(LoanDetails loan);

}
