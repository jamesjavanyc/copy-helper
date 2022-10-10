package ui;

import component.ClickStateButton;
import component.LabelTextInput;
import listener.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @projectName:PACKAGE_NAME
 * @className: ui.BoardFrame
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class BoardFrame extends Panel {

    public BoardFrame(String title) {
        Frame frame = new Frame(title);

        frame.setSize(360, 620);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setBackground(Color.lightGray);

        final TextArea textArea = new TextArea(28, 47);
        textArea.setBackground(Color.WHITE);
        textArea.setText("");
        textArea.setSize(460,600);
        this.add(textArea);
        text = textArea;
        textArea.addTextListener(new BoardTextListener());

        ClickStateButton buttonEnable = new ClickStateButton("Enable Text Buffer");
        EnableBufferingListener bufferingListener = new EnableBufferingListener(buttonEnable);
        buttonEnable.addMouseListener(bufferingListener);
        this.add(buttonEnable);

        Button clearTextArea = new Button("Clear Text Area");
        clearTextArea.addMouseListener(new ClearTextAreaListener());
        this.add(clearTextArea);

        ClickStateButton templateLock = new ClickStateButton("Template Lock");
        templateLock.addMouseListener(new TemplateLockListener(templateLock));
        this.add(templateLock);

        LabelTextInput connector = new LabelTextInput("Enable Connector", "");
        EnableConnectorListener connectorListener = new EnableConnectorListener(connector.getButton(), connector.getTextArea());
        connectorListener.setBufferingListener(bufferingListener);

        LabelTextInput template = new LabelTextInput("Enable Template", "");
        EnableTemplateListener templateListener = new EnableTemplateListener(template.getButton(), template.getTextArea());
        templateListener.setBufferingListener(bufferingListener);

        this.add(connector.addButtonMouseListener(connectorListener.setTemplateListener(templateListener)));
        this.add(template.addButtonMouseListener(templateListener.setConnectorListener(connectorListener)));


        frame.add(this);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    private static TextArea text = null;

    public static TextArea getTextAreaInstance(){
        if(text == null){
            throw new RuntimeException("Initialize text area exception.");
        }
        return text;
    }
}
