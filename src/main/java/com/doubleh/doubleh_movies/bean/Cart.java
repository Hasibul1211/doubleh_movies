package com.doubleh.doubleh_movies.bean;



import lombok.Data;

import java.beans.Transient;
import java.util.List;

@Data
public class Cart {
    private int customer_id;
    private int film_id;
    private int quantity;
    private List<Movie> movieList;




}
