package space.digitallab.bitcoinconverter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Repo implements Serializable
{

    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;
    @SerializedName("chartName")
    @Expose
    private String chartName;
    @SerializedName("bpi")
    @Expose
    private Bpi bpi;
    private final static long serialVersionUID = -5570562322092223887L;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public Bpi getBpi() {
        return bpi;
    }

    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }

}
