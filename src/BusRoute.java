public class BusRoute {
    private String startCity;
    private String destinationCity;
    private int availableSeats;
    private int maxCapacity;
    private int ticketPrice;
    public BusRoute(String startCity, String destinationCity, int availableSeats, int maxCapacity, int ticketPrice) {
        this.startCity = startCity;
        this.destinationCity = destinationCity;
        this.maxCapacity = maxCapacity;
        this.ticketPrice = ticketPrice;
        if (availableSeats < 0) {
            this.availableSeats = 0;
        } else {
            this.availableSeats = availableSeats;
        }
    }
    public void bookSeats(int requestedSeats) {
        if(requestedSeats > 0 && availableSeats >= requestedSeats) {
            this.availableSeats = availableSeats - requestedSeats;
            int totalBill = requestedSeats * ticketPrice;
            System.out.println("SUCCESS: " + requestedSeats + " ticket booked. Total Bill: Rs. " + totalBill + " Seats remaining: " + availableSeats);
        } else {
            System.out.println("FAILURE: Not enough seats available. Only " + availableSeats + " seats available.");
        }
    }
    public void cancelSeat(int cancelledSeats) {
        if (cancelledSeats > 0 && (availableSeats + cancelledSeats) <= maxCapacity) {
            this.availableSeats = availableSeats + cancelledSeats;
            System.out.println("Cancellation successful: " + cancelledSeats + " Seats remaining: " + availableSeats);
        } else {
            System.out.println("FAILURE: Invalid cancellation. Cannot exceed  maximum bus capacity.");
        }
    }
    public String getDestinationCity() {
        return this.destinationCity;
    }

    public String getStartCity() {
        return this.startCity;
    }

}