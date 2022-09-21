package all;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static all.TikTakproj.field;

public class Optional{

    public static void printField(){
        for (int j = 0 ; j < 3 ; j++){
            for (int i = 0 ; i < 3 ; i++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] makeField(){
        for (int j = 0 ; j < 3 ; j++){
            for (int i = 0 ; i < 3 ; i++){
                field[i][j] = "-";
            }
        }
        return field;
    }

        static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        public void getValue(Object o){

            System.out.println("Insert position:");
            String position;
            try {
                position = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] mes = position.split(" ");
            int posX = Integer.parseInt(mes[0]);
            int posY = Integer.parseInt(mes[1]);
            try {
                XThread xThread = (XThread) o;
            }catch (ClassCastException e){
                setOValue(posX , posY);
                return;
            }
            try {
                OThread oThread = (OThread) o;
            }catch (ClassCastException e){
                setXValue(posX , posY);
                return;
            }
        }


        public  void setXValue(int posX , int posY){

            int varPosX;
            int varPosY;
            try {


            varPosX = posX-1;
            varPosY = posY-1;
            if (field[varPosX][varPosY].equals("X") || field[varPosX][varPosY].equals("O")){
                System.out.println("try other field");
                getValue(new XThread());

            }
            else {
                field[varPosX][varPosY] = "X";
                if (checkXvinner()){
                    System.out.println("X winner!");
                    Optional.printField();
                    System.exit(0);
                }
                else if (checkDraw()) {
                    System.out.println("Draw :)");
                    Optional.printField();
                    System.exit(0);
                }
                printField();
            }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of bounds on field");
                getValue(new XThread());
            }
        }
        public  void setOValue(int posX , int posY){
            int varPosX;
            int varPosY;
            varPosX = posX-1;
            varPosY = posY-1;
            try {


            if (field[varPosX][varPosY].equals("X") || field[varPosX][varPosY].equals("O")){
                System.out.println("try other field");
                getValue(new OThread());
            }
            else {
                if (checkOVinner()){
                    System.out.println("O winner!");
                    Optional.printField();
                    System.exit(0);
                } else if (checkDraw()) {
                    System.out.println("Draw :)");
                    Optional.printField();
                    System.exit(0);
                }
                field[varPosX][varPosY] = "O";
                printField();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Out of bounds on field");
                getValue(new OThread());
            }
        }



        public  boolean checkXvinner() {
        boolean Xvinner = false;

             if (field[0][0].equals("X") && field[0][1].equals("X") && field[0][2].equals("X")){
                Xvinner = true;
            }
            else if (field[1][0].equals("X") && field[1][1].equals("X") && field[1][2].equals("X")){
                 Xvinner = true;
            }
            else if (field[2][0].equals("X") && field[2][1].equals("X") && field[2][2].equals("X")){
                 Xvinner = true;
            }
            else if (field[0][0].equals("X") && field[1][0].equals("X") && field[2][0].equals("X")){
                 Xvinner = true;
            }
            else if (field[0][1].equals("X") && field[1][1].equals("X") && field[2][1].equals("X")){
                 Xvinner = true;
            }
            else if (field[0][2].equals("X") && field[1][2].equals("X") && field[2][2].equals("X")){
                 Xvinner = true;
            }
            else if (field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X")){
                 Xvinner = true;
            }
            else if (field[0][2].equals("X") && field[1][1].equals("X") && field[2][0].equals("X")){
                 Xvinner = true;
            }
                return Xvinner;
        }

        public  boolean checkOVinner() {
        boolean Ovinner = false;
            if (field[0][0].equals("O") && field[0][1].equals("O") && field[0][2].equals("O")){
               Ovinner = true;
            }
            else if (field[1][0].equals("O") && field[1][1].equals("O") && field[1][2].equals("O")){
                Ovinner = true;
            }
            else if (field[2][0].equals("O") && field[2][1].equals("O") && field[2][2].equals("O")){
                Ovinner = true;
            }
            else if (field[0][0].equals("O") && field[1][0].equals("") && field[2][0].equals("O")){
                Ovinner = true;
            }
            else if (field[0][1].equals("O") && field[1][1].equals("O") && field[2][1].equals("O")){
                Ovinner = true;
            }
            else if (field[0][2].equals("O") && field[1][2].equals("O") && field[2][2].equals("O")){
                Ovinner = true;
            }
            else if (field[0][0].equals("O") && field[1][1].equals("O") && field[2][2].equals("O")){
                Ovinner = true;
            }
            else if (field[0][2].equals("O") && field[1][1].equals("O") && field[2][0].equals("O")){
                Ovinner = true;
            }
            return Ovinner;
        }

        public boolean checkDraw(){
            int control = 0;
            boolean boob = false;
            for (int j = 0 ; j < 3 ; j++){
                for (int i = 0 ; i < 3 ; i++){
                    if (field[i][j].equals("X") || field[i][j].equals("O")){
                        control++;
                    }
                }
            }
            if (control == 9){
                if (!checkOVinner() || !checkXvinner()){
                    boob = true;
                }
            }

            return boob;
        }


}
