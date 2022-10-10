package listener;

import clipboard.ClipBoard;
import component.ClickStateButton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class EnableBufferingListener extends StateButtonClickListener {

    public static  Boolean enabled = Boolean.TRUE;

    private ClickStateButton button ;

    public EnableBufferingListener(ClickStateButton btn) {
        super(btn);
        this.button = btn;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(enabled == null ) enabled = Boolean.TRUE;
        button.click();
        enabled = !enabled;
        if(enabled){
            button.setLabel("Disable Text Buffer");
            ClipBoard.getInstance().setClipboardText(ClipBoard.getInstance().getBoardText());
        }else{
            button.setLabel("Enable Text Buffer");
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
