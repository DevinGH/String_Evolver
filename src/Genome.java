import java.util.Random;

public class Genome {
    /**
     * Instance Variables
     */
    private String target = "Devin Hanson";
    private String value;
    private double mutationRate;
    private Random rand = new Random();
    private char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', ' ', '-', '\''};

    /**
     * a constructor that initializes a Genome with value ‘A’ and
     * assigns the internal mutation rate. The mutationRate must be between zero and one.
     * @param mutationRate
     */
    Genome(double mutationRate){
        this.value = "A";
        this.mutationRate = mutationRate;

    }

    /**
     * a  copy  constructor  that  initializes  a  Genome  with  the  same
     * values as the input gene.
     * @param gene
     */
    Genome(Genome gene){
        this.value = gene.value;
        this.mutationRate = gene.mutationRate;

    }

    /**
     * this function mutates the string in this Genome using the following rules:
     * o with  mutationRate  chance  add  a  randomly  selected  character  to  a  randomly
     * selected position in the string.
     * o with  mutationRate  chance  delete  a  single  character  from  a  randomly  selected
     * position of the string but do this only if the string has length at least 2.
     * o for each character in the string:
     *      ▪ with mutationRate chance the character is replaced by a randomly selected
     *        character.
     */
    public void mutate(){
        double coinFlip = rand.nextDouble();

        //System.out.println("Flipped coin: " + coinFlip);
        if(coinFlip <= this.mutationRate){
            int addChar = rand.nextInt(alphabet.length);
            int stringPos = rand.nextInt(value.length());

            //System.out.println("Adding Char " + alphabet[addChar] + " at position " + stringPos);

            value = value.substring(0, stringPos) + alphabet[addChar] + value.substring(stringPos);
        }

        coinFlip = rand.nextDouble();

        //System.out.println("Flipped coin 2: " + coinFlip);
        if(coinFlip <= this.mutationRate && value.length() >= 2){
            int removedCharPos = rand.nextInt(value.length());

            //System.out.println("Removing Char at " + removedCharPos);

            value = value.substring(0, removedCharPos) + value.substring(removedCharPos + 1);
        }

        for(int i = 0; i < value.length(); i++){
            coinFlip = rand.nextDouble();

            if(coinFlip <= this.mutationRate){
                int changeCharAt = rand.nextInt(alphabet.length);
                int stringPos = rand.nextInt(value.length());

                //System.out.println("Changing Char " + alphabet[changeCharAt] + " at position " + stringPos);

                if(stringPos == 0){
                    value = value.substring(0, stringPos) + alphabet[changeCharAt] + value.substring(stringPos);
                }else{
                    value = value.substring(0, stringPos - 1) + alphabet[changeCharAt] + value.substring(stringPos);
                }
            }
        }


    }

    /**
     * this function will update the current Genome by crossing
     * it over with other.
     * o Create the new list by following these steps for each index in the new string (which
     * can  be  of  any  length  between  the  minimum  and  the  maximum  of  the  two  string
     * lengths), starting at the first index:
     *      ▪ Randomly choose one of the two parent strings.
     *      ▪ If the parent string has a character at this index (i.e. it is long enough) copy
     *        that character into the new list. Otherwise end the new list here and replace
     *        the old list.
     * @param other
     */
    public void crossover(Genome other){
        String offspring = "";
        String mother = this.value;
        String father = other.value;

        if(mother.length() >= father.length()){
            offspring = getString(offspring, mother, father);
        }else{
            offspring = getString(offspring, father, mother);
        }

        this.value = offspring;

    }

    /**
     * Returns a new offspring string
     * @param offspring
     * @param longer
     * @param shorter
     * @return
     */
    private String getString(String offspring, String longer, String shorter) {
        for(int i = 0; i < longer.length() - 1; i++){
            int pickedParent = rand.nextInt(2);

            if(pickedParent == 0){
                offspring += longer.substring(i, i);
            }
            if(pickedParent == 1 && shorter.substring(i, i) != null){
                offspring += shorter.substring(i, i);
            }
        }

        return offspring;
    }

    /**
     * returns  the  fitness  of  the  Genome  calculated  using  the  following
     * algorithm:
     * o Let n be the length of the current string. Let m be the length of the target string.
     * o Let L be the max(n, m).
     * o Let f be initialized to |m – n|.
     * o For each character position 0≤i<L add one to f if the character in the current string
     * is different from the character in the target string (or if no character exists at that
     * position in either string). Otherwise leave f unchanged.
     * o Return f.
     *
     * OPTIONAL:
     *  instead  of  the  algorithm  above  use  the  Wagner-Fischer
     * algorithm for calculating Levenshtein edit distance:
     * o Let n be the length of the current string. Let m be the length of the target string.
     * o Create an (n + 1) × (m + 1) matrix D initialized with 0s.
     * o Fill the first row of the matrix with the column indices and fill the first column of the
     * matrix with the row indices.
     * o Implement this nested loop to fill in the rest of the matrix:
     *  for i from 1 to n
     *     for j from 1 to m
     *  if (current[i–1] == target[j–1]) D[i, j] = D[i–1, j–1]
     *  else D[i, j] = min(D[i–1, j] + 1, D[i, j–1] + 1, D[i–1, j–1] + 1)
     *
     * o Return the value stored in D[n,m] + (abs(n–m)+ 1)/2. (Use integer arithmetic.)
     * @return
     */
    public Integer fitness(){
        int n = this.value.length();
        int m = target.length();
        int l = Math.min(n, m);
        int f = Math.abs(m - n);

        for(int i = 0; i < l; i++){
            /*System.out.println("Value substring:" + this.value.substring(i,i));
            System.out.println("Target substring:" + target.substring(i,i));*/
            if(!this.value.substring(i,i + 1).equals(target.substring(i,i + 1))){
                //System.out.println("made it here");
                f += 1;
            }
        }

        return f;
    }

    /**
     * this  function  will  display  the  Genome’s  current  character  string  and
     * fitness in an easy to read format.
     * @return
     */
    public String toString(){
        return "(\"" + this.value + "\", " + fitness() + ")";
    }
}
