public class Main {
    /**
     * this method should instantiate a population and call day() until
     * the target string is part of the population.
     * o The  target  string  has  fitness  zero  so  the  loop  should  repeat  until  the  most-fit
     * genome has fitness zero.
     * o After each execution of day() output the most fit genome.
     * o To  measure  performance  output  the  number  of  generations  (i.e  times  day()  is
     * called) and the execution time.
     * @param args
     */
    public static void main(String[] args) {
        Main driver = new Main();

        driver.testGenome();
    }

    /**
     * this method tests the Genome class.
     */
    public void testGenome(){
        Genome testGene = new Genome(0.05);

        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
        testGene.mutate();
        System.out.println("Gene:" + testGene.toString());
    }

    /**
     * this method tests the Population class.
     */
    public void testPopulation(){

    }
}
