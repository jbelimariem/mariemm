package tn.esprit.gestionzoo.entities;

public class Animal {
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal() {}

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age); // validation : age >= 0
        this.isMammal = isMammal;
    }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    // Instruction 18 : un animal ne peut pas avoir un âge négatif
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge d'un animal ne peut pas être négatif");
        }
        this.age = age;
    }

    public boolean isMammal() { return isMammal; }
    public void setMammal(boolean mammal) { isMammal = mammal; }

    @Override
    public String toString() {
        return "Animal [Famille=" + family + ", Nom=" + name + ", Âge=" + age + ", Mammifère=" + isMammal + "]";
    }

    // Deux animaux sont identiques s'ils ont le même nom
    // (nécessaire pour que searchAnimal détecte les doublons)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal other = (Animal) o;
        return name != null && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.hashCode();
    }
}