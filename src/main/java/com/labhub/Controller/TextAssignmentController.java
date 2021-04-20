package com.labhub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.labhub.Entity.AssignmentText;
import com.labhub.repo.AssignmentTextRepo;

/**
 * @author nikhil All Text related controllers are from here
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TextAssignmentController {

	private AssignmentTextRepo textRepo;

	public TextAssignmentController(AssignmentTextRepo textRepo) {
		this.textRepo = textRepo;
	}

	@GetMapping("/getTextAssignments")
	public List<AssignmentText> getTextAssignments() {
		return textRepo.findAll();
	}

	@PostMapping("/createText")
	public ResponseEntity<AssignmentText> createTextAssignment(@RequestBody AssignmentText assignentText) {
		//System.out.println(assignentText.getName());
		var add = textRepo.save(assignentText);
		return new ResponseEntity<AssignmentText>(add, HttpStatus.CREATED);

	}

	@GetMapping("/getTextAssignment/{id}")
	public ResponseEntity<AssignmentText> getTextAssignment(@PathVariable long id) {
		var optional = textRepo.findById(id);
		if (optional.isPresent()) {
			return new ResponseEntity<AssignmentText>(optional.get(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/deleteText/{id}")
	public ResponseEntity<Boolean> deleteFile(@PathVariable long id) {
		Optional<AssignmentText> findById = textRepo.findById(id);
		if (findById.isEmpty())
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		textRepo.delete(findById.get());
		return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);

	}
}
