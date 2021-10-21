package stu.si.myexams.model;
import lombok.Data;


import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Exam {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;
    private String ename;
    private Date date;

    public Exam(){
        super();
    }

}
