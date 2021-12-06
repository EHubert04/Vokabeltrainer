public class Element{
    Element next;
    Vokabel vokabel;

    public Element(Vokabel pVokabel, Element pNext){
        vokabel = pVokabel;
        next = pNext;
    }

}