package com.labhub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.labhub.Entity.AssignmentFile;
import com.labhub.Entity.AssignmentText;
import com.labhub.repo.AssignmentFileRepo;
import com.labhub.repo.FileResposeRepo;

/**
 * @author nikhil All file related controllers are from here
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FileAssignmentController {

	private AssignmentFileRepo fileRepo;
	private FileResposeRepo fileResposeRepo;

	public FileAssignmentController(AssignmentFileRepo fileRepo) {
		this.fileRepo = fileRepo;
	}

	@GetMapping("/getFileAssignments")
	public List<AssignmentFile> getFilessignments() {
		return fileRepo.findAll();
	}

	@GetMapping("/getFileAssignment/{id}")
	public ResponseEntity<AssignmentFile> getFilessignmentById(@PathVariable long id) {
		Optional<AssignmentFile> optional = fileRepo.findById(id);
		if (optional.isPresent()) {
			return new ResponseEntity<AssignmentFile>(optional.get(), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/createFile")
	public ResponseEntity<AssignmentFile> createFileAssignment(@RequestBody AssignmentFile assignentFile) {
		var file = fileRepo.save(assignentFile);
		return new ResponseEntity<AssignmentFile>(file, HttpStatus.CREATED);

	}

	@DeleteMapping("/deleteFile/{id}")
	public ResponseEntity<Boolean> deleteFile(@PathVariable long id) {
		Optional<AssignmentFile> findById = fileRepo.findById(id);
		if (findById.isEmpty())
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		AssignmentFile entity = findById.get();
		fileRepo.delete(entity);
		fileResposeRepo.delete(entity.getFileResponse());
		return new ResponseEntity<>(true, HttpStatus.ACCEPTED);

	}

	@Autowired
	public void setFileResposeRepo(FileResposeRepo fileResposeRepo) {
		this.fileResposeRepo = fileResposeRepo;
	}
}
