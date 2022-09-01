import java.util.HashMap;
import java.util.Map;

public class Formula1Driver extends   Driver {
    private int raceCount;
    private final Map<String, Integer> pointScheme = new HashMap<>();
    private Map<String, Integer> positionCount = new HashMap<>();

    Formula1Driver(String name, String location, String teamName) {
        super(name, location, teamName);
        pointScheme.put("1", 25);
        pointScheme.put("2", 18);
        pointScheme.put("3", 15);
        pointScheme.put("4", 12);
        pointScheme.put("5", 10);
        pointScheme.put("6", 8);
        pointScheme.put("7", 6);
        pointScheme.put("8", 4);
        pointScheme.put("9", 2);
        pointScheme.put("10", 1);

        positionCount.put("1", 0);
        positionCount.put("2", 0);
        positionCount.put("3", 0);
        positionCount.put("4", 0);
        positionCount.put("5", 0);
        positionCount.put("6", 0);
        positionCount.put("7", 0);
        positionCount.put("8", 0);
        positionCount.put("9", 0);
        positionCount.put("10", 0);
    }

    Formula1Driver(String name, String location, String teamName, int racecount, int positionCount1,
                   int positionCount2,
                   int positionCount3, int positionCount4, int positionCount5, int positionCount6, int positionCount7,
                   int positionCount8, int positionCount9, int positionCount10) {
        super(name, location, teamName);
        this.raceCount = racecount;
        pointScheme.put("1", 25);
        pointScheme.put("2", 18);
        pointScheme.put("3", 15);
        pointScheme.put("4", 12);
        pointScheme.put("5", 10);
        pointScheme.put("6", 8);
        pointScheme.put("7", 6);
        pointScheme.put("8", 4);
        pointScheme.put("9", 2);
        pointScheme.put("10", 1);

        positionCount.put("1", positionCount1);
        positionCount.put("2", positionCount2);
        positionCount.put("3", positionCount3);
        positionCount.put("4", positionCount4);
        positionCount.put("5", positionCount5);
        positionCount.put("6", positionCount6);
        positionCount.put("7", positionCount7);
        positionCount.put("8", positionCount8);
        positionCount.put("9", positionCount9);
        positionCount.put("10", positionCount10);
    }

    public void addPosition(String position) {
        int count = positionCount.get(position) + 1;
        positionCount.put(position, count);
    }

    public int getFirstPositions() {
        return positionCount.get("1");
    }

    public int getSecondPositions() {
        return positionCount.get("2");
    }

    public int getThirdPositions() {
        return positionCount.get("3");
    }

    public int getPoints() {
        int points = 0;
        for (String position : positionCount.keySet()) {
            points += pointScheme.get(position) * positionCount.get(position);
        }
        return points;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    @Override
    public String toString() {
        return "name:" + this.name + "\nlocation: " + this.location + "\nteamName: " + this.teamName
                + "\nraceCount: " + this.raceCount
                + "\npositionCount1: " + this.positionCount.get("1")
                + "\npositionCount2: " + this.positionCount.get("2")
                + "\npositionCount3: " + this.positionCount.get("3")
                + "\npositionCount4: " + this.positionCount.get("4")
                + "\npositionCount5: " + this.positionCount.get("5")
                + "\npositionCount6: " + this.positionCount.get("6")
                + "\npositionCount7: " + this.positionCount.get("7")
                + "\npositionCount8: " + this.positionCount.get("8")
                + "\npositionCount9: " + this.positionCount.get("9")
                + "\npositionCount10: " + this.positionCount.get("10")

                ;
    }

}

// private int raceCount;
// private final Map<String, Integer> pointScheme = new HashMap<>();
// private Map<String, Integer> positionCount = new HashMap<>();