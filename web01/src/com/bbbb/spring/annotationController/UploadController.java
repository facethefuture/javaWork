package com.bbbb.spring.annotationController;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bbbb.spring.DataSource.Dbcp;
import com.bbbb.spring.audience.AudienceImpl;
import com.bbbb.spring.componentScan.soundsystem.ICompactDisc;
import com.bbbb.spring.performance.IPerformance;
import com.bbbb.spring.root.DaoImpl;
import com.bbbb.spring.student.Student;

@Controller
public class UploadController {
	@Autowired
	private ICompactDisc cd;
	@Autowired
	private AudienceImpl audience;
	@Autowired
	private IPerformance performer;
	@Autowired
	private DaoImpl dao;
	@Autowired
	private Dbcp dbcp;
	@RequestMapping("/upload22")
	public String upload(@RequestParam(value="id") int id, @RequestParam(value="name") String name) throws SQLException{
		System.out.println(222);
		performer.perform(2);
		dao.dao();
		System.out.println(id);
		System.out.println(name);
		dbcp.addStudent(new Student(id,name));
//		audience.applaud();
//		cd.play();
//		System.out.println(file.getName());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		return "upload.jsp";
		return "redirect:NewFile.html";
	}
	@RequestMapping("/deleteStudent")
	public String deleteStudent(@RequestParam(value="id") int id){
		dbcp.deleteStudent(id);
		return "redirect:delete.html";
	}
	@RequestMapping("/updateStudent")
	public String updateStudent(@RequestParam(value="id") int id,@RequestParam(value="name") String name){
		System.out.println(name);
		dbcp.updateStudent(id, name);
		return "redirect:update.html";
	}
	@ResponseBody
	@RequestMapping("/queryStudent")
	public String queryStudent(@RequestParam(value="page") int page){
		List<Student> students = dbcp.queryStudent(page);
		System.out.println(students.get(0).getAge());
		return JSON.toJSONString(students);
	}
}
