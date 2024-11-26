import okhttp3.*;

public class ParticleAPI {
    public void addInitialObstacles() {
        try {
            OkHttpClient client2 = new OkHttpClient().newBuilder().build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder().url("http://127.0.0.1:5000/obstacles").method("GET", body).build();
            Response response = client2.newCall(request).execute();
        }
        catch(Exception e) {
            System.out.println("Error AIO");
        }
    }
    public void addObstacle(float x, float y) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"x\":"+ x +",\r\n    \"y\":"+ y +"\r\n}");
            Request request = new Request.Builder().url("http://127.0.0.1:5000/obstacle").method("POST", body).addHeader("Content-Type", "application/json").build();
            Response response = client.newCall(request).execute();
        }
        catch(Exception e) {
            System.out.println("Error");
        }
      }
}
