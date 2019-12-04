package com.example.musicback.service.impl;

import com.example.musicback.pojo.Song;
import com.example.musicback.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author LZY
 */
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private List<Song> songList;
    @Override
    public FileInputStream getInputStreamById(int id) throws FileNotFoundException {
        Song song = songList.get( id - 1 );
        String path = ClassUtils.getDefaultClassLoader().getResource( "" ).getPath() +"song/";
        File file = new File( path + song.getId() + "." + song.getName() +".mp3" );
        return new FileInputStream( file );
    }
}
