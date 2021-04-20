/**
 * 
 */
package com.labhub.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.labhubEntity.AssignmentFile;
import com.labhubEntity.AssignmentText;

/**
 * @author nikhil
 *
 */
@Service
public class AssignmentDemo {

	static ArrayList<AssignmentText> list = new ArrayList<>();
	static ArrayList<AssignmentFile> fileList = new ArrayList<>();
	static long fileCounter = 101l;
	static long counter = 104l;

	static {
		list.add(new AssignmentText(101l, "DateBase", "Assignment 1", new Date(), "Select * from student"));
		list.add(new AssignmentText(102l, "DateBase", "Assignment 1", new Date(), "Select * from student"));
		list.add(new AssignmentText(103l, "DateBase", "Assignment 1", new Date(), "Select * from student"));
		list.add(new AssignmentText(104l, "DateBase", "Assignment 1", new Date(), "Select * from student"));
	}

	public List<AssignmentText> getTextList() {
		return list;
	}

	public AssignmentText addText(AssignmentText assignmentText) {
		assignmentText.setAssignentTextId(++counter);
		list.add(assignmentText);
		return assignmentText;
	}

	public List<AssignmentFile> getFileList() {
		return fileList;
	}

	public AssignmentFile addFile(AssignmentFile assignmentFile) {
		assignmentFile.setAssignentFileId(++fileCounter);
		fileList.add(assignmentFile);
		return assignmentFile;
	}

	public Optional<AssignmentText> getByID(long id) {
		for (AssignmentText assignmentText : list) {
			if(assignmentText.getAssignentTextId()==id) {
				return Optional.of(assignmentText);
			}
		}
		return Optional.empty();
	}

}
