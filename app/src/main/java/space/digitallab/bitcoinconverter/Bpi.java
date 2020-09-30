package space.digitallab.bitcoinconverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Bpi implements Serializable
{

    @SerializedName("USD")
    @Expose
    private USD uSD;
    @SerializedName("GBP")
    @Expose
    private GBP gBP;
    @SerializedName("EUR")
    @Expose
    private EUR eUR;
    private final static long serialVersionUID = 126242162475679099L;

    public USD getUSD() {
        return uSD;
    }

    public void setUSD(USD uSD) {
        this.uSD = uSD;
    }

    public GBP getGBP() {
        return gBP;
    }

    public void setGBP(GBP gBP) {
        this.gBP = gBP;
    }

    public EUR getEUR() {
        return eUR;
    }

    public void setEUR(EUR eUR) {
        this.eUR = eUR;
    }

}