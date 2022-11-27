package com.crud.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Student;
import com.crud.repo.StudentRepo;
import com.crud.serivce.StudentSer;

@Service
public class StudentSerImp implements StudentSer {

	@Autowired
	private StudentRepo studentRepo;
	

	@Override
	public Student saveRecord(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getRecord() {

		return studentRepo.findAll();
	}

	@Override
	public void deleteRecord(Integer Id) {

		if (Id != null) {
			studentRepo.deleteById(Id);
		}

	}

	@Override
	public Student updateRecord(Student st,Integer Id) {
		Student stu = studentRepo.findById(Id).get();
		if (stu!= null) {
		
			stu.setLast(st.getLast());;
		        studentRepo.save(stu);
		}
		return st;
	}

}
