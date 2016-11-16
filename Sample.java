package annotation2;

import java.io.IOException;
import java.lang.reflect.Method;

public class Sample {

    public static void main(String[] args) {

        TextContainer textContainer = new TextContainer("TEXT");
        Class<?> cls = TextContainer.class;

        Method[]  methods = cls.getMethods();
        try {
            if (cls.isAnnotationPresent(SaveTo.class)) {
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Saver.class)) {
                        SaveTo annotation = cls.getAnnotation(SaveTo.class);
                        textContainer.saveFileTo(textContainer.getText(), annotation.text());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
