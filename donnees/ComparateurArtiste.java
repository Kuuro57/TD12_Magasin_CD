package donnees;

public class ComparateurArtiste implements ComparateurCd {

    public ComparateurArtiste() {

    }

    @Override
    public boolean etreAvant(CD cd1, CD cd2) {
        String album1 = cd1.getNomArtiste();
        String album2 = cd2.getNomArtiste();
        int res = album1.compareTo(album2);

        return res <= 0;
    }
}
