package voting;

import voting.model.Vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiVoteAlgorithm {

    List<Vote> voteList = new ArrayList<>();

    //Candidate, totoalvotes
    Map<String,Integer> candidateVoteCount = new HashMap<>();

    // 1, 2 , totalcount
    // 2, 5 , totalcount

    // {A,1} {A,2},{A,3}, {B,1},{B,2},{B,3},
    public void saveVote(List<Vote> voteList){
        this.voteList.addAll(voteList);
    }

    public String findWinner(){
        String winner = "";
        Integer winnerVote = 0 ;

        for(Vote vote : voteList){
            String candidate = vote.getCandidate();
            int preference = vote.getPreference();

            if(candidateVoteCount.containsKey(candidate)){
                int oldVote =  candidateVoteCount.get(candidate);
                int nextVote = calculateVote(preference);
                int newVote = oldVote + nextVote;
                candidateVoteCount.put(candidate,newVote);
                if(newVote > winnerVote){
                    winnerVote = newVote;
                    winner = candidate;
                }
            }else{
                int newVote = calculateVote(preference);
                candidateVoteCount.put(candidate,newVote);
                if(newVote > winnerVote){
                    winnerVote = newVote;
                    winner = candidate;
                }
            }
        }
        return winner;
    }

    private int calculateVote(int preference){
        int nextVote = 0 ;
        if(preference == 1){
            nextVote = 3;
        }else if(preference == 2){
            nextVote = 2;
        }else if(preference == 3){
            nextVote =1;
        }
        return nextVote;
    }
}
