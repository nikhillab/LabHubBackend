/**
 * 
 */
package com.labhub.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.labhub.fileservice.FileResponse;

/**
 * @author nikhil
 *
 */
@Entity
public class AssignmentFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assignmentFileId;
	private String name;
	private String description;
	private Date targetDate;
	@OneToOne
	private FileResponse fileResponse;
	private String userName;

	public AssignmentFile() {
	}

	public AssignmentFile( String name, String description, Date targetDate,
			FileResponse fileResponse, String userName) {
		this.name = name;
		this.description = description;
		this.targetDate = targetDate;
		this.fileResponse = fileResponse;
		this.setUserName(userName);
	}
	public Long getAssignmentFileId() {
		return assignmentFileId;
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

	public FileResponse getFileResponse() {
		return fileResponse;
	}

	public void setFileResponse(FileResponse fileResponse) {
		this.fileResponse = fileResponse;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

}
