package lambda.answers.chapter3;

import lambda.demo.Album;
import lambda.demo.SampleData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static lambda.answers.chapter3.Chapter3.*;
import static org.junit.Assert.assertEquals;

public class Chapter3Test {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addUpTest() {
        IntStream stream = IntStream.range(0, 10); // [1,9]
        int actual = addUp(stream);
        assertEquals(45, actual);
    }

    @Test
    public void getNamesAndOriginsTest() {
        List<String> actual = getNamesAndOrigins(SampleData.getThreeArtists());
        List<String> expected = new ArrayList<>();
        expected.add("John Coltrane");
        expected.add("US");
        expected.add("John Lennon");
        expected.add("UK");
        expected.add("The Beatles");
        expected.add("UK");
        assertEquals(expected, actual);
    }

    @Test
    public void getAlbumsWithAtMostThreeTracksTest() {
        List<Album> actual = getAlbumsWithAtMostThreeTracks(SampleData.getThreeAlbums());
        List<Album> expected = new ArrayList<>();
        expected.add(SampleData.aLoveSupreme);
        expected.add(SampleData.sampleShortAlbum);
        assertEquals(expected, actual);
    }

    @Test
    public void countBandMembersInternalTest() {
        long actual = countBandMembersInternal(SampleData.getThreeArtists());
        assertEquals(4, actual);
    }
}