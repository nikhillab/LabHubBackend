/**
 * 
 */
package com.labhub.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labhub.Entity.AssignmentText;

/**
 * @author nikhil
 *
 */
@Repository
public interface AssignmentTextRepo extends JpaRepository<AssignmentText, Long> {
	List<AssignmentText> findByUserName(String username);

}
