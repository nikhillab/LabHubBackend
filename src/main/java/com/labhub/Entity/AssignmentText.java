/**
 * 
 */
package com.labhubEntity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author nikhil
 *
 */

@Entity
public class AssignmentText {

	@Id
	private Long assignentTextId;
	private String name;
	private String description;
	private Date targetDate;
	private String code;

	public AssignmentText() {

	}

	public AssignmentText(Long assignentTextId, String name, String description, Date targetDate, String code) {
		this.assignentTextId = assignentTextId;
		this.name = name;
		this.description = description;
		this.targetDate = targetDate;
		this.code = code;
	}

	public Long getAssignentTextId() {
		return assignentTextId;
	}

	public void setAssignentTextId(Long assignentTextId) {
		this.assignentTextId = assignentTextId;
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

	@Override
	public String toString() {
		return String.format("AssignentText [assignentTextId=%s, name=%s, description=%s, targetDate=%s, code=%s]",
				assignentTextId, name, description, targetDate, code);
	}

}
