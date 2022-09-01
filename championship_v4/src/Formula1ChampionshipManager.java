import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Formula1ChampionshipManager implements ChampionshipManager {
    private ArrayList<Formula1Driver> formula1DriversList = new ArrayList<Formula1Driver>();

    public void addDriver(String name, String location, String team) {

        if (formula1DriversList.stream().filter(formula1Driver -> formula1Driver.getTeamName().equals(team))
                .count() > 0) {
            System.out.println("Team name is not unique, Driver already exists for the team : " + team + "\n");
        } else {
            formula1DriversList.add(new Formula1Driver(name, location, team));
            System.out.println("Driver :" + name + " Successfully added to the team : " + team + "\n");
        }
    }

    public void addDriver(Formula1Driver newDriver) {
        if (formula1DriversList.stream()
                .filter(formula1Driver -> formula1Driver.getTeamName().equals(newDriver.getTeamName())).count() > 0) {
            System.out.println(
                    "Team name is not unique, Driver already exists for the team : " + newDriver.getTeamName() + "\n");
        } else {
            formula1DriversList.add(newDriver);
            System.out.println("Driver :" + newDriver.getName() + " Successfully added to the team : "
                    + newDriver.getTeamName() + "\n");
        }
    }

    public void deleteDriver(String driverName) {
        formula1DriversList.removeIf(formula1Driver -> formula1Driver.getName().equals(driverName));
    }

    public void deleteDriver(Formula1Driver driverName) {
        formula1DriversList.removeIf(formula1Driver -> formula1Driver.getName().equals(driverName.getName()));
    }

    public void changeDriver(String newDriverName, String location, String teamName) {

        Formula1Driver newDriver = new Formula1Driver(newDriverName, location, teamName);

        formula1DriversList.set(formula1DriversList.indexOf(formula1DriversList.stream()
                .filter(formula1Driver -> formula1Driver.getTeamName().equals(teamName)).toList().get(0)), newDriver);
        System.out.println("Driver Updated Successfully");
    }

    public void changeDriver(Formula1Driver newDriver) {

        formula1DriversList.set(formula1DriversList.indexOf(formula1DriversList.stream()
                        .filter(formula1Driver -> formula1Driver.getTeamName().equals(newDriver.getTeamName())).toList()
                        .get(0)),
                newDriver);
        System.out.println("Driver Updated Successfully");

    }

    public void displayStats(String driverName) {
        Formula1Driver formula1Driver = formula1DriversList.stream()
                .filter(formula1Driver1 -> formula1Driver1.getName().equals(driverName)).findFirst().orElse(null);

        if (formula1Driver == null) {
            System.out.println("No driver with that name");
        } else {
            System.out.println("Driver : " + formula1Driver.getName());
            System.out.println("Team : " + formula1Driver.getTeamName());
            System.out.println("First place count : " + formula1Driver.getFirstPositions());
            System.out.println("Second place count : " + formula1Driver.getSecondPositions());
            System.out.println("Third place count : " + formula1Driver.getThirdPositions());
            System.out.println("Points count : " + formula1Driver.getPoints());
            System.out.println("Race count : " + formula1Driver.getRaceCount());
        }
    }

    public void displayChampionshipDetails() {
        formula1DriversList.sort(Comparator.comparing(Formula1Driver::getFirstPositions));
        formula1DriversList.sort(Comparator.comparing(Formula1Driver::getPoints));
        Collections.reverse(formula1DriversList);
        for (Formula1Driver dri : formula1DriversList) {
            System.out.println("********************");

            this.displayStats(dri.getName());
            System.out.println("--------------------");
        }

    }

    public void racecompleted(Map<String, String> positions) {
        System.out.println(positions);
        for (Map.Entry<String, String> entry : positions.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // System.out.println(key);
            // System.out.println(value);
            Formula1Driver enterNew = formula1DriversList.stream()
                    .filter(formula1Driver -> formula1Driver.getName().equals(key)).toList().get(0);
            enterNew.addPosition(value);
            enterNew.setRaceCount(enterNew.getRaceCount() + 1);
            formula1DriversList.set(formula1DriversList.indexOf(formula1DriversList.stream()
                            .filter(formula1Driver -> formula1Driver.getName().equals(key)).toList().get(0)),
                    enterNew);
        }

    }

    public void savedata() {
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            for (Formula1Driver d : formula1DriversList) {
                o.writeObject(d);
            }

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void readData() {
        try {

            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            Object obj = null;
            while ((obj = oi.readObject()) != null) {

                Formula1Driver pr2 = (Formula1Driver) obj;
                // System.out.println(pr2.getPoints());
                this.addDriver(pr2);
            }
            // Read objects

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void runProgramme() {
        boolean y = true;
        while (y) {
            System.out.println("Welcome to Formula 1 Championship\n");

            System.out.println(
                    "Please select the option\n1. Add a driver 2. Delete a driver 3. Change the driver for an existing constructor team \n4. Display Driver statistics 5. Display the Formula 1 Driver Table 6. Add a race data\n7. Save data 8. Load data 9. Exit");
            Scanner scn = new Scanner(System.in); // Create a Scanner object
            System.out.println("Enter Option");
            int option_1 = scn.nextInt();
            switch (option_1) {
                case 1:
                    String namein;
                    String locin;
                    String teamin;
                    System.out.println("Add User Menu");

                    System.out.println("Enter Name");
                    namein = scn.next();

                    System.out.println("Enter Location");
                    locin = scn.next();

                    System.out.println("Enter Team");
                    teamin = scn.next();
                    this.addDriver(namein, locin, teamin);

                    break;
                case 2:
                    String deletenme;
                    System.out.println("Delete User Menu");
                    System.out.println("Enter Name");
                    deletenme = scn.next();
                    this.deleteDriver(deletenme);
                    break;
                case 3:
                    System.out.println("Change Driver For the team Menu");
                    String namein2;
                    String locin2;
                    String teamin2;
                    System.out.println("Add User Menu");

                    System.out.println("Enter Name");
                    namein2 = scn.next();

                    System.out.println("Enter Location");
                    locin2 = scn.next();

                    System.out.println("Enter Team");
                    teamin2 = scn.next();
                    this.changeDriver(namein2, locin2, teamin2);

                    break;
                case 4:
                    System.out.println("Driver Statistics Menu");
                    String statname;
                    System.out.println("Enter Name");
                    statname = scn.next();
                    this.displayStats(statname);
                    break;
                case 5:
                    System.out.println(" Formula 1 Driver Table");
                    this.displayChampionshipDetails();
                    break;
                case 6:
                    System.out.println("Add a race data");
                    Map<String, String> map = new HashMap<String, String>();
                    System.out.println("Enter the position");
                    for (Formula1Driver d : formula1DriversList) {
                        String newposition;
                        System.out.println(d.name);
                        newposition = scn.next();
                        map.put(d.name, newposition);
                    }

                    this.racecompleted(map);

                    break;
                case 7:
                    System.out.println("Save data");
                    this.savedata();
                    break;
                case 8:
                    System.out.println("Load data");
                    this.readData();
                    break;
                case 9:

                    y = false;
                    break;
                default:
                    System.out.println("invalid Option");
            }

        }
    }
}
