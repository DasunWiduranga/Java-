import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        Formula1ChampionshipManager manager = new Formula1ChampionshipManager();

        // // for constructor 1
        // manager.addDriver("Lewis Hamilton", "England", "Mercedes-AMG Petronas
        // F1Team");
        // manager.addDriver("Valtteri Bottas", "Finland", "Mercedes-AMG Petronas
        // F1Team");
        // manager.addDriver("Robert Kubica", "Poland", "Alfa Romeo Racing Orlen");
        // // manager.addDriver("Antonio Giovinazzi", "Italy", "Alfa Romeo Racing
        // Orlen");
        // manager.addDriver("Sergio Pérez", "Mexico", "Red Bull Racing-Honda");
        // // manager.addDriver("Max Verstappen", "Netherlands", "Red Bull
        // Racing-Honda");

        // // manager.addDriver("Lewis Hamilton", "England", "test team");
        // manager.addDriver("Valtteri Bottas", "Finland", "Mercedes-AMG Petronas F1
        // Team");

        // manager.changeDriver("Max Verstappen", "Netherlands", "Red Bull
        // Racing-Honda");
        // System.out.println("------------------");

        // manager.displayStats("Lewis Hamilton");

        // // for constructor 2
        // Formula1Driver d1 = new Formula1Driver("Lewis Hamilton", "England",
        // "Mercedes-AMG Petronas F1 Team");

        // // for duplicate case
        // Formula1Driver d2 = new Formula1Driver("Valtteri Bottas", "Finland",
        // "Mercedes-AMG Petronas F1 Team");

        // Formula1Driver d3 = new Formula1Driver("Robert Kubica", "Poland", "Alfa Romeo
        // Racing Orlen");
        // Formula1Driver d4 = new Formula1Driver("Sergio Pérez", "Mexico", "Red Bull
        // Racing-Honda");

        // // for driver cahange
        // Formula1Driver d5 = new Formula1Driver("Max Verstappen", "Netherlands", "Red
        // Bull Racing-Honda");

        // Formula1Driver d6 = new Formula1Driver("test", "Netherlands", "test racing");

        // // point addition
        // d1.setRaceCount(10);
        // d2.setRaceCount(8);
        // d3.setRaceCount(10);
        // d4.setRaceCount(6);
        // d5.setRaceCount(5);
        // d6.setRaceCount(11);

        // d1.addPosition("1");
        // d1.addPosition("2");
        // d1.addPosition("1");
        // d1.addPosition("3");
        // d2.addPosition("2");
        // d2.addPosition("4");
        // d2.addPosition("2");
        // d3.addPosition("6");
        // d3.addPosition("8");
        // d3.addPosition("3");
        // d3.addPosition("1");
        // d3.addPosition("1");
        // d4.addPosition("3");
        // d4.addPosition("10");
        // d4.addPosition("4");
        // d4.addPosition("2");
        // d5.addPosition("7");
        // d5.addPosition("1");
        // d6.addPosition("3");
        // d6.addPosition("3");
        // d6.addPosition("3");
        // d6.addPosition("3");
        // d6.addPosition("5");
        // d6.addPosition("5");
        // d6.addPosition("9");
        // d6.addPosition("10");

        // manager.addDriver(d1);
        // manager.addDriver(d2);
        // manager.addDriver(d3);
        // manager.addDriver(d4);
        // manager.addDriver(d5);
        // manager.addDriver(d6);

        // // manager.displayChampionshipDetails();

        // manager.changeDriver(d5);

        // manager.displayStats("Lewis Hamilton");

        // manager.displayChampionshipDetails();

        // System.out.println("New Race addition ----------------------------");

        // manager.racecompleted("23-12", map);

        // manager.displayChampionshipDetails();

        // manager.savedata();
        // System.out.println("Dine ----------------------------");
        // manager.readData();
        // System.out.println("Dine ----------------------------");
        manager.runProgramme();
    }
}
