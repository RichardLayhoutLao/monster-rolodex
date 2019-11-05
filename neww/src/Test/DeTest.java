package Test;
import Framework.CollectionDes;
import org.junit.*;

import Framework.De;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DeTest {
    private De de1;
    private De de2;
    private De de3;
    private De de4;
    private CollectionDes collectionDes;

    @Before
    public void faireAvant(){
        de1 = new De();
        de2 = new De();
        de3 = new De();
        de4 = new De();

        collectionDes = new CollectionDes<>(3);
    }

    /**
     * Cette méthode permet de tester les méthodes
     *
     */

    @Test
    public void setAndGetFaceObtenueTest() {
        //TODO A ENLEVER
        De de = new De();
        de.setFaceObtenue(6);
        assertEquals(6, de.getFaceObtenue());
    }

    @Test
    public void limiteFaceDeTest(){
        de1.setFaceObtenue(0);
        de1.setFaceObtenue(6);
    }

    @Test
    public void deInferieurTest(){
        de1.setFaceObtenue(4);
        de2.setFaceObtenue(5);
        assertTrue(de2.compareTo(de1)==-1);
    }

    @Test
    public void memeDeTest(){
        de1.setFaceObtenue(4);
        assertTrue(de1.compareTo(de1)==0);
    }

    @Test
    public void deSuperieurTest(){
        de1.setFaceObtenue(4);
        de2.setFaceObtenue(5);
        assertTrue(de1.compareTo(de2)==1);
    }
    @Test(expected=NullPointerException.class)
    public void deNullTest(){
        de1.setFaceObtenue(4);
        de1.compareTo(null);
    }


    @Test
    public void sizeTest(){
        collectionDes = new CollectionDes<>(3);
        int nbDes = collectionDes.size();
        assertTrue(nbDes == 3);
    }

    @Test
    public void addAndGetTest() {
        collectionDes.add(de1);
        collectionDes.add(de2);
        collectionDes.add(de3);

        de1.setFaceObtenue(1);
        de2.setFaceObtenue(2);
        de3.setFaceObtenue(6);

//        System.out.println("Face: " + collectionDes.getDice(2).getFaceObtenue());

        assertTrue(collectionDes.getDice(2).getFaceObtenue() == 6);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void outOfBoundCollection() {
        collectionDes.add(de1);
        collectionDes.add(de2);
        collectionDes.add(de3);
        collectionDes.add(de4);
    }

    @Test
    public void hasNextAndNextTest() {
        boolean cycleCompleted = false;

        collectionDes.add(de1);
        collectionDes.add(de2);
        collectionDes.add(de3);

//        System.out.println(collectionDes.size());

        Iterator iterator = collectionDes.iterator();


        while (iterator.hasNext()) {

            De de = (De) iterator.next();
//            System.out.println("Face: " + de.getFaceObtenue());

            if (iterator.hasNext() == false) {
                cycleCompleted = true;
            }
        }

        assertTrue(cycleCompleted == true);

    }
}
