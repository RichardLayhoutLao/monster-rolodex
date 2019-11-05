/**
 * Ceci est une classe qui représente un dé concret.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */

package Framework;

public class De implements Comparable<De>{

    private final int NB_FACES = 6;
    private int faceObtenue;



    public De() {}


    public void setFaceObtenue(int faceObtenue) {
        if (faceObtenue < 0 || faceObtenue > NB_FACES) {
            System.err.println("Le face obtenue doit etre entre 0 et 6");
        } else {
            this.faceObtenue = faceObtenue;
        }
    }

    public int getFaceObtenue() {
        return faceObtenue;
    }


    @Override
    public int compareTo(De de) {
        int faceObtenue = de.getFaceObtenue();
        return faceObtenue - this.getFaceObtenue() ;
    }
}
