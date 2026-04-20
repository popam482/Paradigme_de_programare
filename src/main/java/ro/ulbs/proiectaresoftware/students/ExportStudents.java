package ro.ulbs.proiectaresoftware.students;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportStudents {
    final ExportConfig config;
    final List<Student> lista;

    public ExportStudents(ExportConfig config, List<Student> lista){
        this.config=config;
        this.lista=new ArrayList<>(lista);
    }

    public void export() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(config.numeFisier))) {

            bw.write("NrMatricol,Nume,Prenume,FormatieStudiu");
            bw.newLine();

            for (Student s : lista) {
                String linie = s.getNrMatricol() + "," +
                        s.getNume() + "," +
                        s.getPrenume() + "," +
                        s.getFormatieDeStudiu();
                bw.write(linie);
                bw.newLine();
            }
        }
    }
}

