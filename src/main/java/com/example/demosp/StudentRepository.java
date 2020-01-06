package com.example.demosp;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jani3
 *
 */
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

}
