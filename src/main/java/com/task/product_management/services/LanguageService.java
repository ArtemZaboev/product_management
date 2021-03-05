package com.task.product_management.services;

import com.task.product_management.model.Language;

import java.util.Set;

public interface LanguageService {
    Language addLanguage(Language language);

    void deleteCurrencyByName(String languageName);

    boolean languageExistsByName(String languageName);

    Set<Language> getAllLanguages();

    Language getLanguageByName(String languageName);
}
