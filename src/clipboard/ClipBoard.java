package clipboard;

import java.awt.*;
import java.awt.datatransfer.*;


/**
 * @projectName:PACKAGE_NAME
 * @className: clipboard.ClipBoard
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class BoardFrame implements ClipboardOwner{

    private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    private static String boardText = "";

    private static String connector = "";

    private static Integer currentIndex = 0;

    public BoardFrame(){
        // 将剪切板的所有者设置为自己, 当所有者为自己时，才能监控下一次剪切板的变动, clipboard.getContents(null) 获取当前剪切板的内容
        clipboard.setContents(clipboard.getContents(null), this);
    }


    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        try {
            Thread.sleep(1000);
            String text = null;
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
                Object data = clipboard.getData(DataFlavor.stringFlavor);
                if (data instanceof String) text = (String) data;
                if(currentIndex == 0){
                    boardText = boardText + data;
                }else{
                    boardText = boardText + connector + data;
                }
                currentIndex++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Transferable text = new StringSelection(boardText);
            clipboard.setContents(text, this);
            System.out.println("new copy: "+ boardText);
        }
    }


    public void setClipboardText(String text){
        boardText = text;
        clipboard.setContents(new StringSelection(boardText), this);
        System.out.println("boardText changed: "+text);
    }


    private static BoardFrame singleton;

    public static BoardFrame getInstance(){
        if(singleton == null){
            BoardFrame board = new BoardFrame();
            singleton = board;
        }
        return singleton;
    }

}
