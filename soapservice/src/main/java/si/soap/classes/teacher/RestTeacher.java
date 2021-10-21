package si.soap.classes.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RestTeacher {
    String tname;
    String tmail;
    @JsonIgnore
    Object _links;
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTmail() {
        return tmail;
    }

    public void setTmail(String tmail) {
        this.tmail = tmail;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
