package kodlama.io.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.business.abstracts.LanguageService;
import kodlama.io.dataAccess.abstracts.LanguageRepository;
import kodlama.io.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
	
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {
		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {
		
		if(language.getName().isEmpty()) {
			throw new Exception("Dil adi bos gecilemez");
		}
		
		for (Language lang : getAll()) {
			if(lang.getName().equals(language.getName())) {
				throw new Exception("Ayni isme sahip programlama dili mevcuttur");
			}
		}
		
		languageRepository.add(language);
	}

	@Override
	public void update(int id, String name) throws Exception {
		
		for (Language lang : getAll()) {
			if(lang.getId()==id) {
				languageRepository.update(id, name);
			}
			
		}
		
	}

	@Override
	public void delete(int id) throws Exception {
		for (Language lang : getAll()) {
			if(lang.getId()==id) {
				languageRepository.delete(id);
			}
		}
		
	}
	
	
}
