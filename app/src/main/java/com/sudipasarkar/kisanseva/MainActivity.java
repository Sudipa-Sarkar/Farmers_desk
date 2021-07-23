package com.sudipasarkar.kisanseva;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView schemeRv;
    private ArrayList<Schemes> al;
    private SchemesAdapter schapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schemeRv=findViewById(R.id.schemes);
        al= new ArrayList<>();
        schapt= new SchemesAdapter(al,this);
        schemeRv.setLayoutManager(new LinearLayoutManager(this));
        schemeRv.setAdapter(schapt);
        getScheme();
    }
    private void  getScheme()
    {
      al.clear();
      String url= "https://farmerdesk1.herokuapp.com/posts";
      Retrofit retrofit = new  Retrofit.Builder()
              .baseUrl(url)
              .addConverterFactory(GsonConverterFactory.create())
              .build();
      RetrofitAPI retrofitAPI= retrofit.create(RetrofitAPI.class);
      Call<SchemeModal> call;
      call = retrofitAPI.getAllNews(url);
      call.enqueue(new Callback<SchemeModal>() {
          @Override
          public void onResponse(Call<SchemeModal> call, Response<SchemeModal> response) {
           SchemeModal schemesModal = response.body();
           ArrayList<Schemes> al1 = schemesModal.getSch();
           for(int i=0;i<al1.size();i++)
           {
               al.add(new Schemes(al1.get(i).getTitle(),
                       al1.get(i).getLink(),al1.get(i).getTitle()));
           }
           schapt.notifyDataSetChanged();
          }

          @Override
          public void onFailure(Call<SchemeModal> call, Throwable t) {
              Toast.makeText(MainActivity.this,
                      "Failed",Toast.LENGTH_LONG).show();
          }
      });
    }
}