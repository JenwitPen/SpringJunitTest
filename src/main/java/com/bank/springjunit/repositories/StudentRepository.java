package com.bank.springjunit.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.springjunit.model.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}