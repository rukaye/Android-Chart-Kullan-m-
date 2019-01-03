package com.rukayye.yenigrafik;




import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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


public class yeni_grafik extends AppCompatActivity {

    PieChart pieChart;
    private String[] agaclar;
    private Spinner sagaclar;
    ArrayAdapter<String> dataAdapterAgac;
    private String[] yil;
    private Spinner syil;
    ArrayAdapter<String> dataAdapterYil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_grafik);
        
        Bundle bundle=getIntent().getExtras();

        //grafik
        pieChart = (PieChart) findViewById(R.id.pieChart);
        pieChart.setDescription("Pie chart uygulaması");
        pieChart.setTransparentCircleRadius(61f);


        pieChart.setUsePercentValues(false);//% lik olarak kullanılcak
        pieChart.setOffsets(25, 25, 25, 25);

        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);


        ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(30, 1));
        entries.add(new Entry(50, 2));
        entries.add(new Entry(20, 3));

        ArrayList<String> Agaclar = new ArrayList<>();
        Agaclar.add("Çam");
        Agaclar.add("Ladin");
        Agaclar.add("Sedir");

        PieDataSet piedataset = new PieDataSet(entries, "üretim degerleri");
        piedataset.setSliceSpace(3);
        piedataset.setSelectionShift(5);
        piedataset.setColors(ColorTemplate.JOYFUL_COLORS);


        PieData piedata = new PieData(Agaclar, piedataset);

        pieChart.setData(piedata);//?
        pieChart.animateY(1500);
        pieChart.setCenterText("Orman");
        pieChart.setCenterTextSize(25f);

        pieChart.setValueTextSize(15f);

        pieChart.setValueTextColor(Color.rgb(0, 0, 0));

        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

    }




    }

