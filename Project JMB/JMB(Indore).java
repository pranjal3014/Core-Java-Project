import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javafx.beans.binding.When;
class Thali{
    String[] Thalis = {"Thali A", "Thali B", "Thali C", "Thali D", "Thali E", "Thali F"};
    String[] ThalisP = {"Rs. 310/-", "Rs. 360/-", "Rs. 410/-", "Rs. 480/-", "Rs. 600/-", "Rs. 700/-"};
    
    // Menu options for customization
    String[] soupOptions = {"Tomato Soup", "Veg Mancho", "Hot & Sour Soup", "Lemon Coriander"};
    String[] welcomeDrinkOptions = {"Blue Lagoon", "Orange Pink City", "Blowgun Kesher Pista", "Jaljeera" , "Strawberry Delight","Fresh Lime Water","Butter Milk" , "Rasna Water"};
    String[] vegetableOptions = {"Nav Ratan Korma","Lahori Aloo with Mutter","Mix Veg","Green Chana (Seasonal)","Corn Palak","Aloo 65","Aloo Mutter","Aloo Capsicum","Aloo Do Pyaza","Aloo Gobhi/Tomato","Gobhi Mutter","Kadi Punjabi","Veg. Kofta (Gol)","Methi Mutter Malai","Haryali Kofta","Chana Masala","Bhindi Masala","Jeera Aloo","Dum Aloo","Gujrati Aloo","Tinda Masala","Aloo Palak","Seasonal Veg.","Bhindi Do Pyaza","Veg. Kohlapuri","Corn Capsicum"};
    String[] dalOptions = {"Dal Tadka", "Dal Makhani", "Dal Fry", "Panchmel Dal"};
    String[] riceOptions = {"Steamed Rice", "Jeera Rice", "Pulao", "Fried Rice","Green Peas Pulao"};
    String[] breadOptions = {"Roti", "Butter Naan", "Tandoori Roti", "Laccha Paratha", "Butter Paratha", "Kulcha"};
    String[] starterOptions = {"Paneer Tikka", "Veg Manchurian", "Spring Roll", "Chilli Potato"};
    String[] sweetDishOptions = {"Gulab Jamun", "Rasgulla", "Ice Cream", "Rasmalai"};
    String[] saladOptions = {"Green Salad", "Fruit Salad", "Kachumber"};
    String[] papadOptions = {"Plain Papad", "Masala Papad", "Fried Papad"};
    String[] pickleOptions = {"Mango Pickle", "Mixed Pickle", "Lemon Pickle"};
    String[] snacksOption = {"Idli/Vada Shambhar","Pav Bhaji","Chhola Kulcha","Methi Paratha","Stuffed Paratha","Muli Paratha","Noodles","Chhole Bhatura","Chhola Poori","Paratha with Dahi (Limited)","Aloo Paratha","Gobhi Paratha"};           
    String[] curdOptions = {"Plain Curd", "Raita", "Boondi Raita"};
    String[] menuA = {"1 Poha","1 Jalebi","1 Bread Item","1 Tea or Coffee"};
    String[] menuB = {"1 Poha","1 Jalebi","1 Bread Item","1 Heavy Snacks","1 Tea or Coffee"};
    String[] menuC = {"1 Poha","1 Jalebi","1 Bread Item","2 Heavy Snacks","1 Tea or Coffee"};
}

class Billing{
    private double total = 0;
    private double firstTotal = 0;
    private double concation = 0;
    private double gst = 0;
    private double grandTotal = 0;
    private int noOfPeople;
    private int afterFunctionPeople;
    private double bestprice;
    private int extraPeople;
    private double maxTotal;
    public static final String RESET = "\u001B[0m";

    public static final String BLACK = "\u001B[30m";
    public static final String WHITE = "\u001B[37m";

    public static final String RED_BG = "\u001B[48;5;52m";
    public static final String GREEN_BG = "\u001B[48;5;52m";
    public static final String YELLOW_BG = "\u001B[48;5;52m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String PURPLE_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String MAROON = "\u001B[48;5;52m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    Billing(double bestprice, int noOfPeople,int afterFunctionPeople){
        this.bestprice = bestprice;
        this.noOfPeople = noOfPeople;
        this.afterFunctionPeople = afterFunctionPeople;
    }

    void cal(){
        total = bestprice * afterFunctionPeople;
        firstTotal = bestprice * noOfPeople;
        if(noOfPeople>=afterFunctionPeople){
            gst = (firstTotal * 0.18);
            grandTotal = (firstTotal + gst);
        }
        else{
            extraPeople = afterFunctionPeople - noOfPeople;
            concation = (firstTotal * 0.10);
            extraPeople = (int)(extraPeople - (noOfPeople * 0.10));
            maxTotal = total - concation;
            gst = maxTotal * 0.18;
            grandTotal = maxTotal + gst;
        }
    }

    void display(String name, String date,long number) {
    System.out.println();

    // Top Border
    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
    System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");

    // Customer Details
    System.out.printf(MAROON + WHITE + "   %-20s : %-49s" + RESET + "%n", "Name", name);
    System.out.printf(MAROON + WHITE + "   %-20s : %-49s" + RESET + "%n", "Contact Number: ", number);
    System.out.printf(MAROON + WHITE + "   %-20s : %-49s" + RESET + "%n", "Booking Date", date);

    // Separator
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");

    // Bill Details
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-30s : %-39s" + RESET + "%n", "Thali", bestprice);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-30s : %-39s" + RESET + "%n", "Number of People", noOfPeople);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-30s : %-39s" + RESET + "%n", "After Function People", afterFunctionPeople);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-30s : %-39s" + RESET + "%n", "Extra People after concation", extraPeople);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-30s : %-39s" + RESET + "%n", "Bill", (noOfPeople>=afterFunctionPeople)?firstTotal:maxTotal);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-30s : %-39s" + RESET + "%n", "GST(18%)", gst);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
    System.out.printf(MAROON + WHITE + "   %-30s : %-39s" + RESET + "%n", "Total Bill", grandTotal);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");

    // Bottom Border
    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
}

}

class JMB {
    public static final String RESET = "\u001B[0m";

    public static final String BLACK = "\u001B[30m";
    public static final String WHITE = "\u001B[37m";

