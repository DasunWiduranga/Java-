import java.io.Serializable;

public abstract class Driver implements Serializable {
    protected String name;
    protected String location;
    protected String teamName;

    Driver(String name, String location, String teamName) {
        this.name = name;
        this.location = location;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTeamName() {
        return teamName;
    }

    public void changeTeamName(String newTeam) {
        this.teamName = newTeam;
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeLocation(String newLoc) {
        this.location = newLoc;
    }
}