package listener;

import clipboard.ClipBoard;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @projectName:listener
 * @className: BoardTextListener
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class BoardTextListener implements TextListener {

    private static ClipBoard board = ClipBoard.getInstance();

    @Override
    public void textValueChanged(TextEvent e) {
        String modifiedText = ((TextArea) e.getSource()).getText();
        board.setClipboardText(modifiedText);
    }
}
