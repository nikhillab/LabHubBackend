package com.labhub.fileservice;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.labhub.repo.FileResposeRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("files")
public class FileController {

	private FileStorageService fileStorageService;
	private FileResposeRepo fileResposeRepo;

	public FileController(FileStorageService fileStorageService) {
		this.fileStorageService = fileStorageService;
	}

	@PutMapping
	public ResponseEntity<FileResponse> uploadFile(@RequestParam("file") MultipartFile file) {
		// if file exist then return error
		Optional<FileResponse> findByFilename = fileResposeRepo.findByFilename(file.getOriginalFilename());
		if (findByFilename.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(fileName)
				.toUriString();

		FileResponse fileResponse = new FileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
		// save the file and return
		FileResponse savedFile = fileResposeRepo.save(fileResponse);
		System.out.println(savedFile);
		return new ResponseEntity<FileResponse>(savedFile, HttpStatus.OK);
	}

	@GetMapping("/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {

		Resource resource = fileStorageService.loadFileAsResource(fileName);

		String contentType = null;

		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			System.out.println("Could not determine fileType");
		}

		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);
	}

	@Autowired
	public void setFileResposeRepo(FileResposeRepo fileResposeRepo) {
		this.fileResposeRepo = fileResposeRepo;
	}

}