package kodlama.io.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.dataAccess.abstracts.LanguageRepository;
import kodlama.io.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{
	
	List<Language> languages;
	
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"Java"));
		languages.add(new Language(2,"C"));
		languages.add(new Language(3,"C#"));
		languages.add(new Language(4,"Python"));
		languages.add(new Language(5,"C++"));
	}


	@Override
	public List<Language> getAll() {
		
		return languages;
	}


	@Override
	public Language getById(int id) throws Exception {
		for (Language language : languages) {
			if(language.getId()==id) {
				return language;
			}
		}
		throw new Exception("kayitli id bulunamadi!");
		
	}


	
	public void add(Language language) throws Exception {
		
		languages.add(language);
	}


	@Override
	public void update(int id , String name) throws Exception {
		Language tempLanguage = getById(id);
		tempLanguage.setName(name);
		
	}


	@Override
	public void delete(int id) throws Exception {
		Language tempLanguage = getById(id);
		languages.remove(tempLanguage);
		
	}
	

	

}
