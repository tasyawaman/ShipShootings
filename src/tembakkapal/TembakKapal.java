/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tembakkapal;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class TembakKapal {
    public static Scanner scn = new Scanner(System.in);
    int x = 9;
    int y = 9;
    int score = 100;
    public static int totalScore = 0;
    public static int ship = 5;
    public static int bullet = 10;
    public static int totalFire =0;
    public static int tryX, tryY;
    String[][] map = new String[9][9]; 
    String[][] sea = new String[x][y];
    String k = "X";
    String b = "O";
    
    
    //This method fills the array and also adds 5 Xs (the ships) at the specific index
    public void generateArray(){
        for(int i = 0; i < sea.length; i++){
            for(int j = 0; j < sea.length; j++){
                sea[i][j] = b;
                map [i][j] = b;
            }
        }
        sea[0][0] = k;
        sea[2][0] = k;
        sea[3][5] = k;
        sea[5][5] = k;
        sea[7][8] = k;
        map[0][0] = k;
        map[2][0] = k;
        map[3][5] = k;
        map[5][5] = k;
        map[7][8] = k;
    }
    

    //This function returns the result of your shooting actions
    //If the input (x and y are the index of the array) is correct, the user will get points (100-the number of guess user does)
    
    public String shoot(int x, int y){
        
        String hit = "";
        bullet--;
        totalFire ++;
            
            if(sea[x][y].equals(k)){
                sea[x][y] = b;
                score = 100 - totalFire;
                totalScore = totalScore + score;
                ship--;
                hit = "Good shot! You hit the ship \n" + "Your score +" + score + "\n" + ship + " more ships you have to shoot " + "You have " + bullet + " bullets left to shoot" ;
                
                
            }else{
                hit = "You missed! " + "you have " + bullet + " bullets to shoot" ;
            }
        return hit;
        
    }
    //This method displays the map of the location of the ships in an array. Xs indicate the location of the ships.
    public void openSea(){
        
        System.out.println("Map of the ships ");
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TembakKapal t1 = new TembakKapal();
        t1.generateArray();
        while(ship > 0 && bullet > 0){
            System.out.printf("Shoot at the X coordinate:"); tryX = scn.nextInt();
            System.out.printf("Shoot at the Y coordinate:"); tryY = scn.nextInt();
            String hasil = t1.shoot(tryX, tryY);
            System.out.println(hasil);
        }
        
        System.out.println("Your total score : " + totalScore);
        t1.openSea();
    }
    
}
