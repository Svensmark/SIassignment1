package si.soap.classes.student;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LinkStu {
        EmbeddedStu _embeddedStu;
        @JsonIgnore
        Object page;
        @JsonIgnore
        Object _links;
        public EmbeddedStu get_embedded() {
            return _embeddedStu;
        }

        public void set_embedded(EmbeddedStu _embeddedStu) {
            this._embeddedStu = _embeddedStu;
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

