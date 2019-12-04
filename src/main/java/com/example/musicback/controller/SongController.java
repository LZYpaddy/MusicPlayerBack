package com.example.musicback.controller;

import com.example.musicback.pojo.Song;
import com.example.musicback.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

/**
 * @author LZY
 */

@RestController
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private List<Song> songList;
    @GetMapping(value = "/song/list")
    public List<Song> list() {
        return songList;
    }

    @GetMapping(value = "/song/download/{id}")
    public ResponseEntity<byte[]> getBudgetWord(@PathVariable int id) throws IOException {
        ResponseEntity<byte[]> response;
        try (
            FileInputStream fis =songService.getInputStreamById( id );
            FileChannel channel = fis.getChannel()
        ) {
            ByteBuffer body = ByteBuffer.allocate( fis.available() );
            channel.read( body );
            HttpHeaders headers = new HttpHeaders();
            headers.add( CONTENT_DISPOSITION, "attachment;filename=" + id + ".mp3" );
            headers.add( ACCESS_CONTROL_ALLOW_HEADERS, CONTENT_DISPOSITION );
            response = new ResponseEntity<>( body.array(), headers, HttpStatus.OK );
        }
        return response;
    }
}
