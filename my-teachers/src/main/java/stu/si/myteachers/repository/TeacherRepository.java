package stu.si.myteachers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.si.myteachers.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long>
{

}
