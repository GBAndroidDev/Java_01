import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

// left: 10; top: 30;
// right: 10; bottom: 30;
// v_align:center; h_align:center;
// v_align:left; h_align:right; width: 800; height: 600;

class SetBoundsPosition extends JFrame {

    private int screenWidth;
    private int screenHeight;
    private HashMap<String,String> paramData = new HashMap<>();
    private int window_width = 640;
    private int window_height = 480;
    private int x_position;
    private int y_position;


    void setBounds(String paramStr) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        splitStr(paramStr);
        checkBoundsParam();
        setBounds(x_position,y_position,window_width,window_height);
    }


    private void splitStr(String paramStr) {
        String[] splittedArray = paramStr.split(";");
        for (String value: splittedArray) {
            if (!value.isEmpty()) {
                paramData.put(value.split(":")[0].trim(),value.split(":")[1].trim());
            }
        }
    }

    private void checkBoundsParam() {

        try {
            getSizeWindow(paramData);
            getPosition(paramData);
        } catch (Exception e) {
            //Что-то пошло не так. Окну будут присвоены значения по умолчанию. Вывод по центру экрана.
            System.out.println(e);
            x_position = positionCenterX(window_width);
            y_position = positionCenterY(window_height);
        }
    }

    private int positionCenterX(int winWidth) {
        return (screenWidth - winWidth) / 2;
    }
    private int positionCenterY(int winHeight) {
        return (screenHeight - winHeight) / 2;
    }

    private int getAlign(Object o, String dir) {
        String getPos = (String)o;
        switch (getPos) {
            case "left":
            case "top": break;
            case "right": return screenWidth - window_width;
            case "bottom": return screenHeight - window_height;
            case "center":
                if ("v".equals(dir)) {System.out.println(getPos); return positionCenterY(window_height);}
                if ("h".equals(dir)) {System.out.println(getPos); return positionCenterX(window_width);}
        }
        System.out.println(getPos);
        return 0;
    }

    private void getSizeWindow(HashMap<String, String> map) {
        for (HashMap.Entry pair: map.entrySet()) {
            switch ((String)pair.getKey()) {
                case "width": window_width = Integer.parseInt((String)pair.getValue()); break;
                case "height": window_height = Integer.parseInt((String)pair.getValue()); break;
            }
        }
    }

    private void getPosition(HashMap<String, String> map) {
        for (HashMap.Entry pair: map.entrySet()) {
            switch ((String)pair.getKey()) {
                case "left": x_position = Integer.parseInt((String)pair.getValue()); break;
                case "right": x_position = screenWidth - window_width - Integer.parseInt((String)pair.getValue()); break;
                case "top": y_position = Integer.parseInt((String)pair.getValue()); break;
                case "bottom": y_position = screenHeight - window_height - Integer.parseInt((String)pair.getValue()); break;
                case "v_align": System.out.println((String)pair.getKey()); y_position = getAlign(pair.getValue(),"v"); break;
                case "h_align": System.out.println((String)pair.getKey()); x_position = getAlign(pair.getValue(),"h"); break;
            }
        }
    }
    // left: 10; top: 30;
    // right: 10; bottom: 30;
    // v_align:center; h_align:center;
    // v_align:left; h_align:right; width: 800; height: 600;

}
