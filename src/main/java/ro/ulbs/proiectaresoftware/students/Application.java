package ro.ulbs.proiectaresoftware.students;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Student s1 = new Student("3112", "Ioan", "Popa", "TI21/2");
        Student s2= new Student("3123", "Maria", "Oprea", "TI21/1");
        Student s3= new Student("1245", "Alis", "Popa", "TI21/1");
        Student s4= new Student("5362", "Mihai", "Vecerdea", "C22/1");
        Student s5= new Student("5981", "Eugen", "Uritescu", "C22/2");
        Student s6=new Student ("4784", "Andra", "Marin", "C22/1");

        List studenti = new ArrayList();

        System.out.println("Numar studenti: "+studenti.size());

        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);
        studenti.add(s5);
        studenti.add(s6);

        System.out.println("Numar studenti: "+studenti.size());

        System.out.println("matricol  prenume     nume    formatieDeStudiu");
        afisare(studenti);

        System.out.println(prezent(new Student(null, "Ana", "Ionescu", "C22/2"), studenti));
        Student s7=new Student(null, "Ana", "Ionescu", "C22/2");
        studenti.add(s7);

        System.out.println(prezent(s7, studenti));

       /* for(Object s: studenti){
            System.out.println(s);
        }
       */

        Set<Student> setStudenti = new HashSet<>(studenti);
        System.out.println(prezentSet(s7, setStudenti));

        String numeFisier="studenti.csv";
        List<Student> lista=citireFisier(numeFisier);
        afisare(lista);

        sortare(lista);
        System.out.println("=====SORTARE=====");
        afisare(lista);

        System.out.println("\n===== CITIRE NOTE DIN FISIER =====");
        Map<String, Integer> noteMap = citireNote("note.csv");

        System.out.println("Note brute: " + noteMap);

        System.out.println("Mapare studenti");

        Map<Student, Integer> noteStudenti = mapareNote(noteMap, lista);

        System.out.println("\n===== REZULTAT MAPARE =====");
        for (int i = 0; i < lista.size(); i++) {
            Student s = lista.get(i);
            Integer nota = noteStudenti.get(s);
            System.out.println("Student: " + s.getNume() + " " + s.getPrenume() + " - nota: " + nota);
        }

        if(!lista.isEmpty()) {
            Student proba = lista.get(0);
            Integer notaProba = getNota(proba, noteMap);
            System.out.println("Nota pentru " + proba.getNrMatricol() + " este: " + notaProba);
        }




    }

    static void sortare(List<Student> lista) {
        Collections.sort(lista);
    }

    public static List<Student> citireFisier(String numeFisier){
        List<Student> lista=new ArrayList<>();
        File fisier = new File(numeFisier);
        try(Scanner sc=new Scanner(fisier)){
            while(sc.hasNextLine()){
                String linie=sc.nextLine();
                if(linie.trim().isEmpty()){
                    continue;
                }
                String date[]=linie.split(",");
                if(date.length==4){
                    Student s=new Student(date[0].trim(), date[1].trim(), date[2].trim(), date[3].trim());
                    lista.add(s);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return lista;
    }

    public static boolean prezentSet(Student student, Set<Student> studenti) {
        return studenti.contains(student);
    }

    public static boolean prezent(Student student, List<Student> studenti){
        return studenti.contains(student);
    }

    private static void afisare(List studenti) {
        for(int i = 0; i< studenti.size(); i++){
             System.out.println(studenti.get(i));
         }
    }

    public static Map<String, Integer> citireNote(String numeFisier){
        String numarMatricol, nota;
        Map<String, Integer> note= new HashMap<>();
        FileInputStream fisier;
        try{
            fisier=new FileInputStream(numeFisier);
            Scanner sc = new Scanner(fisier);
            while(sc.hasNext()){
                String linie=sc.nextLine();
                String comp[]=linie.split(",");
                numarMatricol=comp[0];
                nota=comp[1];
                note.put(numarMatricol, Integer.parseInt(nota));
            }
            sc.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return note;
    }

    public static Integer getNota(Student st, Map<String, Integer> note){
        return(note.get(st.getNrMatricol()));
    }

    public static Map<Student, Integer> mapareNote(Map<String, Integer> note, List<Student> listaStudenti){
        Map<Student, Integer> mapareStudenti = new HashMap<>();
        for(Student s:listaStudenti){
            mapareStudenti.put(s,note.get(s.getNrMatricol()));
        }
        return mapareStudenti;
    }
}
