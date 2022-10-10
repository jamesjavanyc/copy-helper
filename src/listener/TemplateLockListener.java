package listener;

import component.ClickStateButton;
import ui.BoardFrame;

import java.awt.*;
import java.awt.event.MouseEvent;


/**
 * @projectName:listener
 * @className: TemplateLockListener
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/27/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class TemplateLockListener extends EnableListener {

    public TextArea textArea = BoardFrame.getTextAreaInstance();

    public ClickStateButton button;

    public static boolean enabled;

    private static String template = "";

    public TemplateLockListener(ClickStateButton btn) {
        super(btn);
        this.button = btn;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(EnableTemplateListener.enabled){
            this.button.click();
            enabled = ! enabled;
            if(enabled){
                template = textArea.getText();
            }else{
                template = "";
            }
        }
    }

    public static String getTemplate(){
        return template;
    }
}
