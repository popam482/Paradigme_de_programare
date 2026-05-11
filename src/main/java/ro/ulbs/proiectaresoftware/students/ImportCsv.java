package ro.ulbs.proiectaresoftware.students;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportCsv implements Importer{
    private final String filename;

    public ImportCsv(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Student> getImporter() throws IOException {
        List<Student> lista = new ArrayList<>();
        File fisier = new File(filename);
        try (Scanner sc = new Scanner(fisier)) {
            while (sc.hasNextLine()) {
                String linie = sc.nextLine();
                if (linie.trim().isEmpty()) {
                    continue;
                }
                String date[] = linie.split(",");
                if (date.length == 4) {
                    Student s = new Student(date[0].trim(), date[1].trim(), date[2].trim(), date[3].trim());
                    lista.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
