public class Person {
    private final String document;

    public Person(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Account owner with ID:" + this.document;
    }
}