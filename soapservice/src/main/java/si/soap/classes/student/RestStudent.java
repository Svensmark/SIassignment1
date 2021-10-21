package si.soap.classes.student;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RestStudent {
    String sname;
    String smail;
    @JsonIgnore
    Object _links;
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSmail() {
        return smail;
    }

    public void setSmail(String smail) {
        this.smail = smail;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
