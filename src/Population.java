import java.util.*;

public class Population {
    /**
     * a data element that is equal to the most-fit Genome in the population.
     */
    public Genome mostfit;
    private ArrayList<Genome> population = new ArrayList<>();
    private Random rand = new Random();

    /**
     * a constructor that initializes a
     * Population with a number of default genomes
     * @param numGenomes
     * @param mutationRate
     */
    Population(Integer numGenomes, Double mutationRate){
        this.mostfit = new Genome(mutationRate);

        for(int i = 0; i < numGenomes; i++){
            population.add(new Genome(mutationRate));
        }

    }

    /**
     * this function is called every breeding cycle
     */
    public void day(){
        int populationSize = population.size();

        Collections.sort(population);
        this.updateMostFit();
        this.deleteLeastFitHalf();
        this.fillPopulation(populationSize);

    }

    /**
     * o update mostFit variable to the most-fit Genome in the population. (Remember this
     *   is the genome with the lowest fitness!)
     */
    private void updateMostFit(){
        Genome newfit = population.get(0);

        mostfit = newfit;
    }

    /**
     * o delete the least-fit half of the population.
     */
    private void deleteLeastFitHalf(){
        for(int i = (population.size() / 2); i < population.size(); i++){
            population.remove(population.get(i));
            i--;
        }
    }

    /**
     * o create new genomes from the remaining (most-fit) population until the number of
     *   genomes is restored by doing either of the following with equal chance:
     *       ▪ pick a remaining genome at random and clone it (with the copy constructor)
     *         and mutate the clone.
     *      ▪ pick a remaining genome at random and clone it and then crossover the
     *        clone with another remaining genome selected at random and then mutate
     *        the result.
     * @param populationSize
     */
    private void fillPopulation(int populationSize){
        while(population.size() < populationSize){
            int coinFlip = rand.nextInt(2);

            if(coinFlip == 0){
                coinFlip = rand.nextInt(population.size());

                Genome newGenome = new Genome(population.get(coinFlip));
                newGenome.mutate();
                population.add(newGenome);
            } else{
                coinFlip = rand.nextInt(population.size());

                Genome newGenome = new Genome(population.get(coinFlip));

                coinFlip = rand.nextInt(population.size());

                Genome crossoverGenome = new Genome(population.get(coinFlip));

                newGenome.crossover(crossoverGenome);
                newGenome.mutate();
                population.add(newGenome);
            }
        }
    }
}
