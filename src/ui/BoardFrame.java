import listener.BoardTextListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @projectName:PACKAGE_NAME
 * @className: BoardFrame
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

        frame.setSize(360, 560);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        final TextArea textArea = new TextArea(28, 40);
        textArea.setBackground(Color.CYAN);
        textArea.setText("");
        textArea.setSize(460,660);
        this.add(textArea);
        textArea.addTextListener(new BoardTextListener());

        frame.add(this);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    private static final BoardFrame frame = BoardFrame.getInstance();    private static clipboard.BoardFrame singleton;

    public static BoardFrame getInstance(){
        if(singleton == null){
            clipboard.BoardFrame board = new clipboard.BoardFrame();
            singleton = board;
        }
        return singleton;
    }
}
