	package com.spring.mongodb.Repositories;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mongodb.model.Student;
@Repository
public interface StudentRepositories extends CrudRepository<Student, Integer> {

}
