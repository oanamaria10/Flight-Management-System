import model.*;
import services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

import static sun.util.locale.LocaleUtils.isEmpty;

public class Menu {
    private static Menu instance;
    Menu() {}

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void displayOptions() {
        System.out.println("\nAirline Ticket Reservation System");
        System.out.println("Welcome! Choose an option:");
        System.out.println("1. I am an administrator");
        System.out.println("2. I am a new user");
        System.out.println("3. I am an existing user");
        System.out.println("4. Exit");
    }

    public void displayOptionsAdministrator() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Create airport table");
        System.out.println("2. Add an airport");
        System.out.println("3. Get an airport by location");
        System.out.println("4. Get all airports");
        System.out.println("5. Remove an airport");
        System.out.println("6. Update airport name");
        System.out.println("7. Create airline table");
        System.out.println("8. Add an airline");
        System.out.println("9. Get an airline by name");
        System.out.println("10. Get all airlines");
        System.out.println("11. Remove an airline");
        System.out.println("12. Update economy seats");
        System.out.println("13. Update business seats");
        System.out.println("14. Update economy price");
        System.out.println("15. Update business price");
        System.out.println("16. Create flight table");
        System.out.println("17. Add a flight");
        System.out.println("18. Remove a flight");
        System.out.println("19. Update flight departure time");
        System.out.println("20. Update flight arrival time");
        System.out.println("21. Create passenger table");
        System.out.println("22. Back");
    }

    public void displayNewUser(){
        System.out.println("\nLet's create an account! Please provide your information here: ");
    }

    public void displayOptionsUser(){
        System.out.println("\nPlease select an option: ");
        System.out.println("1. Book a ticket");
        System.out.println("2. Upgrade a ticket");
        System.out.println("3. Remove a ticket");
        System.out.println("4. Confirm the reservation");
        System.out.println("5. Cancel the reservation");
        System.out.println("6. Display my reservation");
        System.out.println("7. Look up for flights");
        System.out.println("8. Edit my account data");
        System.out.println("9. View passengers");
        System.out.println("10. Back");
    }

    public void displayEditUser(){
        System.out.println("\nPlease select an option: ");
        System.out.println("1. Update name");
        System.out.println("2. Update passport");
        System.out.println("3. Back");
    }

    // Metodă pentru interacțiunea cu utilizatorul și gestionarea opțiunilor
    public void interact() {
        Scanner scanner = new Scanner(System.in);
        FlightServices flightServices = new FlightServices();
        AirlineServices airlineServices = new AirlineServices();
        AirportServices airportServices = new AirportServices();
        PassengerServices passengerServices = new PassengerServices();
        while (true) {
            displayOptions();
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayOptionsAdministrator();
                    int choice1 = scanner.nextInt();
                    switch (choice1){
                        case 1:
                            airportServices.createAirportTable();
                            scanner.nextLine();
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice11 = scanner.nextLine();
                            if (choice11.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 2:
                            System.out.println("Airport Name: ");
                            Scanner airportName = new Scanner(System.in);
                            System.out.println("Airport Location: ");
                            Scanner airportLocation = new Scanner(System.in);
                            airportServices.addAirport(airportName.toString(), airportLocation.toString());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice12 = scanner.nextLine();
                            if (choice12.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 3:
                            System.out.println("Provide your desired location: ");
                            Scanner airportLocation2 = new Scanner(System.in);
                            List<Airport> airports = airportServices.getAirportsbyLocation(airportLocation2.toString());
                            for(Airport a : airports){
                                System.out.println(a);
                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice13 = scanner.nextLine();
                            if (choice13.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 4:
                            List<Airport> allAirports =airportServices.getAllAirports();
                            for(Airport a : allAirports){
                                System.out.println(a);
                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice14 = scanner.nextLine();
                            if (choice14.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 5:
                            System.out.println("Airport Id: ");
                            Scanner airportId = new Scanner(System.in);
                            airportServices.deleteAirport(airportId.nextInt());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice15 = scanner.nextLine();
                            if (choice15.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 6:
                            System.out.println("Airport Name: ");
                            Scanner airportNameUpdated = new Scanner(System.in);
                            System.out.println("Airport Id: ");
                            Scanner airportIdUpdated = new Scanner(System.in);
                            airportServices.updateAirportName(airportNameUpdated.toString(),airportIdUpdated.nextInt());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice16 = scanner.nextLine();
                            if (choice16.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 7:
                            airlineServices.createAirlineTable();
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice17 = scanner.nextLine();
                            if (choice17.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 8:
                            System.out.println("Airline Name: ");
                            Scanner airlineName = new Scanner(System.in);
                            System.out.println("Number of economy seats:");
                            Scanner economySeats = new Scanner(System.in);
                            System.out.println("Number of business seats:");
                            Scanner businessSeats = new Scanner(System.in);
                            System.out.println("Economy ticket price:");
                            Scanner economyPrice = new Scanner(System.in);
                            System.out.println("Business ticket price:");
                            Scanner businessPrice = new Scanner(System.in);
                            airlineServices.addAirline(airlineName.toString(), economySeats.nextInt(), businessSeats.nextInt(), economyPrice.nextDouble(), businessPrice.nextDouble());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice18 = scanner.nextLine();
                            if (choice18.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 9:
                            System.out.println("Airline Name: ");
                            Scanner getAirline = new Scanner(System.in);
                            Airline airline = airlineServices.getAirlineByName(getAirline.toString());
                            System.out.println(airline);
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice19 = scanner.nextLine();
                            if (choice19.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 10:
                            List<Airline> airlines = airlineServices.getAllAirlines();
                            for(Airline air : airlines){
                                System.out.println(air);
                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice110 = scanner.nextLine();
                            if (choice110.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 11:
                            System.out.println("Airline Id: ");
                            Scanner airlineId = new Scanner(System.in);
                            airlineServices.deleteAirline(airlineId.nextInt());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice111 = scanner.nextLine();
                            if (choice111.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 12:
                            System.out.println("Airline Id: ");
                            Scanner airlineIdUpdated = new Scanner(System.in);
                            System.out.println("Update economy seats number: ");
                            Scanner economySeatsUpdated = new Scanner(System.in);
                            airlineServices.updateEconomySeats(economySeatsUpdated.nextInt(), airlineIdUpdated.nextInt());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice112 = scanner.nextLine();
                            if (choice112.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 13:
                            System.out.println("Airline Id: ");
                            Scanner airlineIdUpdated2 = new Scanner(System.in);
                            System.out.println("Update business seats number: ");
                            Scanner businessSeatsUpdated = new Scanner(System.in);
                            airlineServices.updateBusinessSeats(businessSeatsUpdated.nextInt(), airlineIdUpdated2.nextInt());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice113 = scanner.nextLine();
                            if (choice113.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 14:
                            System.out.println("Airline Id: ");
                            Scanner airlineIdUpdated3 = new Scanner(System.in);
                            System.out.println("Update economy ticket price: ");
                            Scanner economyPriceUpdated = new Scanner(System.in);
                            airlineServices.updateEconomyPrice(economyPriceUpdated.nextDouble(), airlineIdUpdated3.nextInt());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice114 = scanner.nextLine();
                            if (choice114.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 15:
                            System.out.println("Airline Id: ");
                            Scanner airlineIdUpdated4 = new Scanner(System.in);
                            System.out.println("Update economy ticket price: ");
                            Scanner businessPriceUpdated = new Scanner(System.in);
                            airlineServices.updateEconomyPrice(businessPriceUpdated.nextDouble(), airlineIdUpdated4.nextInt());
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice115 = scanner.nextLine();
                            if (choice115.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 16:
                            // create flight table
                            flightServices.createFlightTable();
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice116 = scanner.nextLine();
                            if (choice116.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 17:
                            // add a flight
                            System.out.println("Departure airport ID: ");
                            Scanner departFlightId = new Scanner(System.in);
                            System.out.println("Arrival airport ID: ");
                            Scanner arrFlightId = new Scanner(System.in);
                            System.out.println("Airline id: ");
                            Scanner airFlightId = new Scanner(System.in);
                            System.out.println("Departure time: ");
                            Scanner departTime = new Scanner(System.in);
                            System.out.println("Arrival time: ");
                            Scanner arrivalTime = new Scanner(System.in);
                            flightServices.addFlight(departFlightId.nextInt(), arrFlightId.nextInt(), airFlightId.nextInt(), LocalDateTime.parse(departTime.toString()), LocalDateTime.parse(arrivalTime.toString()));
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice117 = scanner.nextLine();
                            if (choice117.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 18:
                            // remove a flight
                            System.out.println("Flight id: ");
                            int flightId = scanner.nextInt();
                            flightServices.removeFlight(flightId);
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice118 = scanner.nextLine();
                            if (choice118.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 19:
                            // Update flight departure time
                            System.out.println("Flight id: ");
                            int flightIdUpd = scanner.nextInt();
                            System.out.println("Update departure time: ");
                            LocalDateTime departureTime  = LocalDateTime.parse(scanner.nextLine());
                            flightServices.updateFlightDepartureTime(departureTime,flightIdUpd);
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice119 = scanner.nextLine();
                            if (choice119.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 20:
                            // Update flight arrival time
                            System.out.println("Flight id: ");
                            int flightIdUpd2 = scanner.nextInt();
                            System.out.println("Update arrival time: ");
                            LocalDateTime arrivalTimeUpd  = LocalDateTime.parse(scanner.nextLine());
                            flightServices.updateFlightDepartureTime(arrivalTimeUpd,flightIdUpd2);
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice120 = scanner.nextLine();
                            if (choice120.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 21:
                            // create passenger table
                            passengerServices.createPassengerTable();
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice121 = scanner.nextLine();
                            if (choice121.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                return;
                            }
                            else {
                                break;
                            }
                        case 22:
                            // intoarcere in meniul principal
                            displayOptions();
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 2:
                    displayNewUser();
                    try {
                        scanner.nextLine();
                        System.out.println("Your full name: ");
                        String fullName = scanner.nextLine();
                        System.out.println("Date of Birth (yyyy-mm-dd):");
                        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
                        System.out.println("Passport:");
                        String passport = scanner.nextLine();
                        passengerServices.addPassenger(fullName, dateOfBirth, passport);
                    }
                    catch (Exception e){
                        System.out.println("Your information cannot be null");
                        continue;
                    }
                    System.out.println("Do you want to go back? [yes/no]");
                    String choice2 = scanner.nextLine();
                    if (choice2.equalsIgnoreCase("no")) {
                        System.out.println("Exiting...");
                        return;
                    }
                    else {
                        break;
                    }
                case 3:
                    System.out.println("Introduce your id: ");
                    int id = scanner.nextInt();
                    Passenger passenger = passengerServices.getPassenger(id);
                    Reservation reservation = new Reservation(passenger);
                    displayOptionsUser();
                    int choice3 = scanner.nextInt();
                    switch (choice3) {
                        case 1:
                            // Book a ticket
                            System.out.println("Choose an option:");
                            System.out.println("1. Economy Ticket");
                            System.out.println("2. Business Ticket");
                            int choice311 = scanner.nextInt();
                            switch (choice311){
                                case 1:
                                    System.out.println("Flight id:");
                                    int eTicket = scanner.nextInt();
                                    Ticket ticket = new EconomyTicket(eTicket,reservation.getClient());
                                    reservation.addTicket(ticket);
                                    break;
                                case 2:
                                    System.out.println("Flight id:");
                                    int bTicket = scanner.nextInt();
                                    Ticket ticket2 = new BusinessTicket(bTicket,reservation.getClient());
                                    reservation.addTicket(ticket2);
                                    break;
                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice31 = scanner.nextLine();
                            if (choice31.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;

                            }
                        case 2:
                            // upgrade a ticket
                            System.out.println("What ticket do you want to upgrade?");
                            System.out.println("Flight id: ");
                            int flightUpg = scanner.nextInt();
                            System.out.println("Passenger id:");
                            int passId = scanner.nextInt();
                            Passenger passengerUpg = passengerServices.getPassenger(passId);
                            Ticket ticketUpg = new EconomyTicket(flightUpg, passengerUpg);
                            reservation.upgradeTicket(ticketUpg);
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice32 = scanner.nextLine();
                            if (choice32.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;

                            }
                        case 3:
                            // remove a ticket
                            System.out.println("What ticket do you want to remove?");
                            System.out.println("Choose an option");
                            System.out.println("1. Economy ticket");
                            System.out.println("2. Business ticket");
                            int choicetick = scanner.nextInt();
                            switch (choicetick){
                                case 1:
                                    System.out.println("Flight id: ");
                                    int flightRem = scanner.nextInt();
                                    System.out.println("Passenger id:");
                                    int passIdRem = scanner.nextInt();
                                    Passenger passengerRem = passengerServices.getPassenger(passIdRem);
                                    Ticket ticketRem = new EconomyTicket(flightRem, passengerRem);
                                    reservation.removeTicket(ticketRem);
                                    break;
                                case 2:
                                    System.out.println("Flight id: ");
                                    int flightRem2 = scanner.nextInt();
                                    System.out.println("Passenger id:");
                                    int passIdRem2 = scanner.nextInt();
                                    Passenger passengerRem2 = passengerServices.getPassenger(passIdRem2);
                                    Ticket ticketRem2 = new BusinessTicket(flightRem2, passengerRem2);
                                    reservation.removeTicket(ticketRem2);
                                    break;
                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice33 = scanner.nextLine();
                            if (choice33.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;

                            }
                        case 4:
                            LocalDate curDate = LocalDate.now();
                            Period age = Period.between(reservation.getClient().getDateOfBirth(), curDate);
                            if(age.getYears() < 18){
                                System.out.println("You cannot make a reservation");
                            }
                            else {
                                reservation.confirmReservation();
                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice34 = scanner.nextLine();
                            if (choice34.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            reservation.cancelReservation();
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice35 = scanner.nextLine();
                            if (choice35.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            reservation.displayReservationDetails();
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice36 = scanner.nextLine();
                            if (choice36.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            // look for a flight
                            System.out.println("Choose an option");
                            System.out.println("1. Look for a specific flight");
                            System.out.println("2. Display all flights");
                            int choicefl = scanner.nextInt();
                            switch (choicefl){
                                case 1:
                                    System.out.println("Departure Location: ");
                                    String departLoc = scanner.nextLine();
                                    System.out.println("Arrival Location: ");
                                    String arrivalLoc = scanner.nextLine();
                                    System.out.println("Departure time:");
                                    LocalDate departTime = LocalDate.parse(scanner.nextLine());
                                    if(departLoc != null && arrivalLoc != null && !isEmpty(departTime.toString())) {
                                        List<Flight> flights = flightServices.getFlightsByLocationAndDateTime(departLoc, arrivalLoc, departTime);
                                        for(Flight f : flights){
                                            System.out.println(f);
                                        }
                                    } else if(departLoc != null && arrivalLoc != null){
                                        List<Flight> flights = flightServices.getFlightsByLocation(departLoc, arrivalLoc);
                                        for(Flight f : flights){
                                            System.out.println(f);
                                        }
                                    } else if (!isEmpty(departTime.toString())) {
                                        List<Flight> flights = flightServices.getFlightsByDateTime(departTime);
                                        for(Flight f : flights){
                                            System.out.println(f);
                                        }
                                    } else if (departLoc!= null) {
                                        List<Flight> flights = flightServices.getFlightsByDepartureLocation(departLoc);
                                        for (Flight f : flights) {
                                            System.out.println(f);
                                        }
                                    } else if (arrivalLoc!=null) {
                                        List<Flight> flights = flightServices.getFlightsByArrivalLocation(arrivalLoc);
                                        for(Flight f : flights){
                                            System.out.println(f);
                                        }

                                    }
                                    break;
                                case 2:
                                    List<Flight> flights = flightServices.getFlights();
                                    for(Flight f : flights){
                                        System.out.println(f);
                                    }
                                    break;
                            }
                        case 8:
                            displayEditUser();
                            int choice337 = scanner.nextInt();
                            switch (choice337){
                                case 1:
                                    System.out.println("Passenger id: ");
                                    int idPass = scanner.nextInt();
                                    System.out.println("Update Name: ");
                                    String namePass = scanner.nextLine();
                                    passengerServices.updatePassengerName(namePass,idPass);
                                    System.out.println("Do you want to go back? [yes/no]");
                                    String choice3371 = scanner.nextLine();
                                    if (choice3371.equalsIgnoreCase("no")) {
                                        System.out.println("Exiting...");
                                        break;
                                    } else {
                                        break;

                                    }
                                case 2:
                                    System.out.println("Passenger id: ");
                                    int idPass2 = scanner.nextInt();
                                    System.out.println("Update Passport: ");
                                    String passportPass = scanner.nextLine();
                                    passengerServices.updatePassengerPassport(passportPass,idPass2);
                                    System.out.println("Do you want to go back? [yes/no]");
                                    String choice3372 = scanner.nextLine();
                                    if (choice3372.equalsIgnoreCase("no")) {
                                        System.out.println("Exiting...");
                                        break;
                                    } else {
                                        break;

                                    }
                                case 3:
                                    break;


                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice38 = scanner.nextLine();
                            if (choice38.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;

                            }
                        case 9:
                            // afisare date utilizatori
                            List<Passenger> passengers = passengerServices.getAllPassengers();
                            for( Passenger p : passengers){
                                System.out.println(p);
                            }
                            System.out.println("Do you want to go back? [yes/no]");
                            String choice39 = scanner.nextLine();
                            if (choice39.equalsIgnoreCase("no")) {
                                System.out.println("Exiting...");
                                break;
                            } else {
                                break;

                            }

                        case 10:
                            // intoarcere in meniul principal
                            displayOptions();
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                case 4:
                    // Ieșire din aplicație
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

