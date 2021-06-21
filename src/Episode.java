import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Episode {
    private String name, summary, formatDate;
    private LocalDate publishDate;
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Episode(String name, String summary, int day, int month, int year) {
        this.name = name;
        this.summary = summary;
        this.publishDate = LocalDate.of(year,month,day);
        this.formatDate = publishDate.format(dateTimeFormatter);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String toString() {
        return String.format("%s \n", name) +
                String.format("%s \n", summary) +
                String.format("%s \n", formatDate) ;
    }
    public boolean equals(Object obj) {
        if (obj instanceof Episode) {
            if (((Episode)obj).getName().equals(this.name)) {
                return true;
            }
        }
        return false;
    }
}