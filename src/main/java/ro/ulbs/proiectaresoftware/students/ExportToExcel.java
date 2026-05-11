package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportToExcel implements Exporter {

    private final String filename;

    public ExportToExcel(String filename) {
        this.filename = filename;
    }

    @Override
    public void export(List<Student> studenti) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Detalii studenti");


            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Nr. Matricol");
            headerRow.createCell(1).setCellValue("Nume");
            headerRow.createCell(2).setCellValue("Prenume");
            headerRow.createCell(3).setCellValue("Formatie Studiu");

            int rowNum = 1;
            for (Student s : studenti) {
                XSSFRow row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(s.getNrMatricol());
                row.createCell(1).setCellValue(s.getNume());
                row.createCell(2).setCellValue(s.getPrenume());
                row.createCell(3).setCellValue(s.getFormatieDeStudiu());
            }
            try (FileOutputStream out = new FileOutputStream(filename)) {
                workbook.write(out);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}

