package com.example.mypost3;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackGroundTask extends AsyncTask<String , Void , String> {
    Context ctx;
    BackGroundTask(Context ctx){
        this.ctx=ctx;

    }
    @Override

    protected String doInBackground(String... params) {

        String regurl = "";//set the url for connecting to the database
        String method = params[0];//to get the values passed by background task in Main activity java file
        if(method.equals("register")){//to check that the passed value is register or not
            String name = params[1];//to get the values passed by background task in Main activity java file
            String pass = params[2];//to get the values passed by background task in Main activity java file

            try {
                URL url = new URL(regurl);//to get hte url of the connection the url that is given above
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();//Start a new connection
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os  = httpURLConnection.getOutputStream();//creates object of the output stream
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));  //to create an object to write the dat for reading the data we use buffer reader
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
                bufferedWriter.write(data);//to write the data
                bufferedWriter.flush();//to flush rhe buffer writer
                bufferedWriter.close();//to close the buffer writer
                os.close();//close the outputstream
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "registration success";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}