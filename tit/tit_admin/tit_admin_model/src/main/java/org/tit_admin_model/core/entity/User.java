package org.tit_admin_model.core.entity;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.tit_admin_model.core.entity.embedded.Address;
import org.tit_admin_model.core.entity.enums.Role;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * User entity
 *
 * @author: 刘晓勇
 */
@SuppressWarnings("restriction")
@XmlRootElement(name = "user")
public class User extends Entity implements Serializable {
	@XmlElement @NotNull @Size(min = 6, max = 15) 
	private String userName;
	@XmlElement @NotNull @Email
	private String email;
	@XmlElement @NotNull
    private String mobile;
	@XmlElement @NotNull
    private Role role;
	@XmlElement @NotNull @Valid
    private Address address;
	@JsonIgnore @NotNull 
    private @XStreamOmitField String passWord;
	@JsonIgnore 
    private @XStreamOmitField Integer loginCount;
	@JsonIgnore
    private @XStreamOmitField Date currentLoginAt;
	@JsonIgnore
    private @XStreamOmitField Date lastLoginAt;
	@JsonIgnore
    private @XStreamOmitField String currentLoginIp;
	@JsonIgnore
    private @XStreamOmitField String lastLoginIp;

    public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public Integer getLoginCount() {
		return loginCount;
	}


	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}


	public Date getCurrentLoginAt() {
		return currentLoginAt;
	}


	public void setCurrentLoginAt(Date currentLoginAt) {
		this.currentLoginAt = currentLoginAt;
	}


	public Date getLastLoginAt() {
		return lastLoginAt;
	}


	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}


	public String getCurrentLoginIp() {
		return currentLoginIp;
	}


	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}


	public String getLastLoginIp() {
		return lastLoginIp;
	}


	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}


	/**
     * Method to create the SHA hash of the password before storing
     *
     * @param pass
     *
     * @return SHA hash digest of the password
     */
	public static synchronized String hashPassword(String pass) {
        return org.apache.commons.codec.digest.DigestUtils.sha512Hex(pass);
    }


    @Override 
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", role=" + role +
                ", loginCount=" + loginCount +
                ", currentLoginAt=" + currentLoginAt +
                ", lastLoginAt=" + lastLoginAt +
                ", currentLoginIp='" + currentLoginIp + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                '}';
    }
}
