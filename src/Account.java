import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private String name, userName, password, subscriptionDateCreated, subscriptionDateEnd;
    private LocalDate created, membershipEnd;
    private DateTimeFormatter DateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private HashMap<TvSeries, ArrayList<String>> seriesWatched;

    public Account() {}
    public Account(String name, String userName, String password, int monthsOfMembership) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.created = LocalDate.now();
        this.subscriptionDateCreated = created.format(DateFormatter);
        this.membershipEnd = created.plusMonths(monthsOfMembership);
        this.subscriptionDateEnd = membershipEnd.format(DateFormatter);
        this.seriesWatched = new HashMap<TvSeries, ArrayList<String>>();
    }

    public Account(Account user) {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public String getSubscriptionDateCreated() {
        return subscriptionDateCreated;
    }
    public String getSubscriptionDateEnd() {
        return subscriptionDateEnd;
    }
    public HashMap<TvSeries, ArrayList<String>> getSeriesWatched() {
        return seriesWatched;
    }

    public void displayWatchedSeries() {
        for (TvSeries key : seriesWatched.keySet()) {
            System.out.println(key.getName());
            System.out.println("Last episode: " + seriesWatched.get(key).get(seriesWatched.get(key).size()-1));
        }
    }

    public void memberDetails() {
        int totalShows = seriesWatched.size(), showsFinished = 0, totalEpisodes = 0;
        for (TvSeries key : seriesWatched.keySet()) {
            ArrayList<String> a = seriesWatched.get(key);
            totalEpisodes += a.size();
            String lastEpisode = a.get(a.size()-1);
            if (key.getEpisodes().get(key.getEpisodes().size()-1).getName().equals(lastEpisode)) {
                showsFinished ++;
            }
        }

        System.out.println(toString());

        System.out.println("Total shows watched: \n" +totalShows);
        System.out.println("Total episodes watched: \n" + totalEpisodes);
        System.out.println("Total shows finished: \n" + showsFinished);
    }

    public void addToWatched(TvSeries show, String episode) {
        if (!seriesWatched.containsKey(show)) {
            seriesWatched.put(show, new ArrayList<String>());
        } seriesWatched.get(show).add(episode);
    }
    public String toString() {
        return "User information:\n" +
                String.format("Name: %s\n", name) +
                String.format("User name: %s\n", userName) +
                String.format("Joined at: %s\n", subscriptionDateCreated) +
                String.format("Ending in: %s\n", subscriptionDateEnd) ;
    }

}
