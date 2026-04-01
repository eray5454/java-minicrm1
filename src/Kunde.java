public class Kunde {
    private String name;
    private String email;
    private int kundennummer;

    public Kunde(String name, String email, int kundennummer) {
        this.name = name;
        this.email = email;
        this.kundennummer = kundennummer;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getKundennummer() {
        return kundennummer;
    }
}
