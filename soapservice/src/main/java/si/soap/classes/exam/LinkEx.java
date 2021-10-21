package si.soap.classes.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LinkEx {
        EmbeddedEx _embeddedEx;
        @JsonIgnore
        Object page;
        @JsonIgnore
        Object _links;
        public EmbeddedEx get_embedded() {
            return _embeddedEx;
        }

        public void set_embedded(EmbeddedEx _embeddedEx) {
            this._embeddedEx = _embeddedEx;
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

