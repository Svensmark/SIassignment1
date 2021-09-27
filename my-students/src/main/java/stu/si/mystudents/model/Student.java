package stu.si.mystudents.model;
import lombok.Data;


import javax.persistence.*;
import javax.persistence.criteria.From;

@Data
@Entity
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;
    private String sname;
    private String smail;

    public Student(){
        super();
    }

}
