package com.sch.common.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "staffs")
public class Staff extends UserBasicInfo{

	
	
	String qualification;
	
	@Enumerated(EnumType.STRING)
	StaffCategory staffCategory;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "staff_roles",
			joinColumns = @JoinColumn(name = "staff_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	Set<Role> roles = new HashSet<>();
	public Staff() {}
	
	public Staff(String firstName, String lastName, String otherName, String email,
			String password, String qualification) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.otherName = otherName;
		this.email = email;
		this.password = password;
		this.qualification = qualification;
	}


	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public StaffCategory getStaffCategory() {
		return staffCategory;
	}

	public void setStaffCategory(StaffCategory staffCategory) {
		this.staffCategory = staffCategory;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Transient
	public String getFullName() {
		return firstName + " " + otherName + " " + lastName;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", otherName=" + otherName
				+ ", gender=" + gender + ", email=" + email + ", password=" + password + ", qualification="
				+ qualification + ", staffCategory=" + staffCategory + ", roles=" + roles + "]";
	}
	
	
	
}
