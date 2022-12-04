package kodlama.io.business.abstracts;

import java.util.List;

import kodlama.io.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();
	Language getById(int id) throws Exception;
	void add(Language language) throws Exception;
	void update(int id , String name) throws Exception;
	void delete(int id) throws Exception;
}
