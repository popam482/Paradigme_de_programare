package ro.ulbs.proiectaresoftware.students;

import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {

    private String nrMatricol;
    private String prenume, nume, formatieDeStudiu;

    public Student(String nrMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setFormatieDeStudiu(String formatieDeStudiu) {
        this.formatieDeStudiu = formatieDeStudiu;
    }

    @Override
    public String toString() {

        return String.format("%5s %10s %10s %10s", nrMatricol, prenume, nume, formatieDeStudiu);

    }

    @Override
    public int compareTo(Student s) {
        if (this.formatieDeStudiu.equals(s.formatieDeStudiu)) {
            if (this.nume.equals(s.nume)) {
                return this.prenume.compareTo(s.prenume);
            }
            return this.nume.compareTo(s.nume);
        }
        return this.formatieDeStudiu.compareTo(s.formatieDeStudiu);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return Objects.equals(nume, student.nume) &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nume, prenume, formatieDeStudiu);
    }


}