    public static final String RED_BG = "\u001B[48;5;52m";
    public static final String GREEN_BG = "\u001B[48;5;52m";
    public static final String YELLOW_BG = "\u001B[48;5;52m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String PURPLE_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String MAROON = "\u001B[48;5;52m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";


    //lunch content print
    static void printLunch(String text){
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", text);
    }

    //heading print
    static void printHeading(String text){
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
    System.out.printf(WHITE + YELLOW_BG + "   %-72s" + RESET + "%n", text);
    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
    }    

    // Custom method for integer input validation
    static int getIntInRange(Scanner sc, int min, int max) {
        int num;
        while (true) {
            System.out.println();
            System.out.println("Enter your choice (" + min + " to " + max + "): "+ RESET+"\n");
            if (sc.hasNextInt()) {  
                num = sc.nextInt();
                if (num >= min && num <= max) {
                    return num; 
                } else {
                    System.out.println(RED+"\nInvalid input! Please try again."+RESET);
                }
            } else {
                printHeading("Please enter a valid number!");
                sc.next(); 
            }
        }
    }
    
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        //for price
        double bestprice = 0;
        
            //CUSTOMER NAME VALIDATION
            String name;
            while (true) {
                System.out.println(WHITE_BACKGROUND+BLACK+"\nEnter Customer Name :                                                      "+RESET);
                name = sc.nextLine();
            
                if (name.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println(RED+"Invalid Name! Enter Correct Name !!!"+RESET);
                }
            }

            //CONTACT NUMBER VALIDATION
            long number;
            while (true) {
                System.out.println(WHITE_BACKGROUND+BLACK+"\nEnter Customer Contact Number :                                            "+RESET);
                String numStr = sc.nextLine();
            
                if (numStr.matches("[6789][0-9]{9}")) {
                    number = Long.parseLong(numStr);
                    break;
                } else {
                    System.out.println(RED+"Invalid Number! 10 digit are required as well as number start from 6,7,8,9"+RESET);
                }
            }

            //BOOKING DATE VALIDATION 
            String date;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            while (true) {
                System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Booking Date (dd-mm-yyyy)::                                       "+RESET);
                date = sc.nextLine();
            
                if (date.matches("\\d{2}-\\d{2}-\\d{4}")) {
                    try {
                        LocalDate bookingDate = LocalDate.parse(date, formatter);
                        LocalDate today = LocalDate.now();
                    
                        if (bookingDate.isBefore(today)) {
                            System.out.println(RED + "Invalid Date! Date cannot be in the past." + RESET);
                        } else {
                            break; 
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println(RED + "Invalid Date Format! Please use dd-mm-yyyy." + RESET);
                    }
                } else {
                    System.out.println(RED + "Invalid Date! Hint: Enter Format dd-mm-yyyy" + RESET);
                }
            }
            // people count
        System.out.println(WHITE_BACKGROUND+BLACK+"\nHow many people are coming?(Max. 500) :                                    "+RESET);
        int noOfPeople = getIntInRange(sc, 1, 500);

        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println(CYAN_BG + BLACK+"=============================Enter Your Choice============================="+RESET);
        System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(RED_BG + WHITE + "             1. LUNCH                 " + RESET + YELLOW_BG + WHITE + "             2. BREAKFAST            "+RESET);
        System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(WHITE_BACKGROUND+BLACK+"1. LUNCH                                                                   "+RESET);
        System.out.println(WHITE_BACKGROUND+BLACK+"2. BREAKFAST                                                               "+RESET);
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int firstChoice = getIntInRange(sc, 1, 2); 

        switch(firstChoice){
        case 1:
        System.out.println(RED_BG + WHITE+"                                                                           "+RESET);
        System.out.println(RED_BG + WHITE+"                                                                           "+RESET);
        System.out.println(RED_BG + WHITE+"                             VEGETARIAN MENU                               "+RESET);
        System.out.println(RED_BG + WHITE+"                                                                           "+RESET);
        System.out.println(RED_BG + WHITE+"                                                                           "+RESET);

        //Lunch
        printHeading("A) Thali - Rs. 310/-");
        printLunch("Soup/Welcome Drink");
        printLunch("Vegetable Dish");
        printLunch("Dal");
        printLunch("Rice");
        printLunch("Roti/Naan/Paratha");
        printLunch("Pickle, Salad, Papad");
        printLunch("Sweet Dish");

        printHeading("B) Thali - Rs. 360/-");
        printLunch("Soup/Welcome Drink");
        printLunch("Paneer Dish");
        printLunch("Vegetable Dish");
        printLunch("Dal, Rice");
        printLunch("Roti/Naan/Paratha");
        printLunch("Pickle, Salad, Papad");
        printLunch("Sweet Dish / Ice-cream");

        printHeading("C) Thali - Rs. 410/-");
        printLunch("Soup/Welcome Drink");
        printLunch("Starter");
        printLunch("Paneer Dish");
        printLunch("Vegetable Dish");
        printLunch("Curd Dish");
        printLunch("Dal, Rice");
        printLunch("Roti/Naan/Paratha");
        printLunch("Sweet Dish, Ice-cream");

        printHeading("D) Thali - Rs. 470/-");
        printLunch("Soup/Welcome Drink");
        printLunch("Starter");
        printLunch("Paneer Dish");
        printLunch("Vegetable Dish");
        printLunch("Curd Dish");
        printLunch("Dal, Rice");
        printLunch("Roti/Naan/Paratha");
        printLunch("Sweet Dish, Ice-cream / Coffee");

        printHeading("E) Thali - Rs. 600/-");
        printLunch("Soup/Welcome Drink");
        printLunch("1 Starter, 1 Paneer Starter");
        printLunch("1 Pasta (Any Type)");
        printLunch("Paneer Dish, Vegetable Dish");
        printLunch("Dal, Rice");
        printLunch("Roti/Naan/Paratha");
        printLunch("Curd Dish");
        printLunch("Sweet Dish, Ice-cream");

        printHeading("F) Thali - Rs. 700/-");
        printLunch("Soup/Welcome Drink");
        printLunch("2 Starters");
        printLunch("Same Item + 2 Paneer Dish");
        printLunch("Vegetable Dish + Curd Dish");
        printLunch("Dal, Rice");
        printLunch("Roti/Naan/Paratha");
        printLunch("2 Sweet Dishes, Ice-cream");
        System.out.printf(WHITE_BACKGROUND + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        
    
        //Thali Choice
        char thaliChoice;
        do {
            System.out.println();
            System.out.println(WHITE_BACKGROUND + BLACK + "Enter Thali Choice : " + RESET);
            thaliChoice = sc.next().toLowerCase().charAt(0);

            if (!(thaliChoice >= 'a' && thaliChoice <= 'f')) {
                System.out.println(RED + "Invalid input! Please enter only letters (A-F)." + RESET);
            }
        } while (!(thaliChoice >= 'a' && thaliChoice <= 'f'));

        switch(thaliChoice){
            case 'a' : 
            bestprice = 310;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("A) Thali - Rs. 310/-");
                printLunch("Soup/Welcome Drink");
                printLunch("Vegetable Dish");
                printLunch("Dal");
                printLunch("Rice");
                printLunch("Roti/Naan/Paratha");
                printLunch("Pickle, Salad, Papad");
                printLunch("Sweet Dish");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;
                
                case 'b':
                bestprice = 360;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("B) Thali - Rs. 360/-");
                printLunch("Soup/Welcome Drink");
                printLunch("Paneer Dish");
                printLunch("Vegetable Dish");
                printLunch("Dal, Rice");
                printLunch("Roti/Naan/Paratha");
                printLunch("Pickle, Salad, Papad");
                printLunch("Sweet Dish / Ice-cream");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;
                
                case 'c':  
                bestprice = 410;  
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("C) Thali - Rs. 410/-");
                printLunch("Soup/Welcome Drink");
                printLunch("Starter");
                printLunch("Paneer Dish");
                printLunch("Vegetable Dish");
                printLunch("Curd Dish");
                printLunch("Dal, Rice");
                printLunch("Roti/Naan/Paratha");
                printLunch("Sweet Dish, Ice-cream");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;
                
                case 'd':
                bestprice = 470;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("D) Thali - Rs. 470/-");
                printLunch("Soup/Welcome Drink");
                printLunch("Starter");
                printLunch("Paneer Dish");
                printLunch("Vegetable Dish");
                printLunch("Curd Dish");
                printLunch("Dal, Rice");
                printLunch("Roti/Naan/Paratha");
                printLunch("Sweet Dish, Ice-cream / Coffee");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;
                
                case 'e':
                bestprice = 600;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("E) Thali - Rs. 600/-");
                printLunch("Soup/Welcome Drink");
                printLunch("1 Starter, 1 Paneer Starter");
                printLunch("1 Pasta (Any Type)");
                printLunch("Paneer Dish, Vegetable Dish");
                printLunch("Dal, Rice");
                printLunch("Roti/Naan/Paratha");
                printLunch("Curd Dish");
                printLunch("Sweet Dish, Ice-cream");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;
                
                case 'f':
                bestprice = 700;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("F) Thali - Rs. 700/-");
                printLunch("Soup/Welcome Drink");
                printLunch("2 Starters");
                printLunch("Same Item + 2 Paneer Dish");
                printLunch("Vegetable Dish + Curd Dish");
                printLunch("Dal, Rice");
                printLunch("Roti/Naan/Paratha");
                printLunch("2 Sweet Dishes, Ice-cream");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;

            }

            //Thali Object Creation
            Thali thaliObj = new Thali();

            String fcustomizeThali[] = new String[14];
            String customizeThali[] = new String[12]; 
            String printCustomize[] = new String[12];
            String fprintCustomize[] = new String[14];

            
            //second choice
            System.out.println("\n");    
            System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(RED_BG + WHITE + "            1. Soup               " + RESET + YELLOW_BG + WHITE + "             2. Welcome Drink            "+RESET);
            System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(WHITE_BACKGROUND+BLACK+"1. Soup                                                                    "+RESET);
            System.out.println(WHITE_BACKGROUND+BLACK+"2. Welcome Drink                                                           "+RESET);
            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
            int secondChoice = getIntInRange(sc, 1, 2); 

            //print customize thali menu
            printCustomize[0] = (secondChoice == 1)?"Soup" : "Welcome Drink";  
            printCustomize[1] = "Starter";
            printCustomize[2] = "1st Vegetable";
            printCustomize[3] = "2nd Vegetable";
            printCustomize[4] = "Curd Dish";
            printCustomize[5] = "Dal";
            printCustomize[6] = "Rice";
            printCustomize[7] = "Break";
            printCustomize[8] = "Pickel";
            printCustomize[9] = "Salad";
            printCustomize[10] = "Papad";
            printCustomize[11] = "Sweet Dish";

            //print for f thali #Customize Thali
            fprintCustomize[0] = (secondChoice == 1)?"Soup" : "Welcome Drink";
            fprintCustomize[1] = "1st Starter";
            fprintCustomize[2] = "2nd Starter";
            fprintCustomize[3] = "1st Vegetable";
            fprintCustomize[4] = "2nd Vegetable";
            fprintCustomize[5] = "Curd Dish";
            fprintCustomize[6] = "Dal";
            fprintCustomize[7] = "Rice";
            fprintCustomize[8] = "Break";
            fprintCustomize[9] = "Pickel";
            fprintCustomize[10] = "Salad";
            fprintCustomize[11] = "Papad";
            fprintCustomize[12] = "1st Sweet Dish";
            fprintCustomize[13] = "2nd Sweet Dish";

        //second choice selection
        //select soup | welcome drink
        switch(secondChoice){
            case 1:
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-28s%s%36s" + RESET + "%n", "", "Select Soup", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.soupOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.soupOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int soupChoice = getIntInRange(sc, 1, 4);

        customizeThali[0] = thaliObj.soupOptions[soupChoice-1];
        fcustomizeThali[0] = thaliObj.soupOptions[soupChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.soupOptions[soupChoice-1]+"......"+RESET);
        break;

        case 2:
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-25s%s%30s" + RESET + "%n", "", "Select Welcome Drink", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.welcomeDrinkOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.welcomeDrinkOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int welcomeDrinkChoice =getIntInRange(sc, 1, 8);

        customizeThali[0] = thaliObj.welcomeDrinkOptions[welcomeDrinkChoice-1];
        fcustomizeThali[0] = thaliObj.welcomeDrinkOptions[welcomeDrinkChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.welcomeDrinkOptions[welcomeDrinkChoice-1]+"....."+RESET);
        break;
    }


    //third choice selection
    //select starter
    if(thaliChoice == 'f'){
        //starter for f thali
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-27s%s%34s" + RESET + "%n", "", "Select Starter", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.starterOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.starterOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 1st Starter Choice :                                            "+RESET);
        int firststarterChoice = getIntInRange(sc, 1,4);
        fcustomizeThali[1] = thaliObj.starterOptions[firststarterChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.starterOptions[firststarterChoice-1]+"......"+RESET);
        //second strater
        while(true){
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 2nd Starter Choice :                                           "+RESET);
        int secondStarterChoice = getIntInRange(sc, 1,4);
        fcustomizeThali[2] = thaliObj.starterOptions[secondStarterChoice-1];

        //compare starter 1 and 2
        if(fcustomizeThali[1] == fcustomizeThali[2]){
            System.out.println();
            System.out.println(RED+"You already selected this Starter***"+RESET);
            System.out.println("Choose another Starter...\n");
            continue;
            }
            else
            {
              System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.starterOptions[secondStarterChoice-1]+"......"+RESET);
              break;   
            }
        }
    }
    else{
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-27s%s%34s" + RESET + "%n", "", "Select Starter", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.starterOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.starterOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int starterChoice = getIntInRange(sc, 1, 4);
        customizeThali[1] = thaliObj.starterOptions[starterChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.starterOptions[starterChoice-1]+"......"+RESET);
    }

    //fourth choice selection
    // first vegetable choice
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-27s%s%31s" + RESET + "%n", "", "Select Vegetables", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.vegetableOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.vegetableOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 1st Vegetable Choice :                                          "+RESET);
        int firstVegetableChoice = getIntInRange(sc, 1, 26);
        customizeThali[2] = thaliObj.vegetableOptions[firstVegetableChoice-1];
        fcustomizeThali[3] = thaliObj.vegetableOptions[firstVegetableChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.vegetableOptions[firstVegetableChoice-1]+"......"+RESET);

        //second vegetable choice
        int count = 0;
        do{
        count =0;
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 2nd Vegetable Choice :                                          "+RESET);
        int secondVegetableChoice = getIntInRange(sc, 1, 26);
        customizeThali[3] = thaliObj.vegetableOptions[secondVegetableChoice-1];
        fcustomizeThali[4] = thaliObj.vegetableOptions[secondVegetableChoice-1];

        //compare vegetable 1 and 2
        if(customizeThali[2] == customizeThali[3] || fcustomizeThali[3] == fcustomizeThali[4]){
            System.out.println();
            System.out.println(RED+"You already selected this vegetable***"+RESET);
            System.out.println("Choose another vegetable...\n");
            count++;
        }
        else{
            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.vegetableOptions[secondVegetableChoice-1]+"......"+RESET);
        }
    }while(count>0);

