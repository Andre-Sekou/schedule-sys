package com.rj.sys.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the test database table.
 * 
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TEST")
public class Test implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="TEST_NAME")
	private String testName;
	
	@Column(name="TEST_TYPE")
	private String testType;
	
	@OneToMany(mappedBy="test")
	private List<UserTest> userTests;
	
	public UserTest addUserTest(UserTest userTest) {
		getUserTests().add(userTest);
		userTest.setTest(this);

		return userTest;
	}

	public UserTest removeUserTest(UserTest userTest) {
		getUserTests().remove(userTest);
		userTest.setTest(null);

		return userTest;
	}

}