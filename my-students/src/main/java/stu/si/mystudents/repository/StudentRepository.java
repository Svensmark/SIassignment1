package stu.si.mystudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.si.mystudents.model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>
{

}
