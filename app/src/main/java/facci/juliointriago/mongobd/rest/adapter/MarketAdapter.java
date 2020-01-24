package facci.juliointriago.mongobd.rest.adapter;


import java.util.List;

import facci.juliointriago.mongobd.rest.constants.ApiConstants;
import facci.juliointriago.mongobd.rest.model.Post;
import facci.juliointriago.mongobd.rest.service.MarketService;
import retrofit2.Call;

public class MarketAdapter extends BaseAdapter implements MarketService{
    private MarketService marketService;

    public MarketAdapter(){
        super(ApiConstants.BASE_POST_URL);
        marketService=creativeService(MarketService.class);
    }
    @Override
    public Call<Post> InsertPost(Post post) {
        return marketService.InsertPost(post);
    }
    @Override
    public Call<List<Post>> getPost() {
        return marketService.getPost();
    }



}


