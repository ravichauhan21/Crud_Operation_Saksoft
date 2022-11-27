package com.crud.serivce;

import java.util.List;

import com.crud.entity.Student;

public interface StudentSer {

	public Student saveRecord(Student student);

	public List<Student> getRecord();

	public void deleteRecord(Integer Id);

	public Student updateRecord(Student student , Integer Id);

}
