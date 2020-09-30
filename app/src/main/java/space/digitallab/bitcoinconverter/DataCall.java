package space.digitallab.bitcoinconverter;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataCall {

    @GET("https://api.coindesk.com/v1/bpi/currentprice.json")
    Call <Repo> messages();

}