package listener;

import clipboard.ClipBoard;
import component.ClickStateButton;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @projectName:listener
 * @className: EnableConnectorListener
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class EnableConnectorListener extends EnableListener{

    public void setBufferingListener(EnableBufferingListener bufferingListener) {
        this.bufferingListener = bufferingListener;
    }

    public EnableBufferingListener bufferingListener;

    public static boolean enabled = false;

    public TextArea textArea;

    public static ClickStateButton button;

    public EnableConnectorListener setTemplateListener(EnableTemplateListener templateListener) {
        this.templateListener = templateListener;
        return this;
    }

    public EnableTemplateListener templateListener;

    public EnableConnectorListener(ClickStateButton btn) {
        super(btn);
        this.button = btn;
        enabled = false;
    }
    public EnableConnectorListener(ClickStateButton btn, TextArea textArea) {
        super(btn);
        this.button = btn;
        enabled = false;
        this.textArea = textArea;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        button.click();
        if(EnableTemplateListener.enabled){
            templateListener.mouseReleased(null);
        }
        enabled = !enabled;
        if(enabled){
            if(!EnableBufferingListener.enabled) bufferingListener.mouseReleased(null);
            button.setLabel("Disable Connector");
            String connector = textArea.getText();
            ClipBoard.setConnector(connector);
        }else{
            button.setLabel("Enable Connector");
            ClipBoard.setConnector("");
        }

    }

}
