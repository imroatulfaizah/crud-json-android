package com.example.acer.json_mahasiswa;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class tambah_data extends AppCompatActivity {
    EditText npm,nama,alamat;
    Button add,update;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        PD = new ProgressDialog(this);
        PD.setMessage("silahkan tunggu.....");
        PD.setCancelable(false);

        npm = (EditText) findViewById(R.id.npm);
        nama = (EditText) findViewById(R.id.nama);
        alamat = (EditText) findViewById(R.id.alamat);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();

                StringRequest postRequest = new StringRequest(Request.Method.POST,
                        "http://mydeveloper.id/sekolah/admin/add_mhs.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                PD.dismiss();
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                                Log.d("laporan ",response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        PD.dismiss();
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("npm", npm.getText().toString());
                        params.put("nama", nama.getText().toString());
                        params.put("alamat", alamat.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(tambah_data.this);
                requestQueue.add(postRequest);
            }
        });

        update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PD.show();

                StringRequest postRequest = new StringRequest(Request.Method.POST,
                        "http://mydeveloper.id/sekolah/admin/update_mhs.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                PD.dismiss();
                                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                                Log.d("laporan ",response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        PD.dismiss();
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("npm", npm.getText().toString());
                        params.put("nama", nama.getText().toString());
                        params.put("alamat", alamat.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(tambah_data.this);
                requestQueue.add(postRequest);
            }
        });
    }
}
