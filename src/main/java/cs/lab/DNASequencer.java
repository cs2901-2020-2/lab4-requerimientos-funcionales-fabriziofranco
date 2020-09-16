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
        for(int iterator=1;iterator<part.size();iterator++){
            currentSubsequence=part.get(iterator);
            int positionOfPrev=previousSubsequence.indexOf(currentSubsequence);
            if(positionOfPrev!=-1)
                finalSequence.append(previousSubsequence.substring(0, positionOfPrev -1 ));
            else
                finalSequence.append(previousSubsequence);
            finalSequence.append(currentSubsequence);
            previousSubsequence=currentSubsequence;

        }
        return finalSequence.toString();
    }
}
