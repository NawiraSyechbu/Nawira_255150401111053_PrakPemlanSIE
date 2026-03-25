package UsesA_HasA;

public class Driver {
  //Hubungan Has-A
    private Car coupe;

    public Driver() {
      //Instansiasi objek class Car
        this.coupe = new Car();
        System.out.println("Driver is created.");
    }
    
    public void driving() {
        System.out.println("Driver is driving.");
        System.out.println("Using a car that has " + coupe.numWheel + " wheels.");
    }
}
