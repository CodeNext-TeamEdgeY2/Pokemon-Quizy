package com.example.volleystarter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView poke1;
    TextView poke2;
    TextView poke3;
    TextView poke4;
    ImageButton pokeimg1;
    ImageButton pokeimg2;
    ImageButton pokeimg3;
    ImageButton pokeimg4;
    String responseimg1;
    String responseimg2;
    String responseimg3;
    String responseimg4;


    Random rand = new Random();
    int rand_int1;
    int rand_int2;
    int rand_int3;
    int rand_int4;
    int answer;
    public int Points;
    public int flag1;
    public int flag2;
    public int flag3;
    public int flag4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        poke1 = findViewById(R.id.pokemon1);
        poke2 = findViewById(R.id.pokemon2);
        poke3 = findViewById(R.id.pokemon3);
        poke4 = findViewById(R.id.pokemon4);
        pokeimg1 = findViewById(R.id.pokemonimg1);
        pokeimg2 = findViewById(R.id.pokemonimg2);
        pokeimg3 = findViewById(R.id.pokemonimg3);
        pokeimg4 = findViewById(R.id.pokemonimg4);
        responseimg1 = "";
        responseimg2 = "";
        responseimg3 = "";
        responseimg4 = "";
        answer = rand.nextInt(4) + 1;
        playGame(null);

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Button|Getting the pokemons to appear Logic
    public void fetchData(View view) {
        // Instantiate the RequestQueue.
        rand_int1 = rand.nextInt(807) + 1;
        rand_int2 = rand.nextInt(807) + 1;
        rand_int3 = rand.nextInt(807) + 1;
        rand_int4 = rand.nextInt(807) + 1;
        answer = rand.nextInt(4) + 1;
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://pokeapi.co/api/v2/pokemon/" + rand_int1;


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String responsePoke = jsonObject.getString("name");
                            poke1.setText(responsePoke);
                            JSONObject jsonPic = jsonObject.getJSONObject("sprites");
                            responseimg1 = jsonPic.getString("front_default");
                            Picasso.get().load(responseimg1).into(pokeimg1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                poke1.setText("That didn't work!");
            }
        });

        String url2 = "https://pokeapi.co/api/v2/pokemon/" + rand_int2;

        // Request a string response from the provided URL.
        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String responsePoke = jsonObject.getString("name");
                            poke2.setText(responsePoke);
                            JSONObject jsonPic = jsonObject.getJSONObject("sprites");
                            responseimg2 = jsonPic.getString("front_default");
                            Picasso.get().load(responseimg2).into(pokeimg2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                poke2.setText("That didn't work!");
            }
        });

        String url3 = "https://pokeapi.co/api/v2/pokemon/" + rand_int3;

        // Request a string response from the provided URL.
        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, url3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String responsePoke = jsonObject.getString("name");
                            poke3.setText(responsePoke);
                            JSONObject jsonPic = jsonObject.getJSONObject("sprites");
                            responseimg3 = jsonPic.getString("front_default");
                            Picasso.get().load(responseimg3).into(pokeimg3);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                poke3.setText("That didn't work!");
            }
        });

        String url4 = "https://pokeapi.co/api/v2/pokemon/" + rand_int4;

        // Request a string response from the provided URL.
        StringRequest stringRequest4 = new StringRequest(Request.Method.GET, url4,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String responsePoke = jsonObject.getString("name");
                            poke4.setText(responsePoke);
                            JSONObject jsonPic = jsonObject.getJSONObject("sprites");
                            responseimg4 = jsonPic.getString("front_default");
                            Picasso.get().load(responseimg4).into(pokeimg4);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                poke4.setText("That didn't work!");
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        queue.add(stringRequest2);
        queue.add(stringRequest3);
        queue.add(stringRequest4);
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Quiz Logic
    public void playGame(View view){

        if (answer == 1){
            fetchData(null);
            flag1 = 1;
            poke1.setVisibility(View.VISIBLE);
            poke2.setVisibility(View.INVISIBLE);
            poke3.setVisibility(View.INVISIBLE);
            poke4.setVisibility(View.INVISIBLE);

        }else if (answer == 2) {
            fetchData(null);
            flag2 = 1;
            poke2.setVisibility(View.VISIBLE);
            poke1.setVisibility(View.INVISIBLE);
            poke3.setVisibility(View.INVISIBLE);
            poke4.setVisibility(View.INVISIBLE);


        }else if (answer == 3) {
            fetchData(null);
            flag3 = 1;
            poke3.setVisibility(View.VISIBLE);
            poke2.setVisibility(View.INVISIBLE);
            poke1.setVisibility(View.INVISIBLE);
            poke4.setVisibility(View.INVISIBLE);


        }else if (answer == 4) {
            fetchData(null);
            flag4 = 1;
            poke4.setVisibility(View.VISIBLE);
            poke2.setVisibility(View.INVISIBLE);
            poke3.setVisibility(View.INVISIBLE);
            poke1.setVisibility(View.INVISIBLE);


        }
    }

    public void logic1(View view) {
        if (flag1 == 1){
            flag1 = 0;
            flag2 = 0;
            flag3 = 0;
            flag4 = 0;
            playGame(null);
            Points += 1;
        } else {
            lose(null);
        }
    }
    public void logic2(View view) {
        if (flag2 == 1){
            flag1 = 0;
            flag2 = 0;
            flag3 = 0;
            flag4 = 0;
            playGame(null);
            Points += 1;
        } else {
            lose(null);
        }
    }
    public void logic3(View view) {
        if (flag3 == 1){
            flag1 = 0;
            flag2 = 0;
            flag3 = 0;
            flag4 = 0;
            playGame(null);
            Points += 1;
        } else {
            lose(null);
        }
    }
    public void logic4(View view) {
        if (flag4 == 1){
            flag1 = 0;
            flag2 = 0;
            flag3 = 0;
            flag4 = 0;
            playGame(null);
            Points += 1;
        } else {
            lose(null);
        }
    }

    public void lose(View view) {
        Intent intent = new Intent(this, different.class);
        intent.putExtra("Points", Points);
        startActivity(intent);
    }
}
