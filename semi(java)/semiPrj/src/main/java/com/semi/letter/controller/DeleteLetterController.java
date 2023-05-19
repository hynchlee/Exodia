package com.semi.letter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.ast.TypeReference;

import com.semi.letter.service.LetterService;

@WebServlet("/letter/delete")
public class DeleteLetterController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	    
		System.out.println(json);
//	    List<String> boxList = new ArrayList<>();
//
//		LetterService ls = new LetterService();
//		int result = ls.letterDelete(json);
//
//		if (result > 0) {
//			resp.getWriter().write("Success");
//		} else {
//			resp.getWriter().write("Error");
//		}
	}
}
