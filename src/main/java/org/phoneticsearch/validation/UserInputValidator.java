package org.phoneticsearch.validation;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInputValidator {

    private static final Logger logger = Logger.getLogger(UserInputValidator.class.getName());

    public int getValidSeparatorOrShowMessageAndExit(List<String> userInputList) {
        int separatorPosition = userInputList.indexOf("<");
        if (separatorPosition < 0) {
            logger.log(Level.SEVERE, "Input must follow the pattern: 'word1 word2 .. wordn < <dictionary_path>'.");
            System.exit(0);

            return -1;
        }
        return separatorPosition;
    }

    public String getValidDictionaryPathOrShowMessageAndExit(List<String> userInputList) {
        String filePath  = userInputList.get(userInputList.size() -1 );
        if (filePath.isEmpty()) {
            logger.log(Level.SEVERE,"Input must inform the dictionary path after the '<' symbol.");
            System.exit(0);
        }
        return filePath;
    }



}
