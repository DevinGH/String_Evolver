public class Population {
    /**
     * a data element that is equal to the most-fit Genome in the population.
     */
    public Genome mostfit;

    /**
     * a constructor that initializes a
     * Population with a number of default genomes
     * @param numGenomes
     * @param mutationRate
     */
    Population(Integer numGenomes, Double mutationRate){

    }

    /**
     * this function is called every breeding cycle and carries out the following steps:
     * o update mostFit variable to the most-fit Genome in the population. (Remember this
     * is the genome with the lowest fitness!)
     * o delete the least-fit half of the population.
     * o create new genomes from the remaining (most-fit) population until the number of
     * genomes is restored by doing either of the following with equal chance:
     *      ▪ pick a remaining genome at random and clone it (with the copy constructor)
     *      and mutate the clone.
     *      ▪ pick a remaining genome at random and clone it and then crossover the
     *      clone with another remaining genome selected at random and then mutate
     *      the result.
     */
    public void day(){

    }
}
