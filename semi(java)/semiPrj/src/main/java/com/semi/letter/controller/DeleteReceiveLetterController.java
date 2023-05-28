package com.semi.letter.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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

@WebServlet("/letter/delete/receive")
public class DeleteReceiveLetterController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String json = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
						
			String [] strNumbers = json.replaceAll("\\s","")
					.replace("[", "")
					.replace("]", "")
					.replace("\"","")
					.split(",");
						
			int[] letterNo = new int[strNumbers.length];
			
			for (int i = 0; i < letterNo.length; i++) {
				letterNo[i] = Integer.parseInt(strNumbers[i]);
			}
			
			LetterService ls = new LetterService();
			int result = ls.deleteReceiveLetter(letterNo);
			
			if(result == 1) {
				req.getRequestDispatcher("/WEB-INF/views/letter/receive-letter.jsp").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println("�޼��� ���� �� ���� �߻�");
			e.printStackTrace();
		}
		
		
	}
	
}
