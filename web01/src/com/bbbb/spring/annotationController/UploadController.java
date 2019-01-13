package com.bbbb.spring.annotationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bbbb.spring.componentScan.soundsystem.ICompactDisc;

@Controller
public class UploadController {
	@Autowired
	private ICompactDisc cd;
	@RequestMapping("/upload22")
	public String upload(){
		System.out.println(222);

		cd.play();
//		System.out.println(file.getName());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
		return "upload.jsp";
	}
}
