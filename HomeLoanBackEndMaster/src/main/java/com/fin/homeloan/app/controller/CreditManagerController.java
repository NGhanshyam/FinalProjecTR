package com.fin.homeloan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fin.homeloan.app.model.EmailSender;
import com.fin.homeloan.app.model.LoanApprovedList;
import com.fin.homeloan.app.model.SanctionLetter;
import com.fin.homeloan.app.servicei.CreditManagerServicei;


@RestController
public class CreditManagerController {

	@Autowired
	CreditManagerServicei cms;
//-----------------------------------loan-Approve-list-Ghanshyam-----------------------------------------
	@PostMapping("/saveloanapprovelist")
	public LoanApprovedList saveData(@RequestBody LoanApprovedList lal) {
		return cms.savelal(lal);
	}

	@GetMapping("/getloanapprovelist")
	public List<LoanApprovedList> getListLoanApprovedData() {
		List<LoanApprovedList> lal = cms.getLoanApprovedList();
		return lal;
	}

	@GetMapping("/getLoanApprovedapplicant/{loanAid}")
	public LoanApprovedList getLoanApprovedListData(@PathVariable("loanAid") int id) {
		LoanApprovedList lal = cms.getLoanApprovedList(id);
		return lal;
	}
//-----------------------------------Snctionletter-Ghanshyam---COMMENT--Calculate Emi work is Pending-----------------------------------------
	@PostMapping("/calculateEMI/{loanAid}")
	public SanctionLetter saveData(@PathVariable ("loanAid") int id,@RequestBody LoanApprovedList lallist)
	{
		SanctionLetter sl=new SanctionLetter();
		return cms.savesanction(id,lallist,sl);
	}
	@GetMapping("/getAllSanctionLetterData")
	public List<SanctionLetter> getAllSanctionLetterData()
	{
		List<SanctionLetter> sl = cms.getSanctionLetterData();
		return sl;
	}
	
	@GetMapping("/getSanctionLetterData/{sanctionId}")
	public SanctionLetter getDataForLetter(@PathVariable("sanctionId") int id)
	{
		return cms.getDataForLetter(id);
	}
//-----------------------------Email Attach And Send------------------------------------------------------
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping(value="/emailsendwithattachment")
	public String emailsendwithattachment(@RequestBody EmailSender es)
	{
		es.setFromEmail(fromEmail);
		System.out.println(es.getFromEmail());
		System.out.println(es.getToEmail());
		System.out.println(es.getSubject());
		System.out.println(es.getTextMessage());
		System.out.println(es.getClass());
		try {
			cms.sendEmailWithAttachment(es);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Email can not be send";
		}
		return "Email send Successfully";
	}

}