    //fifth choice selection
    //select curd dish
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-27s%s%32s" + RESET + "%n", "", "Select Curd Dish", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.curdOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.curdOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int curdDishChoice = getIntInRange(sc, 1,3);
        customizeThali[4] = thaliObj.curdOptions[curdDishChoice-1];
        fcustomizeThali[5] = thaliObj.curdOptions[curdDishChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.curdOptions[curdDishChoice-1]+"......"+RESET); 

    //sixth choice selection
    //select dal
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-30s%s%35s" + RESET + "%n", "", "Select Dal", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.dalOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.dalOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int dalChoice = getIntInRange(sc, 1, 4);
        customizeThali[5] = thaliObj.dalOptions[dalChoice-1];
        fcustomizeThali[6] = thaliObj.dalOptions[dalChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.dalOptions[dalChoice-1]+"......"+RESET); 

    //seventh choice selection
    //select rice
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-29s%s%35s" + RESET + "%n", "", "Select Rice", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.riceOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.riceOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int riceChoice = getIntInRange(sc, 1, 5);
        customizeThali[6] = thaliObj.riceOptions[riceChoice-1];
        fcustomizeThali[7] = thaliObj.riceOptions[riceChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.riceOptions[riceChoice-1]+"......"+RESET);

    //eighth choice selection
    //select roti
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-29s%s%34s" + RESET + "%n", "", "Select Bread", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.breadOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.breadOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int breadChoice = getIntInRange(sc, 1, 6);
        customizeThali[7] = thaliObj.breadOptions[breadChoice-1];
        fcustomizeThali[8] = thaliObj.breadOptions[breadChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.breadOptions[breadChoice-1]+"......"+RESET);

