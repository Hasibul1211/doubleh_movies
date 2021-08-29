package com.doubleh.doubleh_movies.bean;

import lombok.Data;

import java.beans.Transient;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Data
public class Movie {

        private int fid;
        private String title;
        private String description;
        private String category;
        private float price;
        private int length;
        private String rating;
        private List<Actor> actors;
        private int rental_duration;
        private float rental_rate;
        private float replacement_cost;
        private int quantity;



        public float getSubtotal(){
                float subT = this.price *quantity;
                String sT = String.format(java.util.Locale.US,"%.2f", subT);
                subT = Float.parseFloat(sT);
                return subT;
        }
}
