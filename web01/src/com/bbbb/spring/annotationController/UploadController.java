package com.bbbb.spring.annotationController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("/upload22")
	public String upload(){
		System.out.println(222);
//		System.out.println(file.getName());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
		return "upload.jsp";
	}
}
