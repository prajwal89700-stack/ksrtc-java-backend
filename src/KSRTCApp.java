import java.util.Scanner;
import java.util.ArrayList;
public class KSRTCApp {
    public static BusRoute findBus(ArrayList<BusRoute> fleet, String targetStart, String targetDest) {
        for (int i = 0; i < fleet.size(); i++) {
            if (fleet.get(i).getStartCity().equals(targetStart) && fleet.get(i).getDestinationCity().equals(targetDest)) {
                return fleet.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BusRoute b1 = new BusRoute("Harihar", "Bengaluru", 10, 50, 500);
        BusRoute b2 = new BusRoute("Bengaluru", "Davanagere", 38, 40, 480);
        BusRoute b3 = new BusRoute("Davangere", "Bengaluru", 15, 30, 480);
        BusRoute b4 = new BusRoute("Bengaluru", "Harihar", 15, 30, 500);
        ArrayList<BusRoute> ksrtcFleet = new ArrayList<>();
        ksrtcFleet.add(b1);
        ksrtcFleet.add(b2);
        ksrtcFleet.add(b3);
        ksrtcFleet.add(b4);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Type 'book', 'cancel', 'admin' to add a route, or 'exit' to quit:");
            String command = input.nextLine();
            if(command.equalsIgnoreCase("exit")){
                System.out.println("Bye");
                break;
            }else if(command.equalsIgnoreCase("admin")) {
                System.out.println("Enter start city");
                String startCity = input.nextLine();
                System.out.println("Enter destination city");
                String destinationCity = input.nextLine();
                System.out.println("How many seats you would like to add?");
                int numberOfSeats = input.nextInt();
                System.out.println("Ticket Price: ");
                int ticketPrice = input.nextInt();
                input.nextLine();

                BusRoute newBus = new BusRoute(startCity, destinationCity, numberOfSeats, numberOfSeats, ticketPrice);
                ksrtcFleet.add(newBus);
                System.out.println("SUCCESS: New bus added to the fleet!");
            }else if(command.equalsIgnoreCase("book") || command.equalsIgnoreCase("cancel")){
                System.out.println("Enter start city");
                String startCity = input.nextLine();
                System.out.println("Enter destination city");
                String destinationCity = input.nextLine();
                BusRoute myBus = findBus(ksrtcFleet, startCity, destinationCity);

                if(myBus !=null){
                    if(command.equalsIgnoreCase("book")) {
                        System.out.println("How many tickets do you want to book?");
                        int numberOfTickets = input.nextInt();
                        myBus.bookSeats(numberOfTickets);
                        input.nextLine();
                    }else if(command.equalsIgnoreCase("cancel")){
                        System.out.println("How many tickets do you want to cancel?");
                        int numberOfTickets = input.nextInt();
                        myBus.cancelSeat(numberOfTickets);
                        input.nextLine();
                    }
                } else {
                    System.out.println("FAILURE: Route does not exist. Please check your cities.");
                }
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}