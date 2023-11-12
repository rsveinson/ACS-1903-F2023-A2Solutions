// As1 Q2 Sample Solution
import javax.swing.JOptionPane;

public class InstrumentClassifier{
    public static void main(String[] args){
        String output;
        String model = JOptionPane.showInputDialog("Enter a Yamaha model number:").toUpperCase();

        // get all the codes
        char first = model.charAt(0);
        String typeCode = model.substring(1,3);
        char gradeCode = model.charAt(4);
        char keyCode = model.charAt(5);

        if (first == 'Y'){  // check if Yamaha

            // Instrument lookup
            String instrument;
            if (typeCode.equals("TR")) 
                instrument = "Trumpet";
            else if (typeCode.equals("CR")) 
                instrument = "Cornet";
            else if (typeCode.equals("FH")) 
                instrument = "Flugelhorn";
            else instrument = "unknown";

            // Grade lookup
            String grade;
            if (gradeCode == '1' || gradeCode == '2') 
                grade = "Beginner";
            else if (gradeCode == '3') 
                grade = "Step-up";
            else if (gradeCode == '4' || gradeCode == '5') 
                grade = "Intermediate";
            else if (gradeCode == '6' || gradeCode == '7') 
                grade = "Professional";
            else if (gradeCode == '8' || gradeCode == '9') 
                grade = "Artist/Custom";
            else grade = "unknown";

            // Key lookup
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

            // create info string
            output = "Instrument: " + instrument + "\nGrade: " + grade + "\nKey: " + key;
        } 
        else
            output = "Not a Yamaha instrument";

        // display result
        JOptionPane.showMessageDialog(null, output);
    }
}
