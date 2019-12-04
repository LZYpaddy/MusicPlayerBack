package com.example.musicback.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public interface SongService {
    FileInputStream getInputStreamById(int id) throws FileNotFoundException;
}
