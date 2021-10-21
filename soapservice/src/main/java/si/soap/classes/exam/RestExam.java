package si.soap.classes.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;

public class RestExam {
    String ename;
    Date date;
    @JsonIgnore
    Object _links;
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
