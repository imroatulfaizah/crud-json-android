package com.example.acer.json_mahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    private String TAMP_URL = "http://mydeveloper.id/sekolah/admin/list_json_mhs.php";
    private TextView txtresult;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtresult = (TextView) findViewById(R.id.tampil_npm);
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                TAMP_URL, new Response.Listener<JSONObject>() {
            @Override
            //proses pengambilan data json dan pengeluaran data json
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                try {
                    //mengambil json array
                    JSONArray json = response.getJSONArray("list_info");
                    for(int i = 0; i <json.length(); i++){
                        JSONObject info = json.getJSONObject(i);
                        //mengambil data json dari databse dengan field npm
                        String npm = info.getString("npm");
                        //menampilkan data yg sudah terlooping
                        txtresult.append("\n npm : " +npm +  "\n");
                    }
                    txtresult.append("====\n");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            //untuk menamilkan eror jika data json tidak muncul
            public void onErrorResponse(VolleyError error) {
                System.out.append(error.getMessage());
            }
        });
        requestQueue.add(jsonObjectRequest);

        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,tambah_data.class));
            }
        });
    }
}
