package com.programmer.newsandmore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private EditText name, email , password, c_password;
    private Button btn_regist;
    private ProgressBar loading;
    private ProgressDialog progressDialog;
    private static String URL_REGIST = "http://192.168.0.101:8080/newsandmore/register.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loading = findViewById(R.id.loading);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        c_password = findViewById(R.id.c_password);
        btn_regist = findViewById(R.id.btn_regist);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String registerName = name.getText().toString().trim();
                String registerEmail = email.getText().toString().trim();
                String registerPass = password.getText().toString().trim();
                String registerConfirmPassword = c_password.getText().toString().trim();

                if ( !registerName.isEmpty() || !registerEmail.isEmpty() || !registerPass.isEmpty() || !registerConfirmPassword.isEmpty()) {
                    Regist(registerName, registerEmail, registerPass, registerConfirmPassword);
                } else {

                    name.setError("Please insert name");
                    email.setError("Please insert email");
                    password.setError("Please insert password");
                    c_password.setError("Please confirm password");

                }
            }
        });

    }


    private void Regist(final String name, final String email, final String password, final String c_password){
        progressDialog.setMessage("Registering Successfull...");
        showDialog();
        loading.setVisibility(View.VISIBLE);
        btn_regist.setVisibility(View.GONE);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Register Response: " + response.toString());
                        hideDialog();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if(success.equals("1")) {
                                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(i);
                               Toast.makeText(RegisterActivity.this, "Register Success!", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this, "Register Error!" + e.toString(), Toast.LENGTH_LONG).show();
                            loading.setVisibility(View.GONE);
                            btn_regist.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError e) {
                        Log.e(TAG, "Login Error: " + e.getMessage());
                        Toast.makeText(RegisterActivity.this, "Register Error!" + e.toString(), Toast.LENGTH_LONG).show();
                        loading.setVisibility(View.GONE);
                        btn_regist.setVisibility(View.VISIBLE);
                        hideDialog();
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String> params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);
                params.put("password",password);
                params.put("confirm_password", c_password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }
    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
