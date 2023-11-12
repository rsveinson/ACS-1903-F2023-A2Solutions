// As2 Q1 Sample Solution
import javax.swing.JOptionPane;

public class InstrumentClassifierMethods{
    public static void main(String[] args){
        String response, output;
        do{
            String model = JOptionPane.showInputDialog("Enter a Yamaha model number:").toUpperCase();
            // get all the codes
            char first = model.charAt(0);
            String typeCode = model.substring(1,3);
            char gradeCode = model.charAt(4);
            char keyCode = model.charAt(5);

            if (first == 'Y'){  // check if Yamaha
                // Instrument lookup
                String instrument = lookUpInstrument(typeCode);
                // Grade lookup
                String grade = lookUpGrade(gradeCode);
                // Key lookup
                String key = lookUpKey(keyCode);
                // create output String
                output = createInfoText(instrument, grade, key);

            } else output = "Not a Yamaha instrument";
            response = JOptionPane.showInputDialog(output + "\n\nEnter another number? yes/no");            
        } while(response.equals("yes"));
        JOptionPane.showMessageDialog(null, "Goodbye!");
    }

    public static String lookUpInstrument(String typeCode){       
        String instrument;
        if (typeCode.equals("TR")) 
            instrument = "Trumpet";
        else if (typeCode.equals("CR")) 
            instrument = "Cornet";
        else if (typeCode.equals("FH")) 
            instrument = "Flugelhorn";
        else 
            instrument = "unknown";
        return instrument;
    }

    public static String lookUpGrade(char gradeCode){
        String grade;
        switch(gradeCode){
            case '1':
            case '2': grade = "Beginner";
            break;
            case '3': grade = "Step-up";
            break;
            case '4':
            case '5': grade = "Intermediate";
            break;
            case '6':
            case '7': grade = "Professional";
            break;
            case '8':
            case '9': grade = "Artist/Custom";
            break;
            default: grade = "unknown";
        }
        return grade;
    }

    public static String lookUpKey(char keyCode){
        String key;
        if (keyCode == '3') 
            key = "Bb";
        else if (keyCode == '4') 
            key = "C";
        else if (keyCode == '5') 
            key = "D";
        else if (keyCode == '6') 
            key = "Eb";
        else if (keyCode == '7') 
            key = "FG";
        else if (keyCode == '8') 
            key = "A";
        else key = "unknown";
        return key;
    }

    public static String createInfoText(String instrument, String grade, String key){
        return "Instrument: " + instrument + "\nGrade: " + grade + "\nKey: " + key;
    }
}
