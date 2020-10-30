package voting;

import voting.model.Vote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiVoteAlgorithmTest {

    MultiVoteAlgorithm multiVoteAlgorithm;

    @BeforeEach
    void init(){
        multiVoteAlgorithm = new MultiVoteAlgorithm();
    }

    @Test
    void findWinner() {

        List<Vote> voteByCandidate1 = new ArrayList<>();
        voteByCandidate1.add(new Vote("A",1));
        voteByCandidate1.add(new Vote("B",2));
        voteByCandidate1.add(new Vote("C",3));

        multiVoteAlgorithm.saveVote(voteByCandidate1);

        List<Vote> voteByCandidate2 = new ArrayList<>();
        voteByCandidate2.add(new Vote("C",1));
        voteByCandidate2.add(new Vote("B",2));
        voteByCandidate2.add(new Vote("A",3));

        multiVoteAlgorithm.saveVote(voteByCandidate2);

        List<Vote> voteByCandidate3 = new ArrayList<>();
        voteByCandidate3.add(new Vote("A",1));
        voteByCandidate3.add(new Vote("B",2));
        voteByCandidate3.add(new Vote("C",3));

        multiVoteAlgorithm.saveVote(voteByCandidate3);


        List<Vote> voteByCandidate4 = new ArrayList<>();
        voteByCandidate4.add(new Vote("B",1));
        voteByCandidate4.add(new Vote("A",2));
        voteByCandidate4.add(new Vote("C",3));

        multiVoteAlgorithm.saveVote(voteByCandidate4);

        assertEquals("B",multiVoteAlgorithm.findWinner());
    }
}