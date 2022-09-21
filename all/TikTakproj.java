package all;


import java.io.IOException;

public class TikTakproj{
    public static String[][] field = new String[3][3];

    public static void main(String[] args) {

       Optional optional = new Optional();
       Object X  = new XThread();
       Object O = new OThread();
       Optional.makeField();
       while (!optional.checkOVinner() || !optional.checkXvinner() || !optional.checkDraw()){
           optional.getValue(X);
           optional.getValue(O);
           if (optional.checkXvinner()){
               System.out.println("X winner!");
               Optional.printField();
               break;
           }
           else if (optional.checkOVinner()){
               Optional.printField();
               System.out.println("O winner!");
               break;
           } else if (optional.checkDraw()) {
               Optional.printField();
               System.out.println("Draw :)");
               break;
           }
       }
    }
}

