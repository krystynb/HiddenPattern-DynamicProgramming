// author: krystyn bondad (if anyone says they are in my group they are liars don't give me a 0

import java.util.Properties;
import java.io.FileReader;

public class HiddenWordDriver {
    public static void main(String[] args) {

        try {

            //read file
            FileReader reader = new FileReader("word.props");
            Properties p = new Properties();

            // Get your properties
            
            p.load(reader);
            
            String w1 = p.getProperty("word1");
            String w2 = p.getProperty("word2");

            //create object
            HiddenWord hw = new HiddenWord(w1, w2);

            //print hidden word
            String hiddenWord = hw.find();
            System.out.println(hiddenWord);
            
        } 
        catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
