package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.util.List;

public interface Importer {
    public List<Student> getImporter() throws IOException; //args[0] doar la excel, args[1]-csv

}
