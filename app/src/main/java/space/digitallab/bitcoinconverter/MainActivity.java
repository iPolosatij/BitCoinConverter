package space.digitallab.bitcoinconverter;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService( Context.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(imm).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN)
            hideKeyboard();
        return super.dispatchTouchEvent(ev);
    }

    private Button convert;
    private TextView textUsd, textEur, textGbp;
    private EditText bitCoin;
    private double a, b, c, d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUsd = findViewById(R.id.TextUsd);
        textEur = findViewById(R.id.TextEur);
        textGbp = findViewById(R.id.TextGbp);
        bitCoin = findViewById(R.id.BitCoin);
        convert = findViewById(R.id.Convert);



    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.coindesk.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    DataCall dataCall = retrofit.create(DataCall.class);

    Call<Repo> message = dataCall.messages();

    message.enqueue(new Callback<Repo>() {
        @Override
        public void onResponse(Call<Repo> call, Response<Repo> response) {
            if (response.isSuccessful()) {

               a = response.body().getBpi().getUSD().getRateFloat();
               b = response.body().getBpi().getEUR().getRateFloat();
               c = response.body().getBpi().getGBP().getRateFloat();

            } else {
                bitCoin.setText("not data");
            }
        }

        @Override
        public void onFailure(Call<Repo> call, Throwable t) {
            bitCoin.setText("error");
        }
    });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(bitCoin.getText().toString().equals("")) {bitCoin.setText("incorrect");
                }else {

                    d = Double.parseDouble(bitCoin.getText().toString());

                    String Susd = "  " + ((Math.ceil((d * a)*100))/100);
                    String Seur = "  " + ((Math.ceil((d * b)*100))/100);
                    String Sgbp = "  " + ((Math.ceil((d * c)*100))/100);

                    textUsd.setText(Susd);

                    textEur.setText(Seur);

                    textGbp.setText(Sgbp);
                }

            }
        });
    }
}