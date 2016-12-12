package com.obigo.obigoproject.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.obigo.obigoproject.log.service.LogService;
import com.obigo.obigoproject.user.service.UserService;
import com.obigo.obigoproject.vo.LogVO;

import net.sf.json.JSONObject;

@Controller
public class MailController {

	@Autowired
	LogService logService;
	@Autowired
	UserService userService;

	@Autowired
	JavaMailSender mailSender;

	private String from = "alldevotion@gmail.com";
	private String subject = "Log Data PDF 파일 보내드립니다.";

	
	
	//매월 1일 15일 오전 9시 자동으로 Log기록 pdf파일 이메일 발송
	// @Scheduled(cron = "*/5 * * * * *")
	@Scheduled(cron = "00 00 09 1,15 * ?")
	public void autoEmail() {
		// Calendar calendar1 = Calendar.getInstance();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// System.out.println("스케줄 실행 : " + dateFormat.format(calendar1.getTime()));
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo("inthelord@hanmail.net");
			messageHelper.setFrom(from);
			messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다

			MimeBodyPart bodypart = new MimeBodyPart();
			bodypart.setContent("PDF 파일 첨부되었습니다.", "text/html;charset=euc-kr");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodypart);

			// PDF 파일명에 로그 날짜 포함
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName = formatter.format(calendar.getTime()) + "_log.pdf"; // for
																					// log-time
			String path = "c:\\obigo\\pdf\\" + fileName;

