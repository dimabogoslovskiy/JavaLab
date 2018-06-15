
public class Sportsman {
    private String surname;
    private String name;
    private String middlename;
    private int ageSport;

    public Sportsman(String surname, String name, String middlename, int ageSport) {
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.ageSport = ageSport;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public int getAgeSport() {
        return ageSport;
    }
}
