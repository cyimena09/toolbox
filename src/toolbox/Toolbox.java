package toolbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class which contains a set of functions that can be useful in development and in technical tests.
 */
public class Toolbox {

    /**
     * Sorts a string in ascending alphabetical order.
     *
     * @param letters word to sort
     * @return string sorted
     */
    public String sorter(String letters) {
        char[] chars = letters.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * Returns true if both strings are anagrams.
     *
     * @param string1 first word
     * @param string2 second word
     * @return return true if string1 equal string2
     */
    public boolean isAnagramSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    /**
     * Allows to sort an array of numbers in ascending order.
     *
     * @param ArrayNumbers array to sort
     */
    public void sortAscDoubleArray(Double[] ArrayNumbers) {
        //Arrays.toString(ArrayNumbers); // for print array
        Arrays.sort(ArrayNumbers);
    }

    /**
     * Allows you to sort an array of numbers in descending order.
     *
     * @param ArrayNumbers array to sort
     */
    public void sortDescDoubleArray(Double[] ArrayNumbers) {
        //return Arrays.toString(ArrayNumbers);
        Arrays.sort(ArrayNumbers, Collections.reverseOrder());
    }

    /**
     * Returns the biggest number in an array.
     *
     * @param array table to process
     * @return biggest number
     */
    public Double getBiggestValue(Double[] array) {
        Double biggest = null;
        for (Double aDouble : array) {
            if (biggest == null) {
                biggest = aDouble;
            } else {
                if (biggest < aDouble) {
                    biggest = aDouble;
                }
            }
        }
        return biggest;
    }

    /**
     * Returns the smallest number in an array.
     *
     * @param array table to process
     * @return smallest number
     */
    public Double getSmallestValue(Double[] array) {
        Double smallest = null;
        for (Double aDouble : array) {
            if (smallest == null) {
                smallest = aDouble;
            } else {
                if (smallest > aDouble) {
                    smallest = aDouble;
                }
            }
        }
        return smallest;
    }

    /**
     * Find the greatest difference between the numbers in the table.
     *
     * @return biggest gap
     */
    public double getBiggestGap(Double[] array) throws Exception {
        // if the array has only one element
        if (array.length <= 1) {
            throw new Exception("The array must contain at least 2 elements");
        }
        this.sortAscDoubleArray(array); //sort array
        double gap = -1.0; // we initialize the difference with -1 because the difference will never be negative
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) { // we check that we are not at the last element of the array
                double difference = Math.abs(array[i] - array[i + 1]); // one affects the difference between the element i and the following one

                if (difference > gap) { // if the difference is bigger than the previous difference then the current difference becomes the biggest difference
                    gap = difference;
                }
            }
        }
        return gap;
    }

    /**
     * Find the smallest difference in a list of numbers.
     *
     * @return biggest gap
     */
    public double getSmallestGap(Double[] array) throws Exception {
        // if the array has only one element
        if (array.length <= 1) {
            throw new Exception("The array must contain at least 2 elements");
        }
        this.sortAscDoubleArray(array); // sort array
        double gap = -1.0; // we initialize the difference with -1 because the difference will never be negative
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) { // we check that we are not at the last element of the array
                double difference = Math.abs(array[i] - array[i + 1]); // one affects the difference between the element i and the following one
                if (gap < 0) { // if we are in the first loop and gap has not yet been assigned
                    gap = difference;
                } else {
                    if (difference < gap) { // if the difference is smallest than the previous difference then the current difference becomes the biggest difference
                        gap = difference;
                    }
                }
            }
        }
        return gap;
    }

    /**
     * The number of combination in a array.
     *
     * @param array parameter in which to determine the number of combinations
     * @return number of combination.
     */
    public int getNumberOfCombination(String[] array) {
        int nbCombination = 0;

        for (int i = 0; i < array.length - 1; i++) {
            nbCombination += i + 1;
        }
        return nbCombination;
    }

    /**
     * Returns the value closest to closest to zero.
     *
     * @param target value to which we must find the closest
     * @param array  numbers array
     * @return closest to target
     */
    public int getClosestToTarget(int target, int[] array) {
        int index = 0; // index of the value closest to 0
        Integer difference = null; // value closer to 0
        int toCompare; // value to compare with the difference

        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (difference == null) { // if we are in the first loop
                difference = Math.abs(array[i]);
            } else {
                toCompare = Math.abs(array[i] - target);

                if (toCompare < difference) {
                    difference = toCompare;
                    index = i;
                }
            }
        }
        int temperature = array[index];
        if (temperature < 0) {
            for (int temp : array) {

                if (temp == Math.abs(temperature)) {
                    temperature = Math.abs(temperature);
                }
            }
        }
        return array[index];
    }

    public void boxSorter(int width, int height, int length, int mass) {
        // todo finish this shit
        int volume = width * height * length;
        if (volume >= 1000) {
            System.out.println("SPECIAL");
        } else if (width >= 150 || height >= 150 || length >= 150) {
            System.out.println("SPECIAL");
        } else if (volume >= 1000 && width >= 150 || height >= 150 || length >= 150) {
            System.out.println("ENCOMBRANT");
        } else {
            System.out.println("STANDARD");
        }
    }

    /**
     * Removes duplicates from an array, without changing the order.
     *
     * @param intArray table to be processed
     * @return table processed
     */
    public int[] removeDouble(int[] intArray) {
        List<Integer> list = new ArrayList<>();
        for (int element : intArray) {
            if (!list.contains(element)) {
                list.add(element);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Verify if two words are anagrams.
     *
     * @param word1 first word
     * @param word2 second word
     * @return return true if words are anagram
     */
    public boolean isAnagram(String word1, String word2) {
        String[] arrWord1 = word1.split("");
        String[] arrWord2 = word2.split("");

        Arrays.sort(arrWord1);
        Arrays.sort(arrWord2);

        return Arrays.equals(arrWord1, arrWord1);
    }

    public void arabicToRomanConverter() {
        // todo Entretien test technique : convertir chiffre arabe en romain, tris
    }

    public void romanToArabicConverter() {
        // todo Entretien test technique : convertir chiffre arabe en romain, tris
    }

    public void boxStacking() {
        // todo stacker des boites du plus large au moins large
    }

}

