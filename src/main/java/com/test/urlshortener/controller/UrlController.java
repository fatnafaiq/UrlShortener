package com.test.urlshortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.urlshortener.entity.Url;
import com.test.urlshortener.service.UrlService;

@Controller
public class UrlController {

	@Autowired
	private UrlService urlService;

	@GetMapping({ "/" })
	public String homePage() {
		return "index";
	}

	@PostMapping("/getUrlRaccourcie")
	public String getUrlRaccourcie(@RequestParam("urlComplete") String urlComplete, ModelMap modelMap) {
		String url = urlService.generateShortenedUrl(urlComplete);

		modelMap.put("urlRaccourcie", url);
		return "index";
	}

	@PostMapping("/getUrlComplete")
	public String getUrlComplete(@RequestParam("urlRaccourcie") String urlRaccourcie, ModelMap modelMap) {
		Url url = urlService.getUrlByUrlRaccourcie(urlRaccourcie);
		if (url != null) {
			modelMap.put("urlComplete", url.getUrlComplete());
		} else {
			modelMap.put("error", "error");
		}

		return "index";
	}
}
