package com.example.musicback.pojo;

/**
 * @author LZY
 */
public class Song {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "{" );
        sb.append( "\"id\":" )
                .append( id );
        sb.append( ",\"name\":\"" )
                .append( name ).append( '\"' );
        sb.append( '}' );
        return sb.toString();
    }
}