    //ningth choice selection
    //pickel selection
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-29s%s%33s" + RESET + "%n", "", "Select Pickel", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.pickleOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.pickleOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int pickelChoice = getIntInRange(sc, 1, 3);
        customizeThali[8] = thaliObj.pickleOptions[pickelChoice-1];
        fcustomizeThali[9] = thaliObj.pickleOptions[pickelChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.pickleOptions[pickelChoice-1]+"......"+RESET);

    //tenth choice selection
    //salad selection
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-29s%s%34s" + RESET + "%n", "", "Select Salad", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.saladOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.saladOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int saladChoice = getIntInRange(sc, 1, 3);
        customizeThali[9] = thaliObj.saladOptions[saladChoice-1];
        fcustomizeThali[10] = thaliObj.saladOptions[saladChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.saladOptions[saladChoice-1]+"......"+RESET);

    //eleventh choice selection
    //select papad
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-29s%s%34s" + RESET + "%n", "", "Select Papad", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.papadOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.papadOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int papadChoice = getIntInRange(sc, 1, 3);
        customizeThali[10] = thaliObj.papadOptions[papadChoice-1];
        fcustomizeThali[11] = thaliObj.papadOptions[papadChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.papadOptions[papadChoice-1]+"......"+RESET);

    //twelfth choice selection
    //sweet dish 
    if(thaliChoice == 'f'){
        //first sweet dish for f thali
        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-28s%s%30s" + RESET + "%n", "", "Select Sweet Dish", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj.sweetDishOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.sweetDishOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 1st Sweet Dish Choice :                                          "+RESET);
        int firstsweetDishChoice = getIntInRange(sc, 1, 4);
        fcustomizeThali[12] = thaliObj.sweetDishOptions[firstsweetDishChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.sweetDishOptions[firstsweetDishChoice-1]+"......"+RESET);

        //second sweet dish

