/**
 * 
 */
package com.labhub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labhub.Entity.AssignmentFile;

/**
 * @author nikhil
 *
 */
@Repository
public interface AssignmentFileRepo extends JpaRepository<AssignmentFile, Long> {

}
