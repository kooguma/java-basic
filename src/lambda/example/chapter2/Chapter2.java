package lambda.example.chapter2;

import javax.swing.*;

public class Chapter2 {

    private JButton button;

    public void error() {
        String name = getUserName();
        name = formatUserName(name);
        // Uncommenting this line should cause a compile error:
        // button.addActionListener(event -> System.out.println("hi " + name));
    }

    private String formatUserName(String name) {
        return name.toLowerCase();
    }

    private String getUserName() {
        return "Kuma";
    }
}