			// PDF 만들어주는 메서드 호출 및 PDF 파일 첨부
			if (pdfpage(path)) {
				MimeBodyPart attachPart = new MimeBodyPart();
				attachPart.setDataHandler(new DataHandler(new FileDataSource(new File(path))));
				attachPart.setFileName(fileName); // 파일명
				multipart.addBodyPart(attachPart);
				message.setContent(multipart);
				mailSender.send(message);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@RequestMapping(value = "/pdfmail")
	@ResponseBody
	public String sendMail() {
		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("스케줄 실행 : " + dateFormat.format(calendar1.getTime()));
		JSONObject jobj = new JSONObject();
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setTo("inthelord@hanmail.net");
			// messageHelper.setText("PDF 파일 첨부되었습니다.");
			messageHelper.setFrom(from);
			messageHelper.setSubject(subject); // 메일제목은 생략이 가능하다
			// messageHelper.addInline("table.pdf", new FileDataSource("c:/pdftest/table.pdf"));

			MimeBodyPart bodypart = new MimeBodyPart();
			bodypart.setContent("PDF 파일 첨부되었습니다.", "text/html;charset=euc-kr");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodypart);

			// PDF 파일명에 로그 날짜 포함
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName = formatter.format(calendar.getTime()) + "_log.pdf"; // for
																					// log-time
			String path = "c:\\obigo\\pdf\\" + fileName;

			// PDF 만들어주는 메서드 호출 및 PDF 파일 첨부
			if (pdfpage(path)) {
				MimeBodyPart attachPart = new MimeBodyPart();
				// attachPart.setDataHandler(new
				// DataHandler(attachment,"text/xml"));
				attachPart.setDataHandler(new DataHandler(new FileDataSource(new File(path))));
				attachPart.setFileName(fileName); // 파일명
				multipart.addBodyPart(attachPart);
				message.setContent(multipart);
				mailSender.send(message);
				jobj.put("flag", true);
			} else {
				// message.setContent(multipart);
				// mailSender.send(message);
				jobj.put("flag", false);
			}

		} catch (Exception e) {
			jobj.put("flag", false);
			System.out.println(e);
		}
		return jobj.toString();
	}

	// PDF 파일을 생성해주는 메서드
	public boolean pdfpage(String path) throws IOException, DocumentException {
		// Document 생성
		Document document = new Document(PageSize.A4, 50, 50, 50, 50); // 용지 및
																		// 여백 설정

		// 한글 폰트 설정
		BaseFont bfKorean = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font fontKorean = new Font(bfKorean, 10, Font.NORMAL);

		// Log리스트
		List<LogVO> list = logService.getLogList();

		//// PdfWriter 생성, 바로 다운로드 해준다. ////
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		////////////////////////////////////////////

		///////// 바로 PDF 페이지 Open. 그리고 나서 사용자가 직접 저장해 줘야 함.//////////
		// PdfWriter writer = PdfWriter.getInstance(document,
		///////// response.getOutputStream());
		///////////////////////////////////////////////////////////////////////////////

		writer.setInitialLeading(12.5f);

		//////// 바로 PDF 페이지 Open시, 파일명이 한글일 땐 인코딩 설정///////
		// response.setContentType("application/pdf");
		// String fileName = URLEncoder.encode("테이블", "UTF-8");
		// response.setHeader("Content-Transper-Encoding", "binary");
		// response.setHeader("Content-Disposition", "inline; filename=" +
		//////// fileName + ".pdf");
		///////////////////////////////////////////////////////////////////

		// Document 오픈
		document.open();

		// 테이블 Column을 PdfPTable 생성자 파라미터로 넣어준다
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100.0f);

		// Column의 넓이를 조절
		table.setWidths(new float[] { 1.0f, 2.0f, 3.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(6);

		// write table header
		cell.setPhrase(new Phrase("Url", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Body", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Returned", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Date Time", font));
		table.addCell(cell);

		// write table row data
		for (LogVO vo : list) {
			table.addCell(vo.getUrl());
			table.addCell(vo.getBody());
			table.addCell(vo.getReturned());
			table.addCell(vo.getDateTime());
			// 데이터가 한글일 경우, 아래와 같이 한글 font 설정을 해준다.
			// 한글 font 설정을 해주지 않으면 PDF 파일에 데이터가 안들어간다
			// table.addCell(new Paragraph(vo.getReturned(), fontKorean));
		}

		boolean flag = document.add(table);

		document.close();
		writer.close();

		return flag;

	}

	@RequestMapping("/viewpdf")
	public String viewOnPDF(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
		// Document 생성
		Document document = new Document(PageSize.A4, 50, 50, 50, 50); // 용지 및 여백 설정
		JSONObject jobj = new JSONObject();

		// 한글 폰트 설정
		BaseFont bfKorean = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font fontKorean = new Font(bfKorean, 10, Font.NORMAL);

		// Log리스트
		List<LogVO> list = logService.getLogList();

		//// PdfWriter 생성, 바로 다운로드 해준다. ////
		// PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
		////////////////////////////////////////////

		///////// 바로 PDF 페이지 Open. 그리고 나서 사용자가 직접 저장해 줘야 함.//////////
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
		///////////////////////////////////////////////////////////////////////////////

		writer.setInitialLeading(12.5f);

		//////// 바로 PDF 페이지 Open시, 파일명이 한글일 땐 인코딩 설정///////
		response.setContentType("application/pdf");
		// String fileName = URLEncoder.encode("테이블", "UTF-8");
		String fileName = "log";
		response.setHeader("Content-Transper-Encoding", "binary");
		response.setHeader("Content-Disposition", "inline; filename=" + fileName + ".pdf");
		///////////////////////////////////////////////////////////////////

		// Document 오픈
		document.open();

		// 테이블 Column을 PdfPTable 생성자 파라미터로 넣어준다
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100.0f);

		// Column의 넓이를 조절
		table.setWidths(new float[] { 1.0f, 2.0f, 3.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(6);

		// write table header
		cell.setPhrase(new Phrase("Url", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Body", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Returned", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Date Time", font));
		table.addCell(cell);

		// write table row data
		for (LogVO vo : list) {
			table.addCell(vo.getUrl());
			table.addCell(vo.getBody());
			table.addCell(vo.getReturned());
			table.addCell(vo.getDateTime());
			// 데이터가 한글일 경우, 아래와 같이 한글 font 설정을 해준다.
			// 한글 font 설정을 해주지 않으면 PDF 파일에 데이터가 안들어간다
			// table.addCell(new Paragraph(vo.getReturned(), fontKorean));
		}

		boolean flag = document.add(table);

		jobj.put("flag", flag);

		document.close();
		writer.close();

		return null;

	}

}
