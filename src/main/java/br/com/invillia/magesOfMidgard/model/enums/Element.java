package br.com.invillia.magesOfMidgard.model.enums;

/** Enum do elementos disponiveis para um mago **/
public enum Element {
    WATER("W", "Água"),
    ARCANE("A", "Arcano"),
    SHIELD("S", "Escudo"),
    FIRE("F", "Fogo"),
    COLD("C", "Frio"),
    LIGHTNING("LG", "Raio"),
    EARTH("E", "Terra"),
    LIFE("LF", "Vida");

    private final String valor;
    private final String label;

    Element(String valor, String label) {
        this.valor = valor;
        this.label = label;
    }

    public String getValor() {
        return valor;
    }

    public String getLabel() {
        return label;
    }
}
