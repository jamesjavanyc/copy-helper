package listener;

import clipboard.ClipBoard;
import component.ClickStateButton;

import java.awt.event.MouseEvent;

/**
 * @projectName:listener
 * @className: MultiplePasteListener
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class EnableListener extends StateButtonClickListener {

    public static  Boolean enabled = Boolean.TRUE;

    public ClickStateButton button ;

    public EnableListener(ClickStateButton btn) {
        super(btn);
        this.button = btn;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.click();
        enabled = !enabled;
        if(enabled){
            button.setLabel("Disable Button");
        }else{
            button.setLabel("Enable Button");
        }

    }






    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
