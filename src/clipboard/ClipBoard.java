package clipboard;

import java.awt.*;
import java.awt.datatransfer.*;

import listener.EnableBufferingListener;
import listener.EnableConnectorListener;
import listener.EnableTemplateListener;
import ui.BoardFrame;


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
public class ClipBoard implements ClipboardOwner{

    private static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    private static String boardText = "";

    public static void setConnector(String connector) {
        ClipBoard.connector = connector;
    }

    private static String connector = "";

    private static Integer currentIndex = 0;

    private static TextArea applicationTextArea = BoardFrame.getTextAreaInstance();


    public ClipBoard(){
        clipboard.setContents(clipboard.getContents(null), this);
    }


    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        if(!EnableBufferingListener.enabled)  return;
        if(EnableConnectorListener.enabled){
            try {
                Thread.sleep(500);
                String text = null;
                if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
                    Object data = clipboard.getData(DataFlavor.stringFlavor);
                    if (data instanceof String) text = (String) data;
                    if(currentIndex == 0){
                        boardText = boardText + text;
                    }else{
                        boardText = boardText + connector + text;
                    }
                    currentIndex++;
                }
                applicationTextArea.setText(boardText);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                Transferable text = new StringSelection(boardText);
                clipboard.setContents(text, this);
                System.out.println("new copy: "+ boardText);
            }
        }else if(EnableTemplateListener.enabled){
            try{
                Thread.sleep(500);
                if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                    Object data = clipboard.getData(DataFlavor.stringFlavor);
                    String text = "";
                    if (data instanceof String) text = (String) data;
                    String replaced = boardText.replaceFirst("/data/", text);
                    boardText = replaced;
                }
                applicationTextArea.setText(boardText);
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                Transferable text = new StringSelection(boardText);
                clipboard.setContents(text, this);
                System.out.println("new copy: "+ boardText);
            }
        }
    }


    public void setClipboardText(String text){
        if(!EnableBufferingListener.enabled) {
            boardText = text;
            return;
        };
        boardText = text;
        clipboard.setContents(new StringSelection(boardText), this);
        System.out.println("boardText changed: "+text);
    }


    private static ClipBoard singleton;

    public static ClipBoard getInstance(){
        if(singleton == null){
            ClipBoard board = new ClipBoard();
            singleton = board;
        }
        return singleton;
    }

    public String getBoardText(){
        return boardText;
    }

    public void resetCurrentIndex(){
        currentIndex = 0;
    };

}
