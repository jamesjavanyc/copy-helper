package listener;

import component.ClickStateButton;
import jdk.internal.util.xml.impl.Input;
import ui.BoardFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @projectName:listener
 * @className: EnableTemplateListener
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class EnableTemplateListener extends EnableListener{

    public void setBufferingListener(EnableBufferingListener bufferingListener) {
        this.bufferingListener = bufferingListener;
    }

    public EnableBufferingListener bufferingListener;

    private TextArea textArea;

    private TextArea appTextArea = BoardFrame.getTextAreaInstance();

    public static boolean enabled = false;

    public static ClickStateButton button;

    public EnableTemplateListener setConnectorListener(EnableConnectorListener connectorListener) {
        this.connectorListener = connectorListener;
        return this;
    }

    public EnableConnectorListener connectorListener;

    public EnableTemplateListener(ClickStateButton button) {
        super(button);
        this.button = button;
        enabled = false;
    }
    public EnableTemplateListener(ClickStateButton button, TextArea textArea) {
        super(button);
        this.button = button;
        enabled = false;
        this.textArea = textArea;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.click();
        if(EnableConnectorListener.enabled){
            connectorListener.mouseReleased(null);
        }
        enabled = !enabled;
        if(enabled){
            if(!EnableBufferingListener.enabled) bufferingListener.mouseReleased(null);
            button.setLabel("Disable Template");
            StringBuilder finalText = new StringBuilder("Input Template here.");
            try {
                System.out.println(textArea.getText());
                BufferedReader in = new BufferedReader(new FileReader(textArea.getText().trim()));
                finalText = new StringBuilder();
                String str = "";
                while ( (str = in.readLine()) != null) {
                    finalText.append(str);
                    System.out.println(str);
                }
            } catch (Exception ex) {
                ex.getStackTrace();
            }finally {
                appTextArea.setText(finalText.toString());
            }
        }else{
            button.setLabel("Enable Template");
        }

    }
}
