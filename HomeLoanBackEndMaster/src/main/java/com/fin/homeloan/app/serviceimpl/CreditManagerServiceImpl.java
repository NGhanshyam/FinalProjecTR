package com.fin.homeloan.app.serviceimpl;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.fin.homeloan.app.model.EmailSender;
import com.fin.homeloan.app.model.LoanApprovedList;
import com.fin.homeloan.app.model.LoanDetails;
import com.fin.homeloan.app.model.PermanantAddress;
import com.fin.homeloan.app.model.SanctionLetter;
import com.fin.homeloan.app.repository.ApplicantRepository;
import com.fin.homeloan.app.repository.LoanApprovedListRepository;
import com.fin.homeloan.app.repository.LoanDetailsRepository;
import com.fin.homeloan.app.repository.PermanantAddressRepository;
import com.fin.homeloan.app.repository.SanctionLetterRepository;
import com.fin.homeloan.app.servicei.CreditManagerServicei;

public class CreditManagerServiceImpl implements CreditManagerServicei {

	@Autowired
	ApplicantRepository ar;
	@Autowired
	LoanApprovedListRepository lalr;
	@Autowired
	SanctionLetterRepository slr;
	@Autowired
	PermanantAddressRepository pa;
	@Autowired
	JavaMailSender jms;
	@Autowired
	LoanDetailsRepository ldr;

	// ----------------------Loan-Approved-------------------
	@Override
	public LoanApprovedList savelal(LoanApprovedList lal) {

		LoanApprovedList loanal = lalr.save(lal);
		return loanal;
	}

	@Override
	public List<LoanApprovedList> getLoanApprovedList() {
		List<LoanApprovedList> lal = lalr.findAll();
		return lal;
	}

	@Override
	public LoanApprovedList getLoanApprovedList(int id) {
		LoanApprovedList lall = lalr.findByLoanAid(id);
		return lall;
	}

//---------------------------Permanant-Address---------------------------
	@Override
	public PermanantAddress savePAddress(PermanantAddress paddr) {
		PermanantAddress paa = pa.save(paddr);
		return paa;
	}

//---------------------------Loan-Deatails-------------------------------
	@Override
	public LoanDetails saveLoanData(LoanDetails loan) {

		LoanDetails ld = ldr.save(loan);

		return null;
	}

//---------------------------About-Sanction-letter------------------------
	@Override
	public SanctionLetter savesanction(int id, LoanApprovedList lallist, SanctionLetter sl) {
		// TODO Auto-generated method stub
		LoanApprovedList lal = lalr.findByLoanAid(id);
		System.out.println(lal.getLoanDetails().getTenureofLoan());
		sl.setLal(lal);
		return sl;
		/// Ghanshyam --- this mwthod work is pending

	}

	@Override
	public List<SanctionLetter> getSanctionLetterData() {
		List<SanctionLetter> sl = slr.findAll();
		return sl;
	}

	@Override
	public SanctionLetter getDataForLetter(int id) {
		return slr.findBySanctionId(id);
	}
//-------------------------------------------AttachedEmail-----------------------------------
	@Override
	public void sendEmailWithAttachment(EmailSender es) throws MessagingException {

		MimeMessage msg = jms.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(es.getToEmail());
		helper.setFrom(es.getFromEmail());
		helper.setText(es.getTextMessage());
		helper.setSubject(es.getSubject());

		FileSystemResource file = new FileSystemResource(new File("C://Users/Ghanshyam/sanction-letter.pdf"));
		helper.addAttachment(file.getFilename(), file);
		jms.send(msg);
	}

}
