package com.dp.springboot;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration_requests")
public class RegistrationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String ownerName;
    private String rollNo;
    private String ownerEmail;
    private String accessCode;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

	public RegistrationRequest(Long id, String companyName, String ownerName, String rollNo, String ownerEmail,
			String accessCode) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.ownerName = ownerName;
		this.rollNo = rollNo;
		this.ownerEmail = ownerEmail;
		this.accessCode = accessCode;
	}

	public RegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

