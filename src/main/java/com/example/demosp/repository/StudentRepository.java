package com.example.demosp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demosp.domain.Student;

/**
 * @author jani3
 *
 */
@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

}
