import java.io.File;
import java.io.IOException;

public class OutputFile {

    private String fileName;

    public OutputFile(String fileName) {
        this.fileName = fileName;
//        create();
    }

//    CODE EMPRUNTÉ pour create un fichier
//    https://www.w3schools.com/java/java_files_create.asp
    public void create() {
        try {
            File myObj = new File(this.fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File overwriten because the file already exists.");
                myObj.delete();
                myObj.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
