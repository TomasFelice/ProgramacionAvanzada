import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Patient> pacientes = new ArrayList<>();
        ArrayList<Triage> triages = new ArrayList<>();

        triages.add(Triage.RESUCITAR);
        triages.add(Triage.EMERGENCIA);
        triages.add(Triage.URGENCIA);
        triages.add(Triage.POCA_URGENCIA);
        triages.add(Triage.SIN_URGENCIA);

        // Genera 3 pacientes de cada Triage
        int j = 0;
        for (Triage triage : triages) {
            for (int i = j; i < j + 3; i++) {
                pacientes.add(new Patient("Paciente " + i, triage));
            }
            j += 3;
        }

        TDAMonticulo monticulo = new TDAMonticulo();
        pacientes.forEach(monticulo::agregar);

        while (!monticulo.estaVacia()) {
            System.out.println(monticulo.atender());
        }
    }
}

