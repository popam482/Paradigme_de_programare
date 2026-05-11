package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ImportExcel implements Importer {
    private String filename;
    private String sheetname;

    public ImportExcel(String filename) {
        this.filename = filename;
        this.sheetname = sheetname;
    }

    @Override
    public List<Student> getImporter() throws IOException {
        List<Student> listaStudenti = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filename);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            XSSFSheet sheet = workbook.getSheet(sheetname);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet-ul '" + sheetname + "' nu a fost gasit in fisier!");
            }

            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    Cell primaCelula = row.getCell(0);
                    if (primaCelula != null && primaCelula.getStringCellValue().equalsIgnoreCase("matricol")) {
                        continue;
                    }
                }

                String nrMatricol = getCellValueAsString(row.getCell(0));
                String prenume = getCellValueAsString(row.getCell(1));
                String nume = getCellValueAsString(row.getCell(2));
                String formatie = getCellValueAsString(row.getCell(3));


                if (!nrMatricol.isEmpty() && !nume.isEmpty()) {
                    Student s = new Student(nrMatricol, prenume, nume, formatie);
                    listaStudenti.add(s);
                }
            }

        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului Excel: " + e.getMessage());
            throw e;
        }

        return listaStudenti;
    }


    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                double numericValue = cell.getNumericCellValue();
                if (numericValue == (long) numericValue) {
                    return String.valueOf((long) numericValue);
                }
                return String.valueOf(numericValue);
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
            default:
                return "";
        }
    }
}