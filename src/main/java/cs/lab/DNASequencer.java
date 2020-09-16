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
        finalSequence.append(previousSubsequence);
        for(int iterator=1;iterator<part.size();iterator++) {
            currentSubsequence = part.get(iterator);
            String subSequenceinCommon = "";
            for (int i = 0; i < previousSubsequence.length(); i++) {
                if (currentSubsequence.contains(previousSubsequence.substring(i))) {
                    subSequenceinCommon = previousSubsequence.substring(i);
                    break;
                }
            }
            int positionOfCur = currentSubsequence.indexOf(subSequenceinCommon);
            finalSequence.append(currentSubsequence.substring(positionOfCur+subSequenceinCommon.length(),currentSubsequence.length()));
            previousSubsequence = currentSubsequence;
        }
            return finalSequence.toString();
    }
}
