package com.example.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.languages.models.Language;
import com.example.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class LanguageController {
	
	@Autowired
	LanguageService languageService;
	
	// Get index.jsp
	@RequestMapping("")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	// Create a new entry into languages
	@PostMapping("")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		languageService.saveLanguage(language);
		return "redirect:/languages";
	}
	
	// Get edit.jsp
	@RequestMapping("/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	// Update language
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		languageService.saveLanguage(language);
		return "redirect:/languages";
	}
	
	// Delete a language
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	// Get a detail of language
	@GetMapping("/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "detail.jsp";
	}
	
	
}
