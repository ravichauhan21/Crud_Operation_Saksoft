package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.serviceImpl.StudentSerImp;

@RestController
public class StudentController {

	@Autowired
	private StudentSerImp studentSerImp;

	// Create the Student record
	@RequestMapping(value = "/saveStudentInformation", method = RequestMethod.POST)
	public ResponseEntity<?> saveStudentInformation(@RequestBody Student student) {
		if (student != null)
			studentSerImp.saveRecord(student);
		return new ResponseEntity<String>("Record save Successfully", HttpStatus.OK);
	}

	// Read the Student Details
	@RequestMapping(value = "/studentDetails", method = RequestMethod.GET)
	public List<Student> getStudentDetails() {
		return studentSerImp.getRecord();
	}

	// Update the information
	@RequestMapping(value = "/updateStudentInformation/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateSudentInformation(@RequestBody Student student ,@PathVariable Integer id) {
		try {
			studentSerImp.updateRecord(student, id);
			return new ResponseEntity<String>("Update record  Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Record is Update failed", HttpStatus.NOT_FOUND);
		}
	}

	// Delete the record
	@RequestMapping(value = "/deleteRecord/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudentInformation(@PathVariable Integer id) {
		try {
			studentSerImp.deleteRecord(id);
			return new ResponseEntity<String>("Delete record  Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Record Not Delete", HttpStatus.NOT_FOUND);
		}
	}

}
