package MakeMyTrip;
import java.util.*;

class Seat {
    private String seatId;
    private String seatType; // e.g., Economy, Business
    private String customerId; // Null if not occupied

    public Seat(String seatId, String seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.customerId = null;
    }

    public String getSeatId() { return seatId; }
    public String getSeatType() { return seatType; }
    public String getCustomerId() { return customerId; }

    public boolean isAvailable() {
        return customerId == null;
    }

    public void assignToCustomer(String customerId) {
        if (isAvailable()) {
            this.customerId = customerId;
        } else {
            throw new IllegalStateException("Seat is already occupied.");
        }
    }
}

class Flight {
    private String flightId;
    private String source;
    private String destination;
    private Date departureTime;
    private Date arrivalTime;
    private double price;
    private Map<String, Seat> seats; // Map of seatId -> Seat

    public Flight(String flightId, String source, String destination, Date departureTime, Date arrivalTime, double price, int seatCount) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;

        seats = new HashMap<>();
        for (int i = 1; i <= seatCount; i++) {
            String seatType = i <= seatCount / 2 ? "Economy" : "Business";
            String seatId = "Seat-" + i;
            seats.put(seatId, new Seat(seatId, seatType));
        }
    }

    public String getFlightId() { return flightId; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public Date getDepartureTime() { return departureTime; }

    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        for (Seat seat : seats.values()) {
            if (seat.isAvailable()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    public Seat assignSeatToCustomer(String seatId, String customerId) {
        Seat seat = seats.get(seatId);
        if (seat != null && seat.isAvailable()) {
            seat.assignToCustomer(customerId);
            return seat;
        } else {
            throw new IllegalArgumentException("Seat is either unavailable or does not exist.");
        }
    }
}

class User {
    private String userId;
    private String name;
    private List<Booking> bookings = new ArrayList<>();

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public void addBooking(Booking booking) { bookings.add(booking); }
    public List<Booking> getBookings() { return bookings; }
    public String getName() { return name; }
    public String getUserId() { return userId; }
}

class Booking {
    private String bookingId;
    private Flight flight;
    private User user;
    private Seat seat;

    public Booking(String bookingId, Flight flight, User user, Seat seat) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.user = user;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking: " + bookingId + ", Flight: " + flight.getFlightId() +
                ", User: " + user.getName() + ", Seat: " + seat.getSeatId() +
                " (" + seat.getSeatType() + ")";
    }
}

class FlightService {
    private static FlightService instance; // Singleton instance
    private List<Flight> flights = new ArrayList<>();

    private FlightService() {}

    public static FlightService getInstance() {
        if (instance == null) {
            instance = new FlightService();
        }
        return instance;
    }

    public void addFlight(Flight flight) { flights.add(flight); }

    public List<Flight> searchFlights(String source, String destination, Date date) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getSource().equals(source) &&
                flight.getDestination().equals(destination) &&
                isSameDay(flight.getDepartureTime(), date)) {
                result.add(flight);
            }
        }
        return result;
    }

    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}

public class MakeMyTrip {
    public static void main(String[] args) {
        FlightService flightService = FlightService.getInstance(); // Singleton access

        // Example Flights
        Flight flight1 = new Flight("F001", "Pune", "Delhi", new Date(2025, 1, 2, 10, 0), new Date(2025, 1, 2, 12, 0), 5000.0, 6);
        flightService.addFlight(flight1);

        // User
        User user = new User("U001", "Atharva");

        // Search Flights
        Date searchDate = new Date(2025, 1, 2); // Search for a specific date
        List<Flight> availableFlights = flightService.searchFlights("Pune", "Delhi", searchDate);

        if (!availableFlights.isEmpty()) {
            Flight selectedFlight = availableFlights.get(0);
            List<Seat> availableSeats = selectedFlight.getAvailableSeats();

            if (!availableSeats.isEmpty()) {
                Seat seatToBook = availableSeats.get(0); // Book the first available seat
                selectedFlight.assignSeatToCustomer(seatToBook.getSeatId(), user.getUserId());

                Booking booking = new Booking("B001", selectedFlight, user, seatToBook);
                user.addBooking(booking);
                System.out.println("Booking successful: " + booking);
            } else {
                System.out.println("No seats available on the selected flight.");
            }
        } else {
            System.out.println("No flights available on the selected date.");
        }
    }
}
