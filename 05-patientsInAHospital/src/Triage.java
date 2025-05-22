public enum Triage {
    RESUCITAR(1),
    EMERGENCIA(2),
    URGENCIA(3),
    POCA_URGENCIA(4),
    SIN_URGENCIA(5);

    private final int prioridad;

    Triage(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Cuanto menor sea el número, mayor es la prioridad
    public boolean tieneMayorPrioridadQue(Triage otro) {
        return this.prioridad < otro.prioridad;
    }
}
