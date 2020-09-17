package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }

    public String calculate(List<String> parts) throws Exception{
        if(parts.size()>160000)
            throw new TooManyLinesExcepction("Demasiadas subsecuencias");

        StringBuilder finalSequence= new StringBuilder("");
        String previousSubsequence=parts.get(0);
        if(previousSubsequence.length()>200)
            throw new TooLongSubsequenceException("La subsecuencia "+previousSubsequence+" es demasiado larga");

        String currentSubsequence;
        finalSequence.append(previousSubsequence);
        for(int iterator=1;iterator<parts.size();iterator++) {
            currentSubsequence = parts.get(iterator);
            if(currentSubsequence.length()>200)
                throw new TooLongSubsequenceException("La subsecuencia "+currentSubsequence+" es demasiado larga");

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
