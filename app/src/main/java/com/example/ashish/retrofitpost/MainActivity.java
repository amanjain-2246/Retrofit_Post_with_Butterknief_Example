package com.example.ashish.retrofitpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editText) EditText name;
    @BindView(R.id.editText2) EditText job;
    @BindView(R.id.button) Button btn;
    @BindView(R.id.textView) TextView txt;

    Retrofit client;
    ReqResInterface service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        client=RestClient.getClient();
        service=client.create(ReqResInterface.class);


    }



    @OnClick(R.id.button)
    public void submit(View view) {
        UserRequest request=new UserRequest();
        request.setName(name.getText().toString());
        request.setJob(job.getText().toString());
        service.userreq(request).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                //Toast.makeText(MainActivity.this, ""+response.body().getCreatedAt(), Toast.LENGTH_SHORT).show();

            txt.setText("ID : "+response.body().getId()+
                    "\n NAME :"+response.body().getName()+
                    "\n JOB : "+response.body().getJob()+
                    "\n CREATED ON :"+response.body().getCreatedAt());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }

}
