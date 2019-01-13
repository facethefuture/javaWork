package com.bbbb.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@RequestMapping("/upload")
	public String upload(@RequestParam(value="picture",required=false) MultipartFile file){
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		String dir = "D:/images";
		OutputStream out = null;
		try {
			InputStream inputStream = file.getInputStream();
			String uuid = UUID.randomUUID().toString();
			String lastName = file.getOriginalFilename().split("\\.")[1]; 
			String fileName = uuid + "." + lastName;
			out = new FileOutputStream(new File(dir,fileName));
			System.out.println(Paths.get("D:/images"));
			Files.copy(Paths.get("D:/images"), out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (out != null){
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "redirect:upload.jsp";
	}
	@RequestMapping("/download")
	@ResponseBody // 添加这个注解的作用是告诉springmvc所有的响应都由response来完成
	public void download(HttpServletResponse response){
		Path path = Paths.get("D:/images","QQ20190106220710.png");
		 FileInputStream fis = null;
		 response.setHeader("Content-Disposition", "attachment;filename=a.jpg");
		 try {
			ServletOutputStream outputStream = response.getOutputStream();
			Files.copy(path, outputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			if (fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
