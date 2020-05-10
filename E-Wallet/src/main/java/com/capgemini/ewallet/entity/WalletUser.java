package com.capgemini.ewallet.entity;
import javax.persistence.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name="walletuser")
@DynamicUpdate(true)
@DynamicInsert(true)
public class WalletUser {
	
	@NotNull(message="User Id is Mandatory")
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="user_seq")
	@SequenceGenerator(sequenceName="user_seq",initialValue=1000,allocationSize=1,name="user_seq")
	private int userId;
	
	@NotNull(message="UserName is Mandatory")
	@Size(min=3,max=25,message="Length must be from 3 to 25 character ")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[ ]+[A-Za-z]+)", message="Only alphabets and space is allowed")
	@Column(name="user_name",length=25)
	private String userName;
	
	@NotNull(message="Password is Mandatory")
	@Size(min=8,max=15,message="Length must be from 3 to 25 character ")
	@Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit.")
	@Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter.")
	@Pattern(regexp = "(?=.*[A-Z])", message = "Password must contain one uppercase letter.")
	@Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.")
	@Pattern(regexp="(?=.*[@#$%^&+=])",message="Password must contain one special character")
	@Pattern(regexp=".{8,} ",message="Password must have atleast 8 character")
	@Column(name="password")
	private String password;
	
	@NotNull(message="Phone number is Mandatory")
	@Size(max=10,message="Number must be of 10 digits")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phoneNumber;
	
	@NotNull(message="Login Name is Mandatory")
	@Size(min=3,max=25,message="Length can be betwwen 3 and 25 chars")
	@Pattern(regexp="([A-Za-z]+)|([A-Za-z]+[][A-Za-z]+)",message="Only Alphabet and blank space is allowed")
	@Column(name="login_name" ,length=25)
	private String loginName;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "acc_Id",referencedColumnName="acc_id")
	private WalletAccount walletaccount;
	
	
	public WalletUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public WalletUser(int userId,String userName,String password, String phoneNumber, String loginName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.loginName = loginName;
	}

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public WalletAccount getWalleAccount() {
		return walletaccount;
	}

	public void setWallet(WalletAccount walletaccount) {
		this.walletaccount = walletaccount;
	}


}
