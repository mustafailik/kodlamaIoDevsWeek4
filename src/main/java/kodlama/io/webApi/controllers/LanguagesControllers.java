package kodlama.io.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.business.abstracts.LanguageService;
import kodlama.io.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesControllers {
	private LanguageService languageService;

	@Autowired
	public LanguagesControllers(LanguageService languageService) {
	
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<Language> getAll(){
		 return languageService.getAll();
	}
	
	@GetMapping("/{id}")
	public Language getById(@PathVariable int id) throws Exception{
		return languageService.getById(id);
	}
	
	
	@PostMapping("/add")
	public void add( Language language)throws Exception {
		languageService.add(language);
	}
	
	@PutMapping("/update")
	public void update( int id , String name)throws Exception{
		languageService.update(id, name);
	}
	
	@DeleteMapping("/delete")
	public void delete( int id) throws Exception {
		languageService.delete(id);
	}
	
}
