package ro.ulbs.proiectaresoftware.students;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportToCsv implements Exporter {

    String filename;

    public ExportToCsv(String filename) {
        this.filename = filename;
    }

    @Override
    public void export(List<Student> studenti) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student s : studenti) {
                writer.println(s.getNrMatricol() + "," + s.getPrenume() + "," + s.getNume() + "," + s.getFormatieDeStudiu());
            }
            System.out.println("Export CSV, fisier: " + filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
