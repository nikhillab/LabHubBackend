package com.labhub.fileservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fileId;
	private String filename;
	private String fileDownloadUri;
	private String fileType;
	private long size;

	public FileResponse() {
		super();
	}

	public FileResponse(String filename, String fileDownloadUri, String fileType, long size) {
		super();
		this.filename = filename;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public Long getFileId() {
		return fileId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return String.format("FileResponse [fileId=%s, filename=%s, fileDownloadUri=%s, fileType=%s, size=%s]", fileId,
				filename, fileDownloadUri, fileType, size);
	}

	

}