package si.soap.classes;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Link {
        Embedded _embedded;
        @JsonIgnore
        Object page;
        @JsonIgnore
        Object _links;
        public Embedded get_embedded() {
            return _embedded;
        }

        public void set_embedded(Embedded _embedded) {
            this._embedded = _embedded;
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

