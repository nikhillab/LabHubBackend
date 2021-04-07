/**
 * 
 */
package com.labhub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.labhub.repo.AssignmentDemo;
import com.labhubEntity.AssignmentFile;
import com.labhubEntity.AssignmentText;

/**
 * @author nikhil
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AssignmentController {

	private AssignmentDemo assignmentRepo;

	public AssignmentController(AssignmentDemo assignmentRepo) {
		this.assignmentRepo = assignmentRepo;
	}

	/*
	 * All Text related controllers are from here 
	 * 
	 * */
	@GetMapping("/getTextAssignments")
	public List<AssignmentText> getTextAssignments() {
		return assignmentRepo.getTextList();
	}

	@PostMapping("/createText")
	public ResponseEntity<AssignmentText> createTextAssignment(@RequestBody AssignmentText assignentText) {
		var add = assignmentRepo.addText(assignentText);
		return new ResponseEntity<AssignmentText>(add, HttpStatus.CREATED);

	}
	@GetMapping("/getTextAssignment/{id}")
	public  ResponseEntity<AssignmentText> getTextAssignment(@PathVariable long id) {
		var optional = assignmentRepo.getByID(id);
		if(optional.isPresent()) {
			return new ResponseEntity<AssignmentText>(optional.get(), HttpStatus.ACCEPTED);
		}
		return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	/*
	 * All file related controllers are from here 
	 * 
	 * */
	
	@GetMapping("/getFileAssignments")
	public List<AssignmentFile> getFilessignments() {
		return assignmentRepo.getFileList();
	}

	@PostMapping("/createFile")
	public ResponseEntity<AssignmentFile> createFileAssignment(@RequestBody AssignmentFile assignentFile) {
		var file = assignmentRepo.addFile(assignentFile);
		return new ResponseEntity<AssignmentFile>(file, HttpStatus.CREATED);

	}
}
