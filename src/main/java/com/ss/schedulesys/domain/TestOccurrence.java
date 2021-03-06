package com.ss.schedulesys.domain;
// Generated Feb 11, 2017 7:27:59 PM by Hibernate Tools 5.0.0.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TestOccurrence generated by hbm2java
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test_occurrence", catalog = "schedulesys_db")
public class TestOccurrence implements java.io.Serializable {

	private static final long serialVersionUID = -2496662569883001774L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "fk_testoccurrence_employee"))
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "test_id", nullable = false, foreignKey = @ForeignKey(name = "fk_testoccurrence_test"))
	private Test test;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "test_subcategory_id", foreignKey = @ForeignKey(name = "fk_testoccurrence_category"))
	private TestSubcategory testSubcategory;
	
	@Column(name = "is_applicable", nullable = false)
	private boolean applicable;
	
	@JsonFormat(timezone = "America/New_York")
	@Temporal(TemporalType.DATE)
	@Column(name = "expiry_date", length = 10)
	private Date expirationDate;
	
	@JsonFormat(timezone = "America/New_York")
	@Temporal(TemporalType.DATE)
	@Column(name = "completion_date", length = 10)
	private Date completionDate;
	
	public TestOccurrence test(Test test){
		this.test = test;
		return this;
	}
	
	public TestOccurrence testSubcategory(TestSubcategory testSubcategory){
		this.testSubcategory = testSubcategory;
		return this;
	}
	
	public TestOccurrence employee(Employee employee){
		this.employee = employee;
		return this;
	}
	
	public TestOccurrence expiryDate(Date expiryDate){
		this.expirationDate = expiryDate;
		return this;
	}
	
	public TestOccurrence completionDate(Date completionDate){
		this.completionDate = completionDate;
		return this;
	}

}