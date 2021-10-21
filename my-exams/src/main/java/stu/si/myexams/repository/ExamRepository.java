package stu.si.myexams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.si.myexams.model.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long>
{

}
