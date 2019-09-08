package Task2;


import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "d:\\file.txt")
public class TextContainer {

    public TextContainer() {
    }

    String text = "I'am TextContainer";

    @Save
    public void save(String path) {
        try (
                FileWriter writer = new FileWriter(path)) {
            writer.write(text);
            writer.flush();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

