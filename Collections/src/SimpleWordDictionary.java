import java.util.*;

public class SimpleWordDictionary {
    private TreeMap<Character, ArrayList<String>> dictionary=new TreeMap<>();
    public SimpleWordDictionary(){
        for(int i=0;i<26;i++)
        {
            dictionary.put((char)('a'+i),new ArrayList<>());
        }

    }
    public void addWord(String word)
    {
        String newWord=word.toLowerCase();
        dictionary.get(newWord.charAt(0)).add(word);
        Collections.sort(dictionary.get(newWord.charAt(0)));
    }
    public void printAll()
    {
        for (Map.Entry<Character, ArrayList<String>> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public void printAllCleaned()      // Only Print nonEmpty lists
    {
        for (Map.Entry<Character, ArrayList<String>> entry : dictionary.entrySet()) {
            if(entry.getValue().isEmpty())
                continue;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public void printGivenLetter(Character c)
    {
        System.out.println(c +" : "+ dictionary.get(c));
    }





}
