public interface ChampionshipManager {
    void addDriver(String name, String location, String team);

    void deleteDriver(String driverName);

    void changeDriver(String newDriverName, String location, String teamName);

    void displayStats(String driverName);
}

