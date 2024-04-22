package com.learnmongo.mongoDB.mongodb.documents;

public class Subject {

    private String subjectName;

    private String marks;

    public Subject(String subjectName, String marks) {
        this.subjectName = subjectName;
        this.marks = marks;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
