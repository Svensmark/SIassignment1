package si.soap.classes.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import si.soap.classes.student.EmbeddedStu;

public class LinkTea {
        EmbeddedTea _embeddedTea;
        @JsonIgnore
        Object page;
        @JsonIgnore
        Object _links;
        public EmbeddedTea get_embedded() {
            return _embeddedTea;
        }

        public void set_embedded(EmbeddedTea _embeddedTea) {
            this._embeddedTea = _embeddedTea;
        }

        public Object getPage() {
            return page;
        }

        public void setPage(Object page) {
            this.page = page;
        }

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }
}

