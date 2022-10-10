package listener;

import clipboard.ClipBoard;
import ui.BoardFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @projectName:listener
 * @className: ClearTextAreaListener
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class ClearTextAreaListener implements MouseListener {

    private static final TextArea text = BoardFrame.getTextAreaInstance();

    private static final ClipBoard board = ClipBoard.getInstance();

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(TemplateLockListener.enabled){
            text.setText(TemplateLockListener.getTemplate());
            board.resetCurrentIndex();
        }else{
            text.setText("");
            board.resetCurrentIndex();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
