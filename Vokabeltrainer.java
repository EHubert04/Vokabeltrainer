import java.util.Scanner;

public class Vokabeltrainer {

    static List<Vokabel> vokabelListe;

    public Vokabeltrainer(){
        vokabelListe = new List<Vokabel>();
        menue();
    }

    public static void main(String[] args) {
        Vokabeltrainer vt = new Vokabeltrainer();
    }

    void menue(){
        System.out.println("42) Testmethode aufrufen");
        Scanner input = new Scanner(System.in);
        int auswahl = input.nextInt();
        if(auswahl == 42){
            Testmethode();
        }
    }

    static void Testmethode(){
        Vokabel pVokabel = new Vokabel("Home", "Haus");
        vokabelListe.insert(pVokabel);
        vokabelListe.toFirst();
        System.out.print(vokabelListe.getContent().deutsch);
        System.out.print(" = ");
        System.out.println(vokabelListe.getContent().fremd);
    }
    
}
