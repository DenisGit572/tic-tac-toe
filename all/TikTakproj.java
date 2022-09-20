package all;


import java.io.IOException;

public class TikTakproj{
    public static String[][] field = new String[3][3];

    public static void main(String[] args) {

       Optional optional = new Optional();
       Object X  = new XThread();
       Object O = new OThread();
       Optional.makeField();
       do {
           optional.getValue(X);
           optional.getValue(O);
           if (optional.checkXvinner()){
               System.out.println("X winner!");
               break;
           }
           else if (optional.checkOVinner()){
               System.out.println("O winner!");
               break;
           } else if (optional.checkDraw()) {
               System.out.println("Draw :)");
               break;
           }
       }
       while (!optional.checkOVinner() || !optional.checkXvinner() || !optional.checkDraw());

    }
    }

