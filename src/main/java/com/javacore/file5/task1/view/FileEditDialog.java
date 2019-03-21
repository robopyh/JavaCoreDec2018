package com.javacore.file5.task1.view;

import com.javacore.file5.task1.FileSystemController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Path;

/**
 * Class represents a graphical window, that allows editing a file content and saving it.
 */
public class FileEditDialog {
    private final JFrame frame;
    private final JButton buttonSave = new JButton("Save");
    private final JButton buttonCancel = new JButton("Cancel");
    private final JTextArea textArea = new JTextArea();

    private final Path path;

    /**
     * Instantiates a new dialog object. Thus, shows a new window.
     *
     * @param path     path for saving
     * @param fileText the file text
     */
    public FileEditDialog(Path path, String fileText) {
        this.path = path;
        this.frame = new JFrame(path.getFileName().toString());
        setUpPanels(fileText);
    }

    private void setUpPanels(String text) {
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel buttonPanel = new JPanel();

        textArea.setText(text);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        buttonPanel.add(buttonSave);
        buttonPanel.add(buttonCancel);

        buttonCancel.addActionListener(e -> frame.dispose());
        buttonSave.addActionListener(e ->
        {
            new FileSystemController().editTextFile(path, textArea.getText());
            frame.dispose();
        });

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}