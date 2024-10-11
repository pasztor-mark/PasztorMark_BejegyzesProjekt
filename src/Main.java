import java.io.*;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //init
        List<Bejegyzes> bejegyzesek = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        //2/a
        bejegyzesek.add(new Bejegyzes("Első Szerző", "Első poszt"));
        bejegyzesek.add(new Bejegyzes("Második Szerző", "Második poszt"));

        //2/b
        int darab = 0;
        while (darab < 1) {
            System.out.println("2/b: Hány bejegyzést szeretnél létrehozni?");
            darab = Integer.parseInt(scanner.nextLine());
            if (darab < 0) {
                System.out.println("Helyes számot adjon meg.");
            }
        }
        for (int i = 0; i < darab; i++) {
            System.out.println("Adja meg a felhasználónevét ");
            String szerzo = scanner.nextLine();
            System.out.println("Adja meg a bejegyzés tartalmát ");
            String tartalom = scanner.nextLine();
            bejegyzesek.add(new Bejegyzes(szerzo, tartalom));
        }
        //2/c
        String file = "bejegyzesek.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                bejegyzesek.add(
                        new Bejegyzes(line.split(";")[0], line.split(";")[1])
                );
            }
            System.out.println("2/c: Fájlok beolvasva.");
        } catch (IOException e) {
            System.out.println(e);
        }
        //2/d
        int likeok = bejegyzesek.size()*20;
        for (Bejegyzes bejegyzes: bejegyzesek) {
            Random rand = new Random();
            int szamok = rand.nextInt(likeok);
            System.out.println(szamok);
            likeok = likeok-szamok;
            for (int i = 0; i < szamok; i++) {
                bejegyzes.like();
            }
        }
        //2/e
        System.out.println("2/e: Szerkeszd a második poszt tartalmát");
        String edit = scanner.nextLine();
        bejegyzesek.get(1).setTartalom(edit);
        //2/f
        for (Bejegyzes bejegzes: bejegyzesek) {
            System.out.println(bejegzes.toString());
        }
        //3/a
        int legtobbLike = 0;
        for (Bejegyzes bejegzes: bejegyzesek) {
            if (bejegzes.getLikeok() > legtobbLike) {
                legtobbLike = bejegzes.getLikeok();
            }
        }
        System.out.println("3/a: Legtöbb like:");
        System.out.println(legtobbLike);
        //3/b
        boolean hasMoreLikes = false;
        for (Bejegyzes bejegzes: bejegyzesek) {
            if (bejegzes.getLikeok() > 35) {
                hasMoreLikes = true;
            }
        }
        if (hasMoreLikes) {
            System.out.println("3/b: Van ilyen bejegyzés.");
        } else System.out.println("3/b: Nincs ilyen bejegyzés");
        //3/c
        int kevesLikeBejegyzesek = 0;
        for (Bejegyzes bejegzes: bejegyzesek) {
            if (bejegzes.getLikeok() > 15) {
                kevesLikeBejegyzesek++;
            }
        }
        System.out.println("3/c: Ennyi bejegyzésnek van 15-nél kevesebb like-ja:");
        System.out.println(kevesLikeBejegyzesek);
        //3/d
        Collections.sort(bejegyzesek, new Comparator<Bejegyzes>() {
            @Override
            public int compare(Bejegyzes o1, Bejegyzes o2) {
                return Integer.compare(o1.getLikeok(), o2.getLikeok());
            }
        });

        //+
        try {
            File txtFile = new File("bejegyzesek_rendezett.txt");
            if (txtFile.createNewFile()) {
                System.out.println("Fájl létrehozva.");
            }
            FileWriter fw = new FileWriter(txtFile);
            for (Bejegyzes bejegyzes : bejegyzesek) {
                fw.write(bejegyzes.toString() + "\n");
            }
            fw.close();
            System.out.println("Lista exportálva .txt fájlba.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }



}