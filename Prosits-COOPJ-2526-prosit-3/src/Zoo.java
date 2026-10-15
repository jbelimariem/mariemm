package tn.esprit.gestionzoo.entities;

public class Zoo {
    private static final int NBR_CAGES = 25; // constante
    private  Animal[] animals = new Animal[NBR_CAGES];
    private String name;
    private String city;
    private int animalCount;

    public Zoo() {}

    public Zoo(String name, String city) {
        setName(name); // validation : nom non vide
        this.city = city;
    }

    public Animal[] getAnimals() { return animals; }

    public String getName() { return name; }

    // Instruction 18 : le nom d'un zoo ne doit pas être vide
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne doit pas être vide");
        }
        this.name = name;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getAnimalCount() { return animalCount; }

    public static int getNbrCages() { return NBR_CAGES; }

    public void displayZoo() {
        System.out.println("Zoo : " + name + ", Ville : " + city + ", Cages : " + NBR_CAGES);
    }

    @Override
    public String toString() {
        return "Zoo [Nom=" + name + ", Ville=" + city + ", Cages=" + NBR_CAGES + "]";
    }

    // Instruction 17 : utilise isZooFull() avant d'ajouter
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter l'animal");
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println("Cet animal existe déjà");
            return false;
        }
        animals[animalCount] = animal;
        animalCount++;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Liste des animaux dans le zoo " + name + ":");
        for (int i = 0; i < animalCount; i++) {
            System.out.println(animals[i]);
        }
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].equals(animal)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            System.out.println("Animal introuvable");
            return false;
        }
        for (int i = index; i < animalCount - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animalCount - 1] = null;
        animalCount--;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.animalCount > z2.animalCount) return z1;
        else if (z2.animalCount > z1.animalCount) return z2;
        return null; // égalité
    }
}