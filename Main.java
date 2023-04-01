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
          del(data);
          break;
        case "edit":
          edit(data);
          break;
        case "print":
          print(data);
          break;
        case "sort":
          sort(data);
          break;
        case "find":
          find(data);
          break;
        case "avg":
          avg(data);
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

  public static void del(ArrayList<Celojums> data){
    return;
  }

  public static void edit(ArrayList<Celojums> data){
    return;
  }

  public static void print(ArrayList<Celojums> data){
    System.out.println("------------------------------------------------------------");
    System.out.println("ID  City                 Date         Days     Price Vehicle");
    System.out.println("------------------------------------------------------------");
    for(Celojums cel: data){
      System.out.printf("%-4d%-21s%-11s%6d%10.2f %-8s%n", cel.id, cel.city, cel.date, cel.duration, cel.price, cel.transport);
    }
    System.out.println("------------------------------------------------------------");
    return;
  }

  public static void sort(ArrayList<Celojums> data){
    return;
  }

  public static void find(ArrayList<Celojums> data){
    return;
  }

  public static void avg(ArrayList<Celojums> data){
    return;
  }

  public static void exit(ArrayList<Celojums> data){
    try{
    FileWriter fileWriter = new FileWriter(filename);
    PrintWriter printWriter = new PrintWriter(fileWriter);
    for(Celojums cel: data){
      printWriter.printf("%d;%s;%s;%d;%.2f;%s%n", cel.id, cel.city, cel.date, cel.duration, cel.price, cel.transport);
    }
    printWriter.close();
    } catch(Exception e) {
      System.out.println(e);
    }
    return;
  }
}
