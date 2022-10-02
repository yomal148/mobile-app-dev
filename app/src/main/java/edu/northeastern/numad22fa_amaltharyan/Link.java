package edu.northeastern.numad22fa_amaltharyan;

public class Link {

    private String name;
    private String link;

    /**
     * Construct a link object with name and link
     * @param name - name of the url
     * @param link - the link provided by user
     */
    public Link(String name, String link){
        this.name = name;
        this.link = link;
    }

    public String getName(){
        return name;
    }

    public String getLink(){
        return link;
    }
}
