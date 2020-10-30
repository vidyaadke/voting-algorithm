package voting.model;

public class Vote {

    private String candidate;
    private int preference;

    //(A,1),(B,1),(C,1)
    public Vote(String candidate, int preference) {
        this.candidate = candidate;
        this.preference = preference;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }
}
