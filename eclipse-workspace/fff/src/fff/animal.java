package fff;
import java.util.ArrayList;
import java.util.List;

class Mammal extends Animal {
    public Mammal(int zooID, String name, String dateOfBirth, String placeOfBirth) {
        super(zooID, name, dateOfBirth, placeOfBirth);
    }

    @Override
    public String getAnimalType() {
        return "Mammal";
    }
}

class Bird extends Animal {
    public Bird(int zooID, String name, String dateOfBirth, String placeOfBirth) {
        super(zooID, name, dateOfBirth, placeOfBirth);
    }

    @Override
    public String getAnimalType() {
        return "Bird";
    }
}

class Lion extends Mammal {
    public Lion(int zooID, String name, String dateOfBirth, String placeOfBirth) {
        super(zooID, name, dateOfBirth, placeOfBirth);
    }

    @Override
    public String getAnimalType() {
        return "Lion";
    }
}

class Elephant extends Mammal {
    public Elephant(int zooID, String name, String dateOfBirth, String placeOfBirth) {
        super(zooID, name, dateOfBirth, placeOfBirth);
    }

    @Override
    public String getAnimalType() {
        return "Elephant";
    }
}

class Penguin extends Bird {
    public Penguin(int zooID, String name, String dateOfBirth, String placeOfBirth) {
        super(zooID, name, dateOfBirth, placeOfBirth);
    }

    @Override
    public String getAnimalType() {
        return "Penguin";
    }
}

class Parrot extends Bird {
    public Parrot(int zooID, String name, String dateOfBirth, String placeOfBirth) {
        super(zooID, name, dateOfBirth, placeOfBirth);
    }

    @Override
    public String getAnimalType() {
        return "Parrot";
    }
}

class Vaccination {
    private String vaccineName;
    private String vaccinationDate;

    public Vaccination(String vaccineName, String vaccinationDate) {
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    public String toString() {
        return vaccineName + " (" + vaccinationDate + ")";
    }
}