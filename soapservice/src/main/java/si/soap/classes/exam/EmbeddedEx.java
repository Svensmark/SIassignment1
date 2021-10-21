package si.soap.classes.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmbeddedEx {
    RestExam[] exams;
    @JsonIgnore
    Object _links;
    public RestExam[] getExams() {
        return exams;
    }

    public void setExams(RestExam[] exams) {
        this.exams = exams;
    }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}
