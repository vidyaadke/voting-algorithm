package voting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VoteAlgorithmTest {

    VoteAlgorithm voteAlgorithm;

    @BeforeEach
    void init(){
        voteAlgorithm = new VoteAlgorithm();
    }

    @Test
    void findWinner() {
        String candidate = voteAlgorithm.findWinner(Arrays.asList("A","B","C","A"));
        assertEquals("A",candidate);
    }

    @Test
    void findWinner_1() {
        String candidate = voteAlgorithm.findWinner(Arrays.asList("A","B","A","B"));
        assertEquals("A",candidate);
    }

    @Test
    void findWinnerWithoutReloop() {
        String candidate = voteAlgorithm.findWinnerWithoutReloop(Arrays.asList("A","B","A","B"));
        assertEquals("A",candidate);
    }

    @Test
    void findWinnerWithoutReloop_1() {
        String candidate = voteAlgorithm.findWinnerWithoutReloop(Arrays.asList("A","B","C","B"));
        assertEquals("B",candidate);
    }

    @Test
    void findWinnerWithoutReloop_2() {
        String candidate = voteAlgorithm.findWinnerWithoutReloop( Arrays.asList("A", "B", "C", "B", "C", "D", "C", "D"));
        assertEquals("C",candidate);
    }


}