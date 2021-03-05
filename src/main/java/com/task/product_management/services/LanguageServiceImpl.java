package com.task.product_management.services;

import com.task.product_management.exception.TestException;
import com.task.product_management.model.Language;
import com.task.product_management.repo.LanguageRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service("LanguageService")
@Slf4j
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepo languageRepo;

    @Autowired
    public LanguageServiceImpl(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }

    @Override
    public Language addLanguage(Language language) {
        if (languageExistsByName(language.getName())) {
            log.info("Language {} already exist.", language.getName());
            //поменять на нормальное исключение!!!!!!!!!!!
            throw new TestException();
        }
        return languageRepo.save(language);
    }
    @Override
    public void deleteCurrencyByName(String languageName) {
        if (!languageExistsByName(languageName)) {
            log.info("Language {} doesn't exist.", languageName);
            //поменять на нормальное исключение!!!!!!!!!!!
            throw new TestException();
        }
        languageRepo.deleteByName(languageName);
    }

    @Override
    public boolean languageExistsByName(String languageName) {
        return languageRepo.existsByName(languageName);
    }

    @Override
    public Set<Language> getAllLanguages() {
        Set<Language> languageList;
        try {
            languageList = Objects.requireNonNull(languageRepo.findAll());
        } catch (NullPointerException ex) {
            //поменять на нормальное исключение!!!!!!!!!!!
            throw new TestException();
        }
        return languageList;
    }
    @Override
    public Language getLanguageByName(String languageName) {
        Language language;
        try {
            language = Objects.requireNonNull(languageRepo.findByName(languageName));
        } catch (NullPointerException ex) {
            throw new TestException();
        }
        return language;
    }
}
