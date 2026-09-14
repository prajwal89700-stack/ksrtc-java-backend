import java.util.Scanner;
public class KSRTCApp {
    public static BusRoute findBus(BusRoute[] fleet, String targetStart, String targetDest) {
        for (int i = 0; i < fleet.length; i++) {
            if (fleet[i].getStartCity().equals(targetStart) && fleet[i].getDestinationCity().equals(targetDest)) {
                return fleet[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BusRoute b1 = new BusRoute("Harihar", "Bengaluru", 10, 50, 500);
        BusRoute b2 = new BusRoute("Bengaluru", "Davanagere", 38, 40, 480);
        BusRoute b3 = new BusRoute("Davangere", "Bengaluru", 15, 30, 480);
        BusRoute b4 = new BusRoute("Bengaluru", "Harihar", 15, 30, 500);
        BusRoute[] ksrtcFleet = new BusRoute[4];
        ksrtcFleet[0] = b1;
        ksrtcFleet[1] = b2;
        ksrtcFleet[2] = b3;
        ksrtcFleet[3] = b4;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Type 'book' to buy tickets, 'cancel' to return tickets, or 'exit' to quit:");
            String command = input.nextLine();
            if(command.equalsIgnoreCase("exit")){
                System.out.println("Bye");
                break;
            }
            System.out.println("Enter Start City: ");
            String userStartCity = input.nextLine();
            System.out.println("Enter Destination City: ");
            String userDestinationCity = input.nextLine();
            BusRoute myBus = findBus(ksrtcFleet, userStartCity, userDestinationCity);
            if (myBus != null) {
                if (command.equalsIgnoreCase("book")) {
                    System.out.println("How many tickets do you want to book?");
                    int userSeats = input.nextInt();
                    myBus.bookSeats(userSeats);
                    input.nextLine();
                } else if (command.equalsIgnoreCase("cancel")) {
                    System.out.println("How many tickets do you want to cancel?");
                    int userSeats = input.nextInt();
                    myBus.cancelSeat(userSeats);
                    input.nextLine();
                }else {
                    System.out.println("Invalid command. Please try again.");
                }
            } else {
                System.out.println("FAILURE: Route does not exist. Please check your cities.");
            }
        }
    }
}