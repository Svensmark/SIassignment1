package si.soap.classes.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import si.soap.classes.student.RestStudent;

public class EmbeddedTea {
    RestTeacher[] teachers;
    @JsonIgnore
    Object _links;
    public RestTeacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(RestTeacher[] teachers) {
        this.teachers = teachers;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
