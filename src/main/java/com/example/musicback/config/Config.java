package com.example.musicback.config;

import com.example.musicback.pojo.Song;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;


@Configuration
public class Config {
    @Bean
    public List<Song> songList() {
        LinkedList<Song> list = new LinkedList<>();
        list.add( new Song() {{
            setId( 1 );
            setName( "义勇军进行曲" );
        }} );
        list.add( new Song() {{
            setId( 2 );
            setName( "国际歌" );
        }} );


        return list;
    }
}
