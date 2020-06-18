package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	  @Inject
	  private BoardService service;
	  
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public void registerGET(BoardVO board, Model model) throws Exception {

	    logger.info("register get ...........");
	  }

	   @RequestMapping(value = "/register", method = RequestMethod.POST)
	   public String registPOST(BoardVO board, Model model) throws Exception {
	  
	   logger.info("regist post ...........");
	   logger.info(board.toString());
	  
	   service.regist(board);
	  
	   model.addAttribute("result", "success");
	  
	   return "/board/success";
	   //return "redirect:/board/listAll";
	   }
	   
//	   @RequestMapping(value = "/", method = RequestMethod.GET)
//		  public String home(Locale locale, Model model) {
//		    logger.info("Welcome home! The client locale is {}.", locale);
//
//		    Date date = new Date();
//		    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//
//		    String formattedDate = dateFormat.format(date);
//
//		    model.addAttribute("serverTime", formattedDate);
//
//		    return "home";
//	   }
}
