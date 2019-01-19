package com.javacore.file2.students;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GroupTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private EnglishClass englishClass = new EnglishClass();
    private HistoryClass historyClass = new HistoryClass();
    private MathClass mathClass = new MathClass();
    private PhysicsClass physicsClass = new PhysicsClass();

    private Student student1 = Student.builder("Andrey", 24).email("a@b.ru").phoneNumber(921111111).build();

    @Before
    public void setUp() {
        Student student2 = Student.builder("Maxim", 22).email("b@bc.net").phoneNumber(993231231).build();
        Student student3 = Student.builder("Oleg", 19).phoneNumber(912312331).build();
        Student student4 = Student.builder("Vyacheslav", 17).build();
        Student student5 = Student.builder("Alexandr", 20).email("dfx@gssadf.com").build();
        Student student6 = Student.builder("Grigory", 22).email("cbnbv@arqt.org").phoneNumber(926543525).build();
        Student student7 = Student.builder("Dmitry", 24).email("fnvb@lhjj.ru").phoneNumber(964190214).build();
        Student student8 = Student.builder("Andrey", 26).build();

        englishClass.addStudent(student1, 5);
        englishClass.addStudent(student3, 3);
        englishClass.addStudent(student4, 4);
        englishClass.addStudent(student6, 5);
        englishClass.addStudent(student7, 4);

        historyClass.addStudent(student1, 5);
        historyClass.addStudent(student2, 5);
        historyClass.addStudent(student3, 4);
        historyClass.addStudent(student6, 3);
        historyClass.addStudent(student5, 4);

        mathClass.addStudent(student1, 4.7);
        mathClass.addStudent(student2, 4.4);
        mathClass.addStudent(student3, 3.8);
        mathClass.addStudent(student4, 3.3);
        mathClass.addStudent(student5, 5.0);
        mathClass.addStudent(student6, 4.1);
        mathClass.addStudent(student7, 3.5);
        mathClass.addStudent(student8, 2.9);

        physicsClass.addStudent(student2, 4.3);
        physicsClass.addStudent(student3, 2.5);
        physicsClass.addStudent(student4, 4.9);
        physicsClass.addStudent(student5, 3.4);
        physicsClass.addStudent(student8, 3.8);
    }

    @Test
    public void findStudentTest() {
        Assert.assertTrue(englishClass.isContainsStudent(student1));
        Assert.assertTrue(historyClass.isContainsStudent(student1));
        Assert.assertTrue(mathClass.isContainsStudent(student1));
        Assert.assertFalse(physicsClass.isContainsStudent(student1));
    }

    @Test
    public void removeStudentTest() {
        englishClass.removeStudent(student1);
        mathClass.removeStudent(student1);
        Assert.assertFalse(englishClass.isContainsStudent(student1));
        Assert.assertTrue(historyClass.isContainsStudent(student1));
        Assert.assertFalse(mathClass.isContainsStudent(student1));
        Assert.assertFalse(physicsClass.isContainsStudent(student1));
    }

    @Test
    public void getGradeTest() {
        Assert.assertEquals((int) englishClass.getGrade(student1), 5);
        Assert.assertEquals((int) historyClass.getGrade(student1), 5);
        Assert.assertEquals(mathClass.getGrade(student1), 4.7, 0.0);
        exception.expect(IllegalArgumentException.class);
        physicsClass.getGrade(student1);
    }

    @Test
    public void setGradeTest() {
        mathClass.setGrade(student1, 5.0);
        historyClass.setGrade(student1, 4);

        Assert.assertEquals((int) englishClass.getGrade(student1), 5);
        Assert.assertEquals((int) historyClass.getGrade(student1), 4);
        Assert.assertEquals(mathClass.getGrade(student1), 5.0, 0.0);
    }
}