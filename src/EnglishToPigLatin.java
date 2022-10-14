import java.util.ArrayList;
import java.util.Arrays;

public class EnglishToPigLatin {

    private final String inputText;

    private final String[] vowelSounds = new String[] {"a", "e", "i", "o", "u"};
    private final ArrayList<String> vowelSoundsList = new ArrayList<>(Arrays.asList(vowelSounds));

    public EnglishToPigLatin(String inputText) {
        this.inputText = inputText;
    }

    public String convertToPigLatin() {
        ArrayList<String> outputText = new ArrayList<>();
        String[] inputArray = this.inputText.toLowerCase().split(" ");
        for (String word : inputArray) {
            String firstLetter = word.substring(0, 1);
            String secondLetter = word.substring(1, 2);
//            Rule 1
             if (vowelSoundsList.contains(firstLetter)) {
                 if (firstLetter.equals("u") && vowelSoundsList.contains(word.substring(2, 3))) {
                     outputText.add(word.substring(1) + firstLetter + "ay");
                 } else {
                     outputText.add(word + "ay");
                 }
             } else if (firstLetter.equals("x") ) {
                 if (!(vowelSoundsList.contains(secondLetter)) || !secondLetter.equals("x")) {
                     outputText.add(word + "ay");
                 }
             } else if(firstLetter.equals("y")) {
                 if (!(vowelSoundsList.contains(secondLetter))) {
                     outputText.add(word + "ay");
                 }
             } else {
//                 Rule 2
                 if (word.startsWith("qu", 1)) {
                     outputText.add(word.substring(3) + firstLetter + "quay");

                 }
//                 Rule  3 & 4
                 else if (word.length() == 2 && word.endsWith("y")) {
                     outputText.add("y" + firstLetter + "ay");
                 } else {
                     int beginningIndex = 0;
                     int endIndex = 1;
                     String singleCharacter = word.substring(beginningIndex, endIndex);
                     while ((!vowelSoundsList.contains(singleCharacter))) {
                         System.out.println(word);
                         if ((beginningIndex >=1 && singleCharacter.equals("y"))) {
                             break;
                         }
                         beginningIndex++;
                         endIndex++;
                         singleCharacter = word.substring(beginningIndex, endIndex);
                     }
                     outputText.add(word.substring(beginningIndex) + word.substring(0, beginningIndex) + "ay");
                 }
             }
        }
        return outputText.toString();
    }


}
