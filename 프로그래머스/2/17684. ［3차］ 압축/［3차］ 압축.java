import java.util.*;

class Word implements Comparable<Word> {
    String word;
    int number;
    int wordLength;
    
    Word(String word, int number) {
        this.word = word;
        this.number = number;
        this.wordLength = word.length();
    }
    
    String getWord() {
        return word;
    }
    
    int getLength() {
        return wordLength;
    }
    
    @Override
    public int compareTo(Word o) {
        return o.word.length() - word.length();
    }
}

class Solution {
    public int[] solution(String msg) {
        ArrayList<Word> dictionary = initDictionary();
        return getAnswer(msg, dictionary).stream().mapToInt(i -> i).toArray();
    }
    
    ArrayList<Word> initDictionary() {
        ArrayList<Word> dictionary = new ArrayList<>();
        for(int i = 0; i < 26; i++) 
            dictionary.add(new Word(String.valueOf((char)('A' + i)), i + 1));
        return dictionary;
    }
    
    ArrayList<Integer> getAnswer(String msg, ArrayList<Word> dictionary) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < msg.length(); i++) {
            Collections.sort(dictionary);
            String subMsg = msg.substring(i);
            
            for(Word word : dictionary) {
                if(subMsg.startsWith(word.getWord())) {
                    answer.add(word.number);
                    if(i + word.getLength() + 1 <= msg.length()) 
                        dictionary.add(new Word(subMsg.substring(0, word.getLength() + 1), dictionary.size() + 1));
                    
                    i += word.getLength() - 1;
                    break;
                }
            }
        }
        return answer;
    }
}