package edu.northeastern.numad22fa_amaltharyan;

public class Link {

    private String name;
    private String url;

    /**
     * Construct a link object with name and link
     * @param name - name of the url
     * @param url - the link provided by user
     */
    public Link(String name, String url){
        this.name = name;
        this.url = url;
    }

    public String getName(){
        return name;
    }

    public String getUrl(){
        return url;
    }
}
