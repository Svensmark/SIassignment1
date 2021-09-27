package si.soap.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Embedded {
    RestStudent[] students;
    @JsonIgnore
    Object _links;
    public RestStudent[] getStudents() {
        return students;
    }

    public void setStudents(RestStudent[] students) {
        this.students = students;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
