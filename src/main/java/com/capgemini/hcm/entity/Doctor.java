package com.capgemini.hcm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Doctor {
	@Id
	@Column(name = "doctor_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
	@SequenceGenerator(sequenceName = "doctor_seq", initialValue = 1010, allocationSize = 1, name = "doctor_seq")
	private Integer doctorId;

	@NotEmpty(message = "name is mandatory")
	@Column(name = "doctor_Name")
	private String doctorName;

	@NotNull(message = "contact must be mandatory")
	@Size(max = 10, message = "number must be of 10 digit")
	@Column(name = "doctor_contact")
	private Integer contactNumber;

	@NotEmpty(message = "doctorSpecialization is mandatory")
	@Column(name = "doctor_Specialization")
	private String doctorSpecialization;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_Id", referencedColumnName = "test_Id")
	private Tests tests;

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}

	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}

	public Tests getTests() {
		return tests;
	}

	public void setTests(Tests tests) {
		this.tests = tests;
	}

	public Doctor(Integer doctorId, @NotEmpty(message = "name is mandatory") String doctorName,
			@NotNull(message = "contact must be mandatory") @Size(max = 10, message = "number must be of 10 digit") Integer contactNumber,
			@NotEmpty(message = "doctorSpecialization is mandatory") String doctorSpecialization, Tests tests) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.contactNumber = contactNumber;
		this.doctorSpecialization = doctorSpecialization;
		this.tests = tests;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", contactNumber=" + contactNumber
				+ ", doctorSpecialization=" + doctorSpecialization + ", tests=" + tests + "]";
	}

}
