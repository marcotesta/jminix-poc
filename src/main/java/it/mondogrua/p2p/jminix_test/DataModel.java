package it.mondogrua.p2p.jminix_test;

public class DataModel  {
    
    static final String textA = "AAA";
    static final String textB = "BBB";

    String nextText = textB;

    public String getNextText() {
        return this.nextText;
    }

    public void setNextText(String text) {
        this.nextText = text;
    }

}
