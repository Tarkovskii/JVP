package org.example.builder;

public class Person {
    private String name;
    private int age;
    private boolean hasCar;
    private boolean hasRoom;

    private Person (PersonBuilder pb){
        name = pb.name;
        age = pb.age;
        hasCar = pb.hasCar;
        hasRoom = pb.hasRoom;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public boolean isHasRoom() {
        return hasRoom;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hasCar=" + hasCar +
                ", hasRoom=" + hasRoom +
                '}';
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private boolean hasCar;
        private boolean hasRoom;


        public PersonBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public PersonBuilder setHasCar(boolean hasCar) {
            this.hasCar = hasCar;
            return this;
        }

        public PersonBuilder setHasRoom(boolean hasRoom) {
            this.hasRoom = hasRoom;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
