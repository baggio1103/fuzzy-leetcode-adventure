package yandexContest;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Gallery {

    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var width = Double.parseDouble(reader.readLine());
        var values = reader.readLine().split(" ");
        var n = Integer.parseInt(values[0]);
        var k = Integer.parseInt(values[1]);
        var photos = new ArrayList<String>(n);
        for (int i = 0; i < n; i++) {
            photos.add(reader.readLine());
        }
        System.out.println(photos);
        var newPhotos = photos.stream().map(s -> {
            var split = s.split("x");
            var newWidth = Double.valueOf( width * Integer.parseInt(split[1]) / Integer.parseInt(split[0]));
            if (newWidth > newWidth.intValue()) {
                return newWidth.intValue() + 1;
            }
            return newWidth.intValue();
        }).sorted().collect(Collectors.toList());
        var min = newPhotos.subList(0, k);
        var max = newPhotos.subList(photos.size() - k, photos.size());
        System.out.println(min.stream().reduce(0, Integer::sum));
        System.out.println(max.stream().reduce(0, Integer::sum));
    }

}
