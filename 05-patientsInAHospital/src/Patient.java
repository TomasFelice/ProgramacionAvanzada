public class Patient {
    private final String name;
    private final Triage triage;

    public Patient(String name, Triage triage) {
        this.name = name;
        this.triage = triage;
    }

    public String getName() {
        return name;
    }

    public Triage getTriage() {
        return triage;
    }

    @Override
    public String toString() {
        return name + " " + triage;
    }
}
