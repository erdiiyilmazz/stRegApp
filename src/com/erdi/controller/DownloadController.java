package com.erdi.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.erdi.service.DownloadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/download")
public class DownloadController {

	private static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="downloadService")
	private DownloadService downloadService;

    @RequestMapping(value = "/xls", method = RequestMethod.GET)
    public void getXLS(HttpServletResponse response, Model model) throws ClassNotFoundException {
    	logger.debug("Received request");
    	downloadService.downloadXLS(response);
	}
}