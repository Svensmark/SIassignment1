package stu.si.myteachers.model;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Teacher {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tid;
    private String tname;
    private String tmail;

    public Teacher(){
        super();
    }

}
