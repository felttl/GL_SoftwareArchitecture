package com.example;

import java.util.ArrayList;

class Student {
    private String name;
    private int age;
    private double note1;
    private double note2;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student set(double n1, double n2) {
        this.note1 = n1;
        this.note2 = n2;
        return this;
    }

    String name() {
        return name;
    }   

    int age() {
        return age;
    }

    double note1() {
        return note1;
    }
    double note2() {
        return note2;
    }
}



class StudentGroup implements Iterable<Student> {
    private ArrayList<Student> students = new ArrayList<Student>();

    public java.util.Iterator<Student> iterator() {
        return students.iterator();
    }

    public StudentGroup add(Student s) {
        students.add(s);
        return this;
    }

}

abstract class TabBuilder {
    private static TabBuilder builder;
    abstract void newRow();
    abstract void addCell(String content);
    static TabBuilder instance() {
        if (builder == null)
            builder = new HtmlBuilder();
        return builder;
    }
}

class CsvBuilder extends TabBuilder {
    private StringBuilder sb = new StringBuilder();
    @Override
    public void newRow() {
        if (sb.length() > 0) {
            sb.append("\n");
        }
    }
    @Override
    public void addCell(String content) {
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '\n') {
            sb.append(",");
        }
        sb.append(content);
    }
    public String getResult() {
        return sb.toString();
    }
}

class HtmlBuilder extends TabBuilder {
    private StringBuilder sb = new StringBuilder();
    private boolean _rowStarted = false;
    public HtmlBuilder() {
        sb.append("<html>\n<body>\n");
        sb.append("<table>\n");
    }
    @Override
    public void newRow() {
        if (_rowStarted) {
            sb.append("\t</tr>\n");
        }   
        sb.append("\t<tr>\n");
        _rowStarted = true;
    }
    @Override
    public void addCell(String content) {
        sb.append("\t\t<td>").append(content).append("</td>\n");
    }
    public String getResult() {
        return sb.toString() + (_rowStarted?"</tr>":"") + "</table>\n</body>\n</html>\n"; 
    }
}

public class patternCreator {

    public static void studentsToTab(StudentGroup group) {
        for (Student s : group) {
            TabBuilder.instance().newRow();
            TabBuilder.instance().addCell(s.name());
            TabBuilder.instance().addCell(Double.toString(s.note1()));
            TabBuilder.instance().addCell(Double.toString(s.note2()));
            TabBuilder.instance().addCell(Integer.toString(s.age()));
     }    
    }


    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();
        group.add(new Student("Alice", 20).set(15.0, 14.5))
                .add(new Student("Bob", 22).set(12.0, 13.5))
                .add(new Student("Charlie", 21).set(16.0, 15.5));
        
        patternCreator.studentsToTab(group);
        System.out.println(((HtmlBuilder)TabBuilder.instance()).getResult());
        
    }
}