        while(true){
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 2nd Sweet Dish Choice :                                         "+RESET);
        int secondSweetDishChoice = getIntInRange(sc, 1, 4);
        fcustomizeThali[13] = thaliObj.sweetDishOptions[secondSweetDishChoice-1];

        //compare vegetable 1 and 2
        if(fcustomizeThali[12].equals(fcustomizeThali[13])){
            System.out.println();
            System.out.println(RED+"You already selected this Sweet Dish***"+RESET);
            System.out.println("Choose another Sweet Dish...\n");
            continue;
        }
        else{
            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.sweetDishOptions[secondSweetDishChoice-1]+"......"+RESET);
            break;
        }
        }
        }
        else{
            System.out.println();
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + WHITE + "%-28s%s%30s" + RESET + "%n", "", "Select Sweet Dish", "");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            for(int i = 0; i<thaliObj.sweetDishOptions.length; i++){
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj.sweetDishOptions[i]);     
            }
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.println();
            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
            int sweetDishChoice = getIntInRange(sc, 1, 4);
            customizeThali[11] = thaliObj.sweetDishOptions[sweetDishChoice-1];
            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj.sweetDishOptions[sweetDishChoice-1]+"......"+RESET);
        }

        //coustomize Thali
        if(thaliChoice == 'f'){
            System.out.println();
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + WHITE + "%-29s%s%31s" + RESET + "%n", "", "Customize Thali", "");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            int n =(thaliChoice == 'f')?fcustomizeThali.length : customizeThali.length;
            for(int i = 0; i<n; i++){
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+((thaliChoice == 'f')?fprintCustomize[i] : printCustomize[i])+" - "+fcustomizeThali[i]);     
            }
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        }
        else{
            System.out.println();
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + WHITE + "%-29s%s%31s" + RESET + "%n", "", "Customize Thali", "");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            int n =(thaliChoice == 'f')?fcustomizeThali.length : customizeThali.length;
            for(int i = 0; i<n; i++){
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+((thaliChoice == 'f')?fprintCustomize[i] : printCustomize[i])+"  -  "+customizeThali[i]);     
            }
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        }
           break;

        case 2:
        // Breakfast Menu

        System.out.println();
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println(CYAN_BG + BLACK+"=============================Enter Your Choice============================="+RESET);
        System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(RED_BG + WHITE + "           1. BREAKFAST               " + RESET + YELLOW_BG + WHITE + "    2. BREAKFAST (ONLY FOR LADIES)   "+RESET);
        System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
        System.out.println(WHITE_BACKGROUND+BLACK+"1. BREAKFAST                                                               "+RESET);
        System.out.println(WHITE_BACKGROUND+BLACK+"2. BREAKFAST (ONLY FOR LADIES)                                             "+RESET);
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int breakChoice = getIntInRange(sc, 1, 2); 

        switch(breakChoice){

        case 1:
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);
        System.out.println(GREEN_BG + WHITE+"                             BREAKFAST MENU                                "+RESET);
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);

        printHeading("A) Breakfast 1 Rs. 250/-");
        printLunch("Soup/Welcome Drink");
        printLunch("Starter");
        printLunch("Snacks");
        printLunch("Poha");
        printLunch("Jalebi");
        printLunch("Sweet Dish");
        printLunch("Tea/Coffee");

        printHeading("B) Breakfast 2 Rs. 300/-");
        printLunch("Soup/Welcome Drink");
        printLunch("Starter");
        printLunch("2 Snacks");
        printLunch("Poha");
        printLunch("Jalebi");
        printLunch("Sweet Dish");
        printLunch("Tea/Coffee");

        printHeading("C) Breakfast 3 Rs. 350/-");
        printLunch("Soup/Welcome Drink");
        printLunch("Starter");
        printLunch("2 Snacks");
        printLunch("Poha");
        printLunch("Jalebi");
        printLunch("Sweet Dish");
        printLunch("Tea or Ice Cream");
        System.out.printf(WHITE_BACKGROUND + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");

        //Breakfast Thali Choice
        char bthaliChoice;
        do {
            System.out.println();
            System.out.println(WHITE_BACKGROUND + BLACK + "Enter Thali Choice (only 1 character): " + RESET);
            String input = sc.next().toLowerCase();
        
            if (input.length() == 1) {   
                bthaliChoice = input.charAt(0);
            
                if (bthaliChoice >= 'a' && bthaliChoice <= 'c') {
                    break;
                } else {
                    System.out.println(RED + "\nInvalid input! Please enter only letters (A-Z)." + RESET);
                }
            } else {
                System.out.println(RED + "\nInvalid input! Please enter only ONE character." + RESET);
            }
        } while (true);


        switch(bthaliChoice){
            case 'a':
            bestprice = 250;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("A) Breakfast 1 Rs. 250/-");
                printLunch("Soup/Welcome Drink");
                printLunch("Starter");
                printLunch("Snacks");
                printLunch("Poha");
                printLunch("Jalebi");
                printLunch("Sweet Dish");
                printLunch("Tea/Coffee");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;

            case 'b':
            bestprice = 300;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("B) Breakfast 2 Rs. 300/-");
                printLunch("Soup/Welcome Drink");
                printLunch("Starter");
                printLunch("2 Snacks");
                printLunch("Poha");
                printLunch("Jalebi");
                printLunch("Sweet Dish");
                printLunch("Tea/Coffee");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;

            case 'c' :
            bestprice = 350;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("C) Breakfast 3 Rs. 350/-");
                printLunch("Soup/Welcome Drink");
                printLunch("Starter");
                printLunch("2 Snacks");
                printLunch("Poha");
                printLunch("Jalebi");
                printLunch("Sweet Dish");
                printLunch("Tea or Ice Cream");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                break;

        }

            String aPrintCustomizeThali[] = new String[7];
            String bPrintCustomizeThali[] = new String[8];
            String cPrintCustomizeThali[] = new String[8];
            String bCustomizeThali[] = new String[8];
            Thali thaliObj1 = new Thali(); 


            //breakfast second choice
            System.out.println("\n");    
            System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(RED_BG + WHITE+"                                      " + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(RED_BG + WHITE + "            1. Soup               " + RESET + YELLOW_BG + WHITE + "             2. Welcome Drink            "+RESET);
            System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(RED_BG + WHITE+"                                      "  + RESET + YELLOW_BG + BLACK + "                                     "+RESET);
            System.out.println(WHITE_BACKGROUND+BLACK+"1. Soup                                                                    "+RESET);
            System.out.println(WHITE_BACKGROUND+BLACK+"2. Welcome Drink                                                           "+RESET);
            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
            int bsecondChoice = getIntInRange(sc, 1, 2); 

            //print customize breakfast thali A
             aPrintCustomizeThali[0] = (bsecondChoice == 1)?"Soup" : "Welcome Drink";
             aPrintCustomizeThali[1] = "Starter";
             aPrintCustomizeThali[2] = "Snacks";
             aPrintCustomizeThali[3] = "First dish";
             aPrintCustomizeThali[4] = "Second dish";
             aPrintCustomizeThali[5] = "Sweet Dish";
             aPrintCustomizeThali[6] = "Drink";

             //print customize breakfast thali B
             bPrintCustomizeThali[0] = (bsecondChoice == 1)?"Soup" : "Welcome Drink";
             bPrintCustomizeThali[1] = "Starter";
             bPrintCustomizeThali[2] = "1st Snacks";
             bPrintCustomizeThali[3] = "2nd Snacks";
             bPrintCustomizeThali[4] = "First dish";
             bPrintCustomizeThali[5] = "Second dish";
             bPrintCustomizeThali[6] = "Sweet Dish";
             bPrintCustomizeThali[7] = "Drink";

             //print customize breakfast thali c
             cPrintCustomizeThali[0] = (bsecondChoice == 1)?"Soup" : "Welcome Drink";
             cPrintCustomizeThali[1] = "Starter";
             cPrintCustomizeThali[2] = "1st Snacks";
             cPrintCustomizeThali[3] = "2nd Snacks";
             cPrintCustomizeThali[4] = "First dish";
             cPrintCustomizeThali[5] = "Second dish";
             cPrintCustomizeThali[6] = "Sweet Dish";
             cPrintCustomizeThali[7] = "Ice cream / Drink";

            //for breakfast data entry
            switch(bthaliChoice){
                case 'a':
                bCustomizeThali[3] = "Poha";
                bCustomizeThali[4] = "Jalebi";
                bCustomizeThali[6] = "Tea/Coffee";
                    switch(bsecondChoice){
                        case 1:
                            System.out.println();
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + WHITE + "%-28s%s%36s" + RESET + "%n", "", "Select Soup", "");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            for(int i = 0; i<thaliObj1.soupOptions.length; i++){
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.soupOptions[i]);     
                            }
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.println();
                            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                            int soupChoice = getIntInRange(sc, 1, 4);
                        
                            bCustomizeThali[0] = thaliObj1.soupOptions[soupChoice-1];
                            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.soupOptions[soupChoice-1]+"......"+RESET);
                            break;

                            case 2:
                                System.out.println();
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + WHITE + "%-25s%s%30s" + RESET + "%n", "", "Select Welcome Drink", "");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                                for(int i = 0; i<thaliObj1.welcomeDrinkOptions.length; i++){
                                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.welcomeDrinkOptions[i]);     
                                }
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.println();
                                System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                                int welcomeDrinkChoice = getIntInRange(sc, 1, 8);
                            
                                bCustomizeThali[0] = thaliObj1.welcomeDrinkOptions[welcomeDrinkChoice-1];
                                System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.welcomeDrinkOptions[welcomeDrinkChoice-1]+"....."+RESET);
                                break;
                    }
                    
                    //starter choice for breakfast
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-27s%s%34s" + RESET + "%n", "", "Select Starter", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj1.starterOptions.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.starterOptions[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                    int starterChoice = getIntInRange(sc, 1, 4);
                    bCustomizeThali[1] = thaliObj1.starterOptions[starterChoice-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.starterOptions[starterChoice-1]+"......"+RESET);
             
                    //snack choice for breakfast
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-27s%s%34s" + RESET + "%n", "", "Select Snacks ", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj1.snacksOption.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.snacksOption[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                    int snackChoice = getIntInRange(sc, 1, 12);
                    bCustomizeThali[2] = thaliObj1.snacksOption[snackChoice-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.snacksOption[snackChoice-1]+"......"+RESET);


                    //sweet dish option for breakfast
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-28s%s%30s" + RESET + "%n", "", "Select Sweet Dish", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj1.sweetDishOptions.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.sweetDishOptions[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                    int sweetDishChoice = getIntInRange(sc, 1, 4);
                    bCustomizeThali[5] = thaliObj1.sweetDishOptions[sweetDishChoice-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.sweetDishOptions[sweetDishChoice-1]+"......"+RESET);
        
                    break;

                case 'b':
                bCustomizeThali[4] = "Poha";
                bCustomizeThali[5] = "Jalebi";
                bCustomizeThali[7] = "Tea and Ice Cream";
                    switch(bsecondChoice){
                        //soup | welcome drink
                        case 1:
                            System.out.println();
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + WHITE + "%-28s%s%36s" + RESET + "%n", "", "Select Soup", "");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            for(int i = 0; i<thaliObj1.soupOptions.length; i++){
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.soupOptions[i]);     
                            }
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.println();
                            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                            int soupChoice = getIntInRange(sc, 1, 4);
                        
                            bCustomizeThali[0] = thaliObj1.soupOptions[soupChoice-1];
                            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.soupOptions[soupChoice-1]+"......"+RESET);
                            break;

                            case 2:
                                System.out.println();
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + WHITE + "%-25s%s%30s" + RESET + "%n", "", "Select Welcome Drink", "");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                                for(int i = 0; i<thaliObj1.welcomeDrinkOptions.length; i++){
                                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.welcomeDrinkOptions[i]);     
                                }
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.println();
                                System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                                int welcomeDrinkChoice = getIntInRange(sc, 1, 8);
                            
                                bCustomizeThali[0] = thaliObj1.welcomeDrinkOptions[welcomeDrinkChoice-1];
                                System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.welcomeDrinkOptions[welcomeDrinkChoice-1]+"....."+RESET);
                                break;
                                }
                            
                            //Strater choice for breakFast
                            System.out.println();
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + WHITE + "%-27s%s%34s" + RESET + "%n", "", "Select Starter", "");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            for(int i = 0; i<thaliObj1.starterOptions.length; i++){
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.starterOptions[i]);     
                            }
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.println();
                            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                            int starterChoice2 = getIntInRange(sc, 1, 4);
                            bCustomizeThali[1] = thaliObj1.starterOptions[starterChoice2-1];
                            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.starterOptions[starterChoice2-1]+"......"+RESET);
                            
                            //scnaks for breakfast
                            System.out.println();
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + WHITE + "%-30s%s%32s" + RESET + "%n", "", "Select Snacks", "");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            for(int i = 0; i<thaliObj1.snacksOption.length; i++){
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.snacksOption[i]);     
                            }
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.println();
                            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 1st Snacks Choice :                                              "+RESET);
                            int firstsnackChoice = getIntInRange(sc, 1, 12);
                            bCustomizeThali[1] = thaliObj1.snacksOption[firstsnackChoice-1];
                            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.snacksOption[firstsnackChoice-1]+"......"+RESET);
                        
                            //second snacks
                        
                            while(true){
                            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 2nd Snacks Choice :                                              "+RESET);
                            int secondSnack3Choice = getIntInRange(sc, 1, 12);
                            bCustomizeThali[2] = thaliObj1.snacksOption[secondSnack3Choice-1];
                            
                            //compare snacks 1 and 2
                            if(bCustomizeThali[1].equals(bCustomizeThali[2])){
                                System.out.println();
                                System.out.println(RED+"You already selected this Snacks***"+RESET);
                                System.out.println("Choose another Snacks...\n");
                                continue;
                            }
                            else{
                                System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.snacksOption[secondSnack3Choice-1]+"......"+RESET);
                                bCustomizeThali[2] = thaliObj1.snacksOption[secondSnack3Choice-1];
                                break;
                            }
                            }
                             
                            //sweet dish option for breakfast
                            System.out.println();
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + WHITE + "%-28s%s%30s" + RESET + "%n", "", "Select Sweet Dish", "");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            for(int i = 0; i<thaliObj1.sweetDishOptions.length; i++){
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.sweetDishOptions[i]);     
                            }
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.println();
                            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                            int sweetDish2Choice = getIntInRange(sc, 1, 4);
                            bCustomizeThali[6] = thaliObj1.sweetDishOptions[sweetDish2Choice-1];
                            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.sweetDishOptions[sweetDish2Choice-1]+"......"+RESET);
                        
                            break;
                
                case 'c' :
                bCustomizeThali[4] = "Poha";
                bCustomizeThali[5] = "Jalebi";
                bCustomizeThali[7] = "Tea and Ice Cream";
                    switch(bsecondChoice){
                        //soup | welcome drink
                        case 1:
                            System.out.println();
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + WHITE + "%-28s%s%36s" + RESET + "%n", "", "Select Soup", "");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            for(int i = 0; i<thaliObj1.soupOptions.length; i++){
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.soupOptions[i]);     
                            }
                            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                            System.out.println();
                            System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                            int soupChoice = getIntInRange(sc, 1, 4);
                        
                            bCustomizeThali[0] = thaliObj1.soupOptions[soupChoice-1];
                            System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.soupOptions[soupChoice-1]+"......"+RESET);
                            break;

                            case 2:
                                System.out.println();
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + WHITE + "%-25s%s%30s" + RESET + "%n", "", "Select Welcome Drink", "");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                                for(int i = 0; i<thaliObj1.welcomeDrinkOptions.length; i++){
                                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.welcomeDrinkOptions[i]);     
                                }
                                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                                System.out.println();
                                System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                                int welcomeDrinkChoice = getIntInRange(sc, 1, 8);
                            
                                bCustomizeThali[0] = thaliObj1.welcomeDrinkOptions[welcomeDrinkChoice-1];
                                System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.welcomeDrinkOptions[welcomeDrinkChoice-1]+"....."+RESET);
                                break;
                    }
                    //Strater choice for breakFast
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-27s%s%34s" + RESET + "%n", "", "Select Starter", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj1.starterOptions.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.starterOptions[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                    int starterChoice1 = getIntInRange(sc, 1, 4);
                    bCustomizeThali[1] = thaliObj1.starterOptions[starterChoice1-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.starterOptions[starterChoice1-1]+"......"+RESET);


                    //scnaks for breakfast
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-30s%s%32s" + RESET + "%n", "", "Select Snacks", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj1.snacksOption.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.snacksOption[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 1st Snacks Choice :                                              "+RESET);
                    int firstsnack2Choice = getIntInRange(sc, 1, 12);
                    bCustomizeThali[2] = thaliObj1.snacksOption[firstsnack2Choice-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.snacksOption[firstsnack2Choice-1]+"......"+RESET);
                
                    //second snacks
                
                    while(true){
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 2nd Snacks Choice :                                             "+RESET);
                    int secondSnack2Choice =getIntInRange(sc, 1, 12);
                    bCustomizeThali[3] = thaliObj1.snacksOption[secondSnack2Choice-1];
                    
                    //compare snacks 1 and 2
                    if(bCustomizeThali[2].equals(bCustomizeThali[3])){
                        System.out.println();
                        System.out.println(RED+"You already selected this Snacks***"+RESET);
                        System.out.println("Choose another Snacks...\n");
                        continue;
                    }
                    else{
                        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.snacksOption[secondSnack2Choice-1]+"......"+RESET);
                        bCustomizeThali[2] = thaliObj1.snacksOption[secondSnack2Choice-1];
                        break;
                    }
                    }
                     
                    //sweet dish option for breakfast
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-28s%s%30s" + RESET + "%n", "", "Select Sweet Dish", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj1.sweetDishOptions.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj1.sweetDishOptions[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                    int sweetDish3Choice = getIntInRange(sc, 1, 4);
                    bCustomizeThali[6] = thaliObj1.sweetDishOptions[sweetDish3Choice-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj1.sweetDishOptions[sweetDish3Choice-1]+"......"+RESET);
        
                    break;
            }


            //customize thali for breakfast
             System.out.println();
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + WHITE + "%-29s%s%31s" + RESET + "%n", "", "Customize Thali", "");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            int n =0;
            if(bthaliChoice == 'a'){
                n = aPrintCustomizeThali.length;
            }
            else if(bthaliChoice == 'b'){
                n = bPrintCustomizeThali.length;
            }
            else if(bthaliChoice == 'c'){
                n = cPrintCustomizeThali.length;
            }
            for(int i = 0; i<n && i < bCustomizeThali.length; i++){
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",(i+1)+" "+((bthaliChoice == 'a')?aPrintCustomizeThali[i] :(bthaliChoice == 'b')? bPrintCustomizeThali[i] : cPrintCustomizeThali[i] )+"  -  "+bCustomizeThali[i]);     
            }
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        break;
        
        
        case 2:
        //Ladies Menu
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);
        System.out.println(GREEN_BG + WHITE+"                    BREAKFAST MENU (ONLY FOR LADIES)                       "+RESET);
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);
        System.out.println(GREEN_BG + WHITE+"                                                                           "+RESET);

    // Menu A (Rs. 200)    
    printHeading("A) Menu A (Rs. 200)");
    printLunch("1 Poha");           
    printLunch("1 Jalebi");         
    printLunch("1 Bread Item");     
    printLunch("1 Tea or Coffee");  


    // Menu B (Rs. 230)
    printHeading("B) Menu B (Rs. 230)");
    printLunch("1 Poha");           
    printLunch("1 Jalebi");         
    printLunch("1 Bread Item");     
    printLunch("1 Heavy Snaks");    
    printLunch("1 Tea or Coffee");  


    // Menu C (Rs. 250)
    printHeading("C) Menu C (Rs. 250)");
    printLunch("1 Poha");           
    printLunch("1 Jalebi");         
    printLunch("1 Bread Item");     
    printLunch("2 Heavy Snaks");    
    printLunch("1 Tea or Coffee");
    System.out.printf(WHITE_BACKGROUND + "   %-72s" + RESET + "%n", " ");
    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");  

    //breakfast for ladies 
    char bLadiesthaliChoice;
        do {
            System.out.println();
            System.out.println(WHITE_BACKGROUND + BLACK + "Enter Thali Choice (only 1 character): " + RESET);
            String input = sc.next().toLowerCase();
        
            if (input.length() == 1) {   
                bLadiesthaliChoice = input.charAt(0);
            
                if (bLadiesthaliChoice >= 'a' && bLadiesthaliChoice <= 'c') {
                    break;
                } else {
                    System.out.println(RED + "\nInvalid input! Please enter only letters (A-C)." + RESET);
                }
            } else {
                System.out.println(RED + "\nInvalid input! Please enter only ONE character." + RESET);
            }
        } while (true);

        switch(bLadiesthaliChoice){
            case 'a':
            bestprice = 200;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("A) Menu A (Rs. 200)");
                printLunch("1 Poha");           
                printLunch("1 Jalebi");         
                printLunch("1 Bread Item");     
                printLunch("1 Tea or Coffee");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            break;

            case 'b':
            bestprice = 230;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("B) Menu B (Rs. 230)");
                printLunch("1 Poha");           
                printLunch("1 Jalebi");         
                printLunch("1 Bread Item");     
                printLunch("1 Heavy Snaks");    
                printLunch("1 Tea or Coffee"); 
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " "); 
            break;

            case 'c':
            bestprice = 250;
                System.out.println();
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(MAROON + WHITE + "%-28s%s%28s" + RESET + "%n", "", "Jain Mithai Bhandar", "");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                printHeading("C) Menu C (Rs. 250)");
                printLunch("1 Poha");           
                printLunch("1 Jalebi");         
                printLunch("1 Bread Item");     
                printLunch("2 Heavy Snaks");    
                printLunch("1 Tea or Coffee");
                System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            break;

        }

        //print customize breakfast thali A
        Thali thaliObj3 = new Thali();
        String lcustomizeThali[] = new String[6];
        String lAPrintCustomizeThali[] = new String[4];
        String lBPrintCustomizeThali[] = new String[5];
        String lCPrintCustomizeThali[] = new String[6];

             lAPrintCustomizeThali[0] = "Poha";
             lAPrintCustomizeThali[1] = "Jalebi";
             lBPrintCustomizeThali[0] = "Poha";
             lBPrintCustomizeThali[1] = "Jalebi";
             lCPrintCustomizeThali[0] = "Poha";
             lCPrintCustomizeThali[1] = "Jalebi";
             lcustomizeThali[0] = "Poha";
             lcustomizeThali[1] = "Jalebi";
             

             //select roti
        System.out.println();
        lAPrintCustomizeThali[2] = "Bread";
        lBPrintCustomizeThali[2] = "Bread";
        lCPrintCustomizeThali[2] = "Bread";
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + WHITE + "%-29s%s%34s" + RESET + "%n", "", "Select Bread", "");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        for(int i = 0; i<thaliObj3.breadOptions.length; i++){
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj3.breadOptions[i]);     
        }
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        System.out.println();
        System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
        int lbreadChoice = getIntInRange(sc, 1, 6);
        lcustomizeThali[2] = thaliObj3.breadOptions[lbreadChoice-1];
        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj3.breadOptions[lbreadChoice-1]+"......"+RESET);

        switch(bLadiesthaliChoice){
            case 'a':
            lcustomizeThali[3] = "Tea or Coffee";
            lAPrintCustomizeThali[3] = "Tea/Coffee";
            break;

            case 'b':
            //snack choice for breakfast
                    lBPrintCustomizeThali[3] = "Heavy Snacks";
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-27s%s%34s" + RESET + "%n", "", "Select Snacks ", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj3.snacksOption.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj3.snacksOption[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your Choice :                                                        "+RESET);
                    int snackChoice = getIntInRange(sc, 1, 12);
                    lcustomizeThali[3] = thaliObj3.snacksOption[snackChoice-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj3.snacksOption[snackChoice-1]+"......"+RESET);

            //tea or coffee
            lcustomizeThali[4] = "Tea or Coffee";
            lBPrintCustomizeThali[4] = "Tea/Coffee";
            break;

            case 'c':
            //scnaks for breakfast
                    lCPrintCustomizeThali[3] = "1st Heavy Snacks";
                    lCPrintCustomizeThali[4] = "2nd Heavy Snacks";
                    System.out.println();
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + WHITE + "%-30s%s%32s" + RESET + "%n", "", "Select Snacks", "");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    for(int i = 0; i<thaliObj3.snacksOption.length; i++){
                        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",+(i+1)+" "+thaliObj3.snacksOption[i]);     
                    }
                    System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
                    System.out.println();
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 1st Snacks Choice :                                              "+RESET);
                    int firstsnack2Choice = getIntInRange(sc, 1, 12);
                    lcustomizeThali[3] = thaliObj3.snacksOption[firstsnack2Choice-1];
                    System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj3.snacksOption[firstsnack2Choice-1]+"......"+RESET);
                
                    //second snacks
                
                    while(true){
                    System.out.println(WHITE_BACKGROUND+BLACK+"Enter Your 2nd Snacks Choice :                                             "+RESET);
                    int secondSnack2Choice =getIntInRange(sc, 1, 12);
                    lcustomizeThali[4] = thaliObj3.snacksOption[secondSnack2Choice-1];
                    
                    //compare snacks 1 and 2
                    if(lcustomizeThali[3].equals(lcustomizeThali[4])){
                        System.out.println();
                        System.out.println(RED+"You already selected this Snacks***"+RESET);
                        System.out.println("Choose another Snacks...\n");
                        continue;
                    }
                    else{
                        System.out.println(GREEN+"WonderFull!!! You Selected "+thaliObj3.snacksOption[secondSnack2Choice-1]+"......"+RESET);
                        lcustomizeThali[4] = thaliObj3.snacksOption[secondSnack2Choice-1];
                        break;
                    }
                    }

                    //tea and coffee
                    lcustomizeThali[5] = "Tea or Coffee";
                    lCPrintCustomizeThali[5] = "Tea/Coffee";
            break;
        }

        //customize thali for ladies
         System.out.println();
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + WHITE + "%-29s%s%31s" + RESET + "%n", "", "Customize Thali", "");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            int n1 =0;
            if(bLadiesthaliChoice == 'a'){
                n1 = 4;
            }
            else if(bLadiesthaliChoice == 'b'){
                n1 = 5;
            }
            else if(bLadiesthaliChoice == 'c'){
                n1 = 6;
            }
            for(int i = 0; i<n1 && i < lcustomizeThali.length; i++){
                System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n",(i+1)+" "+((bLadiesthaliChoice == 'a')?lAPrintCustomizeThali[i] :(bLadiesthaliChoice == 'b')? lBPrintCustomizeThali[i] : lCPrintCustomizeThali[i] )+"  -  "+lcustomizeThali[i]);     
            }
            System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
            System.out.printf(MAROON + "   %-72s" + RESET + "%n", " ");
        break;
    }
}

    //outside body inside main class
        System.out.println();
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.printf(WHITE + YELLOW_BG + "   %-72s" + RESET + "%n", "After Function : ");
        System.out.printf(WHITE_BACKGROUND + ANSI_BLACK + "   %-72s" + RESET + "%n", " ");
        System.out.println(WHITE_BACKGROUND+BLACK+"How many people are come? :                                                "+RESET);
        int afterFunctionPeople = getIntInRange(sc, 1, 550);

        //bill object create
        Billing bill = new Billing(bestprice,noOfPeople,afterFunctionPeople);
        bill.cal();
        bill.display(name,date,number);

    }
}
