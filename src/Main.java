import java.util.*;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("Anna");
        Owner.Pet pet = owner.new Pet("Barsik", 3);
        Vet vet = new Vet("Dr. John");

        vet.addPet(pet);
        pet.displayPetInfo();
        owner.visitVet(vet);
    }
}

class Owner {
    private String name;
    private Pet pet;

    public Owner(String name) {
        this.name = name;
        this.pet = new Pet("Kismos", 0);
    }

    public class Pet {
        private String name;
        private int age;

        public Pet(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void displayPetInfo() {
            System.out.println("Pet: " + name + ", Age: " + age);
            System.out.println("Pet mood: Playful");
        }
    }

    public void visitVet(Vet vet) {
        class HealthReport {
            void print() {
                System.out.println("Health card for " + Owner.this.name + "'s pet.");
            }
        }

        vet.treatPet(pet);
        HealthReport report = new HealthReport();
        report.print();
    }

    public static class PetHealthCard {
        public void printCard(String ownerName) {
            System.out.println("Static card for " + ownerName + "'s pet.");
        }
    }
}

class Vet {
    private String name;
    private List<Owner.Pet> pets = new ArrayList<>();

    public Vet(String name) {
        this.name = name;
    }

    public void addPet(Owner.Pet pet) {
        pets.add(pet);
    }

    public void treatPet(Owner.Pet pet) {
        System.out.println(name + " now treats " + pet);
    }
}
