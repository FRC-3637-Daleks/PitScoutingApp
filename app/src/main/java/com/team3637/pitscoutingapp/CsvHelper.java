package com.team3637.pitscoutingapp;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Zethra on 2/21/2015.
 */
public class CsvHelper {

    public String teams[][];

    private File csvFile;

    public String read() {
        File sdcard = Environment.getExternalStorageDirectory();

        csvFile = new File(sdcard, "teams.csv");

        StringBuilder text = new StringBuilder();

        try {
            if (!csvFile.exists()) {
                csvFile.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String line;

            while((line = br.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
            br.close();
        } catch (IOException e) {}

        return text.toString();
    }

    public void write(String data) {
        File sdcard = Environment.getExternalStorageDirectory();
        csvFile = new File(sdcard, "teams.csv");
        try {
            FileOutputStream fOut = new FileOutputStream(csvFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();
        } catch (IOException e){}
    }



    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}
