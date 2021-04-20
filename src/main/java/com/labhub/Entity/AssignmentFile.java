/**
 * 
 */
package com.labhubEntity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.labhub.fileservice.FileResponse;

/**
 * @author nikhil
 *
 */
@Entity
public class AssignmentFile {
	@Id
	private Long assignentFileId;
	private String name;
	private String description;
	private Date targetDate;
	private FileResponse fileResponse;

	public AssignmentFile() {
		super();
	}
	

	public AssignmentFile(Long assignentFileId, String name, String description, Date targetDate,
			FileResponse fileResponse) {
		this.assignentFileId = assignentFileId;
		this.name = name;
		this.description = description;
		this.targetDate = targetDate;
		this.fileResponse = fileResponse;
	}


	public Long getAssignentFileId() {
		return assignentFileId;
	}

	public void setAssignentFileId(Long assignentFileId) {
		this.assignentFileId = assignentFileId;
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

	@Override
	public String toString() {
		return String.format(
				"AssignmentFile [assignentFileId=%s, name=%s, description=%s, targetDate=%s, fileResponse=%s]",
				assignentFileId, name, description, targetDate, fileResponse);
	}


}
