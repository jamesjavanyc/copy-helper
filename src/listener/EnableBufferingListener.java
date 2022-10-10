package listener;

import clipboard.ClipBoard;
import component.ClickStateButton;

import java.awt.event.MouseEvent;

/**
 * @projectName:listener
 * @className: EnableBufferingListener
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class EnableBufferingListener extends EnableListener{

    public static boolean enabled = false;

    public EnableBufferingListener(ClickStateButton btn) {
        super(btn);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.click();
        enabled = !enabled;
        if(enabled){
            button.setLabel("Disable Text Buffer");
            ClipBoard.getInstance().setClipboardText(ClipBoard.getInstance().getBoardText());
        }else{
            button.setLabel("Enable Text Buffer");
        }

    }
}
