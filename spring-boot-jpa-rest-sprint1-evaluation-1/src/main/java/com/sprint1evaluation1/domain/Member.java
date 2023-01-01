package com.sprint1evaluation1.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "tbl_customer")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String email;

	private String mobileNo;
	private String gender;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] profilePicture;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date createdAt;
	@UpdateTimestamp

	@Column(name = "updated_at")
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	

	public Member(Long id, String name, String email, String mobileNo, String gender, Date dob, byte[] profilePicture,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.dob = dob;
		this.profilePicture = profilePicture;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Member() {

	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", Email=" + email + ", mobileNo=" + mobileNo + ", gender="
				+ gender + ", dob=" + dob + ", profilePicture=" + Arrays.toString(profilePicture) + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
