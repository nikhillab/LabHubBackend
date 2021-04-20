/**
 * 
 */
package com.labhub.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.labhub.fileservice.FileResponse;

/**
 * @author nikhil
 *
 */
public interface FileResposeRepo extends CrudRepository<FileResponse, Long> {

	public Optional<FileResponse> findByFilename(String filename);
}
