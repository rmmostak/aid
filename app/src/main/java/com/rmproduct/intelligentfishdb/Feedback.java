package com.rmproduct.intelligentfishdb;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity {

    private EditText name, comment;
    private RatingBar rating;
    private Button sendComment;
    ProgressDialog dialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        getSupportActionBar().setTitle(R.string.feed_back);

        name = findViewById(R.id.name);
        comment = findViewById(R.id.comment);
        rating = findViewById(R.id.rating);
        sendComment = findViewById(R.id.sendComment);
        dialog = new ProgressDialog(Feedback.this);
        dialog.setTitle(getString(R.string.sending_feedback));

        sendComment.setOnClickListener(view -> {
            String rateS = String.valueOf(rating.getRating());
            String nameS = name.getText().toString().trim();
            String commentS = comment.getText().toString().trim();

            if (!TextUtils.isEmpty(nameS)) {
                if (!TextUtils.isEmpty(commentS)) {
                    if (isConnected()) {
                        dialog.show();
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbxGYKhqupqNuzClL_bh20sOmlzoDW8gAmeas7fNb8cIwmrms7vK2psevT4oqEGGSKoi/exec", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                AlertDialog.Builder alert = new AlertDialog.Builder(Feedback.this);
                                alert.setTitle(R.string.notice);
                                alert.setIcon(R.drawable.ic_launcher_round);
                                alert.setMessage(R.string.sharing_comment);
                                alert.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        name.setText("");
                                        comment.setText("");
                                        Intent intent = new Intent(Feedback.this, HomePage.class);
                                        ActivityOptions options = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                                        startActivity(intent, options.toBundle());
                                    }
                                }).show();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Feedback.this, getString(R.string.error) + error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                            @Nullable
                            @Override
                            protected Map<String, String> getParams() {

                                Map<String, String> params = new HashMap<>();
                                params.put("action", "addComment");
                                params.put("rating", rateS);
                                params.put("name", nameS);
                                params.put("comment", commentS);

                                return params;
                            }
                        };
                        int timeOut = 50000;
                        RetryPolicy retryPolicy = new DefaultRetryPolicy(timeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                        stringRequest.setRetryPolicy(retryPolicy);

                        RequestQueue requestQueue = Volley.newRequestQueue(Feedback.this);
                        requestQueue.add(stringRequest);
                    } else {
                        dialog.hide();
                        Toast.makeText(Feedback.this, R.string.connect_internet + "", Toast.LENGTH_LONG).show();
                    }
                } else {
                    comment.setError(getString(R.string.write_someting));
                    comment.requestFocus();
                }
            } else {
                name.setError(getString(R.string.write_name));
                name.requestFocus();
            }


        });
    }

    private boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

}