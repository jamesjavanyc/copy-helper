package component;

import javax.accessibility.Accessible;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.TextListener;

/**
 * @projectName:component
 * @className: ButtonText
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class LabelTextInput extends Panel implements Accessible {

    private ClickStateButton button;

    private TextArea textArea;


    public LabelTextInput addButtonMouseListener(MouseListener listener){
        this.button.addMouseListener(listener);
        return this;
    }
    public LabelTextInput addTextAreaTextListener(TextListener listener){
        this.textArea.addTextListener(listener);
        return this;
    }


    public LabelTextInput(String label, String defaultText) {
        this.button = new ClickStateButton(label);
        this.textArea = new TextArea(defaultText);
        this.add(button);
        this.add(textArea);
        textArea.setColumns(25);
        textArea.setRows(1);
        this.setSize(350,20);
    }
    public LabelTextInput(String label, String defaultText, int column) {
        this.button = new ClickStateButton(label);
        this.textArea = new TextArea(defaultText);
        this.add(button);
        this.add(textArea);
        textArea.setColumns(column);
        textArea.setRows(1);
        this.setSize(300,20);
        textArea.setSize(350,20);
    }

    public LabelTextInput(String label, String defaultText, int column, int width, int height) {
        this.button = new ClickStateButton(label);
        this.textArea = new TextArea(defaultText);
        this.add(button);
        this.add(textArea);
        textArea.setColumns(column);
        textArea.setRows(1);
        this.setSize(width,height);
        textArea.setSize(width,height);
    }


    public ClickStateButton getButton() {
        return button;
    }


    public TextArea getTextArea() {
        return textArea;
    }

}
