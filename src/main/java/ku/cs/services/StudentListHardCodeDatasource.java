package ku.cs.services;

import ku.cs.models.StudentList;

public class StudentListHardCodeDatasource implements Datasource<StudentList>{

    @Override
    public StudentList readData() {
        StudentList list = new StudentList();
        list.addNewStudent("6410400001", "First", "password1");
        list.addNewStudent("6410400002", "Second", "password2");
        list.addNewStudent("6410400003", "Third", "password3");
        list.addNewStudent("6410400004", "Fourth", "password4");
        return list;
    }

    @Override
    public void writeData(StudentList data) {

    }
}
