package clbrain.mapio;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

class User {
    private String user_id;

    public User(String user_id) {
        this.user_id = user_id;
    }

    public User() {
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}

class StringStatus {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StringStatus(String status) {
        this.status = status;
    }

    public StringStatus() {

    }
}

class SquaresDataList implements Serializable {
    @SerializedName("squares")
    private List<SquaresData> squares;

    public List<SquaresData> getSquares() {
        return squares;
    }

    public void setSquares(List<SquaresData> squares) {
        this.squares = squares;
    }

    public SquaresDataList(List<SquaresData> squares) {
        this.squares = squares;
    }

    public SquaresDataList() {
    }
}

class SendCoordinates {
    private String user_id;
    private Double latitude;
    private Double longitude;

    public SendCoordinates() {
    }

    public SendCoordinates(String user_id, Double latitude, Double longitude) {
        this.user_id = user_id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}

class Color {

    private String user_color;

    public Color() {
    }

    public Color(String user_color) {
        this.user_color = user_color;
    }

    public String getUser_color() {
        return user_color;
    }

    public void setUser_color(String user_color) {
        this.user_color = user_color;
    }
}

class Scoreboard {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_score")
    @Expose
    private String userScore;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

}

class FrameData {
    private double left_bottom_corner_latitude, left_bottom_corner_longitude, right_top_corner_latitude, right_top_corner_longitude;

    public FrameData() {
    }

    public FrameData(double left_bottom_corner_latitude, double left_bottom_corner_longitude, double right_top_corner_latitude, double right_top_corner_longitude) {
        this.left_bottom_corner_latitude = left_bottom_corner_latitude;
        this.left_bottom_corner_longitude = left_bottom_corner_longitude;
        this.right_top_corner_latitude = right_top_corner_latitude;
        this.right_top_corner_longitude = right_top_corner_longitude;
    }

    public double getLeft_bottom_corner_latitude() {
        return left_bottom_corner_latitude;
    }

    public void setLeft_bottom_corner_latitude(double left_bottom_corner_latitude) {
        this.left_bottom_corner_latitude = left_bottom_corner_latitude;
    }

    public double getLeft_bottom_corner_longitude() {
        return left_bottom_corner_longitude;
    }

    public void setLeft_bottom_corner_longitude(double left_bottom_corner_longitude) {
        this.left_bottom_corner_longitude = left_bottom_corner_longitude;
    }

    public double getRight_top_corner_latitude() {
        return right_top_corner_latitude;
    }

    public void setRight_top_corner_latitude(double right_top_corner_latitude) {
        this.right_top_corner_latitude = right_top_corner_latitude;
    }

    public double getRight_top_corner_longitude() {
        return right_top_corner_longitude;
    }

    public void setRight_top_corner_longitude(double right_top_corner_longitude) {
        this.right_top_corner_longitude = right_top_corner_longitude;
    }
}

class SquaresData implements Comparable<SquaresData> {


    private Integer horizontal_id, vertical_id;

    private String color;

    public SquaresData() {
    }

    public SquaresData(Integer horizontal_id, Integer vertical_id, String color) {
        this.horizontal_id = horizontal_id;
        this.vertical_id = vertical_id;
        this.color = color;
    }

    public Integer getHorizontal_id() {
        return horizontal_id;
    }

    public void setHorizontal_id(Integer horizontal_id) {
        this.horizontal_id = horizontal_id;
    }

    public Integer getVertical_id() {
        return vertical_id;
    }

    public void setVertical_id(Integer vertical_id) {
        this.vertical_id = vertical_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getVertical_id() + " " + getHorizontal_id() + " " + getColor();
    }

    @Override
    public int compareTo(@NonNull SquaresData squaresData) {
        return squaresData.toString().compareTo(this.toString());
    }
}

class Score {
    private Integer user_score;

    public Score(Integer user_score) {
        this.user_score = user_score;
    }

    public Score() {
    }

    public Integer getUser_score() {
        return user_score;
    }

    public void setUser_score(Integer user_score) {
        this.user_score = user_score;
    }
}

interface APIServices {
    @GET("get_user_score/")
    Call<Score> getUserScore(@Query("user_id") String uid);

    @GET("get_user_color/")
    Call<Color> getUserColor(@Query("user_id") String uid);

    @POST("add_user/")
    Call<Color> sendUID(@Body User user);

    @POST("send_user_coordinates/")
    Call<StringStatus> sendCoordinates(@Body SendCoordinates sendCoordinates);

    @GET("get_squares_data/")
    Call<SquaresDataList> getSquaresData();

    @GET("get_frame_data/")
    Call<SquaresDataList> getFrameData(@Query("bottom_left_latitude") Double bottomLeftLatitude,
                                       @Query("bottom_left_longitude") Double bottomLeftLongitude,
                                       @Query("top_right_latitude") Double topRightLatitude,
                                       @Query("top_right_longitude") Double topRightLongitude);
    @POST("drop_bomb/")
    Call<StringStatus> sendDropBomb(@Body SendCoordinates sendCoordinates);
}

public class Requests {

    private static final String BASE_URL = "http://128.199.35.73:80/";

    private static final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build();
    public static final APIServices apiServices = retrofit.create(APIServices.class);

    Requests() {
    }
}
