import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


class LetterFrequency {

    public int[] calcLetterFrequency(String filePath) {

        try {

            //Opening and Reading Input File

            File file = new File(filePath);

            Scanner reader = new Scanner(file);

            //Declaring Array
            //ArrayList<Integer> array =  new ArrayList<Integer>();

            int[] countArray = new int[26];
                    
            for(int i = 0; i < 26; i++) {
                
                countArray[i] = 0;
            }
            
            //Initializing varaibles to be used for computation
            String[] chars = null;
            
            int intChar = 0;
            
            String word = "";

            //Loop to read words in each line and count letter frequency            
            while(reader.hasNextLine()) {

                word = reader.nextLine();

                chars = word.split(" ");
            
                for(int i = 0; i < chars.length; i++) {
                
                    //Parsing string to integer for comparison
                    intChar = Integer.parseInt(chars[i]);
                    
                    //ASCII Code Range for Uppercase Letters in Decimal
                    if(intChar >= 65 && intChar <= 90) {
                        
                        countArray[intChar - 65] += 1;
                    }

                    //ASCII Code Range for Lowercase Letters in Decimal                    
                    else if(intChar >= 97 && intChar <= 122) {
                        
                        countArray[intChar - 97] += 1;  
                    }
                }
            }

            reader.close();


            //Storing results in array for unit testing
            int[] outputForTest = new int[26];
            
            for (int i = 0; i < countArray.length; i++) {

                outputForTest[i] = countArray[i];
            }

            //Opening second file to write results ordered by Max to Min Occurence

            File file2 = new File("FrequencyOutput.txt");
            
            FileWriter writer = new FileWriter(file2);

            //Variables to sort in descending order while keeping index for letters constant
            int maxOccur = countArray[0]; 
            int maxIndex = 0;
            
            int counter = 0;
            
            while(counter < 26) {
                
                maxOccur = 0;
                maxIndex = 0;
                
                for (int i = 0; i < countArray.length; i++) {

                    if(countArray[i] >= maxOccur) {

                        maxOccur = countArray[i];

                        maxIndex = i;
                    }
                }

                //Writing Frequencies in file in descending order
                writer.write("Count of " + (char)(65 + maxIndex) + " : " + countArray[maxIndex] + "\n");

                countArray[maxIndex] =  -1;
                
                counter++;
                
            }

            System.out.println("Writing Successful");
            writer.close();

            return outputForTest;


        }

        catch(FileNotFoundException e) {

            System.out.println("File Not Found Exception Occured");

            return null;

        }

        catch(IOException e) {

            System.out.println("IO Exception Occured");

            return null;
        }


    }

    public static void main(String[] args) {

        LetterFrequency test = new LetterFrequency();

        test.calcLetterFrequency("Provinces.txt");

    }
}