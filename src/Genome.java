public class Genome {
    /**
     * a data element that is initialized to your name.
     */
    public String target;

    /**
     * a constructor that initializes a Genome with value ‘A’ and
     * assigns the internal mutation rate. The mutationRate must be between zero and one.
     * @param mutationRate
     */
    Genome(double mutationRate){

    }

    /**
     * a  copy  constructor  that  initializes  a  Genome  with  the  same
     * values as the input gene.
     * @param gene
     */
    Genome(Genome gene){

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

    }

    /**
     * this  function  will  display  the  Genome’s  current  character  string  and
     * fitness in an easy to read format.
     * @return
     */
    public String toString(){

    }
}
