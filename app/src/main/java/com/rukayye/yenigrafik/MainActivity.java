package com.rukayye.yenigrafik;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Legend;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    private String[] agaclar;
    private Spinner sagaclar;
    ArrayAdapter<String> dataAdapterAgac;
    private String[] yil;
    private Spinner syil;
    ArrayAdapter<String> dataAdapterYil;
    boolean isFirst = true;
    String agacTipi = "";
    String tarih = "";
    ArrayList<OrmanVerisi> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //spinner1
        sagaclar = (Spinner) findViewById(R.id.spinner1_id);
        syil = (Spinner) findViewById(R.id.spinner2_id);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        agaclar = getResources().getStringArray(R.array.agac_array);
        yil = getResources().getStringArray(R.array.yil_array);
        agacTipi = agaclar[0];
        tarih = yil[0];
        data = getData();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.agac_array, android.R.layout.simple_spinner_item);
        sagaclar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!isFirst) {
                    agacTipi = agaclar[position];
                    grafikCiz(agacTipi, tarih);
                }
                isFirst = false;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sagaclar.setAdapter(adapter);
        //spinner2 q q
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.yil_array, android.R.layout.simple_spinner_item);

        syil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tarih = yil[position];//hangi yılın seçildiği
                grafikCiz(agacTipi, tarih);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        syil.setAdapter(adapter2);
    }
    void grafikCiz(String agacTipi, String yil) {
        Toast.makeText(this, agacTipi + " " + yil, Toast.LENGTH_SHORT).show();
//grafik
        pieChart.setDescription("Pie chart uygulaması");
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setUsePercentValues(false);//% lik olarak kullanılcak
        pieChart.setOffsets(25, 25, 25, 25);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.animateY(1500);
        pieChart.setCenterText("Orman");
        pieChart.setCenterTextSize(25f);
        pieChart.setValueTextSize(15f);
        pieChart.setValueTextColor(Color.rgb(0, 0, 0));
        ArrayList<Entry> entries = new ArrayList<>();
        for(OrmanVerisi veri : data){//orman verisindeki datanın içinin dolu olup olmadığını kontrol et
            if (veri.getAgacTipi().equals(agacTipi) && veri.getYil().equals(yil)){
                entries = veri.getEntries();
            }
        }
        PieDataSet piedataset = new PieDataSet(entries, "üretim degerleri");
        piedataset.setSliceSpace(3);
        piedataset.setSelectionShift(5);
        piedataset.setColors(ColorTemplate.JOYFUL_COLORS);
        PieData piedata = new PieData(agaclar, piedataset);
        pieChart.setData(piedata);//?
        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
    }

    ArrayList<OrmanVerisi> getData(){
        ArrayList<OrmanVerisi> data = new ArrayList<>();
        OrmanVerisi o1 = new OrmanVerisi();
        o1.setAgacTipi(agaclar[0]);
        o1.setYil(yil[0]);
        o1.setEntries( new ArrayList() {{
            add(new Entry(35, 1));
            add(new Entry(65, 2));
        }});
        OrmanVerisi o2 = new OrmanVerisi();
        o2.setAgacTipi(agaclar[0]);
        o2.setYil(yil[1]);
        o2.setEntries(new ArrayList() {{
            add(new Entry(10, 1));
            add(new Entry(90, 2));
        }});
        OrmanVerisi o3 = new OrmanVerisi();
        o3.setAgacTipi(agaclar[1]);
        o3.setYil(yil[0]);
        o3.setEntries( new ArrayList() {{
            add(new Entry(25, 1));
            add(new Entry(75, 2));
        }});
        OrmanVerisi o4 = new OrmanVerisi();
        o4.setAgacTipi(agaclar[1]);
        o4.setYil(yil[1]);
        o4.setEntries( new ArrayList() {{
            add(new Entry(40, 1));
            add(new Entry(60, 2));
        }});

        data.add(o1);
        data.add(o2);
        data.add(o3);
        data.add(o4);

        return data;
    }
}
