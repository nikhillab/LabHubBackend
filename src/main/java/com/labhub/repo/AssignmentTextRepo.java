/**
 * 
 */
package com.labhub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labhub.Entity.AssignmentText;

/**
 * @author nikhil
 *
 */
@Repository
public interface AssignmentTextRepo extends JpaRepository<AssignmentText, Long> {

}
