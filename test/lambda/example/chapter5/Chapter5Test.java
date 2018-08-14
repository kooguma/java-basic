package lambda.example.chapter5;

import lambda.demo.Album;
import lambda.demo.Artist;
import lambda.demo.SampleData;
import org.junit.Test;

import java.util.*;

import static lambda.demo.SampleData.*;
import static lambda.example.chapter5.Chapter5.*;
import static org.junit.Assert.assertEquals;

public class Chapter5Test {

    @Test
    public void collectionOrderedTest() {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> actual = collectionOrdered(array);
        assertEquals(array, actual);
    }

    @Test
    public void collectionDisOrderedTest() {
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        List<Integer> actual = collectionDisOrdered(new HashSet<>(Arrays.asList(4, 3, 2, 1)));
        assertEquals(expected, actual);
    }

    @Test
    public void biggestGroupTest() {
        Optional<Artist> expected = Optional.of(SampleData.theBeatles);
        Optional<Artist> actual = biggestGroup(SampleData.threeArtists());
        assertEquals(expected, actual);
    }

    @Test
    public void averageNumberOfTracksTest() {
        double expected = 2.66d;
        double actual = averageNumberOfTracks(SampleData.getThreeAlbums());
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void bandsAndSoloTest() {
        Map<Boolean, List<Artist>> expected = new HashMap<>();
        Map<Boolean, List<Artist>> actual = bandsAndSolo(SampleData.threeArtists());
        expected.put(Boolean.TRUE, Arrays.asList(SampleData.johnColtrane, SampleData.johnLennon));
        expected.put(Boolean.FALSE, Collections.singletonList(SampleData.theBeatles));
        assertEquals(expected, actual);
    }

    @Test
    public void albumsByArtistTest() {
        Map<Artist, List<Album>> expected = new HashMap<>();
        Map<Artist, List<Album>> actual = albumsByArtist(getTwoAlbums().stream());
        expected.put(SampleData.johnColtrane, Arrays.asList(aLoveSupreme, differentOriginsAlbum));
        assertEquals(expected, actual);
    }

    @Test
    public void artistNameFormatTest() {
        String actual = artistNameFormat(threeArtists());
        assertEquals("[John Coltrane,John Lennon,The Beatles]", actual);
    }

    @Test
    public void numberOfAlbumsTest() {
        Map<Artist, Long> expected = new HashMap<>();
        Map<Artist, Long> actual = numberOfAlbums(getTwoAlbums().stream());
        expected.put(SampleData.johnColtrane, 2L);
        assertEquals(expected, actual);
    }

    @Test
    public void nameOfAlbumsTest() {
        Map<Artist, List<String>> expected = new HashMap<>();
        Map<Artist, List<String>> actual = nameOfAlbums(getThreeAlbums().stream());
        expected.put(SampleData.johnColtrane, Arrays.asList("A Love Supreme","sample Short Album","sample Short Album"));
        assertEquals(expected, actual);
    }

    @Test
    public void customCollectorsTest() {
        String actual = customCollectors(SampleData.membersOfTheBeatles);
        assertEquals("[John Lennon,Paul McCartney,George Harrison,Ringo Starr]", actual);
    }
}
