package entries;

import java.time.LocalDate;
import java.util.Objects;


public class FileEntry {
    private String name;
    private int ID;
    private long size;
    private LocalDate created;
    private Mode mode;

    public FileEntry(String name, long size, int ID) {
        this.name = name;
        this.size = size;
        this.created = LocalDate.now();
        this.mode = Mode.Write;
        this.ID = ID;
    }

    public int getID() {
    	return ID;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }


    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getCreated() {
        return this.created;
    }

    public Mode getMode() {
        return mode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        FileEntry fe = (FileEntry) o;
        return this.name.equals(fe.name) &&
                this.size == fe.size &&
                this.created.equals(fe.created) &&
                this.mode.equals(fe.mode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, mode);
    }

    @Override
    public String toString() {
        return "FileEntry{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", created='" + created + '\'' +
                ", mod='" + mode + '\'' +
                "}";
    }
}
