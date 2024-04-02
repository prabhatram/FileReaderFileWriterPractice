import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        
        String inputPath = "/Users/pram/Downloads/Groceries.txt";
        String outputPath = "/Users/pram/Downloads/GroceriesFormatted.txt";

        String [] array = new String[4];
        String s = "";
        String delimiter = ",";

        int id;
        String item;
        String qty;
        double price;
        double total = 0;
        String heading;
        String line;

        try{
            
            FileReader fileReader = new FileReader(inputPath);
            FileWriter fileWriter = new FileWriter(outputPath);

            BufferedReader reader = new BufferedReader(fileReader);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            
            s = reader.readLine();
            heading = "ID#" + "\t" + "Item" + "\t\t" + "Quantity" + "\t" + "Price (€)" + ".";
            System.out.println(heading);
            writer.write("****************************************************");
            writer.newLine();
            writer.write(heading);
            writer.newLine();


            while(s != null){
                array = s.split(delimiter);
                id = Integer.parseInt(array[0]);
                item = array[1];
                qty = array[2];
                price = Double.parseDouble(array[3]);

                total += price;

                line = id + "\t" + item + "\t\t" + qty + "\t\t" + price + ".";
                
                System.out.println(line);
                
                writer.write(line);
                writer.newLine();
                s = reader.readLine();
            }
            reader.close();
            writer.write("****************************************************");
            writer.newLine();
            writer.write("The grocery shopping total is: €" + Math.round(total));
            writer.newLine();
            System.out.println("The grocery shopping total is: €" + Math.round(total));
            writer.write("****************************************************");
            
            writer.flush();
            writer.close();
            
            
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        
    }
}

/* import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
 */
/* public class Main {
    public static void main(String[] args) throws Exception {
        

        String [] array = new String[4];
        String id;
        String itemName;
        String quantity;
        double price;
        //String temp = "";
        String separator = ",";
        double total = 0;


        String filePathForWindows = "C:\\Program Files\\Groceries.txt"; // Use this only if you have a Windows machine

        
        String filePathForMac = "/Users/pram/Downloads/Groceries.txt";
        String fileToWrite = "/Users/pram/Downloads/ABC.txt";

        FileReader fileReader = new FileReader(filePathForMac);
        FileWriter fileWriter = new FileWriter(fileToWrite);
        
        BufferedReader reader = new BufferedReader(fileReader);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String line;

        while((line = reader.readLine()) != null){
            
            array = line.split(separator);

            price = Double.parseDouble(array[3]); // For integer, Integer.parseInt(array[3])

            total += price;
            
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }

        System.out.println("\n" + "Total price of groceries: " + Math.round(total));
        writer.write("\n" + "Total price of groceries: " + Math.round(total));



        reader.close();

        writer.flush();
        writer.close();

    } 
}*/
