package com.example.misa_demo_retrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.misa_demo_retrofit.adapter.PersonAdapter;
import com.example.misa_demo_retrofit.model.PersonPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private PersonAdapter mPersonAdapter;
    private RecyclerView mRecyclerView;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setMessage("Loading....");
            mProgressDialog.show();//
        } catch (Exception e) {
            e.printStackTrace();

        }
        GetDataService service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        Call<List<PersonPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<PersonPhoto>>() {
            @Override
            public void onResponse(Call<List<PersonPhoto>> call, Response<List<PersonPhoto>> response) {
                mProgressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<PersonPhoto>> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    /**
     * Created by Tuan
     * Created date 15/5/2019
     */

    private void generateDataList(List<PersonPhoto> photoList) {
        mRecyclerView = findViewById(R.id.listPerson);
        mPersonAdapter = new PersonAdapter(photoList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mPersonAdapter);
    }





}
