package org.phoneticsearch.application;

import org.phoneticsearch.searcher.PhoneticSearcher;
import org.phoneticsearch.validation.UserInputValidator;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class MainApplication {

    private static final Logger logger = Logger.getLogger(UserInputValidator.class.getName());

    public static void main(String[] args) {

        List<String> userInputList = Arrays.asList(args);

        UserInputValidator inputValidator = new UserInputValidator();
        int separatorPosition = inputValidator.getValidSeparatorOrShowMessageAndExit(userInputList);

        List<String> inputWords = userInputList.subList(0,separatorPosition);

        String filePath = inputValidator.getValidDictionaryPathOrShowMessageAndExit(userInputList);
        File file = new File(filePath);

        PhoneticSearcher phoneticSearcher = new PhoneticSearcher(inputWords, file);
        phoneticSearcher.getPhoneticallyEquivalentWords();
        phoneticSearcher.printAllPhoneticallyEquivalentWords();
    }




}
