package voting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteAlgorithm {

    Map<String,Integer> candidateVoteCount = new HashMap<>();

    public VoteAlgorithm() {
    }

    public String findWinner(List<String> candidates){
        String winner = "";
        Integer winnerVotes = 0 ;

        //traverse through list and update in map each time the count.
        for(String candidate : candidates){
            if(candidateVoteCount.containsKey(candidate)){
                candidateVoteCount.put(candidate,candidateVoteCount.get(candidate)+1);
            }else{
                candidateVoteCount.put(candidate,1);
            }
        }

        //iterate over vote count of all candidates and find maximum
        for(Map.Entry<String,Integer> entry : candidateVoteCount.entrySet()){
            if(entry.getValue() > winnerVotes) {
               winner = entry.getKey();
               winnerVotes= entry.getValue();
            }
        }
        return winner;
    }


    //function to find winner in sinle loop
    public String findWinnerWithoutReloop(List<String> candidates){
        String winner = "";
        Integer winnerVotes = 0 ;

        //traverse through list and update in map each time the count.
        for(String candidate : candidates){
            if(candidateVoteCount.containsKey(candidate)){
                int votes = candidateVoteCount.get(candidate)+1;
                candidateVoteCount.put(candidate,votes);

                if(votes > winnerVotes){
                    winner = candidate;
                    winnerVotes = votes;
                }

            }else{
                int votes = 1;
                candidateVoteCount.put(candidate,votes);
                if(votes > winnerVotes){
                    winner = candidate;
                    winnerVotes = votes;
                }
            }
        }

        return winner;
    }
}
