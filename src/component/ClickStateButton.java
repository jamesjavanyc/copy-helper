package component;

import java.awt.*;

/**
 * @projectName:StateButton
 * @className: StateButton
 * @description:
 * @TODO:
 * @author: James
 * @createDate: 8/26/2022
 * @updateUser: user
 * @updateDate: datetime
 * @updateRemark:
 * @version: v1.0
 */
public class ClickStateButton extends Button {

    private boolean clicked = false;

    private Color unClickedColor = Color.WHITE;

    private Color clickedColor = Color.yellow;

    public void click() {
        this.clicked = !clicked;
        this.setBackground(clicked?clickedColor: unClickedColor);
    }

    public ClickStateButton(String label) throws HeadlessException {
        super(label);
    }

    public ClickStateButton(String label, Color clickedColor, Color unClickedColor) throws HeadlessException {
        super(label);
        this.clickedColor = clickedColor;
        this.unClickedColor = unClickedColor;
    }
}
