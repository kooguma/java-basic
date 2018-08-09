package lambda.example.chapter3;

import lambda.demo.SampleData;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static lambda.example.chapter3.Chapter3.*;
import static org.junit.Assert.assertEquals;

public class Chapter3Test {

    @Test
    public void getOriginsTest() {
        Set<String> actual = getOrigins(SampleData.differentOriginsAlbum);
        Set<String> expected = new HashSet<>();
        expected.add("UK");
        assertEquals("origins : ", expected, actual);
    }

    @Test
    public void finLongTracksTest() {
        Set<String> actual = finLongTracks(SampleData.getThreeAlbums());
        Set<String> expected = new HashSet<>();
        expected.add("Acknowledgement");
        expected.add("Resolution");
        assertEquals("tracks : ", expected, actual);
    }
}
