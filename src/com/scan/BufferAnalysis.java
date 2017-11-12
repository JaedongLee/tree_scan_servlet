package com.scan;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferAnalysis {
    public String stringBufferAnalysis(HttpServletRequest request) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuffer sb = new StringBuffer();
        String line;
        for (line = br.readLine();line != null;line = br.readLine()) {
            sb.append(line);
        }
        String st = sb.toString();
        return  st;
    }
}
