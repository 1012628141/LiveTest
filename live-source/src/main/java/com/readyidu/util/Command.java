package com.readyidu.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Command {
    public static List<String> exeCmd(String commandStr) {
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(commandStr);
            InputStream stdin = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stdin);
            BufferedReader br = new BufferedReader(isr);
            List<String> info = new ArrayList<>();
            String line = null;
            while ((line = br.readLine()) != null) {
                info.add(line);
            }
            int exitVal = proc.waitFor();
            System.out.println("Process exitV∆alue: " + exitVal);
            return info;
        } catch (Exception t) {
            t.printStackTrace();
            return null;
        }
    }
}