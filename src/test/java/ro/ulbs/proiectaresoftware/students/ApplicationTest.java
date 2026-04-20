package ro.ulbs.proiectaresoftware.students;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void main() {
    }

    @Test
    void citireFisier() {
    }

    @Test
    void prezent() {
        List<Student> studenti = new ArrayList<>();
        Student s1 = new Student("1234", "Ion", "Ionescu", "C22/2");
        Student s2 = new Student("1534", "Ana", "Popescu", "C22/2");

        studenti.add(s1);
        studenti.add(s2);

        assertTrue(Application.prezent(s1, studenti));

        Student s3 = new Student("9999", "Ion", "Anton", "C22/1");
        assertFalse(Application.prezent(s3, studenti));

        Student sDup = new Student("1234", "Ion", "Ionescu", "C22/2");
        studenti.add(sDup);
        assertTrue(Application.prezent(sDup, studenti));
    }

    @Test
    void sortare(){
        List<Student> studenti1 = new ArrayList<>();

        Student s1 = new Student("4784", "Andra", "Marin", "C22/1");
        Student s2 = new Student("5362", "Mihai", "Vecerdea", "C22/1");
        Student s3 = new Student("3112", "Ioan", "Popa", "TI21/2");
        Student s4 = new Student("1245", "Alis", "Popa", "TI21/1");

        studenti1.add(s1);
        studenti1.add(s2);
        studenti1.add(s3);
        studenti1.add(s4);

        Application.sortare(studenti1);

        for (int i = 0; i < studenti1.size() - 1; i++) {
            Student curent = studenti1.get(i);
            Student urmator = studenti1.get(i + 1);

            int rezultatComparare = curent.compareTo(urmator);

            assertTrue(rezultatComparare <= 0,
                    "Ordine gresita (index: " +curent+ ", "+ urmator+")");
        }

        Student s5 = new Student("4784", "Andra", "Marin", "C22/1");
        Student s6 = new Student("5362", "Mihai", "Vecerdea", "C22/1");
        Student s7 = new Student("3112", "Ioan", "Popa", "C22/1");
        Student s8 = new Student("1245", "Alis", "Pop", "C22/1");

        List<Student> studenti2 = new ArrayList<>();
        studenti2.add(s5);
        studenti2.add(s6);
        studenti2.add(s7);
        studenti2.add(s8);

        Application.sortare(studenti2);

        for (int i = 0; i < studenti1.size() - 1; i++) {
            Student curent = studenti1.get(i);
            Student urmator = studenti1.get(i + 1);

            int rezultatComparare = curent.compareTo(urmator);

            assertTrue(rezultatComparare <= 0,
                    "Ordine gresita (index: " +curent+ ", "+ urmator+")");
        }

    }

    @Test
    void citireNote() {
    }

    @Test
    void testGetNota() {
        Student student1 = new Student("1234", "Ion", "Popescu", "C22/1");
        Student student2 = new Student("5678", "Dan", "Pop", "C22/1");
        Student student3 = new Student("4392", "Ana", "Luca", "C22/1");

        Map<String, Integer> noteMap = new HashMap<>();
        noteMap.put("1234", 10);
        noteMap.put("5678", 8);
        //noteMap.put("4392");

        Integer notaObtinuta = Application.getNota(student1, noteMap);
        assertEquals(10, notaObtinuta);

        Integer notaObtinuta2 = Application.getNota(student2, noteMap);
        assertNotEquals(10, notaObtinuta2);

        Integer notaObtinuta3 = Application.getNota(student3, noteMap);
        assertEquals(null, notaObtinuta3);

    }

    @Test
    void mapareNote() {
    }
}