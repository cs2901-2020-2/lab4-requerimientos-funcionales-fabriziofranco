package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> part){
        StringBuilder finalSequence= new StringBuilder("");
        String previousSubsequence=part.get(0);
        String currentSubsequence;
        for(int iterator=1;iterator<part.size();iterator++) {
            currentSubsequence = part.get(iterator);
            String subSequenceinCommon = "";
            for (int i = 0; i < previousSubsequence.length(); i++) {
                if (currentSubsequence.contains(previousSubsequence.substring(i))) {
                    subSequenceinCommon = previousSubsequence.substring(i);
                    break;
                }
            }
            System.out.print("-------------------" + " \n\n");
            System.out.print(subSequenceinCommon + " \n\n");
            int positionOfPrev = previousSubsequence.indexOf(subSequenceinCommon) - 1;
            System.out.print(positionOfPrev + " \n\n");


            if (positionOfPrev == 0)
                finalSequence.append(previousSubsequence.charAt(0));
            else if (positionOfPrev > 0)
                finalSequence.append(previousSubsequence.substring(0, positionOfPrev));
            else
                finalSequence.append(previousSubsequence);
            System.out.print(finalSequence + " \n\n");

            finalSequence.append(currentSubsequence);
            previousSubsequence = currentSubsequence;
            System.out.print(finalSequence + " \n\n");
        }
            return finalSequence.toString();
    }
}
