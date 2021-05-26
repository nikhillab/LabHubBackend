/**
 * 
 */
package com.labhub.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labhub.Entity.AssignmentFile;

/**
 * @author nikhil
 *
 */
@Repository
public interface AssignmentFileRepo extends JpaRepository<AssignmentFile, Long> {

	List<AssignmentFile> findByUserName(String username);

}
