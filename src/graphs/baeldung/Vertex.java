package graphs.baeldung;

import java.util.Objects;
import java.util.StringJoiner;

public class Vertex {

    private String label;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vertex.class.getSimpleName() + "[", "]")
                .add("label='" + label + "'")
                .toString();
    }
}
