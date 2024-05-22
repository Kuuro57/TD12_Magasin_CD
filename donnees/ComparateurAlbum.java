package donnees;

public class ComparateurAlbum implements ComparateurCd {

    public ComparateurAlbum() {

    }

    @Override
    public boolean etreAvant(CD cd1, CD cd2) {
        String album1 = cd1.getNomCD();
        String album2 = cd2.getNomCD();
        int res = album1.compareTo(album2);

        return res <= 0;
    }

}
