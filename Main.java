package rtu;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
  
class Celojums {
  public int id;
  public String city;
  public String date;
  public int duration;
  public float price;
  public String transport;

  public Celojums(int id, String city, String date, int duration, float price, String transport) {
    this.id = id;
    this.city = city;
    this.date = date;
    this.duration = duration;
    this.price = price;
    this.transport = transport;
  }
}

class Main {
  
  static Scanner sc = new Scanner(System.in);
  static String filename = sc.nextLine();
  public static void main(String[] args) {
    ArrayList<Celojums> data = new ArrayList<Celojums>();
    data = readCSV(filename);
    String cmd[];
    loop: while(true){
      cmd = sc.nextLine().toLowerCase().split(" ");

      switch(cmd[0]){
        case "add":
          int fieldCount = cmd[1].length() - cmd[1].replace(";", "").length(); 
          if (fieldCount!=5){
            System.out.println("wrong field count");
            break;
          }
          add(cmd[1]);
          break;
        case "del":
          del();
          break;
        case "edit":
          edit();
          break;
        case "print":
          print(cmd[1]);
          break;
        case "sort":
          sort();
          break;
        case "find":
          find();
          break;
        case "avg":
          avg();
          break;
        case "exit":
          exit(data);
          break loop;
        default:
          System.out.println("wrong command");
          break;
      }
    }
    sc.close();
    
  }

  public static ArrayList readCSV(String path) {
    ArrayList<Celojums> arr = new ArrayList<Celojums>();
    
    try (Scanner sc = new Scanner(new File(path))) {
  
      while(sc.hasNext()) {
        String line[] = sc.nextLine().split(";");
        
        int id = Integer.parseInt(line[0]);
        String city = line[1];
        String date = line[2];
        int duration = Integer.parseInt(line[3]);
        float price = Float.parseFloat(line[4]);
        String transport = line[5];
        Celojums cel = new Celojums(id, city, date, duration, price, transport);
        arr.add(cel);
      }
    } catch(Exception e) {
      System.out.println(e);
    }
    return arr;
  }

  public static void add(String cel){
    return;
  }

  public static void del(){
    return;
  }

  public static void edit(){
    return;
  }

  public static void print(String cel){
    return;
  }

  public static void sort(){
    return;
  }

  public static void find(){
    return;
  }

  public static void avg(){
    return;
  }

  public static void exit(ArrayList<Celojums> data){

    return;
  }
}
