package annotation2;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo(text = "E:\\051016\\text.txt")

public class TextContainer {
    private String text = "TEXT";

    public TextContainer(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    @Saver
    public void saveFileTo(String text, String file) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(text);
        }
    }
}

