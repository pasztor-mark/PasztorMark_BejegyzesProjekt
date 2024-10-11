import java.time.LocalDateTime;

public class Bejegyzes {
    String szerzo;
    String tartalom;
    int likeok;
    LocalDateTime letrejott;
    LocalDateTime szerkesztett;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztett = LocalDateTime.now();
    }

    public String getSzerzo() {
        return this.szerzo;
    }
    public String getTartalom() {
        return this.tartalom;
    }
    public int getLikeok() {
        return this.likeok;
    }
    public LocalDateTime getLetrejott() {
        return this.letrejott;
    }
    public LocalDateTime getSzerkesztett() {
        return szerkesztett;
    }
    public void setTartalom(String ujTartalom) {
        this.tartalom = ujTartalom;
    }
    public void like() {
        this.likeok += 1;
    }

    @Override
    public String toString() {
        return szerzo + " - " + likeok + " - " + letrejott + "\n" + "Szerkesztve: " + szerkesztett + "\n" + tartalom;
    }
}
