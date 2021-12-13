import java.util.Scanner;


public class Vokabeltrainer {

    static List<Vokabel> vokabelListe;
    int richtig; 
    int falsch; 

    public Vokabeltrainer(){
        //Konstruktor Vokabeltrainer; nötig um static aus main aufzulösen
        //VokabelListe erscchaffen, danach aufruf des menues 
        vokabelListe = new List<Vokabel>();
        menue();
    }

    public static void main(String[] args) {
        //Eine Objekt vt vom Typ Vokabeltrainer erstellen
        Vokabeltrainer vt = new Vokabeltrainer();
 
    }

    void menue(){
        //Auswahlmöglichkeiten ausgeben
        System.out.println("1) neue Vokabel einfügen");
        System.out.println("2) Abfrage starten");
        System.out.println("3) Vokabel löschen");
        System.out.println("9) alle Vokabeln anzeigen");
        System.out.println("42) Testmethode aufrufen");
        Scanner input = new Scanner(System.in);

        //Eingabe verarbeiten
        int auswahl = input.nextInt();
        switch(auswahl){
            case 1:
                vokabelnEinfuegen();
                break;

            case 2:
                abfrage();
                break;
            case 3:
                spezVokabelloeschen();
                break;
            case 9:
                alleVokabel();
                break;
            case 42:
                Testmethode();
                break;
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
    
    void vokabelnEinfuegen(){
        //Abfrage Deutsches Wort
        System.out.print("Bitte das Deutschwort eingeben: ");
        Scanner deInput = new Scanner(System.in);
        String deVokabel = deInput.nextLine();
        //Abfrage fremdwort
        System.out.print("Bitte das Fremdwort eingeben: ");
        String engVokabel = deInput.nextLine();
        //Objekt Vokabel daraus erstellen & zur Liste hinzufügen
        Vokabel v = new Vokabel(engVokabel, deVokabel);
        vokabelListe.append(v);
        menue();
    }

    void alleVokabel(){
        vokabelListe.toFirst();
        while(vokabelListe.hasAccess()){
            System.out.println(vokabelListe.getContent().deutsch + " - " + vokabelListe.getContent().fremd);
            vokabelListe.next();
        }
        menue();
    }

    void spezVokabelloeschen(){
        System.out.println("Welche Vokalebn wollen Sie löschen [Deutschevokabel eingenen]");
        Scanner input = new Scanner(System.in);
        String search = input.nextLine();
        vokabelListe.toFirst();
        while(!vokabelListe.getContent().deutsch.equals(search)){
            vokabelListe.next();
        }
        vokabelListe.remove();
        menue();
    }

    void abfrage(){
        vokabelListe.toFirst();
        while(vokabelListe.hasAccess()){
            System.out.println(vokabelListe.getContent().deutsch);
            Scanner vokabelinput = new Scanner(System.in);
            String vokabel = vokabelinput.nextLine();
            String ov = vokabelListe.getContent().fremd;
            if(vokabel.equals(ov)){
                richtig++;
            }else{
                falsch++;
            }
            vokabelListe.next();;
        }
        System.out.println("Du hattest " + richtig  + " Vokabeln richtig");
        System.out.println("Du hattest " + falsch  + " Vokabeln falsch");
        menue();
    }
}