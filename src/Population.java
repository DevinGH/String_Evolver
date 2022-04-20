import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
        int populationSize = population.size();
        System.out.println(populationSize);
        Iterator<Genome> itr = population.iterator();

        for(int i = 0; i < population.size(); i++){
            Genome current = population.get(i);
            System.out.println("Gene " + current + " fitness: " + current.fitness());
            System.out.println(mostfit + " fitness: " + mostfit.fitness());
            System.out.println("Average fitness: " + averageFitness());

            if(current.fitness() < mostfit.fitness()){
                mostfit = current;
            }

            if(current.fitness() >= averageFitness()){
                population.remove(current);
                i--;
            }

        }


       /* while(population.size() != populationSize){
            int restoreValue = rand.nextInt(2);

            if(restoreValue == 0){
                int cloneIndex = rand.nextInt(population.size());

                population.add(new Genome(population.get(cloneIndex)));
            }
            if(restoreValue == 1){
                int cloneIndex1 = rand.nextInt(population.size());
                int cloneIndex2 = rand.nextInt(population.size());
                Genome clone1 = new Genome(population.get(cloneIndex1));

                clone1.crossover(population.get(cloneIndex2));
                clone1.mutate();

                population.add(clone1);
            }
        }*/


    }

    private int averageFitness(){
        Iterator<Genome> itr = population.iterator();
        int avgFit = 0;

        while(itr.hasNext()){
            avgFit += itr.next().fitness();
        }

        avgFit /= population.size();

        return avgFit;
    }
}
