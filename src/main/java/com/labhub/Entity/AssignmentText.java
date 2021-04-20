/**
 * 
 */
package com.labhub.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author nikhil
 *
 */

@Entity
public class AssignmentText {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assignmentTextId;
	private String name;
	private String description;
	private Date targetDate;
	private String code;
	private String userName;

	public AssignmentText() {

	}
	public Long getAssignmentTextId() {
		return assignmentTextId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
