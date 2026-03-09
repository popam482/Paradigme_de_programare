package ro.ulbs.proiectaresoftware.students;

public class Student {

    private int nrMatricol;
    private String prenume, nume, formatieDeStudiu;

    public Student(int nrMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.nrMatricol = nrMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public int getNrMatricol() {
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

    public void setNrMatricol(int nrMatricol) {
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

        return String.format("%05d %10s %10s %10s", nrMatricol, prenume, nume, formatieDeStudiu);

    }
}
