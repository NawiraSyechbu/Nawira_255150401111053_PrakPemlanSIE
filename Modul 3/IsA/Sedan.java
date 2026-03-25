public class Sedan extends Car{
    public int numDoors = 3;

    public void trunk() {
        System.out.println("Sedan is opening trunk");
    }

    public void honk() {
        System.out.println("Sedan is honking");
        super.honk(); //Memanggil method honk() milik Vehicle
    }

    public void getNumWheels() {
        System.out.println("Sedan has " + getNumWheel() + " wheels");
    }
}
